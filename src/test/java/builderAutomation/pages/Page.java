package builderAutomation.pages;

import builderAutomation.tests.TestNgTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public abstract class Page {

  public WebDriverWait wait;
  public WebDriver driver = TestNgTestBase.driver;
  public Page() {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, 20);
  }

  public WebElement waitUntillVisible (WebElement element){
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

  public List<WebElement> waitUntillVisible(List<WebElement> list){
    return wait.until(ExpectedConditions.visibilityOfAllElements(list));
  }
  public WebElement waitUntillClikable (WebElement element){
    return wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void clickOn(WebElement element){
    waitUntillVisible(element);
    element.click();
  }


}