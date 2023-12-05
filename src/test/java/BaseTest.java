import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    private WebDriver driver = null;
    protected String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url); //open page
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
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
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