package com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;

public class BaseTest {

    private WebDriver driver;
    protected String url = "https://qa.koel.app/";
    WebDriverWait explicitWait;
    Actions actions;

    @BeforeSuite
    static void setupClass() {WebDriverManager.chromedriver().setup();}

    @BeforeMethod
    @Parameters({"baseUrl"})
    public void openWebBrowser(String baseUrl) {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicitlyWait is instantiated once for all tests in helperTest
        explicitWait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        driver.get(baseUrl);
        driver.manage().window().fullscreen(); //added to maximize to original screen size
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void closeWebBrowser() {
        getDriver().quit();
    }





    public void createPlaylist(){
        WebElement plusSign = explicitWait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
        actions.click(plusSign).perform();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));

        WebElement optionNewPlaylist = explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("li[data-testid='playlist-context-menu-create-simple']")));
        actions.click(optionNewPlaylist).perform();

        WebElement inputTypeText = getDriver().findElement(By.cssSelector("form[class='create']>input"));
        inputTypeText.sendKeys("NewP");
        inputTypeText.sendKeys(Keys.ENTER);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > a")));
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

        WebElement createdPlaylistNewP = getDriver().findElement(By.cssSelector
                    ("#playlists > ul > li:nth-child(4) > a"));
        createdPlaylistNewP.click();

        WebElement deletePlaylist = getDriver().findElement(By.cssSelector("div>span>button.del"));
        deletePlaylist.click();

//        WebElement buttonOk =getDriver().findElement(By.cssSelector("button.ok"));
//        buttonOk.click();
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
    public void contextClickCreatedPlaylist(){
        WebElement createdPlaylistNewP = explicitWait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//section[@id='playlists']/ul/li[4]/a")));
        actions.contextClick(createdPlaylistNewP).perform();
    }
    public void changePlaylistName(){
        WebElement editCreatedPlaylistButton = driver.findElement
                (By.xpath("//ul/li[4]/nav/ul/li[1]"));
        actions.moveToElement(editCreatedPlaylistButton).click().perform();
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name='name']")));
        WebElement inputFieldForCreatedPlaylist = explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("input[name='name']")));
        inputFieldForCreatedPlaylist.click();
        inputFieldForCreatedPlaylist.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        inputFieldForCreatedPlaylist.sendKeys("SimpleNP");
        inputFieldForCreatedPlaylist.sendKeys(Keys.ENTER);
    }
    public String getChangedPlaylistName(){
        WebElement newPlaylistName = explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("ul>li:nth-child(4)>a.active")));
        String name = newPlaylistName.getText();
        return name;

    }

}