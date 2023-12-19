package com.qa.koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver pageDriver; //null
    WebDriverWait explicitWait;
    Actions actions;

    private static final By SUCCESS_BANNER = By.xpath("//div[contains(@class, 'success')]");

    public BasePage (WebDriver givenDriver) { //WebDriver driver = new ChromeDriver();
        this.pageDriver = givenDriver; //BasePage.pageDriver
        actions = new Actions(pageDriver);
        PageFactory.initElements(pageDriver, this); //driver.findElement()
    }

    public void waitUntilInvisibleOfElement(WebElement element, int timeout) {
        explicitWait = new WebDriverWait(pageDriver, Duration.ofSeconds(timeout));
        explicitWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilVisibleOfElement(WebElement element, int timeout) {
        explicitWait = new WebDriverWait(pageDriver, Duration.ofSeconds(timeout));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilVisibleOfElement(By locator, int timeout) {
        explicitWait = new WebDriverWait(pageDriver, Duration.ofSeconds(timeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement getSuccessBanner() {
        return pageDriver.findElement(SUCCESS_BANNER);
    }
}
