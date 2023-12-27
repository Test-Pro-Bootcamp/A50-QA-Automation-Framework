package com.qa.koel.testng;

import com.qa.koel.pages.HomePage;
import com.qa.koel.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage; //driver = null
    HomePage homePage;

    @Test(dataProviderClass = ParameterProvider.class, dataProvider = "incorrectCredentialValues", testName = "Login with empty email and password test", groups = "Regression")
    public void loginIncorrectEmailPasswordTest(String email, String password) {
        loginPage= new LoginPage(getDriver()); //driver = new ChromeDriver();
        loginPage.loginKoel(email, password);
        homePage = new HomePage(getDriver());

        loginPage.waitUntilInvisibleOfElement(homePage.getHomeMenu(), 5);
        Assert.assertTrue(loginPage.getSubmitButton().isDisplayed());
    }

    @Test(testName = "Login with correct credentials test", groups = {"Smoke", "Regression"})
    public void loginUserTest() {
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("demo@class.com", "te$t$tudent");
        homePage = new HomePage(getDriver());
//......
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }
}
