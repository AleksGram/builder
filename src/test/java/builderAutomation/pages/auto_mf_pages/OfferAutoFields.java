package builderAutomation.pages.auto_mf_pages;

import builderAutomation.fields.Fields;
import builderAutomation.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by agra on 11/25/2016.
 */
public class OfferAutoFields extends Fields{

    @FindBy (css = ".bq-name-ZipCode>label>input")
    private WebElement zipCodeInputField;


    public WebElement getInsuranceCompany() {
        return insuranceCompany;
    }

    @FindBy (css = ".bq-field.bq-type-select.bq-name-InsuranceCompany>label>select")
    private WebElement insuranceCompany;

    public WebElement getInsuranceSince() {
        return insuranceSince;
    }

    @FindBy (css = ".bq-name-InsuredSince>label>select")
    private WebElement insuranceSince;

    @FindBy (css = ".bq-name-ResidenceType>label>select")
    private WebElement residanceType;

    @FindBy (css = ".bq-name-MaritalStatus>label>select")
    private WebElement maritalstatus;

    @FindBy (css = ".bq-name-CreditRating>label>select")
    private WebElement creditRating;

    @FindBy (css = ".bq-type-simple-Continue")
    private WebElement continueButton;

    public WebElement getHeader() {
        return header;
    }

    @FindBy (css = ".bq-name-HeaderText")
    private WebElement header;


    public void fillPage () throws InterruptedException {
        waitUntillVisible(zipCodeInputField);
        zipCodeInputField.sendKeys("90210");
      new Select(insuranceCompany).selectByIndex(1);
      // new Select(insuranceSince).selectByIndex(2);
        new Select(residanceType).selectByIndex(1);
       new Select(maritalstatus).selectByIndex(1);
       new Select(creditRating).selectByIndex(2);
        Thread.sleep(3000);
        System.out.println("text of header "+header.getText());
      //  continueButton.click();

    }
public void fillTheSelectField(WebElement field, Integer valueOfSelect){
    waitUntillVisible(field);
    new Select(field).selectByIndex(valueOfSelect);
}
    public void fillTheInputField(WebElement field, String inputValue){
        waitUntillVisible(field).clear();
        field.sendKeys(inputValue);

    }

   }



