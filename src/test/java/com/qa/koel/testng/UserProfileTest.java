package com.qa.koel.testng;

import com.qa.koel.pages.HomePage;
import com.qa.koel.pages.LoginPage;
import com.qa.koel.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class UserProfileTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;

    @Test(testName = "Rename user name test", groups = {"Smoke", "Regression", "Add playelist"})
    public void renameUserTest() {
        String newName = UUID.randomUUID().toString();
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("demo@class.com", "te$t$tudent");
        homePage.waitUntilVisibleOfElement(homePage.getAvatar(), 10);
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

    @Test(testName = "Change theme for user profile")
    public void changeUserProfileTheme() throws InterruptedException {
        String themeName = "Oak";
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("demo@class.com", "te$t$tudent");
        homePage = new HomePage(getDriver());
        homePage.waitUntilElementToBeClickable(homePage.getAvatar(), 10);
        homePage.getAvatar().click();
        profilePage = new ProfilePage(getDriver());
        profilePage.changeTheme(themeName);
        Thread.sleep(3000);
        Assert.assertTrue(profilePage.isThemeSelected(themeName));
    }
}
