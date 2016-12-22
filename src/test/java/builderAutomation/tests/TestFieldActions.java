package builderAutomation.tests;

import org.testng.annotations.BeforeMethod;

/**
 * Created by Грам on 18.12.2016.
 */
public class TestFieldActions extends TestNgTestBase {
    @BeforeMethod
    public  void prepareActionsForTest() throws InterruptedException {
        prepareToTest("USA", "health", "m");
        System.out.println(driver.getTitle());
    }


}
