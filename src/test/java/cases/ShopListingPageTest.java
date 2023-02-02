package cases;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ShopListingPage;


import static pages.ShopListingPage.*;

public class ShopListingPageTest extends BaseTest {

    @Test
    //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void check_ShopListingPage_AppearCorrect() {

        basePage.open(ShopListingPageUrl);
        basePage.assertPageLoaded(ShopListingPageUrl);
        basePage.verifyTitle(ShopListingPageTitle);
    }

    @Test

    public void verify_ShopListingAutoComplete() {
        basePage.open(ShopListingPageUrl);
        basePage.assertPageLoaded(ShopListingPageUrl);

        basePage.waitElementIsVisible(ShopListingPage.ShopListingInput());
        basePage.verifyField(ShopListingPage.ShopListingInput());

        ShopListingPage.ShopListingInput().click();
        ShopListingPage.ShopListingInput().sendKeys("h");
        basePage.waitElementIsVisible(ShopListingPage.ShopSearchResults().get(1));
        ShopListingPage.verify_ShopListingFilter_working();
    }

    @Test

    public void verify_SopListDropdown_whenAccessories() throws InterruptedException {
        basePage.open(ShopListingPageUrl);
        basePage.assertPageLoaded(ShopListingPageUrl);

        basePage.waitElementIsVisible(ShopListingPage.ShopListDropdown());
        basePage.verifyField(ShopListingPage.ShopListDropdown());

        ShopListingPage.ShopListDropdown().click();
        ShopListingPage.ShopListDropdown_Accessories().click();
        Thread.sleep(2000);
        ShopListingPage.assert_ShopSearchResults_whenAccessories();
    }


}
