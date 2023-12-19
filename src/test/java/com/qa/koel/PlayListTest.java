package com.qa.koel;

import com.qa.koel.pages.LoginPage;
import com.qa.koel.pages.PlayListPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class PlayListTest extends BaseTest {
    LoginPage loginPage;
    PlayListPage playListPage;

    @Test
    public void deletePlayList() {
        String playListName = UUID.randomUUID().toString();
        loginPage = new LoginPage(getDriver());
        loginPage.loginKoel("demo@class.com", "te$t$tudent");
        playListPage = new PlayListPage(getDriver());
        playListPage.waitUntilVisibleOfElement(playListPage.getCreatePlayListBtn(), 5);
        playListPage.createPlayList(playListName);
        playListPage.waitUntilVisibleOfElement(By.xpath(String.format(playListPage.PLAY_LIST_LOCATOR_BY_NAME, playListName)), 5);
        playListPage.deletePlayListByName(playListPage.getPlayLists(), playListName);
        Assert.assertFalse(playListPage.getPlayLists().contains(playListName));
    }
}
