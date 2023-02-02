package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.fail;

public class OpeningHoursPage extends BasePage{

    public OpeningHoursPage(WebDriver driver) {
        super(driver);
    }
    public static final String OpeningHoursUrl = "https://www.livat.com/hammersmith/en/opening-hours";
    public static final String IKEAshopUrl = "https://www.livat.com/hammersmith/en/shops/ikea";
    public static final String OpeningHoursTitle = "Opening hours | Livat - Make Today Different";

    public WebElement FindShopInput(){
        return driver.findElement(By.id("search"));
    }
    public WebElement FindShopAutoOptions(){ return driver.findElement(By.id("tenantList"));}
    public WebElement QuickSearchResultLink(){ return driver.findElement(By.className("underline"));}

    public List<WebElement>optionsToSelect() {return FindShopAutoOptions().findElements(By.tagName("option"));}



    public void verifyFindShop_isEmpty(){
        Assert.assertEquals("", FindShopInput().getAttribute("value"), "Field should be empty");
    }

//    public void verifyFindShopOutline_whenNOTClicked() {  //check for outline color when NOT clicked - поменяли цвета - теперь не нужно
//        FindShopInput().clear();
//        String outlineNotSelected = FindShopInput().getCssValue("border-color"); //rgba(118, 117, 113, 1) - серый, поле не выбрано
//        System.out.println(outlineNotSelected); //for debugging
//        Assert.assertEquals(outlineNotSelected, "rgba(118, 117, 113, 1)", "Wrong outline color when FindShop NOT selected" );
//    }
//    public void verifyFindShopOutline_whenClicked()  {  //check for outline color when clicked - - поменяли цвета - теперь не нужно
//
//        FindShopInput().clear();
//
//        String outlineSelected = FindShopInput().getCssValue("border-color"); //rgba(213, 205, 193, 1) - коричневый, внешний оутлайн при выборе поля
//        System.out.println(outlineSelected);//for debugging
//        Assert.assertEquals(outlineSelected, "rgba(213, 205, 193, 1)", "Wrong outline color when FindShop IS selected" );
//
//        String FindShopText_default = "Find shop";
//        System.out.println(FindShopText_default);
//        Assert.assertEquals(FindShopInput().getAttribute("placeholder"), FindShopText_default, "Wrong default text for blank input");
//    }

    public void verifyFindShop_whenTypedSomething(String textInput){
        FindShopInput().clear();
        FindShopInput().sendKeys(textInput);
        Assert.assertEquals(FindShopInput().getAttribute("value"), textInput);


    }

    public void verifyFindShopFilter_working(){   //вызывать при пустом поле или любом вводе в FindShop, для проверки работы фильтра //возможно стоит переписать чтобы работало самостоятельно
        String textInput = FindShopInput().getAttribute("value");;
        List<String> optionsVerify = new ArrayList<>();
            for(WebElement option : optionsToSelect()) {
                String optionName = option.getAttribute("value");

                if (optionName.toLowerCase().contains(textInput.toLowerCase())) {
                    System.out.println("Pass: Founded option: " + optionName + ", search input: " + textInput + "");
                    optionsVerify.add(optionName.toLowerCase());

                }

            }
        for (int index=0; index < optionsVerify.size(); index++) {

          Assert.assertTrue(optionsVerify.get(index).contains(textInput.toLowerCase()), "Fail: filter is working incorrectly - wrong results from correct input");
        }

        if (optionsVerify.size()>0 == false){
            System.out.println("Pass: No such filter options for input");

        }

    }

    public void verifyFindShop_whenIKEA(){
        FindShopInput().sendKeys("IKEA");
        FindShopInput().sendKeys(Keys.DOWN, Keys.RETURN);
    }

    public void verifyIKEAinfo_IsDisplayed(){
        WebElement QuickSearchResultHeading = driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/div/main/div/div[2]/div[2]/div/div[2]"));
        Assert.assertEquals(QuickSearchResultHeading.getAttribute("textContent"), "IKEA", "Fail: wrong header in results of quick search");
        Assert.assertEquals(QuickSearchResultLink().getAttribute("href"), IKEAshopUrl, "Fail: wrong link in results of quick search ");

    }

    public void verifyIKEAPage_IsDisplayed(){
        String text = "IKEA Hammersmith offers a wide range of simple, well-designed and affordable home furnishings";
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertTrue(list.size() > 0, "Text '" + text + "' not found!");

    }






}
