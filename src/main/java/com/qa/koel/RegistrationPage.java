package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
//    static final By REGISTRATION_ELEMENT = By.xpath("//form//div[2]//a");
    @FindBy(xpath = "//form//div[2]//a")
    WebElement registrationElement;
//    static final By REGISTRATION_EMAIL_FIELD = By.cssSelector("form>p:nth-child(4)>input[type='email']");
    @FindBy(css = "form>p:nth-child(4)>input[type='email']")
    WebElement registrationEmailField;
    static final By REGISTER_NEW_ACCOUNT = By.cssSelector("div[class='login-wrapper']>h2");
    @FindBy(css = "div[class='login-wrapper']>h2")
    WebElement registerNewAccountElement;

    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    public RegistrationPage clickLoginFormRegistrationElement(String s){
//        WebElement registrationElement = pageDriver.findElement(REGISTRATION_ELEMENT);
        registrationElement.click();
        return this;
    }
    public WebElement registrationPageEmailField(){
//        WebElement registrationEmailField = pageDriver.findElement(REGISTRATION_EMAIL_FIELD);
        return registrationEmailField;

    }
    public WebElement getRegisterNewAccountElement(){
//        WebElement registerNewAccountElement = pageDriver.findElement(REGISTER_NEW_ACCOUNT);
        return registerNewAccountElement;
    }
}
