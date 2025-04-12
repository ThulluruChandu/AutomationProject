package automationTest;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebDriverManager.chromedriver().driverVersion("135.0.7049.84").setup();
        ChromeOptions options = new ChromeOptions();
          options.addArguments("--headless");               // Run in headless mode
        options.addArguments("--disable-gpu");            // Disable GPU rendering
        options.addArguments("--window-size=1920x1080");  // Set proper viewport size
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        // driver.manage().window().maximize();
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

