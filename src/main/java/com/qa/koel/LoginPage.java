package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
    private WebElement emailField;
    @FindBy(css = "input[type='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage enterEmail(String email){  //private because we use it only inside this class
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }
    public LoginPage loginKoel(String email,String password){
        enterEmail("son.nam.kim@testpro.io");
        enterPassword("koel08/23");
        clickLoginButton();
        return this;
    }
    public WebElement loginButton(){
        return loginButton;
    }
}
