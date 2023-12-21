package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16_Registration extends BaseTest {
    LoginPage loginPage;
    RegistrationPage registrationPage;

    @Test
    public void registrationNavigationTest() {
        loginPage = new LoginPage(getDriver());
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickLoginFormRegistrationElement();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("form>p:nth-child(4)>input[type='email']")));
        registrationPage.registrationPageEmailField().isDisplayed();

        Assert.assertTrue(registrationPage.getRegisterNewAccountElement());

        }
    }


