import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test(testName = "Login with empty email and password test", groups = "Regression")
    public void loginEmptyEmailPasswordTest() {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    @Test(testName = "Login with correct credentals test", groups = {"Smoke", "Regression"})
    public void loginUserTest() {
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginButton();

        WebElement logoutButton = getDriver().findElement(By.cssSelector("a[data-testid='btn-logout']>i"));

        Assert.assertTrue(logoutButton.isDisplayed());
    }
}
