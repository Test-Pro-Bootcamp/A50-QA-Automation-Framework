import io.netty.util.internal.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class LoginTest extends BaseTest {

    @Test(dataProviderClass = ParameterProvider.class, dataProvider = "incorrectCredentialValues", testName = "Login with empty email and password test", groups = "Regression")
    public void loginIncorrectEmailPasswordTest(String email, String password) throws InterruptedException {
        //empty string "" StringUtil.EMPTY_STRING
        loginKoel(email, password);
        Thread.sleep(3000);
        Assert.assertTrue(getDriver().findElement(By.cssSelector("button[type='submit']")).isDisplayed());
    }

    @Test(testName = "Login with correct credentials test", groups = {"Smoke", "Regression"})
    public void loginUserTest() {
        loginKoel("demo@class.com", "te$t$tudent");
        WebElement logoutButton = getDriver().findElement(By.cssSelector("a[data-testid='btn-logout']>i"));
        Assert.assertTrue(logoutButton.isDisplayed());
    }
}
