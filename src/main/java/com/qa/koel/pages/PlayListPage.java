package com.qa.koel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PlayListPage extends BasePage {

    @FindBy(css = "i[data-testid='sidebar-create-playlist-btn']")
    WebElement createPlayListBtn;

    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple']")
    WebElement contextMenu;

    @FindBy(css = "li[data-testid='playlist-context-menu-create-simple")
    WebElement createNewPlayListButton;

    @FindBy(css = "form[name='create-simple-playlist-form']>input")
    WebElement createNewPlayListInputField;

    @FindBy(xpath = "//li[contains(@class, 'playlist')]")
    List<WebElement> playLists;

    @FindBy(css = "li[data-testid='playlist-context-menu-delete-79513']")
    WebElement deletePlayListButton;

    public static final String PLAY_LIST_LOCATOR_BY_NAME = "//a[contains(text(),'%s')]";

    public PlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }
     public WebElement getCreatePlayListBtn() {
        return createPlayListBtn;
     }

    public void createPlayList(String playlistName) {
        createPlayListBtn.click();
        waitUntilVisibleOfElement(contextMenu, 5);
        createNewPlayListButton.click();
        waitUntilVisibleOfElement(createNewPlayListInputField, 5);
        createNewPlayListInputField.sendKeys(playlistName);
        createNewPlayListInputField.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getPlayLists() {
        return playLists;
    }

    public void deletePlayListByName(List<WebElement> playLists, String playListName) {
        for (WebElement item : playLists) {
            if (item.getText().equals(playListName)) {
                actions.contextClick(item).perform();
                waitUntilVisibleOfElement(deletePlayListButton, 5);
                deletePlayListButton.click();
            }
        }
    }
}
