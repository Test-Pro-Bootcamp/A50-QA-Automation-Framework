import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v105.indexeddb.model.Key;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;

import java.time.Duration;



public class BaseTest {
    public WebDriver driver = null;

    public String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters({"baseUrl"})
    public void lunchBrowser (String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }



    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void loginKoel () {
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("igor.pavliuk@testpro.io");

        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("1q2w3e4R");
    }

    public void clickSubmit() {
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }
public void allSongPage() {
    WebElement allSongs = getDriver().findElement(By.cssSelector("a[href='#!/songs']"));
    allSongs.click();
}
public void dClick (String css) {
    Actions action = new Actions(driver);

    WebElement link = driver.findElement(By.cssSelector(css));
    action.doubleClick(link).perform();

}
public void deletePlaylist () {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        deletePlaylistButton.click();
        WebElement okButton = driver.findElement(By.cssSelector("button[class='ok']"));
        okButton.click();

}
}