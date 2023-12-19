package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test(testName = "Play A Song", groups = {"Smoke","Regression"})

    public void playSong() throws InterruptedException{
        enterEmail("son.nam.kim@testpro.io");
        enterPassword("koel08/23");
        clickLoginButton();
        Thread.sleep(5000);
        clickFirstSongFromAllSongsToPlay();
        Thread.sleep(3000);
        WebElement soundBarsImage = getDriver().findElement(By.cssSelector("div>img"));
        Assert.assertTrue(soundBarsImage.isDisplayed());

    }
}
