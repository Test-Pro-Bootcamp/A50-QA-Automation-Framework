import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver = null; // not null after running line 34
    protected String url = "https://qa.koel.app/";
    WebDriverWait explicitWait = null;
    Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod // setupDriver()
    @Parameters({"baseUrl"}) //https://qa.koel.app/ or https://dev.koel.app/
    public void setupDriver(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); //driver = ChromeDriver instance

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// one time
        driver.manage().window().fullscreen();
        driver.get(url); //open page
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void closerDriver() {
        getDriver().quit();
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));// or xpath
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public void loginKoel(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}