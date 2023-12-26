package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    @Test(testName = "Rename created playlist", groups = {"Smoke", "Regression"})
    public void renamePlaylist(){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());

        loginPage.loginKoel("son.nam.kim@testpro.io", "koel08/23");
        homePage.clickPlusSign("i[class='fa fa-plus-circle create']")
                .clickOptionSimpleNewPlaylist("li[data-testid='playlist-context-menu-create-simple']")
                .typeInNewPlaylistName("form[class='create']>input")
                .contextClickCreatedPlaylistNewP()
                .clickEditCreatedPlaylistButton()
                .renameCreatedPlaylist();

        Assert.assertTrue(homePage.getNotificationUpdatedPlaylist().isDisplayed());
    }
}
