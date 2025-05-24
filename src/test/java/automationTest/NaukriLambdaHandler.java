package automationTest;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import naukriPageAutomation.Page;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class NaukriLambdaHandler implements RequestHandler<Map<String, String>, String> {

    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        NaukriTest seleniumSetup = new NaukriTest();
        WebDriver driver = seleniumSetup.setupDriver();

        driver.get("https://www.naukri.com");
        Page loginPage = new Page(driver);
        try {
            // Perform actions like login, navigation, updates
            // Example:
            loginPage.clickOnLogin();
            // Perform other operations...
            loginPage.enterEmailId();
            loginPage.enterPassword();
            loginPage.clickOnLoginButton();
//       update basic name details
            loginPage.navigateProfile();
            loginPage.clickOnEdit();
            loginPage.updateUserName();
            
            return "Success";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        } finally {
            loginPage.logOut();
            driver.quit();
        }
    }
}