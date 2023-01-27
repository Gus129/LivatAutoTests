package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final String HomePageUrl = "https://www.livat.com/hammersmith/en";
    public static final String HomePageTitle = "Livat Hammersmith | Livat - Make Today Different";

    public WebElement LivatLogo() {return driver.findElement(By.xpath("//*[@class='w-36']"));}
    public WebElement LivatMenuButton() {return driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/nav/button/span[1]"));}
    public WebElement LivatMenuFormInnerLink(){ return driver.findElement(By.xpath("//*[@id='submenugroup-2']/li[1]/a"));}
    public WebElement LivatMenuCloseButton(){ return driver.findElement(By.xpath("//*[@id='main-menu']/button/span"));}
    public WebElement LivatMenuOpeningHoursButton(){ return driver.findElement(By.xpath("//*[@id='main-menu']/div/div[4]/a[2]/div"));}



    public void assert_LivatMenuForm_isVisible(){
        Assert.assertTrue(LivatMenuFormInnerLink().isDisplayed(), "Fail: 'LivatMenuForm' is NOT visible");

    }

    public void assert_LivatMenuForm_isNOTVisible(){
        Assert.assertFalse(LivatMenuFormInnerLink().isDisplayed(), "Fail: 'LivatMenuForm' IS visible");
    }



}
