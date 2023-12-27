package com.qa.koel;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17_AddSong extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AllSongsPage allSongsPage;
  @Test(testName = "Add a song to the playlist", groups = "Smoke")
  public void addSongToPlaylist(){
    loginPage = new LoginPage(getDriver());
    homePage = new HomePage(getDriver());
    allSongsPage = new AllSongsPage(getDriver());

    loginPage.loginKoel("son.nam.kim@testpro.io","koel08/23");
    homePage.createNewPlaylist()
            .clickOptionSimpleNewPlaylist()
            .typeInNewPlaylistName()
            .clickCreatedSimplePlaylistNewP();
    allSongsPage.clickSidePanelListAllSongs()
                .clickFirstSongInAllSongsPlaylist()
                .clickGreenButtonAddTo()
                .clickDropdownMenuPlaylistNewP();
    homePage.clickCreatedSimplePlaylistNewP()
            .clickDeletePlaylistButton()
            .clickDeleteOkButton();
    Assert.assertTrue(homePage.notificationDeletedPlaylistName().isDisplayed());

}
}
