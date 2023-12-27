package com.qa.koel;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    @Test(testName = "Delete Created Playlist", groups = {"Smoke","Regression"})
    public void deletePlaylist(){
        loginPage = new LoginPage(getDriver());
        homePage = new HomePage(getDriver());
        actions = new Actions(getDriver());

        loginPage.loginKoel("son.nam.kim@testpro.io", "koel08/23");
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();
        homePage.createNewPlaylist();
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='playlists']/nav/ul/li[1]")));
        homePage.clickOptionSimpleNewPlaylist()
                .getInputTypeTextField()
                .typeInNewPlaylistName()
                .clickCreatedSimplePlaylistNewP()
                .clickDeletePlaylistButton();

        Assert.assertTrue(homePage.notificationDeletedPlaylistName().isDisplayed());
    }
}
