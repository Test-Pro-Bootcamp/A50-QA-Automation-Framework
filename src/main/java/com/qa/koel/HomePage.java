package com.qa.koel;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;

public class HomePage extends BasePage {
    @FindBy(css = "a[data-testid='btn-logout']>i")
    private WebElement logOutButton;
    @FindBy(css = "image[class='avatar'")
    private WebElement avatar;
    @FindBy(css = "a[data-testid='view-profile-link'")
    private WebElement viewProfileNameElement;
    @FindBy(xpath = "//i[@title='Create a new playlist']")
    private WebElement plusSign;
    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    private WebElement optionSimpleNewPlaylist;
    @FindBy(css = "input[name='name']")
    private WebElement inputTypeText;
    @FindBy(css = "section[id='playlists']>ul>li:nth-child(4)>a")
    private WebElement createdSimplePlaylistNewP;
    @FindBy(xpath = "//ul/li[4]/nav/ul/li[1]")
    private WebElement editCreatedPlaylistButton;
    @FindBy(css = "input[name='name']")
    private WebElement inputFieldForCreatedPlaylist;
    @FindBy(css = "div>span>button.del")
    private WebElement deletePlaylistButton;
    @FindBy(css = "div.success")
    private WebElement notificationMessage;
    @FindBy(css = "button.ok")
    private WebElement buttonOk;
    @FindBy(css = "ul>li:nth-child(4)>a.active")
    private WebElement newPlaylistName;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public WebElement getLogOutButton(){
        return logOutButton;
    }
    public WebElement getAvatar(){
        return avatar;
    }
    public WebElement getViewProfileElement(){
        return viewProfileNameElement;
    }
    public HomePage createNewPlaylist(){
        actions.moveToElement(plusSign).click();
        return this;
    }
    public HomePage clickOptionSimpleNewPlaylist(){
        optionSimpleNewPlaylist.click();
        return this;
   }
   public HomePage getInputTypeTextField(){
        inputTypeText.isDisplayed();
        return this;
   }
    public HomePage typeInNewPlaylistName(){
        inputTypeText.sendKeys("NewP");
        inputTypeText.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage clickCreatedSimplePlaylistNewP(){
        createdSimplePlaylistNewP.click();
        return this;
    }
    public HomePage contextClickCreatedPlaylistNewP(){
        actions.contextClick(createdSimplePlaylistNewP).perform();
        return this;
    }
    public HomePage clickEditCreatedPlaylistButton(){
        editCreatedPlaylistButton.click();
        return this;
    }
    public HomePage renameCreatedPlaylist(){
        inputFieldForCreatedPlaylist.clear();
        inputFieldForCreatedPlaylist.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        inputFieldForCreatedPlaylist.sendKeys("SimpleNP");
        inputFieldForCreatedPlaylist.sendKeys(Keys.ENTER);
        return this;
    }
    public WebElement getNotificationUpdatedPlaylist(){
        return getNotificationUpdatedPlaylist();
    }
    public HomePage clickDeletePlaylistButton(){
        deletePlaylistButton.click();
        return this;
    }
    public HomePage clickDeleteOkButton(){
        buttonOk.click();
        return this;
   }
    public WebElement notificationDeletedPlaylistName(){
        return notificationMessage;
   }
    public String getChangedPlaylistName(){
        String name = newPlaylistName.getText();
        return name;
    }
}
