package com.qa.koel;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(css = "a[data-testid='btn-logout']>i")
    WebElement logOutButton;
    @FindBy(css = "image[class='avatar'")
    WebElement avatar;
    @FindBy(css = "a[data-testid='view-profile-link'")
    WebElement viewProfileNameElement;
    @FindBy(css = "i[data-testid='sidebar-create-playlist-btn']")
    WebElement plusSign;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    WebElement optionSimpleNewPlaylist;
    @FindBy(css = "input[name='name']")
    WebElement inputTypeText;
    @FindBy(css = "#playlists > ul > li:nth-child(4) > a")
    WebElement createdSimplePlaylistNewP;
    @FindBy(xpath = "//ul/li[4]/nav/ul/li[1]")
    WebElement editCreatedPlaylistButton;
    @FindBy(css = "input[name='name']")
    WebElement inputFieldForCreatedPlaylist;
    @FindBy(css = "div>span>button.del")
    WebElement deletePlaylistButton;
    @FindBy(css = "div.success")
    WebElement notificationMessage;
    @FindBy(css = "button.ok")
    WebElement buttonOk;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getLogOutButton(String s){
        return logOutButton;
    }
    public WebElement getAvatar(){
        return avatar;
    }
    public WebElement getViewProfileElement(){
        return viewProfileNameElement;
    }
    public HomePage clickPlusSign(String s){
        actions.moveToElement(plusSign).click();
        return this;
    }
    public HomePage clickOptionSimpleNewPlaylist(String s){
        actions.moveToElement(optionSimpleNewPlaylist).click();
        return this;
   }
   public HomePage getInputTypeTextField(String s){
        inputTypeText.isDisplayed();
        return this;
   }
    public HomePage typeInNewPlaylistName(String s){
        inputTypeText.sendKeys("NewP");
        inputTypeText.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage clickCreatedSimplePlaylistNewP(String s){
        createdSimplePlaylistNewP.click();
        return this;
    }
    public HomePage contextClickCreatedPlaylistNewP(){
        actions.contextClick(createdSimplePlaylistNewP);
        return this;
    }
    public HomePage clickEditCreatedPlaylistButton(){
        editCreatedPlaylistButton.click();
        return this;
    }
    public HomePage renameCreatedPlaylist(){
        inputFieldForCreatedPlaylist.click();
        inputFieldForCreatedPlaylist.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        inputFieldForCreatedPlaylist.sendKeys("SimpleNP");
        inputFieldForCreatedPlaylist.sendKeys(Keys.ENTER);
        return this;
    }
    public WebElement getNotificationUpdatedPlaylist(){
        return getNotificationUpdatedPlaylist();
    }
    public HomePage clickDeletePlaylistButton(String s){
        deletePlaylistButton.click();
        return this;
    }
    public HomePage clickDeleteOkButton(String s){
        buttonOk.click();
        return this;
   }
    public WebElement notificationDeletedPlaylistName(){
        return notificationDeletedPlaylistName();
   }
}
