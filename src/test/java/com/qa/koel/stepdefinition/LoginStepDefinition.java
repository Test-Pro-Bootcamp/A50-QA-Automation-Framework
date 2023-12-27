package com.qa.koel.stepdefinition;

import com.qa.koel.pages.HomePage;
import com.qa.koel.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginStepDefinition {

    protected String url = "https://qa.koel.app/";
    private WebDriver driver;

    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(url);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @When("I login as user in Koel with {string} and {string}")
    public void loginAsUserWithCredentials(String email, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.enterEmail(email)
                .enterPassword(password)
                .clickLoginButton();
    }

    @Then("I should be authorized in home page")
    public void iShouldBeAuthorized() {
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }

    @After
    public void closerDriver() {
        getDriver().quit();
    }
}
