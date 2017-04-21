package builderAutomation.selenideTests;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by agra on 12/7/2016.
 */
public class SelenideTest {
    @Test
    public void openBuilder() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\server\\chromedriver.exe");
       System.setProperty("selenide.browser", "Chrome");
        open("http://lxpui3.stagingrevi.com/offers/settings/offerviews");
        $(By.name("UserName")).setValue("lxdapi");
        $(By.name("Password")).setValue("1234");
    }
}