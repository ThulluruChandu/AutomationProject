package automationTest;

import naukriPageAutomation.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class NaukriTest {

    WebDriver driver;
    private Page loginPage;

    @DataProvider(name = "profileData")
    public Object[][] profileData() {
        return new Object[][]{
                {"thulluruchandu333@gmail.com", "Ch@ndu9010", "Chandu Thulluru"},
                {"chanduthulluru666@gmail.com", "Ch@ndu9010", "Chandu T"},
                {"thulluruchandu444@gmail.com", "Ch@ndu9010", "Chandu"},
                {"thulluruchandu555@gmail.com", "Ch@ndu9010", "Chandu Thulluru"},
                {"y_kishore@outlook.com", "kishore9", "KISHORE YERROLLA"}
                // Add more profiles as needed
        };
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.naukri.com/");
        loginPage = new Page(driver);
    }

    @Test(dataProvider = "profileData")
    public void updateProfile(String email, String password, String newName) throws InterruptedException {
        loginPage.clickOnLogin();
        loginPage.enterEmailId(email);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        loginPage.navigateProfile();
        loginPage.clickOnEdit();
        loginPage.updateUserName(newName);
        // Add other update methods if needed
    }

    @AfterMethod
    public void tearDown() {
        loginPage.logOut();
        driver.quit();
    }
}
