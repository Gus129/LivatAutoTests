package cases;

import base.BaseTest;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.BasePage;
import pages.OpeningHoursPage;
import pages.OpeningHoursPage;

import static pages.OpeningHoursPage.*;


public class OpeningHoursTest extends BaseTest {

    @Test
    //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void check_OpeningHoursPage_AppearCorrect() {

        basePage.open(OpeningHoursUrl);
        basePage.assertPageLoaded(OpeningHoursUrl);
        basePage.verifyTitle(OpeningHoursTitle);
    }

    @Test

    public void verify_FindShopInput(){

        basePage.open(OpeningHoursUrl);
        basePage.assertPageLoaded(OpeningHoursUrl);

        basePage.waitElementIsVisible(OpeningHoursPage.FindShopInput());
        basePage.verifyField(OpeningHoursPage.FindShopInput());



        OpeningHoursPage.FindShopInput().click();



        OpeningHoursPage.verifyFindShop_whenTypedSomething("kekw");



    }

    @Test

    public void verify_FindShopAutoComplete(){
        basePage.open(OpeningHoursUrl);
        basePage.assertPageLoaded(OpeningHoursUrl);

        basePage.waitElementIsVisible(OpeningHoursPage.FindShopInput());
        basePage.verifyField(OpeningHoursPage.FindShopInput());


        OpeningHoursPage.FindShopInput().sendKeys("ea");
        OpeningHoursPage.verifyFindShopFilter_working();
    }

    @Test

    public void verify_FindShop_whenIKEA(){
        basePage.open(OpeningHoursUrl);
        basePage.assertPageLoaded(OpeningHoursUrl);

        basePage.waitElementIsVisible(OpeningHoursPage.FindShopInput());
        basePage.verifyField(OpeningHoursPage.FindShopInput());

        OpeningHoursPage.verifyFindShop_whenIKEA();
        OpeningHoursPage.verifyFindShopFilter_working();
        OpeningHoursPage.verifyIKEAinfo_IsDisplayed();

        OpeningHoursPage.QuickSearchResultLink().click();
        OpeningHoursPage.verifyIKEAPage_IsDisplayed();

        driver.navigate().back();
        basePage.assertPageLoaded(OpeningHoursUrl);

        OpeningHoursPage.verifyFindShop_isEmpty();



    }


}
