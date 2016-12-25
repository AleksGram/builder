package builderAutomation.tests;

import builderAutomation.fields.Fields;
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
      pages.getFields().backTofields();
    }
    public void updateHospitalized() {
      waitUntillVisible(pages.getHealthFields().getSmoker());
      pages.getHealthFields().getSmoker().click();
      pages.getFields().addNewAction("updateByValue", "not use", "Hospitalized", 1, "Yes");
      pages.getFields().backTofields();
    }

    public void addSkipToPage(){
        pages.getHealthFields().getDeniedInsurance().click();
        pages.getFields().addNewAction("skipToAnotherPage", "2", "null", null, "null" );

    }

    public void addRequestsInHeader(){
      String firstNameRequest = "<%= FirstName%>";
      String genderRequest = "<%= Gender%>";
      String insuranceCompanyRequest = "<%= InsuranceCompany%>";

      pages.getFormSettingsPage().changePage(2);
      pages.getFields().getHeaderText().click();


    }


}
