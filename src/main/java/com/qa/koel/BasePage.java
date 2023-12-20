package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver pageDriver;
    WebDriverWait wait;
    Actions actions;
    public BasePage(WebDriver driver){ // not null, driver from BaseTest in 'test' directory
        this.pageDriver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
