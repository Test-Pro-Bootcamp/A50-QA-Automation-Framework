package com.qa.koel;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {
    @FindBy(css = "a[class='songs']")
    WebElement sidePanelListAllSongs;
    @FindBy(css = "tr[class='song-item selected']>td.title")
    WebElement firstSongInAllSongsPlaylist;
    @FindBy(css = "button[class='btn-add-to']")
    WebElement greenButtonAddTo;
    @FindBy(css = "#songsWrapper > header > div > div > section > ul > li.playlist")
    WebElement dropdownMenuPlaylistNewP;
    @FindBy(css = "li.playback")
    WebElement optionPlayInDropdownMenu;
    @FindBy(css = "div>img")
    WebElement soundBarsImage;
    @FindBy(css = "#playlistWrapper>div>div>div>table>tr>td.title")
    WebElement addedFirstSongFromAllSongs;

    public AllSongsPage(WebDriver driver) {
        super(driver);
    }
    public AllSongsPage clickSidePanelListAllSongs(String s){
        actions.moveToElement(sidePanelListAllSongs).click();
        return this;
    }
    public AllSongsPage clickFirstSongInAllSongsPlaylist(String s){
        actions.moveToElement(firstSongInAllSongsPlaylist).click();
        return this;
    }
    public AllSongsPage clickGreenButtonAddTo(String s){
        greenButtonAddTo.click();
        return this;
    }
    public AllSongsPage clickDropdownMenuPlaylistNewP(String s){
        dropdownMenuPlaylistNewP.click();
        return this;
    }
    public WebElement getAddedFirstSongToSimpleCreatedPlaylist(String s){
        return addedFirstSongFromAllSongs;
    }
    public AllSongsPage contextClickFirstSongInAllSongsPlaylist(String s){
        actions.contextClick(firstSongInAllSongsPlaylist);
        return this;
    }
    public AllSongsPage clickOptionPlayInDropdownMenu(String s){
        actions.moveToElement(optionPlayInDropdownMenu).click();
        return this;
    }
    public WebElement soundBarsImage(String s){
        return soundBarsImage;
    }
}
