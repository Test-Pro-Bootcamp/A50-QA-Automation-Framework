package com.qa.koel;

import com.qa.koel.BaseTest;
import com.qa.koel.HomePage;
import com.qa.koel.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.koel.LoginPage.LOGIN_BUTTON;


public class LoginTests extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    @Test(testName = "Login with empty email and password test", groups = "Regression")
    public void loginEmptyEmailPassword(String email,String password) {
         loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("", "");

        Assert.assertTrue(loginPage.loginButton());
    }

    @Test(testName = "Login with correct credentials test", groups = {"Smoke","Regression"})
    public void loginUserTest() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        loginPage.enterEmail("son.nam.kim@testpro.io");
        loginPage.enterPassword("koel08/23");
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.getLogOutButton().isDisplayed());
    }
}
