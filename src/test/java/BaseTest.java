import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.time.Duration;

public class BaseTest {

    private WebDriver driver = null;
    String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {WebDriverManager.chromedriver().setup();}

    @BeforeMethod
    public void openWebBrowser() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
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
    public void addSongIntoUserPlaylist() {
        WebElement playlistAllSongs = getDriver().findElement(By.cssSelector("a[class='songs']"));
        playlistAllSongs.click();

        WebElement firstSongInAllSongsList = getDriver().findElement(By.cssSelector
                ("#songsWrapper > div > div > div > table > tr:nth-child(1) > td.title"));
        firstSongInAllSongsList.click();

        WebElement buttonAddTo = getDriver().findElement(By.cssSelector("button[class='btn-add-to']"));
        buttonAddTo.click();

        WebElement playlistNewPinDropDownMenu = getDriver().findElement(By.cssSelector
                ("  #songsWrapper > header > div > div > section > ul > li.playlist"));
        playlistNewPinDropDownMenu.click();

        WebElement createdPlaylistNewP = getDriver().findElement(By.cssSelector
                ("#playlists > ul > li:nth-child(4) > a"));
        createdPlaylistNewP.click();

    }
        public void clickDeletePlaylist(){
        WebElement deletePlaylist = getDriver().findElement(By.cssSelector("div>span>button.del"));
        deletePlaylist.click();

        WebElement buttonOk =getDriver().findElement(By.cssSelector("button.ok"));
        buttonOk.click();
    }
    public void clickFirstSongFromAllSongsToPlay(){
        WebElement playlistAllSongs = getDriver().findElement(By.cssSelector("a[class='songs']"));
        playlistAllSongs.click();

        WebElement firstSongInAllSongsList = getDriver().findElement(By.cssSelector
                ("#songsWrapper > div > div > div > table > tr:nth-child(1) > td.title"));
        Actions actions = new Actions(getDriver());
        actions.contextClick(firstSongInAllSongsList).perform();

        WebElement dropDownMenuPlayButton = getDriver().findElement(By.cssSelector("#app>nav>ul>li.playback"));
        dropDownMenuPlayButton.click();

    }

}