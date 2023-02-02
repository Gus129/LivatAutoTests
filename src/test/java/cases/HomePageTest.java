package cases;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static pages.HomePage.*;
import static pages.OpeningHoursPage.OpeningHoursTitle;
import static pages.OpeningHoursPage.OpeningHoursUrl;

public class HomePageTest extends BaseTest{

    @Test //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void check_HomePage_AppearCorrect(){

        basePage.open(HomePageUrl);
        basePage.assertPageLoaded(HomePageUrl);
        basePage.verifyTitle(HomePageTitle);
    }

    @Test
    public void verify_HomePage_LogoAndMenu_whenScrolled(){

        basePage.open(HomePageUrl);

        basePage.scrollToBottom();
        basePage.assertWebElement_isVisibleInViewport(HomePage.LivatMenuButton());

        basePage.scrollToTop();
        basePage.assertWebElement_isVisibleInViewport(HomePage.LivatMenuButton());

        basePage.scrollToBottom();
        basePage.assertWebElement_isNOTVisibleInViewport(HomePage.LivatLogo());
        basePage.scrollToTop();
    }

    @Test
    public void verify_LogoClick_backto_HomePage() throws InterruptedException {

        basePage.open(HomePageUrl);
        basePage.assertPageLoaded(HomePageUrl);

        basePage.open(OpeningHoursUrl);
        basePage.assertPageLoaded(OpeningHoursUrl);

        WebElement LivatLogoAnyPage = driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/div/header/div/div[1]/a"));
        LivatLogoAnyPage.click();
        Thread.sleep(1100);
        basePage.verifyTitle(HomePageTitle);

    }

    @Test
    public void verify_HomePage_Menu_whenOpeningHours() throws InterruptedException { // Ajax элементы не признаю обычный exp-wait, пока что такое костыльное решение

        basePage.open(HomePageUrl);
        basePage.assertPageLoaded(HomePageUrl);

        Thread.sleep(1100);
        basePage.waitElementIsVisible(HomePage.LivatMenuButton());
        HomePage.LivatMenuButton().click();
        Thread.sleep(1100);
        HomePage.waitElementIsVisible(HomePage.LivatMenuFormInnerLink());
        HomePage.LivatMenuOpeningHoursButton().click();
        Thread.sleep(1100);
        basePage.verifyTitle(OpeningHoursTitle);
        basePage.assertPageLoaded(OpeningHoursUrl);
    }

    @Test
    public void verify_HomePage_Menu_whenOpenAndClose() throws InterruptedException {
        basePage.open(HomePageUrl);
        Thread.sleep(1100);
        basePage.waitElementIsVisible(HomePage.LivatMenuButton());
        HomePage.LivatMenuButton().click();
        HomePage.waitElementIsVisible(HomePage.LivatMenuFormInnerLink());

        Thread.sleep(1100);
        HomePage.LivatMenuCloseButton().click();
        HomePage.assert_LivatMenuForm_isNOTVisible();
    }


}
