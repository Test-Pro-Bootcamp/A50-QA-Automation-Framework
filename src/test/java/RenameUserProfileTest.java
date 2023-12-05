import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class RenameUserProfileTest extends BaseTest {

    @Test(testName = "Rename user name test", groups = {"Smoke", "Regression"})
    public void renameUserTest() throws InterruptedException {
        String newName = UUID.randomUUID().toString();

        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginButton();

        Thread.sleep(5000);

        WebElement avatar = getDriver().findElement(By.cssSelector("img[class='avatar']"));
        avatar.click();

        WebElement currentPasswordField = getDriver().findElement(By.cssSelector("input[id='inputProfileCurrentPassword']"));
        currentPasswordField.sendKeys("te$t$tudent");

        WebElement profileNameField = getDriver().findElement(By.cssSelector("input[id='inputProfileName']"));
        profileNameField.clear();
        profileNameField.sendKeys(newName);

        WebElement saveButton = getDriver().findElement(By.cssSelector(".btn-submit"));
        saveButton.click();

        Assert.assertEquals(profileNameField.getText(), newName);
    }
}
