package com.qa.koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "a[data-testid='btn-logout']>i")
    WebElement logoutButton; // driver.findElement(By.css(""selector));

    @FindBy(css = "img[class='avatar']")
    WebElement avatar;

    @FindBy(css = "a[data-testid='view-profile-link']")
    WebElement viewProfileNameElement;

    @FindBy(css = "ul[class='menu']")
    WebElement homeMenu;


    public HomePage(WebDriver driver) {
        super(driver); //BasePage.BasePage();
    }

    public WebElement getLogoutButton() {
        return logoutButton; //driver.finElement();
    }

    public WebElement getAvatar() {
        return avatar;
    }

    public WebElement getViewProfileElement() { // for stale element reference exception
        return pageDriver.findElement(By.cssSelector("a[data-testid='view-profile-link']"));
    }

    public WebElement getHomeMenu() {
        return homeMenu;
    }
}
