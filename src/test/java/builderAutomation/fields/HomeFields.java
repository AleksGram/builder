package builderAutomation.fields;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by agra on 12/6/2016.
 */
public class HomeFields extends Fields {
    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='YearsAtResidence']")
    private WebElement yearsAtResidence;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='PropertyZipCode']")
    private WebElement propertyZipCode;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Address1']")
    private WebElement address1;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='BirthDate']")
    private WebElement birthDate;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Gender']")
    private WebElement gender;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='CreditRating']")
    private WebElement creditRating;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Deductible']")
    private WebElement deductible;
    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Bathrooms']")
    private WebElement bathrooms;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Bedrooms']")
    private WebElement bedrooms;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='IsLivingHere']")
    private WebElement isLivingHere;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Garage']")
    private WebElement garage;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Stories']")
    private WebElement stories;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='PropertyOwned']")
    private WebElement propertyOwned;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='SquareFootage']")
    private WebElement squareFootage;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='PropertyType']")
    private WebElement propertytype;

    @FindBy (xpath = ".//div[@id='bq-left-sidebar']//div[@title='YearBuilt']")
    private WebElement yearBuilt;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='ClaimsOrLossesPast5Years']")
    private WebElement claimsOrLossesPast5Years;

    @FindBy (xpath = ".//div[@id='bq-left-sidebar']//div[@title='PersonalLiabilityCoverage']")
    private WebElement personalLiabilityCoverage;

    @FindBy (xpath = ".//div[@id='bq-left-sidebar']//div[@title='CoverageAmount']")
    private WebElement coverageAmount;

    @FindBy (xpath = ".//div[@id='bq-left-sidebar']//div[@title='InsuredSince']")
    private WebElement insuredSince;

    @FindBy (xpath = ".//div[@id='bq-left-sidebar']//div[@title='InsuranceCompany']")
    private WebElement insuranceCompany;

    public WebElement getYearsAtResidence() {
        return yearsAtResidence;
    }

    public WebElement getPropertyZipCode() {
        return propertyZipCode;
    }

    public WebElement getAddress1() {
        return address1;
    }

    public WebElement getBirthDate() {
        return birthDate;
    }

    public WebElement getGender() {
        return gender;
    }

    public WebElement getCreditRating() {
        return creditRating;
    }

    public WebElement getDeductible() {
        return deductible;
    }

    public WebElement getBathrooms() {
        return bathrooms;
    }

    public WebElement getBedrooms() {
        return bedrooms;
    }

    public WebElement getIsLivingHere() {
        return isLivingHere;
    }

    public WebElement getGarage() {
        return garage;
    }

    public WebElement getStories() {
        return stories;
    }

    public WebElement getPropertyOwned() {
        return propertyOwned;
    }

    public WebElement getSquareFootage() {
        return squareFootage;
    }

    public WebElement getPropertytype() {
        return propertytype;
    }

    public WebElement getYearBuilt() {
        return yearBuilt;
    }

    public WebElement getClaimsOrLossesPast5Years() {
        return claimsOrLossesPast5Years;
    }

    public WebElement getPersonalLiabilityCoverage() {
        return personalLiabilityCoverage;
    }

    public WebElement getCoverageAmount() {
        return coverageAmount;
    }

    public WebElement getInsuredSince() {
        return insuredSince;
    }

    public WebElement getInsuranceCompany() {
        return insuranceCompany;
    }
}
