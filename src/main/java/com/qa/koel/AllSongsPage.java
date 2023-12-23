package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {
    @FindBy(css = "a[class='songs']")
    WebElement sidePanelListAllSongs;
    //static final By SIDE_PANEL_LIST_ALL_SONGS = By.cssSelector();
    @FindBy(css = "#songsWrapper > div > div > div > table > tr:nth-child(1) > td.title")
    WebElement firstSongInAllSongs;
    //static final By FIRST_SONG_IN_ALL_SONGS = By.cssSelector();
    @FindBy(css = "button[class='btn-add-to']")
    WebElement greenButtonAddTo;
    //static final By GREEN_BUTTON_ADD_TO = By.cssSelector();
    @FindBy(css = "#songsWrapper > header > div > div > section > ul > li.playlist")
    WebElement dropdownMenuPlaylistNewP;
    //static final By DROPDOWN_MENU_PLAYLIST_NEW_P = By.cssSelector();
    @FindBy(css = "#app>nav>ul>li.playback")
    WebElement optionPlayInDropdownMenu;
    //static final  By OPTION_PLAY_IN_DROPDOWN_MENU = By.cssSelector();
    @FindBy(css = "div>img")
    WebElement soundBarsImage;
    //static final By SOUND_BARS_IMAGE = By.cssSelector();
    @FindBy(css = "#playlistWrapper>div>div>div>table>tr>td.title")
    WebElement addedFirstSongToSimpleCreatedPlaylist;
    //static final By ADDED_FIRST_SONG_TO_SIMPLE_CREATED_PLAYLIST = By.cssSelector();

    public AllSongsPage(WebDriver driver) {
        super(driver);
    }
    public WebElement clickSidePanelListAllSongs(){
        return sidePanelListAllSongs;
//        WebElement sidePanelListAllSongs = pageDriver.findElement(SIDE_PANEL_LIST_ALL_SONGS);
//        sidePanelListAllSongs.click();
    }
    public WebElement clickFirstSongInAllSongs(){
        return firstSongInAllSongs;
//        WebElement firstSongInAllSongsPlaylist = pageDriver.findElement(FIRST_SONG_IN_ALL_SONGS);
//        firstSongInAllSongsPlaylist.click();
    }
    public WebElement clickGreenButtonAddTo(){
        return clickGreenButtonAddTo();
//        WebElement greenButtonAddTo = pageDriver.findElement(GREEN_BUTTON_ADD_TO);
//        greenButtonAddTo.click();
    }
    public WebElement clickDropdownMenuPlaylistNewP(){
        return clickDropdownMenuPlaylistNewP();
//        WebElement playlistNewPinDropDownMenu = pageDriver.findElement(DROPDOWN_MENU_PLAYLIST_NEW_P);
//        playlistNewPinDropDownMenu.click();
    }
    public WebElement getAddedFirstSongToSimpleCreatedPlaylist(){
//        WebElement addedFirstSongFromAllSongs = pageDriver.findElement(ADDED_FIRST_SONG_TO_SIMPLE_CREATED_PLAYLIST);
        return addedFirstSongFromAllSongs();
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
