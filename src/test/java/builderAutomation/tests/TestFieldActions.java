package builderAutomation.tests;

import builderAutomation.fields.Fields;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Грам on 18.12.2016.
 */

public class TestFieldActions extends TestNgTestBase {

    public void deleteUpdateHeaderAction() {
        pages.getFields().getZipcode().click();
        pages.getFormSettingsPage().goToEditActions();
        pages.getFormSettingsPage().deleteAction();
    }

    public void updateHospitalized() {
        waitUntillVisible(pages.getHealthFields().getSmoker());
        pages.getHealthFields().getSmoker().click();
        pages.getFields().addNewAction("updateByValue", "not use", "Hospitalized", 1, "Yes");
    }

    public void addSkipToPage() {
        pages.getHealthFields().getDeniedInsurance().click();
        pages.getFields().addNewAction("skipToAnotherPage", "2", "null", null, "null");
    }

    public void addRequestsInHeader() {
        String firstNameRequest = "<%= FirstName%>";
        String genderRequest = "<%= Gender%>";
        String insuranceCompanyRequest = "<%= InsuranceCompany%>";

        pages.getFormSettingsPage().changePage(2);
        pages.getFields().getHeaderText().click();
        pages.getFormSettingsPage().getOptionBoxes().get(0).sendKeys("and" + firstNameRequest +
                "and" + genderRequest + "and" + insuranceCompanyRequest);
        pages.getFields().backTofields();

    }

    public void addUpdateHeaderToFields() {
        pages.getFields().getFirstName().click();
        pages.getFields().addNewAction("updateHeader", "null", "null", null, "null");
        pages.getHealthFields().getGender().click();
        pages.getFields().addNewAction("updateHeader", "null", "null", null, "null");
        pages.getHealthFields().getInsuranceCompany().click();
        pages.getFields().addNewAction("updateHeader", "null", "null", null, "null");
    }

    public void updateFirstName() {
        String errorMessage = "Please enter at least 4 characters.";
        pages.getHealthFields().getHouseHoldSize().click();
        pages.getFields().addNewAction("updateValidation", "null", "FirstName", 7, "minLength");
    }

    public void removeNextStepFromControlButton() {
        pages.getFields().getControllButton().click();
        pages.getFormSettingsPage().goToEditActions();
        pages.getFormSettingsPage().deleteAction();
        pages.getFormSettingsPage().changePage(1);

    }


    public void setConditionsInBuilder() throws InterruptedException {
        deleteUpdateHeaderAction();
        updateHospitalized();
        addSkipToPage();
        addRequestsInHeader();
        addUpdateHeaderToFields();
        updateFirstName();
        removeNextStepFromControlButton();
        pages.getFormSettingsPage().saveOffer();
        pages.getFormSettingsPage().openOfferInNewTab();
    }
@Test
        public void test() throws InterruptedException {
        setConditionsInBuilder();
        waitUntillVisible(pages.getHealthOfferFields().getOfferZipCode());
        pages.getHealthOfferFields().getOfferZipCode().sendKeys("0000");
       // pages.getHealthOfferFields().choosingConditions("AidsHiv");
        pages.getHealthOfferFields().clickOnRadiobuttons(pages.getHealthOfferFields().getSmoker(), 1);
        Assert.assertTrue(pages.getHealthOfferFields().getZipCodeErrorMessage().isDisplayed());
        pages.getHealthOfferFields().getOfferZipCodeError().sendKeys("90210");
        pages.getHealthOfferFields().choosingConditions("AidsHiv");
        pages.getHealthOfferFields().clickOnRadiobuttons(pages.getHealthOfferFields().getSmoker(), 0);
        Assert.assertTrue(pages.getHealthOfferFields().getZipCodeErrorMessage().isEnabled());
        Assert.assertTrue(pages.getHealthOfferFields().getHospitalized().get(0).getAttribute("class").contains("bq-active"));
        pages.getHealthOfferFields().clickOnRadiobuttons(pages.getHealthOfferFields().getDenideInsurance(),0);
        Thread.sleep(7000);
        Assert.assertTrue(getCurrentUrl().contains("#page/2"));

        Thread.sleep(5000);
    }
}

