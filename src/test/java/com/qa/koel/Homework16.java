package com.qa.koel;

import com.qa.koel.BaseTest;
import com.qa.koel.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework16 extends BaseTest {
    RegistrationPage registrationPage;

    @Test
    public void registrationNavigationTest() {
        registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickRegistrationElement();
        registrationPage.getRegisterNewAccountElement();

        Assert.assertTrue(registrationPage.getRegisterNewAccountElement());

        }
    }


