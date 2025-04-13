package automationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import naukriPageAutomation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NaukriTest {

    WebDriver driver;
    private Page loginPage;

    @BeforeMethod
    public void setLoginPage() {
       WebDriverManager.edgedriver().driverVersion("135.0.3179.54").setup();
       EdgeOptions options = new EdgeOptions();
       options.addArguments("--headless"); // Enable headless mode
       options.addArguments("window-size=1920x1080"); // Set screen size
       options.addArguments("--disable-gpu"); // Disable GPU rendering
       options.addArguments("--disable-software-rasterizer"); // Avoid soft rendering issues
       options.addArguments("--no-sandbox"); // Required for some environments
       options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver();
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
