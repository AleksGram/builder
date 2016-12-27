package builderAutomation.fields;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by agra on 12/27/2016.
 */
public class HealthOfferFields extends Fields {
    @FindBy(xpath = ".//div[@class='bq-field bq-type-zipUS bq-name-ZipCode']//input")
    private WebElement offerZipCode;

    @FindBy(xpath = ".//div[@class='bq-field bq-type-zipUS bq-name-ZipCode bq-error']//input")
    private WebElement offerZipCodeError;

    @FindBy(xpath = ".//div[@class='bq-field bq-type-select bq-name-Conditions']//select")
    private WebElement conditions;

    @FindBy(css = ".bq-field.bq-type-radio.bq-name-Smoker>div>div>span")
    private List<WebElement> smoker;



    @FindBy(xpath = ".//div[@class='bq-field bq-type-radio bq-name-Hospitalized']//ins")
    private List<WebElement> hospitalized;

    @FindBy(xpath = ".//div[@class='bq-field bq-type-radio bq-name-Pregnant']//ins")
    private List<WebElement> pregnant;

    @FindBy(xpath = ".//div[@class='bq-field bq-type-radio bq-name-DeniedInsurance']//ins")
    private List<WebElement> denideInsurance;

    @FindBy(xpath = ".//div[@class='bq-field bq-type-control bq-name-ControlButton']/button")
    private WebElement controlbutton;

    @FindBy(xpath = ".//div[@class='bq-field bq-type-zipUS bq-name-ZipCode bq-error']//span")
    private WebElement zipCodeErrorMessage;
    public WebElement getOfferZipCode() {
        return offerZipCode;
    }

    public WebElement getConditions() {
        return conditions;
    }

    public List<WebElement> getSmoker() {
        return smoker;
    }

    public List<WebElement> getHospitalized() {
        return hospitalized;
    }

    public List<WebElement> getPregnant() {
        return pregnant;
    }

    public List<WebElement> getDenideInsurance() {
        return denideInsurance;
    }

    public WebElement getControlbutton() {
        return controlbutton;
    }

    public WebElement getZipCodeErrorMessage() {
        return zipCodeErrorMessage;
    }

    public WebElement getOfferZipCodeError() {
        return offerZipCodeError;
    }

    public void choosingConditions(String wichCondition){
        new Select(conditions).selectByValue(wichCondition);
    }

    public void clickOnRadiobuttons(List<WebElement> radioField, Integer whichValue){
        radioField.get(whichValue).click();
    }

}
