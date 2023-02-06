package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

import static org.testng.AssertJUnit.fail;


public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public static final String ContactUsUrl = "https://www.livat.com/hammersmith/en/contact-us";
    public static final String ContactUsTitle = "Contact us | Livat - Make Today Different";

    public WebElement MessageInput(){
        return driver.findElement(By.xpath("//*[@id='message']"));
    }
    public WebElement TermsOfUseCheckBox() {return driver.findElement(By.xpath("//*[@id='gatsby-focus-wrapper']/div/main/div/div[2]/div[2]/div/form/div[6]/label/span[2]"));}
    public WebElement SubmitButton(){return driver.findElement(By.xpath("//*[@type='submit']"));}


    public WebElement NameInput(){
        return driver.findElement(By.xpath("//*[@id='name']"));
    }

    public WebElement EmailInput(){
        return driver.findElement(By.xpath("//*[@id='email']"));
    }

    public WebElement ConfirmEmailInput(){
        return driver.findElement(By.xpath("//*[@id='validateEmail']"));
    }

    public WebElement PhoneNumberInput(){
        return driver.findElement(By.xpath("//*[@id='phoneNumber']"));
    }


    public void verifySubmitButtonInactive(){
        Assert.assertFalse(SubmitButton().isEnabled(), "Button 'Submit' expected to be inactive");
    }


    public void verifySubmitButtonActive(){
        Assert.assertTrue(SubmitButton().isEnabled(), "Button 'Submit' expected to be active");
    }


    public void verifyTermsOfUseIsDisplayed(){
        Assert.assertTrue(TermsOfUseCheckBox().isDisplayed(), "Checkbox 'I have read and understood the terms...' is not displayed");
    }


    public void verifySuccessMessageIsDisplayed(){
        String text = "Thank you!";//"We have received your message. Thank you for writing to us and we will get back to you within shortly.";
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertTrue(list.size() > 0, "Text '" + text + "' not found!");
    }


    public void verifyInputMaxLength(WebElement inputElement,int maxLengthInput){

        String maxLengthDefined = inputElement.getAttribute("maxlength");

        if (maxLengthDefined == null) {
            fail("No limit for field '" + inputElement.getAccessibleName() + "'");
        }

        else if (maxLengthDefined.equals(Integer.toString(maxLengthInput))) {
//            Assert.assertTrue(true);
            System.out.println("Max character limit for field '"+inputElement.getAccessibleName() +"' is set as expected = '" + maxLengthInput + "'");

        }

        else {
            fail("Fail -  for field '"+inputElement.getAccessibleName() +"' "+maxLengthInput+ " maxlength expected, actual - "+maxLengthDefined+"");
        }

    }

}
