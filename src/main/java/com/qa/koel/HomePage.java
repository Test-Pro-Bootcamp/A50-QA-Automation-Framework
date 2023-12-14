package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    static final By LOGOUT_BUTTON = By.cssSelector("a[data-testid='btn-logout']>i");
    static final By AVATAR = By.cssSelector("img[class='avatar']");
    static final By VIEW_PROFILE_NAME_ELEMENT = By.cssSelector("a[data-testid='view-profile-link']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogoutButton() {
        return pageDriver.findElement(LOGOUT_BUTTON);
    }

    public WebElement getAvatar() {
        WebElement avatar = pageDriver.findElement(AVATAR);
        return avatar;
    }

    public WebElement getViewProfileElement() {
        return pageDriver.findElement(VIEW_PROFILE_NAME_ELEMENT);
    }
}
