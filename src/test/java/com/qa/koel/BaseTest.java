package com.qa.koel;

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
    
}