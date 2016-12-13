package builderAutomation.pages;

import builderAutomation.TestNgTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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

  public void clickOn(WebElement element){
    waitUntillVisible(element);
    element.click();
  }


}