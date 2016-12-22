package builderAutomation.tests;

import java.io.IOException;
import java.util.Set;

import builderAutomation.pages.Pages;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import builderAutomation.util.PropertyLoader;


/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;
  protected static Pages pages;
protected String urlLink;



  public static WebDriver driver;
  public WebDriverWait wait;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;


    }
    capabilities = PropertyLoader.loadCapabilities();
    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\server\\chromedriver.exe");
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);



  }
    public void loginInLxp(String userName, String password){

        pages.getStartPage().getUserNameField().sendKeys(userName);
        pages.getStartPage().getPasswordField().sendKeys(password);
        pages.getStartPage().getLoginButon().click();

    }



  public void prepareToTest(String country, String vertical, String type) throws InterruptedException {

    pages.getAccountPage().clickCreateButton();
    pages.getAccountPage().saveOffer();
    pages.getFormSettingsPage().closePopup();
    setCookie();
    pages.getFormSettingsPage().closePopup();
    pages.getFormSettingsPage().createOffer(country, vertical, type );
   // setCookie();
   // pages.getFormSettingsPage().closePopup();
  }

  public void setCookie() throws InterruptedException {
    driver.manage().deleteAllCookies();
    Cookie cookie = new Cookie("baesid","A5FFFF68-F65E-4821-B7C9-7CDB9C330695");
    driver.manage().addCookie(cookie);
    driver.navigate().refresh();
  }

  public void clickOn(WebElement element){
    element.click();
  }



  @BeforeClass
  public void initWebDriver() throws InterruptedException {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
      wait = new WebDriverWait(driver, 10);
    driver.get(baseUrl);
    driver.manage().window().maximize();

      loginInLxp("lxdapi", "12345");
    prepareToTest("USA", "health", "mf");
      }

  public WebElement waitUntillVisible (WebElement element){
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

      /*@AfterMethod
      public void reloadBuilder() throws InterruptedException {
        driver.get(urlLink);
        wait.until(ExpectedConditions.visibilityOf(pages.getAutoFields().getCreditRating()));
      }*/


  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();


  }
}