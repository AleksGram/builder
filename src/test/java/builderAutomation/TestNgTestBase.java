package builderAutomation;

import java.io.IOException;
import java.util.Set;

import builderAutomation.pages.Pages;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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
    pages.getFormSettingsPage().createOffer(country, vertical, type );
    setCookie();
    pages.getFormSettingsPage().closePopup();
  }

  public void setCookie(){
    driver.manage().deleteAllCookies();
    Cookie cookie = new Cookie("baesid","0C3CE665-DD0E-4236-BA1D-28C400AE2011");
    driver.manage().addCookie(cookie);
    driver.navigate().refresh();
  }



  @BeforeMethod
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
      wait = new WebDriverWait(driver, 10);
    driver.get(baseUrl);
//    driver.manage().window().maximize();

      loginInLxp("lxdapi", "12345");

      }


  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverFactory.dismissAll();
  }
}