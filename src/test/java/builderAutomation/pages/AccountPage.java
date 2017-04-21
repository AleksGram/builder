package builderAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Грам on 22.11.2016.
 */
public class AccountPage extends Page{

    @FindBy (css = "a.button")
    private WebElement createButton;

    @FindBy (css = "input.ng-pristine")
    private WebElement offerNamefield;

    @FindBy (css = "span.button")
    private WebElement saveButton;

    public void clickCreateButton(){
        waitUntillVisible(createButton).click();

    }
    public void saveOffer(){
        waitUntillVisible(offerNamefield);
        offerNamefield.sendKeys("actionTest");
        waitUntillVisible(saveButton);
        saveButton.click();
    }

}
