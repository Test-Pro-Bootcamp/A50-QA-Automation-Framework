import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {
    @Test(testName = "Login with empty email and password test", groups = "Regression")
    public void loginEmptyEmailPassword() {
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }
    @Test(testName = "Login with correct credentials test", groups = {"Smoke","Regression"})
    public void loginUserTest() {

        enterEmail("son.nam.kim@testpro.io");
        enterPassword("koel08/23");
        clickLoginButton();

        WebElement logOutButton = getDriver().findElement(By.cssSelector("a[data-testid='btn-logout']>i"));
        Assert.assertTrue(logOutButton.isDisplayed());
    }
}
