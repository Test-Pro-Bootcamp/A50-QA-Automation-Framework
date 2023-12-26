package com.qa.koel;

import com.qa.koel.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    Actions actions;
    WebDriverWait wait;
    @Test(testName = "Delete Created Playlist", groups = {"Smoke","Regression"})
    public void deletePlaylist(){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());

        loginPage.loginKoel("son.nam.kim@testpro.io", "koel08/23");
        homePage.clickPlusSign("i[data-testid='sidebar-create-playlist-btn']")
                .clickOptionSimpleNewPlaylist("li[data-testid='playlist-context-menu-create-simple']")
                .getInputTypeTextField("input[name='name']")
                .typeInNewPlaylistName("input[name='name']")
                .clickCreatedSimplePlaylistNewP("#playlists > ul > li:nth-child(4) > a")
                .clickDeletePlaylistButton("div>span>button.del");

        Assert.assertTrue(homePage.notificationDeletedPlaylistName().isDisplayed());
    }
}
