package com.qa.koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    static final By PASSWORD_FIELD = By.cssSelector("input[type='password']");
    static final By EMAIL_FIELD = By.cssSelector("input[type='email']");
    static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void enterEmail(String email) {
        WebElement emailField = pageDriver.findElement(EMAIL_FIELD);// or xpath
        emailField.clear();
        emailField.sendKeys(email);
    }
    private void enterPassword(String password) {
        WebElement passwordField = pageDriver.findElement(PASSWORD_FIELD);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public WebElement getSubmitButton() {
        WebElement loginButton = pageDriver.findElement(LOGIN_BUTTON);
        return loginButton;
    }

    private void clickLoginButton() {
        getSubmitButton().click();
    }

    public void loginKoel(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
