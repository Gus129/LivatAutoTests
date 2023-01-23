package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static org.testng.AssertJUnit.fail;

public class OpeningHoursPage extends BasePage{

    public OpeningHoursPage(WebDriver driver) {
        super(driver);
    }
    public static final String OpeningHoursUrl = "https://www.livat.com/en/hammersmith/opening-hours";
    public static final String OpeningHoursTitle = "Opening Hours | Livat";


}
