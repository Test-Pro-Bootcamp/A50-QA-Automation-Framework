package com.qa.koel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver; // not null after running line 34
    protected String url = "https://qa.koel.app/";

    @BeforeMethod() // setupDriver()
    @Parameters({"baseUrl"}) //https://qa.koel.app/ or https://dev.koel.app/
    public void setupDriver(String baseUrl) throws MalformedURLException {

        driver = pickDriver(System.getProperty("browserName")); //driver = ChromeDriver instance

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));// one time
        driver.manage().window().fullscreen();
        driver.get(url); //open page
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void closerDriver() {
        getDriver().quit();
    }
    public WebDriver pickDriver(String browserName) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridUrl = "http://192.168.1.178:4444/";
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
            case "safari":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return  driver = new RemoteWebDriver(URI.create(gridUrl).toURL(), capabilities);
            default:
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
        }
    }
}