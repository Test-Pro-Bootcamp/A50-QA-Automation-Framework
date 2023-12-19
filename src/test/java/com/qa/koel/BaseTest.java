package com.qa.koel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public abstract class BaseTest {

    private WebDriver driver; // not null after running line 34
    protected String url = "https://qa.koel.app/";

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
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void closerDriver() {
        getDriver().quit();
    }

}