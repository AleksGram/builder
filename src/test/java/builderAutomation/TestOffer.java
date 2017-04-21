package builderAutomation;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestOffer extends TestNgTestBase {

    @BeforeMethod
    public void prepareTest() throws InterruptedException {
        prepareToTest("USA", "auto", "mfs");

    }

    @Test
    public void testMultipleConditions() throws InterruptedException {
        pages.getAutoFields().getInsuranceCompany().click();
        pages.getFields().addAction("updateVisability");
       /* pages.getFields().addAction("updateHeader");
        pages.getFields().addAction("updateByValue");*/
        /* pages.getFields().backTofields();
        pages.getAutoFields().getMaritalStatus().click();
        Thread.sleep(3000);
        pages.getFields().addAction("updateVisability");
        pages.getFields().addAction("updateHeader");
        pages.getFields().addAction("updateByValue");
        pages.getFields().addAction("updateVisability");*/
        pages.getFields().backTofields();
        // pages.getOfferAutoFields().addUpdateFieldAction();

        pages.getFormSettingsPage().saveOffer();
        pages.getFormSettingsPage().openOfferInNewTab();

        wait.until(ExpectedConditions.visibilityOf(pages.getOfferAutoFields().getInsuranceSince()));

        Assert.assertTrue(pages.getOfferAutoFields().getInsuranceSince().isDisplayed());
        pages.getOfferAutoFields().fillPage();
        Assert.assertTrue(pages.getOfferAutoFields().getHeader().getText().contains("BEVERLY HILLS"));
        Assert.assertTrue(pages.getOfferAutoFields().getInsuranceSince().isEnabled());
        }

        @Test
    public void testJumpToPage() throws InterruptedException {
        pages.getAutoFields().getCreditRating().click();
        pages.getFields().addAction("skipToAnotherPage");
        pages.getFields().backTofields();
        pages.getFormSettingsPage().saveOffer();
        pages.getFormSettingsPage().openOfferInNewTab();
        pages.getOfferAutoFields().fillPage();
        Assert.assertTrue(pages.getOfferAutoFields().getHeader().getText().contains("Great News"));
            System.out.println(pages.getOfferAutoFields().getHeader().getText());
        }
    }

