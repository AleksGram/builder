package builderAutomation.fields;

import builderAutomation.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by agra on 11/30/2016.
 */
public class Fields extends Page {
    public AutoFields getAutoFields() {
        return autoFields;
    }

    public AutoFields autoFields;
    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='LastName']")
    private WebElement lastname;

    public WebElement getZipcode() {
        return zipcode;
    }

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='ZipCode']")
    private WebElement zipcode;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='PhoneNumber']")
    private WebElement phoneNumber;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='EmailAddress']")
    private WebElement emailaddress;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Address']")
    private WebElement address;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='ControlButton']")
    private WebElement controllButton;

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getEmailaddress() {
        return emailaddress;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getControllButton() {
        return controllButton;
    }

    public WebElement getAddActionButton() {
        return addActionButton;
    }

    public WebElement getHeaderText() {
        return headerText;
    }

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='HeaderText']")
    private WebElement headerText;

    @CacheLookup
    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//span[@class='bq-label']")
    private WebElement addActionButton;

    public WebElement getWichAction() {
        return wichAction;
    }

    @FindBy(xpath = ".//div[@id='bq-popup-container']//select")
    private WebElement wichAction;

    @FindBy(xpath = ".//input[@type='checkbox']")
    private List<WebElement> actionCheckboxes;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//div[2]/button")
    private WebElement addConditionButton;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//div[3]//select")
    private WebElement extraConditionField;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//div[4]/div[2]//select")
    private WebElement updatedFieldSelect;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//div[5]/div[2]/select")
    private WebElement howUpdateSelect;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//div[6]//select")
    private WebElement updateValueSelect;

    @CacheLookup
    @FindBy(xpath = "//div[@class='bq-builder-button-action']/button[1]")
    private WebElement saveActionButton;

    @CacheLookup
    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//ol/li[1]")
    public WebElement backButton;

    @CacheLookup
    @FindBy(xpath = "//button[@class='bq-builder-control-publish']")
    private WebElement saveOfferButton;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//input[@value='false']")
    private WebElement visabilityShowButton;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//input[@value='true']")
    private WebElement visabilityHideButton;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//div[6]/div[2]/select")
    private WebElement validationRuleSelect;

    @FindBy(xpath = ".//div[@id='bq-popup-container']//div[7]/div[2]/input")
    private WebElement errorMessageField;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//li[4]")
    private WebElement editActionButton;

    @FindBy(css = ".bq-builder-item-container>input")
    private WebElement jumpToPageValueField;

    @FindBy(xpath = ".//div[@class='bq-builder-event-value']/label[2]")
    private WebElement exludeRadioButton;

    @FindBy(xpath = ".//div[@class='bq-builder-event-value']/label[1]")
    private WebElement includeRadioButton;

    public void saveAction() {
        clickOn(saveActionButton);
    }

    public void backTofields() {
        clickOn(backButton);
    }

    public void includeON(){
        includeRadioButton.click();
    }

    public void exludeON (){
        exludeRadioButton.click();
    }


    public void updateHeader() {
        clickOn(editActionButton);
        clickOn(addActionButton);
        new Select(wichAction).selectByValue("updateHeader");
    }
    public void addAction(String typeOfaction)  {
        clickOn(editActionButton);
        clickOn(addActionButton);
        switch (typeOfaction){
            case "updateHeader":
                updateHeader();
            case "updateByValue":
                updateAnotherField(byValue, "InsuredSince", "null",2);
            case "updateVisability":
                updateAnotherField(byVisability, "InsuredSince", "hide", 2);
            case "skipToAnotherPage":
                skipToAnotherPage("3");
        }
        saveAction();
    }








    public void skipToAnotherPage(String pageNumber)  {
        new Select(wichAction).selectByValue("jumpOnStep");
        actionCheckboxes.get(2).click();
        jumpToPageValueField.clear();
        jumpToPageValueField.sendKeys(pageNumber);
    }

    public void skipToNextPage(){
        new Select(wichAction).selectByValue("nextStep");
    }

    public enum Update {
        VALUE("updateField"),
        VISABILITY("hidden"),
        VALIDATION("required");
        String typeOfUpdate;

        Update(String howUpdate) {
            typeOfUpdate = howUpdate;
        }
    }

    public Update byValue = Update.VALUE;
    public Update byVisability = Update.VISABILITY;
    public Update byValidation = Update.VALIDATION;

    public void updateAnotherField(Update howUpdate, String wichFieldUpdated, String howToChange, Integer whichValueChangedTheField) {

        switch (howUpdate) {
            case VALUE:
                new Select(wichAction).selectByValue("updateField");
                actionCheckboxes.get(whichValueChangedTheField).click();
                new Select(updatedFieldSelect).selectByValue(wichFieldUpdated);
                new Select(howUpdateSelect).selectByValue("value");
                new Select(updateValueSelect).selectByValue("Yes");
                break;
            case VISABILITY:
                new Select(wichAction).selectByValue("updateField");
                actionCheckboxes.get(whichValueChangedTheField).click();
                new Select(updatedFieldSelect).selectByValue(wichFieldUpdated);
                new Select(howUpdateSelect).selectByValue(howToChange);
                if (howToChange == "hide") {
                    visabilityHideButton.click();
                } else {
                    visabilityShowButton.click();
                }
                break;
            case VALIDATION:
                new Select(wichAction).selectByValue("updateField");
                actionCheckboxes.get(whichValueChangedTheField).click();
                new Select(updatedFieldSelect).selectByValue(wichFieldUpdated);
                new Select(howUpdateSelect).selectByValue("required");
                new Select(updateValueSelect).selectByValue(howToChange);
        }

    }



    public void updateDynamicField() {
        new Select(wichAction).selectByValue("updateHeader");
    }


    public void addNewAction(String whichAction, String pageNumber, String whichFieldUpdate, Integer whichValueChangedTheField, String value){
        clickOn(editActionButton);
        clickOn(addActionButton);
        switch (whichAction){
            case "updateHeader":
             updateDynamicField();
             break;
            case "updateByValue":
                updateAnotherField(byValue, whichFieldUpdate, value, whichValueChangedTheField );
                break;
            case "updateVisability":
                updateAnotherField(byVisability, whichFieldUpdate, value, whichValueChangedTheField);
                break;
            case "updateValidation":
                updateAnotherField(byValidation,whichFieldUpdate,value, whichValueChangedTheField);
                break;
            case "skipToNextPage":
                skipToNextPage();
                break;
            case "skipToAnotherPage":
                skipToAnotherPage(pageNumber);
                break;
        }
        saveAction();
        backTofields();
    }
}

