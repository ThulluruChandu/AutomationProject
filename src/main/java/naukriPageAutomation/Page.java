package naukriPageAutomation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Page {

    private WebDriver driver;

    private By loginButton = By.xpath("//a[text()='Login']");
    private By enterEmail = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
    private By enterPassword = By.xpath("//input[@placeholder='Enter your password']");
    private By ClickOnLogin = By.xpath("//button[text()='Login']");

    private By ClickViewProfile = By.xpath("//a[text()='View & Update Profile']");
    private By VerifyPage = By.xpath("//div[@title='Chandu Thulluru']");

    private By ClickOnEditButton = By.xpath("//em[text()='editOneTheme']");
    private By ClickOnSaveButton = By.id("saveBasicDetailsBtn");
    private By MainMenu = By.xpath("//div[@class='nI-gNb-drawer__icon']");
    private By ClickOnSave = By.xpath("//button[text()='Save']");
    private By LogOut = By.xpath("//a[@title='Logout']");
    private By UserName = By.xpath("//*[@id='name']");
    private By ResumeHeadLine = By.xpath("//span[text()='Resume headline']/following-sibling::span[text()='editOneTheme']");
    private By ResumeHeadLineTextArea = By.xpath("//textarea[@class='resumeHeadlineTxt materialize-textarea']");

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLogin() {
        driver.findElement(loginButton).click();
    }

    public void enterEmailId(String email) {
        driver.findElement(enterEmail).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(enterPassword).sendKeys(password);
    }

    public void clickOnLoginButton() {
        driver.findElement(ClickOnLogin).click();
    }

    public void navigateProfile() {

        // Handle modal popup if present
        try {
            // Wait briefly for the popup close button to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            By closePopupButton = By.xpath("//div[@class='crossIcon chatBot chatBot-ic-cross']");
            WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(closePopupButton));
            closeBtn.click();
        } catch (TimeoutException e) {
            // Popup not present, continue
        } catch (NoSuchElementException e) {
            // Popup not present, continue
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(MainMenu).click();
        driver.findElement(ClickViewProfile).click();
    }

    public void clickOnEdit() {
        driver.findElement(ClickOnEditButton).click();
    }

    public void updateUserName(String newName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameElement = wait.until(ExpectedConditions.elementToBeClickable(UserName));
        userNameElement.click();
        Thread.sleep(3000);
        userNameElement.clear();
        if (!userNameElement.getAttribute("value").isEmpty()) {
            userNameElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            userNameElement.sendKeys(Keys.DELETE);
        }
        userNameElement.sendKeys(newName);
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(ClickOnSave));
        saveButton.click();
    }

    public void logOut() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            WebElement element = driver.findElement(MainMenu);
            element.click();
        } catch (ElementClickInterceptedException e) {
            WebElement fallbackElement = driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__bars']"));
            fallbackElement.click();
        }
        driver.findElement(LogOut).click();
    }
}
