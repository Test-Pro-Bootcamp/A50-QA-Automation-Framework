import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
public class HomeWork19 extends BaseTest {

    @Test(testName = "Delete playlist")

    public void deletePlaylistTest() throws InterruptedException {
        loginKoel();

        clickSubmit();
WebElement playlists = getDriver().findElement(By.cssSelector("li[class='playlist playlist']"));
playlists.click();

//Thread.sleep(1000);
deletePlaylist();
        WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='success show']")));
        WebElement successShow = getDriver().findElement(By.cssSelector("div[class='success show']"));
Assert.assertTrue(successShow.isDisplayed());


    }  




}
