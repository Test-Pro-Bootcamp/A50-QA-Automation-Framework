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
    homePage.clickPlusSign("i[class='fa fa-plus-circle create']")
            .clickOptionSimpleNewPlaylist("li[data-testid='playlist-context-menu-create-simple']")
            .typeInNewPlaylistName("form[class='create']>input")
            .clickCreatedSimplePlaylistNewP("#playlists > ul > li:nth-child(4) > a");
    allSongsPage.clickSidePanelListAllSongs("a[class='songs']")
                .clickFirstSongInAllSongsPlaylist("#songsWrapper > div > div > div > table > tr:nth-child(1) > td.title")
                .clickGreenButtonAddTo("button[class='btn-add-to']")
                .clickDropdownMenuPlaylistNewP("#songsWrapper > header > div > div > section > ul > li.playlist");
    homePage.clickCreatedSimplePlaylistNewP("#playlists > ul > li:nth-child(4) > a");
    allSongsPage.getAddedFirstSongToSimpleCreatedPlaylist("#playlistWrapper>div>div>div>table>tr>td.title");
    Assert.assertTrue(allSongsPage.getAddedFirstSongToSimpleCreatedPlaylist("#playlistWrapper>div>div>div>table>tr>td.title").isDisplayed());
    homePage.clickDeletePlaylistButton("div>span>button.del")
            .clickDeleteOkButton("button.ok");
    Assert.assertTrue(homePage.notificationDeletedPlaylistName().isDisplayed());

}
}
