//package com.qa.koel;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//import java.util.UUID;
//
//public class PlayListTest extends BaseTest {
//
//    @Test
//    public void deletePlayList() {
//        String playListName = UUID.randomUUID().toString();
//        String playListLocatorByName = "//a[contains(text(),'%s')]";
//        new LoginPage(getDriver()).loginKoel("demo@class.com", "te$t$tudent");
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']")));
//        createPlayList(playListName);
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(playListLocatorByName, playListName))));
//        List<WebElement> playLists = getDriver().findElements(By.xpath("//li[contains(@class, 'playlist')]"));
//        deletePlayListByName(playLists, playListName);
//        Assert.assertFalse(playLists.contains(playListName));
//    }
//
//    public void createPlayList(String playlistName) {
//        WebElement createButton = getDriver().findElement(By.cssSelector("i[data-testid='sidebar-create-playlist-btn']"));
//        createButton.click();
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']")));
//        WebElement createNewPlayListButton = getDriver().findElement(By.cssSelector("li[data-testid='playlist-context-menu-create-simple']"));
//        createNewPlayListButton.click();
//        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form[name='create-simple-playlist-form']>input")));
//        WebElement createNewPlayListInputField = getDriver().findElement(By.cssSelector("form[name='create-simple-playlist-form']>input"));
//        createNewPlayListInputField.sendKeys(playlistName);
//        createNewPlayListInputField.sendKeys(Keys.ENTER);
//    }
//
//    public void deletePlayListByName(List<WebElement> playLists, String playListName) {
//        for (WebElement item : playLists) {
//            if (item.getText().equals(playListName)) {
//               actions.contextClick(item).perform();
//               explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[data-testid='playlist-context-menu-delete-79513']")));
//               WebElement deletePlayListButton = getDriver().findElement(By.cssSelector("li[data-testid='playlist-context-menu-delete-79513']"));
//               deletePlayListButton.click();
//            }
//        }
//    }
//}
