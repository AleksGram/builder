package builderAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Грам on 22.11.2016.
 */
public class StartPage extends Page {
    @FindBy (xpath = ".//form/fieldset[1]/input")
    private WebElement offerNameField;

    public WebElement getLoginButon() {
        return loginButon;
    }

    @FindBy (xpath = ".//fieldset[3]/input")
    private WebElement loginButon;



    @FindBy (xpath = ".//fieldset[2]/input")
    private WebElement passwordField;

    public WebElement getOfferNameField() {
        return offerNameField;
    }
    public WebElement getPasswordField() {
        return passwordField;
    }
}
