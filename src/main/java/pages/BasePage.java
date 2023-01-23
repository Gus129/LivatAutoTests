package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.time.Clock;
import java.time.Duration;

import static common.Config.EXPLICIT_WAIT;

import static org.testng.AssertJUnit.fail;

public class BasePage {


    public final WebDriver driver;



    public BasePage (WebDriver driver){
        this.driver = driver;
    }



    public WebElement waitElementIsVisible(WebElement element){

        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;

    }






    public void open(String url){
        driver.get(url);
    }

    public void verifyTitle(String pageTitle){
        Assert.assertEquals(pageTitle, driver.getTitle());
    }

    public void verifyField (WebElement fieldName){
        Assert.assertTrue(fieldName.isDisplayed());
        System.out.println("Field '"+fieldName.getAccessibleName()+"' verified – Assert passed");
    }

    // public void verifyField_isMandatory (WebElement fieldName){ - пока не нужно, но если делать то отдельно для каждого филда

    public void assertPageLoaded(String url){
        driver.get(url);
        // Javascript executor to return value
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("return document.readyState")
                .toString().equals("complete");
        // get the current URL
        String s = driver.getCurrentUrl();
        // checking condition if the URL is loaded
        if (s.equals(url)) {
            System.out.println("Page Loaded");
            System.out.println("Current Url: " + s);
        }
        else {
            System.out.println("Page did not load");
        }
    }




}
