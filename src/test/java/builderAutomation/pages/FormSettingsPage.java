package builderAutomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Грам on 23.11.2016.
 */
public class FormSettingsPage extends Page {

    @FindBy(css = "div.bq-builder-item-container>input")
    private WebElement offerNameField;

    @FindBy(css = "button.bq-popup-button[tabindex=\"1\"]")
    private WebElement closePopupButton;

    @FindBy(css = "button.bq-builder-control-pages")
    private WebElement nextStepButton;

    @FindBy(xpath = ".//div[@id='bq-content']//div[2]/div[2]/select")
    private WebElement listOfCountries;

    @FindBy(xpath = ".//*[@id='bq-content']//div[3]//select")
    private WebElement campaignVertical;

    @FindBy(xpath = ".//*[@id='bq-content']//div[4]//select")
    private WebElement campaignType;

    @FindBy(xpath = "//button[@class='bq-builder-control-publish']")
    private WebElement saveOfferButton;

    @FindBy(css = ".bq-popup-uri>input")
    private WebElement offerLink;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//li[4]")
    private WebElement editActionButton;

    @FindBy(css = ".bq-builder-delete")
    private WebElement deleteActionButton;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//span[@class='bq-label']")
    private WebElement addActionButton;

    @FindBy (xpath =".//li[@class='bq-disable']")
    private List<WebElement> numbersOfThePages;

    public List<WebElement> getOptionBoxes() {
        return optionBoxes;
    }

    @FindBy(xpath = ".//textarea[@class='bq-edit-text']")
    private List<WebElement> optionBoxes;

    public void changePage(Integer number){
       numbersOfThePages.get(number-2).click();
    }

    public void clickAddAction() {
        addActionButton.click();
    }

    public void saveOffer() {
        clickOn(saveOfferButton);
    }

    public void goToEditActions() {
        editActionButton.click();
    }

    public void deleteAction() {
        deleteActionButton.click();
    }


    public void createOffer(String country, String vertical, String type) throws InterruptedException {
        waitUntillVisible(offerNameField);
        offerNameField.sendKeys("test");

        new Select(listOfCountries).selectByValue(country);
        new Select(campaignVertical).selectByValue(vertical);
        new Select(campaignType).selectByValue(type);
       Thread.sleep(3000);
        nextStepButton.click();
    }

    public void closePopup() {
        waitUntillVisible(closePopupButton);
        closePopupButton.click();
    }

    public void openOfferInNewTab() throws InterruptedException {
        String link;
        waitUntillVisible(offerLink);
        link = offerLink.getAttribute("value");
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        Thread.sleep(2000);
        driver.get("http:" + link);

    }
}
