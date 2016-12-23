package builderAutomation.tests;

import builderAutomation.fields.Fields;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Грам on 18.12.2016.
 */
@Test
public class TestFieldActions extends TestNgTestBase {
    public void prepareActionsForTest() {
      pages.getFields().getZipcode().click();
        pages.getFormSettingsPage().goToEditActions();
        pages.getFormSettingsPage().deleteAction();
        pages.getFields().backTofields();
        waitUntillVisible( pages.getHealthFields().getSmoker());
        pages.getHealthFields().getSmoker().click();
        pages.getFields().addNewAction("updateByValue","not use", "Hospitalized",1, "Yes");

    }


}
