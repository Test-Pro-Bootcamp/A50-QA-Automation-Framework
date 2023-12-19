package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

@Test(testName = "Add a song to the playlist", groups = "Smoke")
  public void addSongToPlaylist() throws InterruptedException {

    enterEmail("son.nam.kim@testpro.io");
    enterPassword("koel08/23");
    clickLoginButton();

    Thread.sleep(5000);
    createPlaylist();

    Thread.sleep(5000);
    addSongIntoUserPlaylist();
    Thread.sleep(5000);
    WebElement addedFirstSongFromAllSongs = getDriver().findElement(By.cssSelector
            ("#playlistWrapper>div>div>div>table>tr>td.title"));
    Assert.assertTrue(addedFirstSongFromAllSongs.isDisplayed());
    clickDeletePlaylist();
    Thread.sleep(3000);
    WebElement notificationMessage = getDriver().findElement(By.cssSelector("div>div.success.show"));
    Assert.assertTrue(notificationMessage.isDisplayed());

}
}
