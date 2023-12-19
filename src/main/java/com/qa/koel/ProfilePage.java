package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {
    static final By CURRENT_PASSWORD_FIELD = By.cssSelector("input[id='inputProfileCurrentPassword']");
    static final By PROFILE_NAME_FIELD = By.cssSelector("input[id='inputProfileName'");
    static final By SAVE_BUTTON = By.cssSelector(".btn-submit");

    public ProfilePage(WebDriver driver){
        super(driver);

    }
    void fillInCurrentPassword(String password){
        WebElement currentPasswordField = pageDriver().findElement(CURRENT_PASSWORD_FIELD);
        currentPasswordField.sendKeys(password);
    }
    void changeProfileNameFieldValue(String newName){
        WebElement profileNameField = pageDriver().findElement(PROFILE_NAME_FIELD);
        profileNameField.clear();
        profileNameField.sendKeys(newName);

    }
    void clickSaveButton() {
        WebElement saveButton = pageDriver().findElement(SAVE_BUTTON);
        saveButton.click();
    }

}
