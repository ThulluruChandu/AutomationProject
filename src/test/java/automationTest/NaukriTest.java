package automationTest;

import naukriPageAutomation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NaukriTest {

    WebDriver driver;
    private Page loginPage;

    @BeforeMethod
    public void setLoginPage() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.naukri.com/");
        loginPage = new Page(driver);
    }


    @Test
    public void enterValidUsernameAndPassword() throws InterruptedException {
        loginPage.clickOnLogin();
        loginPage.enterEmailId();
        loginPage.enterPassword();
        loginPage.clickOnLoginButton();
//       update basic name details
        loginPage.navigateProfile();
        loginPage.clickOnEdit();
        loginPage.updateUserName();


    }

    @AfterMethod
    public void tearDown() {

        loginPage.logOut();
        driver.quit();
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
