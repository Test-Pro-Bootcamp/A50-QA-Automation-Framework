package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {
    static final By REGISTRATION_ELEMENT = By.xpath("//form//div[2]//a");
    static final By REGISTER_NEW_ACCOUNT = By.cssSelector("div[class='login-wrapper']>h2");

    public RegistrationPage(WebDriver driver){
        super(driver);
    }
    public void clickRegistrationElement(){
        WebElement registrationElement = pageDriver.findElement(REGISTRATION_ELEMENT);
        registrationElement.click();
    }
    public boolean getRegisterNewAccountElement(){
        WebElement registerNewAccountElement = pageDriver.findElement(REGISTER_NEW_ACCOUNT);
        return true;
    }
}
