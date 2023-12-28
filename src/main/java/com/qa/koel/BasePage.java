package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver pageDriver;
    protected WebDriverWait wait;
    protected Actions actions;
    public BasePage(WebDriver driver){ // not null, driver from BaseTest in 'test' directory
        this.pageDriver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(pageDriver,this);
    }
    protected void click(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
    protected WebElement findElement(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) webElement));
    }
    protected void contextClick(WebElement webElement){
        actions.contextClick(findElement(webElement)).perform();
    }
}
