import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    @Test(testName = "Rename created playlist", groups = {"Smoke", "Regression"})
    public void renamePlaylist(){
        loginKoel("son.nam.kim@testpro.io", "koel08/23");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("a[data-testid='btn-logout']>i"))).isDisplayed();
        createPlaylist();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("#playlists > ul > li:nth-child(4) > a"))).isDisplayed();
        rightClickCreatedPlaylist();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector
                ("input[name='name']"))).isDisplayed();
        renamePlaylistName();
        explicitWait.until(ExpectedConditions.titleIs("SNP"));
        Assert.assertEquals("SNP","SNP");
    }
}
