package com.qa.koel;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    static final By LOGOUT_BUTTON = By.cssSelector("a[data-testid='btn-logout']>i");
    static final By AVATAR = By.cssSelector("image[class='avatar'");
    static final By VIEW_PROFILE_NAME_ELEMENT = By.cssSelector("a[data-testid='view-profile-link'");
    static final By PLUS_SIGN = By.cssSelector("i[class='fa fa-plus-circle create']");
    static final By OPTION_SIMPLE_NEW_PLAYLIST =By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    static final By INPUT_FIELD_TYPE_IN_NEW_PLAYLIST_NAME = By.cssSelector("form[class='create']>input");
    static final By CREATED_SIMPLE_PLAYLIST_NEW_P = By.cssSelector("#playlists > ul > li:nth-child(4) > a");
    static final By EDIT_CREATED_PLAYLIST_BUTTON = By.xpath("//ul/li[4]/nav/ul/li[1]");
    static final By INPUT_FIELD_FOR_CREATED_PLAYLIST = By.cssSelector("input[name='name']");
    static final By DELETE_PLAYLIST_BUTTON = By.cssSelector("div>span>button.del");
    static final By NOTIFICATION_MESSAGE = By.cssSelector("div.success");
    static final By DELETE_OK_BUTTON = By.cssSelector("button.ok");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getLogOutButton(){
        return pageDriver.findElement(LOGOUT_BUTTON);
    }
    public WebElement getAvatar(){
        WebElement avatar = pageDriver.findElement(AVATAR);
        return avatar;
    }
    public WebElement getViewProfileElement(){
        return pageDriver.findElement(VIEW_PROFILE_NAME_ELEMENT);
    }
    public void clickPlusSign(){
        WebElement plusSign = pageDriver.findElement(PLUS_SIGN);
        plusSign.click();
    }
    public void clickOptionSimpleNewPlaylist(){
        WebElement optionSimpleNewPlaylist = pageDriver.findElement(OPTION_SIMPLE_NEW_PLAYLIST);
        actions.click(optionSimpleNewPlaylist).perform();
    }
    public void typeInNewPlaylistName(){
        WebElement inputTypeText = pageDriver.findElement(INPUT_FIELD_TYPE_IN_NEW_PLAYLIST_NAME);
        inputTypeText.sendKeys("NewP");
        inputTypeText.sendKeys(Keys.ENTER);
    }
    public void clickCreatedSimplePlaylistNewP(){
        WebElement createdSimplePlaylistNewP = pageDriver.findElement(CREATED_SIMPLE_PLAYLIST_NEW_P);
        createdSimplePlaylistNewP.click();
    }
    public void contextClickCreatedPlaylistNewP(){
        WebElement createdPlaylistNewP = pageDriver.findElement(CREATED_SIMPLE_PLAYLIST_NEW_P);
        actions.contextClick(createdPlaylistNewP).perform();
    }
    public void clickEditCreatedPlaylistButton(){
        WebElement editCreatedPlaylistButton = pageDriver.findElement(EDIT_CREATED_PLAYLIST_BUTTON);
        editCreatedPlaylistButton.click();
    }
    public void renameCreatedPlaylist(){
        WebElement inputFieldForCreatedPlaylist = pageDriver.findElement(INPUT_FIELD_FOR_CREATED_PLAYLIST);
        inputFieldForCreatedPlaylist.click();
        inputFieldForCreatedPlaylist.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        inputFieldForCreatedPlaylist.sendKeys("SimpleNP");
        inputFieldForCreatedPlaylist.sendKeys(Keys.ENTER);
    }
    public WebElement getNotificationUpdatedPlaylist(){
        WebElement notificationUpdatedPlaylist = pageDriver.findElement(NOTIFICATION_MESSAGE);
        return pageDriver.findElement(NOTIFICATION_MESSAGE);
    }

    public void clickDeletePlaylistButton(){
        WebElement deletePlaylist = pageDriver.findElement(DELETE_PLAYLIST_BUTTON);
        deletePlaylist.click();
    }
    public void clickDeleteOkButton(){
        WebElement buttonOk =pageDriver.findElement(DELETE_OK_BUTTON);
        buttonOk.click();
    }
    public WebElement notificationDeletedPlaylistName(){
        WebElement notificationMessage = pageDriver.findElement(NOTIFICATION_MESSAGE);
        return pageDriver.findElement(NOTIFICATION_MESSAGE);
    }

}
