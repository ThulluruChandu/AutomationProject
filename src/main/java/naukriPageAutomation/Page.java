package naukriPageAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class Page {

    private WebDriver driver;

    private By loginButton = By.xpath("//a[text()='Login']");
    private By enterEmail = By.xpath("//input[@placeholder='Enter your active Email ID / Username']");
    private By enterPassword = By.xpath("//input[@placeholder='Enter your password']");
    private By ClickOnLogin = By.xpath("//button[text()='Login']");

    private By ClickViewProfile = By.xpath("//a[text()='View & Update Profile']");
    private By VerifyPage = By.xpath("//div[@title='Chandu Thulluru']");

    private By ClickOnEditButton = By.xpath("//em[text()='editOneTheme']");

    private By ClickOnLocationButton = By.xpath("//input[@placeholder='Tell us about your current location']");

    private By ClickOnUpdateKeySkillsButton = By.xpath("//span[text()='Key skills']/following-sibling::span[text()='editOneTheme']");

    private By ClickOnSaveButton = By.id("saveBasicDetailsBtn");

    private By MainMenu = By.xpath("//div[@class='nI-gNb-drawer__icon']");

    private By ClickOnSave = By.xpath("//button[text()='Save']");

    private By LogOut = By.xpath("//a[@title='Logout']");

    private By UserName = By.id("name");

    private By ResumeHeadLine = By.xpath("//span[text()='Resume headline']/following-sibling::span[text()='editOneTheme']");

    private By ResumeHeadLineTextArea = By.xpath("//textarea[@class='resumeHeadlineTxt materialize-textarea']");

    public Page(WebDriver driver) {
        this.driver = driver;
    }


    public void clickOnLogin() {
        driver.findElement(loginButton).click();
    }

    public void enterEmailId() {
        driver.findElement(enterEmail).sendKeys("thulluruchandu333@gmail.com");

    }

    public void enterPassword() {
        driver.findElement(enterPassword).sendKeys("Ch@ndu9010");

    }

    public void clickOnLoginButton() {
        driver.findElement(ClickOnLogin).click();
    }

    public String verifyLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(VerifyPage));

        return driver.findElement((By) userName).getText();
    }

    public void navigateProfile() {
        driver.findElement(MainMenu).click();
        driver.findElement(ClickViewProfile).click();
    }

    public void clickOnEdit() {
        driver.findElement(ClickOnEditButton).click();
    }

    public void clickOnLocationUpdate() {

        driver.findElement(ClickOnSaveButton).click();

    }

    public void clickOnUpdateResumeHeadLine() throws InterruptedException {

        driver.wait(2);
        driver.findElement(ResumeHeadLine).click();
        driver.findElement(ResumeHeadLineTextArea).clear();
        driver.findElement(ResumeHeadLineTextArea).sendKeys("Software Test Automation Engineer with 3 Years of Experience in Automation Testing");
        ;
        driver.findElement(ClickOnSave).click();


    }

    public void clickOnSaveDetails() {

        driver.findElement(ClickOnSaveButton).click();

    }

    public void updateResume() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement resumeSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Update resume']")));
        resumeSection.click();
        String resumePath = Paths.get("src/main/resources/resumeFile/Chandu.pdf").toAbsolutePath().toString();
        resumeSection.sendKeys(resumePath);
    }

    public void updateUserName() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(UserName).click();
        driver.findElement(UserName).clear();
        driver.findElement(UserName).sendKeys("Chandu Thulluru");
        driver.findElement(ClickOnSave).click();


    }

    public void logOut() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            WebElement element = driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']"));
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, trying alternative...");
            WebElement fallbackElement = driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__bars']")); // or dismiss interfering element
            fallbackElement.click();
        }

        driver.findElement(LogOut).click();

    }
}


//-------------------------------------------------------------------------------------------------------------


//        WebElement element = driver.findElement(By.xpath("//form[@name='resumeHeadlineForm']"));
//        driver.switchTo().frame(element);

//        WebElement element = driver.findElement(ClickOnUpdateKeySkillsButton);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();",element);
//        driver.findElement(ClickOnUpdateKeySkillsButton).click();


//        driver.findElement(CurrencyUpdate).clear();
//        driver.findElement(CurrencyUpdate).sendKeys("655000");


//        driver.findElement(ClickOnLocationButton).sendKeys("Hyderabad, Telangana");
//      driver.findElement(By.id("resumeHeadlineTxt")).sendKeys("Software Test Automation Engineer with 3+ Years of Experience in Automation Testing");


//        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
//        WebElement Section = wait.until(ExpectedConditions.visibilityOfElementLocated((ResumeHeadLine)));
//        Section.click();

//        driver.findElement(MainMenu).click();