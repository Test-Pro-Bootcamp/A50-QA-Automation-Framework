package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//form//div[2]//a")
    private WebElement registrationElement;
    @FindBy(css = "form>p:nth-child(4)>input[type='email']")
    private WebElement registrationEmailField;
    @FindBy(css = "div[class='login-wrapper']>h2")
    private WebElement registerNewAccountElement;

    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    public RegistrationPage clickLoginFormRegistrationElement(String s){
        registrationElement.click();
        return this;
    }
    public WebElement registrationPageEmailField(){
        return registrationEmailField;

    }
    public WebElement getRegisterNewAccountElement(){
        return registerNewAccountElement;
    }
}
