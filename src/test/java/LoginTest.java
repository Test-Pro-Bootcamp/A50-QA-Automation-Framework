import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test
    public void loginEmptyEmailPasswordTest() {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test
    public void loginUserTest() {

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.sendKeys("son.nam.kim@testpro.io");

        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.sendKeys("koel08/23");

        WebElement loginButton = getDriver().findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement logOutButton = getDriver().findElement(By.cssSelector("a[data-testid='btn-logout']>i"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }
}
