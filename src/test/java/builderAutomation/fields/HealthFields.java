package builderAutomation.fields;

import builderAutomation.pages.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by agra on 12/22/2016.
 */
public class HealthFields extends Fields {
    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='DeniedInsurance']")
    private WebElement deniedInsurance;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Conditions']")
    private WebElement conditions ;


    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Gender']")
    private WebElement gender ;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Pregnant']")
    private WebElement pregnant;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Hospitalized']")
    private WebElement hospitalized;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Smoker']")
    private WebElement smoker;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Weight']")
    private WebElement weight;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='HouseHoldIncome']")
    private WebElement houseHoldIncome;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='HouseHoldSize']")
    private WebElement houseHoldSize;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='Height']")
    private WebElement Height;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='ExpirationDate']")
    private WebElement expirationDate;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='InsuredSince']")
    private WebElement insuredSince;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='InsuranceCompany']")
    private WebElement insuranceCompany;

    @FindBy(xpath = ".//div[@id='bq-left-sidebar']//div[@title='CoverageType']")
    private WebElement coverageType;


    public WebElement getGender() {
        return gender;
    }

    public WebElement getDeniedInsurance() {
        return deniedInsurance;
    }

    public WebElement getConditions() {
        return conditions;
    }

    public WebElement getPregnant() {
        return pregnant;
    }

    public WebElement getHospitalized() {
        return hospitalized;
    }

    public WebElement getSmoker() {
        return smoker;
    }

    public WebElement getWeight() {
        return weight;
    }

    public WebElement getHouseHoldIncome() {
        return houseHoldIncome;
    }

    public WebElement getHouseHoldSize() {
        return houseHoldSize;
    }

    public WebElement getHeight() {
        return Height;
    }

    public WebElement getExpirationDate() {
        return expirationDate;
    }

    public WebElement getInsuredSince() {
        return insuredSince;
    }

    public WebElement getInsuranceCompany() {
        return insuranceCompany;
    }

    public WebElement getCoverageType() {
        return coverageType;
    }
}
