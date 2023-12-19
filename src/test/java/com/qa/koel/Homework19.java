package com.qa.koel;

import com.qa.koel.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test(testName = "Delete Created Playlist", groups = {"Smoke","Regression"})
    public void deletePlaylist() throws InterruptedException {
        loginKoel("son.nam.kim@testpro.io", "koel08/23");
        Thread.sleep(5000);
        createPlaylist();
        Thread.sleep(5000);
        clickDeletePlaylist();
        Thread.sleep(3000);

        WebElement notificationDeletedPlaylistName = getDriver().findElement(By.cssSelector("div.success"));
        Assert.assertTrue(notificationDeletedPlaylistName.isDisplayed());

    }

}
