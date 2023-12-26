package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
//    static final By CURRENT_PASSWORD_FIELD = By.cssSelector("input[id='inputProfileCurrentPassword']");
    @FindBy(css = "input[id='inputProfileCurrentPassword']")
    WebElement currentPasswordField;
//    static final By PROFILE_NAME_FIELD = By.cssSelector("input[id='inputProfileName'");
    @FindBy(css = "input[id='inputProfileName'")
    WebElement profileNameField;
//    static final By SAVE_BUTTON = By.cssSelector(".btn-submit");
    @FindBy(css = ".btn-submit")
    WebElement saveButton;

    public ProfilePage(WebDriver driver){
        super(driver);

    }
    ProfilePage fillInCurrentPassword(String password){
//        WebElement currentPasswordField = pageDriver.findElement(CURRENT_PASSWORD_FIELD);
        currentPasswordField.sendKeys(password);
        return this;
    }
    ProfilePage changeProfileNameFieldValue(String newName){
//        WebElement profileNameField = pageDriver.findElement(PROFILE_NAME_FIELD);
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        return this;

    }
    ProfilePage clickSaveButton() {
//        WebElement saveButton = pageDriver.findElement(SAVE_BUTTON);
        saveButton.click();
        return this;
    }
}
