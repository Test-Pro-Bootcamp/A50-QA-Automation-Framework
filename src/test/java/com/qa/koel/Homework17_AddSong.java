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
    allSongsPage =new AllSongsPage(getDriver());

    loginPage.loginKoel("son.nam.kim@testpro.io","koel08/23");
    homePage.clickPlusSign();
    homePage.clickOptionSimpleNewPlaylist();
    homePage.typeInNewPlaylistName();
    homePage.clickCreatedSimplePlaylistNewP();
    allSongsPage.clickSidePanelListAllSongs();
    allSongsPage.clickFirstSongInAllSongs();
    allSongsPage.clickGreenButtonAddTo();
    allSongsPage.clickDropdownMenuPlaylistNewP();
    homePage.clickCreatedSimplePlaylistNewP();
    allSongsPage.getAddedFirstSongToSimpleCreatedPlaylist();
    Assert.assertTrue(allSongsPage.getAddedFirstSongToSimpleCreatedPlaylist());
    homePage.clickDeletePlaylistButton();
    homePage.clickDeleteOkButton();
    Assert.assertTrue(homePage.notificationDeletedPlaylistName().isDisplayed());

}
}
