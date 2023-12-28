package com.qa.koel;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AllSongsPage extends BasePage {
    @FindBy(css = "a[class='songs']")
    private WebElement sidePanelListAllSongs;
    @FindBy(css = "tr[class='song-item selected']>td.title")
    private WebElement firstSongInAllSongsPlaylist;
    @FindBy(css = "button[class='btn-add-to']")
    private WebElement greenButtonAddTo;
    @FindBy(css = "#songsWrapper > header > div > div > section > ul > li.playlist")
    private WebElement dropdownMenuPlaylistNewP;
    @FindBy(css = "li.playback")
    private WebElement optionPlayInDropdownMenu;
    @FindBy(css = "div>img")
    private WebElement soundBarsImage;
    @FindBy(css = "#playlistWrapper>div>div>div>table>tr>td.title")
    private WebElement addedFirstSongFromAllSongs;

    public AllSongsPage(WebDriver driver) {
        super(driver);
    }
    public AllSongsPage clickSidePanelListAllSongs(){
        sidePanelListAllSongs.click();
        return this;
    }
    public AllSongsPage clickFirstSongInAllSongsPlaylist(){
        firstSongInAllSongsPlaylist.click();
        return this;
    }
    public AllSongsPage clickGreenButtonAddTo(){
        greenButtonAddTo.click();
        return this;
    }
    public AllSongsPage clickDropdownMenuPlaylistNewP(){
        dropdownMenuPlaylistNewP.click();
        return this;
    }
    public WebElement getAddedFirstSongToSimpleCreatedPlaylist(){
        return addedFirstSongFromAllSongs;
    }
    public AllSongsPage contextClickFirstSongInAllSongsPlaylist(){
        contextClick(firstSongInAllSongsPlaylist);
        return this;
    }
    public AllSongsPage clickOptionPlayInDropdownMenu(){
        optionPlayInDropdownMenu.click();
        return this;
    }
    public WebElement soundBarsImage(){
        return soundBarsImage;
    }
}
