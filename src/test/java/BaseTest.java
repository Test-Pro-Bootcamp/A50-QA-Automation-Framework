import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver = null;
    String url = "https://testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void openWebBrowser() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    public WebDriver getDriver() {
        return driver;
    }
    @AfterMethod
    public void closeWebBrowser() {
        getDriver().quit();
    }
    public void enterEmail(String email){
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }
    public void createPlaylist(){
        WebElement plusSign = getDriver().findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
        plusSign.click();

        WebElement buttonNewPlaylist = getDriver().findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
        buttonNewPlaylist.click();

        WebElement inputTypeText = getDriver().findElement(By.cssSelector("form[class='create']>input"));
        inputTypeText.sendKeys("NewP");
        inputTypeText.sendKeys(Keys.ENTER);


    }
    public void addSongUserPlaylist() {
        WebElement playlistAllSongs = getDriver().findElement(By.cssSelector("a[class='songs']"));
        playlistAllSongs.click();

        WebElement songWayOfSamurai = getDriver().findElement(By.cssSelector("tr[class='song-item selected']"));
        songWayOfSamurai.click();

        WebElement buttonAddTo = getDriver().findElement(By.cssSelector("button[class='btn-add-to']"));
        buttonAddTo.click();


    }
}