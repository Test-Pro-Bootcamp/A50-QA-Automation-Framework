package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage; //driver = null
    HomePage homePage;

    @Test(dataProviderClass = ParameterProvider.class, dataProvider = "incorrectCredentialValues", testName = "Login with empty email and password test", groups = "Regression")
    public void loginIncorrectEmailPasswordTest(String email, String password) {
        loginPage= new LoginPage(getDriver());
        loginPage.loginKoel(email, password);

        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ul[class='menu']")));
        Assert.assertTrue(getDriver().findElement(By.cssSelector("button[type='submit']")).isDisplayed());
    }

    @Test(testName = "Login with correct credentials test", groups = {"Smoke", "Regression"})
    public void loginUserTest() {
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("demo@class.com", "te$t$tudent");
        homePage = new HomePage(getDriver());

        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }
}
