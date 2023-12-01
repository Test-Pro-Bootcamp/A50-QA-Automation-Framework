import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Homework16 extends BaseTest{

    @Test
    public void registrationNavigationTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);


        WebElement registrationElement = driver.findElement(By.xpath("//form//div[2]//a"));
        registrationElement.click();

        WebElement registrationPage = driver.findElement(By.cssSelector("div[class='login-wrapper']>h2"));
        Assert.assertTrue(registrationPage.isDisplayed());
        driver.quit();


        }
    }


