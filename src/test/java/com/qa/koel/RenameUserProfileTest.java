package com.qa.koel;

import com.qa.koel.pages.HomePage;
import com.qa.koel.pages.LoginPage;
import com.qa.koel.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RenameUserProfileTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;

    @Test(testName = "Rename user name test", groups = {"Smoke", "Regression", "Add playelist"})
    public void renameUserTest() {
        String newName = UUID.randomUUID().toString();
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("demo@class.com", "te$t$tudent");
        homePage.waitUntilInvisibleOfElement(homePage.getAvatar(), 10);
        homePage = new HomePage(getDriver());
        homePage.getAvatar().click();
        profilePage = new ProfilePage(getDriver());
        profilePage.fillCurrentPassword("te$t$tudent");
        profilePage.changeProfileNameFieldValue(newName);
        profilePage.clickSaveButton();
        profilePage.waitUntilInvisibleOfElement(profilePage.getSuccessBanner(), 5);
        Assert.assertEquals(homePage.getViewProfileElement().getText(), newName);
        Assert.assertTrue(homePage.getAvatar().isDisplayed());
    }
}
