package com.qa.koel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver pageDriver;
    public BasePage(WebDriver driver){ // not null, driver from BaseTest in 'test' directory
        this.pageDriver = driver;
    }
}
