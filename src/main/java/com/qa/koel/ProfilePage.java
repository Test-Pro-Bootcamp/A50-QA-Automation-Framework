package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(css = "input[id='inputProfileCurrentPassword']")
    private WebElement currentPasswordField;
    @FindBy(css = "input[id='inputProfileName'")
    private WebElement profileNameField;
    @FindBy(css = ".btn-submit")
    private WebElement saveButton;

    public ProfilePage(WebDriver driver){
        super(driver);
    }

    ProfilePage fillInCurrentPassword(String password){
        currentPasswordField.sendKeys(password);
        return this;
    }
    ProfilePage changeProfileNameFieldValue(String newName){
        profileNameField.clear();
        profileNameField.sendKeys(newName);
        return this;

    }
    ProfilePage clickSaveButton() {
        saveButton.click();
        return this;
    }
}
