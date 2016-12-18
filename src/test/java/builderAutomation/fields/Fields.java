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

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='HeaderText']")
    private WebElement headerText;

    @CacheLookup
    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//span[@class='bq-label']")
    private WebElement addActionButton;

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

    public void saveAction() {
        clickOn(saveActionButton);
    }

    public void backTofields() {
        clickOn(backButton);
    }

    public void updateAnotherFieldVisability(String wichFieldUpdated, String howToChange) {
        new Select(wichAction).selectByValue("updateField");
        actionCheckboxes.get(2).click();
        new Select(updatedFieldSelect).selectByValue(wichFieldUpdated);
        new Select(howUpdateSelect).selectByValue("hidden");
        if (howToChange == "hide") {
            visabilityHideButton.click();
        } else {
            visabilityShowButton.click();
        }
    }

    public void updateAnotherFieldByValue(String wichFieldUpdated, String valueForUpdating) {
        new Select(wichAction).selectByValue("updateField");
        actionCheckboxes.get(2).click();
        new Select(updatedFieldSelect).selectByValue(wichFieldUpdated);
        new Select(howUpdateSelect).selectByValue("value");
        new Select(updateValueSelect).selectByValue(valueForUpdating);

    }
    public void skipToAnotherPage()  {
        new Select(wichAction).selectByValue("jumpOnStep");
        actionCheckboxes.get(2).click();
        jumpToPageValueField.clear();
        jumpToPageValueField.sendKeys("3");


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

    protected Update byValue = Update.VALUE;
    protected Update byVisability = Update.VISABILITY;
    protected Update byValidation = Update.VALIDATION;

    public void updateAnotherField(Update howUpdate, String wichFieldUpdated, String howToChange) {

        switch (howUpdate) {
            case VALUE:
                new Select(wichAction).selectByValue("updateField");
                actionCheckboxes.get(2).click();
                new Select(updatedFieldSelect).selectByValue(wichFieldUpdated);
                new Select(howUpdateSelect).selectByValue("value");
                new Select(updateValueSelect).selectByValue("10");
            case VISABILITY:
                new Select(wichAction).selectByValue("updateField");
                actionCheckboxes.get(2).click();
                new Select(updatedFieldSelect).selectByValue(wichFieldUpdated);
                new Select(howUpdateSelect).selectByValue("hidden");
                if (howToChange == "hide") {
                    visabilityHideButton.click();
                } else {
                    visabilityShowButton.click();
                }
        }

    }

    public void updateDynamicField() {
        new Select(wichAction).selectByValue("updateHeader");
    }

    public void addAction(String typeOfaction)  {
        clickOn(editActionButton);
        clickOn(addActionButton);
        switch (typeOfaction){
            case "updateHeader":
                updateDynamicField();
            case "updateByValue":
                updateAnotherField(byValue, "InsuredSince", "null");
            case "updateVisability":
                updateAnotherField(byVisability, "InsuredSince", "hide");
            case "skipToAnotherPage":
                skipToAnotherPage();
        }
        saveAction();
    }
}

