package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllSongsPage extends BasePage {
    static final By SIDE_PANEL_LIST_ALL_SONGS = By.cssSelector("a[class='songs']");
    static final By FIRST_SONG_IN_ALL_SONGS = By.cssSelector
            ("#songsWrapper > div > div > div > table > tr:nth-child(1) > td.title");
    static final By GREEN_BUTTON_ADD_TO = By.cssSelector("button[class='btn-add-to']");
    static final By DROPDOWN_MENU_PLAYLIST_NEW_P = By.cssSelector
            ("#songsWrapper > header > div > div > section > ul > li.playlist");
    static final  By OPTION_PLAY_IN_DROPDOWN_MENU = By.cssSelector("#app>nav>ul>li.playback");
    static final By SOUND_BARS_IMAGE = By.cssSelector("div>img");
    static final By ADDED_FIRST_SONG_TO_SIMPLE_CREATED_PLAYLIST = By.cssSelector
            ("#playlistWrapper>div>div>div>table>tr>td.title");

    public AllSongsPage(WebDriver driver) {
        super(driver);
    }
    public void clickSidePanelListAllSongs(){
        WebElement sidePanelListAllSongs = pageDriver.findElement(SIDE_PANEL_LIST_ALL_SONGS);
        sidePanelListAllSongs.click();
    }
    public void clickFirstSongInAllSongs(){
        WebElement firstSongInAllSongsPlaylist = pageDriver.findElement(FIRST_SONG_IN_ALL_SONGS);
        firstSongInAllSongsPlaylist.click();
    }
    public void clickGreenButtonAddTo(){
        WebElement greenButtonAddTo = pageDriver.findElement(GREEN_BUTTON_ADD_TO);
        greenButtonAddTo.click();
    }
    public void clickDropdownMenuPlaylistNewP(){
        WebElement playlistNewPinDropDownMenu = pageDriver.findElement(DROPDOWN_MENU_PLAYLIST_NEW_P);
        playlistNewPinDropDownMenu.click();
    }
    public boolean getAddedFirstSongToSimpleCreatedPlaylist(){
        WebElement addedFirstSongFromAllSongs = pageDriver.findElement(ADDED_FIRST_SONG_TO_SIMPLE_CREATED_PLAYLIST);
        return addedFirstSongFromAllSongs.isDisplayed();
    }
    public void contextClickFirstSongInAllSongsPlaylist(){
        WebElement firstSongInAllSongsPlaylist = pageDriver.findElement(By.cssSelector
                ("#songsWrapper > div > div > div > table > tr:nth-child(1) > td.title"));
        actions.contextClick(firstSongInAllSongsPlaylist).perform();
    }
    public void clickOptionPlayInDropdownMenu(){
        WebElement optionPlayInDropdownMenu = pageDriver.findElement(OPTION_PLAY_IN_DROPDOWN_MENU);
        optionPlayInDropdownMenu.click();
    }
    public WebElement soundBarsImage(){
        WebElement soundBarsImage = pageDriver.findElement(SOUND_BARS_IMAGE);
        return pageDriver.findElement(SOUND_BARS_IMAGE);
    }
}
