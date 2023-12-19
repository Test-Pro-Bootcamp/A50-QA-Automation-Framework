package com.qa.koel;

import com.qa.koel.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test(testName = "Refactor code adding explicit waits")
    public void deletePlaylist() throws InterruptedException {
        loginKoel("son.nam.kim@testpro.io", "koel08/23");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-testid='btn-logout']>i"))).isDisplayed();
        createPlaylist();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(4) > a"))).isDisplayed();
        clickDeletePlaylist();
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div>span>button.del")));
        WebElement notificationDeletedPlaylistName = getDriver().findElement(By.cssSelector("div.success"));
        Assert.assertTrue(notificationDeletedPlaylistName.isDisplayed());
        }
    }


