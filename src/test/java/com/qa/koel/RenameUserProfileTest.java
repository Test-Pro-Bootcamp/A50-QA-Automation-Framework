package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RenameUserProfileTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;

    @Test(testName = "Rename user name test", groups = {"Smoke", "Regression", "Add playelist"})
    public void renameUserTest() throws InterruptedException {
        String newName = UUID.randomUUID().toString();
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("demo@class.com", "te$t$tudent");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        homePage = new HomePage(getDriver());
        homePage.getAvatar().click();
        profilePage = new ProfilePage(getDriver());
        profilePage.fillCurrentPassword("te$t$tudent");
        profilePage.changeProfileNameFieldValue(newName);
        profilePage.clickSaveButton();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'success')]")));
        Assert.assertEquals(homePage.getViewProfileElement().getText(), newName);
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }
}
