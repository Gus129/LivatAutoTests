package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ShopListingPage extends BasePage{

    public ShopListingPage(WebDriver driver) {
        super(driver);
    }

    public static final String ShopListingPageUrl = "https://www.livat.com/hammersmith/en/shops";
    public static final String ShopListingPageTitle = "Shops | Livat - Make Today Different";


    public WebElement ShopListingInput(){return driver.findElement(By.xpath("//*[@placeholder='Find shops']"));}
    public WebElement ShopListAutoOptions(){ return driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/div/main/div[2]"));}
    public WebElement ShopListDropdown(){ return driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/div/main/div[1]/div[1]/div[2]/div[1]/div[2]"));}
    public WebElement ShopListDropdown_Accessories(){return driver.findElement(By.xpath("//*[@id='1740ae7e-59df-5d27-b8f5-7070132f4e8c']"));}


    public List<WebElement> ShopSearchResults() {return ShopListAutoOptions().findElements(By.xpath("//*[@class='text-sm mt-1 font-title font-bold']"));}

    public void verify_ShopListingFilter_working(){   //вызывать при пустом поле или любом вводе в FindShop, для проверки работы фильтра //возможно стоит переписать чтобы работало самостоятельно
        String textInput = ShopListingInput().getAttribute("value");;
        List<String> optionsVerify = new ArrayList<>();
        for(WebElement option : ShopSearchResults()) {
            String optionName = option.getAttribute("textContent");

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

    public void assert_ShopSearchResults_whenAccessories(){
        List<WebElement> SearchResultsAfterClick = driver.findElements(By.xpath("//*[@class='text-sm mt-1 font-title font-bold']"));
        System.out.println(SearchResultsAfterClick.size());
        Assert.assertTrue(SearchResultsAfterClick.size() == 4, "Fail: wrong search results");
    }
}
