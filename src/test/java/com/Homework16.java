package com;

import com.qa.koel.LoginPage;
import com.qa.koel.RegistrationPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{
    RegistrationPage registrationPage;

    @Test
    public void registrationNavigationTest() {
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.registrationElement.click();

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        String url = "https://qa.koel.app/";
//        driver.get(url);


//        WebElement registrationElement = driver.findElement(By.xpath("//form//div[2]//a"));
//        registrationElement.click();

//        WebElement registrationPage = driver.findElement(By.cssSelector("div[class='login-wrapper']>h2"));
        Assert.assertTrue(registrationPage.isDisplayed());
        driver.quit();


        }
    }


