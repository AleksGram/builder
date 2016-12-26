package builderAutomation.tests;

import builderAutomation.fields.Fields;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Грам on 18.12.2016.
 */
@Test
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
    }

    @Test
    public void test() {
        deleteUpdateHeaderAction();
      //  updateHospitalized();
        addSkipToPage();
        addRequestsInHeader();
        addUpdateHeaderToFields();
        updateFirstName();
        removeNextStepFromControlButton();
    }
}
