package automationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NaukriTest {

    public WebDriver setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/bin/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}


















//--------------------------------------------------------------------------

//        loginPage.clickOnEdit();
//        loginPage.clickOnSaveDetails();

//        verify
//        String expectedUserName = "Chandu Thulluru";
//        String actualUserName = loginPage.verifyLogin();
//        Assert.assertEquals(actualUserName, expectedUserName, "Logeed-in username does not macth");

//update basic details
//        loginPage.clickOnEdit();
//        loginPage.clickOnLocationUpdate();

//        update Key Skills
//        loginPage.clickOnKeySkillsUpdate();

//        update Resume Head line

//        loginPage.clickOnUpdateResumeHeadLine();
