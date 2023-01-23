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
}
