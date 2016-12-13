package builderAutomation.fields;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by agra on 11/30/2016.
 */
public class AutoFields extends Fields {


    public WebElement getInsuranceCompany() {
        return insuranceCompany;
    }

    public WebElement getInsuranceSince() {
        return insuranceSince;
    }

    public WebElement getResidenceType() {
        return residenceType;
    }

    public WebElement getCreditRating() {
        return creditRating;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getMake() {
        return make;
    }

    public WebElement getModel() {
        return model;
    }

    public WebElement getEducation() {
        return education;
    }

    public WebElement getBirthDate() {
        return birthDate;
    }

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='InsuranceCompany']")
    private WebElement insuranceCompany;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='InsuredSince']")

    WebElement insuranceSince;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='ResidenceType']")
    WebElement residenceType;

    public WebElement getMaritalStatus() {
        return maritalStatus;
    }

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='MaritalStatus']")
    WebElement maritalStatus;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='CreditRating']")
    WebElement creditRating;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Year']")
    WebElement year;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Make']")
    WebElement make;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Model']")
    WebElement model;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Education']")
    WebElement education;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='BirthDate']")
    WebElement birthDate;

    public void getField(AutoFields field) {


    }


}
