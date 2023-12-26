package com.qa.koel;

import com.qa.koel.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
        LoginPage loginPage;
        HomePage homePage;
    @Test(testName = "Refactor code adding explicit waits")
    public void deletePlaylist() {
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());

        loginPage.loginKoel("son.nam.kim@testpro.io", "koel08/23");
        homePage.clickPlusSign("i[class='fa fa-plus-circle create']")
                .clickOptionSimpleNewPlaylist("li[data-testid='playlist-context-menu-create-simple']")
                .typeInNewPlaylistName("form[class='create']>input")
                .clickCreatedSimplePlaylistNewP("#playlists > ul > li:nth-child(4) > a")
                .clickDeletePlaylistButton("div>span>button.del");
        Assert.assertTrue(homePage.notificationDeletedPlaylistName().isDisplayed());
        }
    }


