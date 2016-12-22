package builderAutomation.pages;

import builderAutomation.fields.AutoFields;
import builderAutomation.fields.Fields;
import builderAutomation.fields.HealthFields;
import builderAutomation.fields.HomeFields;
import builderAutomation.pages.auto_mf_pages.OfferAutoFields;

/**
 * Sample page
 */
public class Pages  {


    public static LoginPage getStartPage() {
      return new LoginPage();
    }
    public static AccountPage getAccountPage(){
        return new AccountPage();
    }
    public static FormSettingsPage getFormSettingsPage(){return new FormSettingsPage();}
    public static OfferAutoFields getOfferAutoFields(){return new OfferAutoFields();}
    public static Fields getFields(){return new Fields();}
    public static AutoFields getAutoFields(){return new AutoFields();}
    public static HomeFields getHomeFields(){return new HomeFields();}
    public static HealthFields getHealthFields() {return new HealthFields();}
}
