package com.qa.koel.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver pageDriver; //null
    WebDriverWait explicitWait;

    public BasePage (WebDriver givenDriver) { //WebDriver driver = new ChromeDriver();
        this.pageDriver = givenDriver; //BasePage.pageDriver
        PageFactory.initElements(pageDriver, this); //driver.findElement()
    }

    public void waitUntilInvisibleOfElement(WebElement element, int timeout) {
        explicitWait = new WebDriverWait(pageDriver, Duration.ofSeconds(timeout));
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }
}
