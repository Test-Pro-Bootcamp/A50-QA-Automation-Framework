package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    static final By PASSWORD_FIELD = By.cssSelector("input[type='password']"); //declared constanta
    static final By EMAIL_FIELD = By.cssSelector("input[type='email']");
    static final By LOGIN_BUTTON  = By.cssSelector("button[type='submit']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterEmail(String email){  //private because we use it only inside this class
        WebElement emailField = pageDriver.findElement(EMAIL_FIELD);
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordField = pageDriver.findElement(PASSWORD_FIELD);
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        WebElement loginButton = pageDriver.findElement(LOGIN_BUTTON);
        loginButton.click();
    }
    public void loginKoel(String email,String password){
        enterEmail("son.nam.kim@testpro.io");
        enterPassword("koel08/23");
        clickLoginButton();
    }
    public boolean loginButton(){
        return pageDriver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}
