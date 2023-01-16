package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.AssertJUnit.fail;


public class ContactUsPage extends BasePage{


    ///Избавится от общего шаблона - все равно он не такой уж и универсальный

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public static final String ContactUsUrl = "https://www.livat.com/en/hammersmith/contact-us";
    public static final String ContactUsTitle = "Contact us | Livat";
//    public static final String ContactUsNameField = "Name";
//    public static final String ContactUsEmailField = "Email Confirmation";
//    public static final String ContactUsEmailConfirmationField = "Email Confirmation";

    public WebElement NameInput(){
        return driver.findElement(By.xpath("//*[@data-sc-field-name='Name']"));
    }

    public WebElement EmailInput(){
        return driver.findElement(By.xpath("//*[@data-sc-field-name='Email Confirmation'][1]"));
    }

    public WebElement ConfirmEmailInput(){
        return driver.findElement(By.xpath("//*[@data-sc-field-name='Email Confirmation'][2]"));
    }

    public WebElement PhoneNumberInput(){
        return driver.findElement(By.xpath("//*[@data-sc-field-name='Telephone']"));
    }

    public WebElement MessageInput(){
        return driver.findElement(By.xpath("//*[@data-sc-field-name='Message']"));
    }

    public void verifyTitle(String pageTitle){
        Assert.assertEquals(pageTitle, driver.getTitle());
    }

    public void verifyField (WebElement fieldName){
        Assert.assertTrue(fieldName.isDisplayed());
        System.out.println("Field '"+fieldName.getAccessibleName()+"' verified – Assert passed");
    }



    public void verifyInputMaxLength(WebElement inputElement,int maxLengthInput){

        String maxLengthDefined = inputElement.getAttribute("maxlength");

        if (maxLengthDefined == null) {
            fail("No limit for field '" + inputElement.getAccessibleName() + "'");
        }

        else if (maxLengthDefined.equals(Integer.toString(maxLengthInput))) {
            Assert.assertTrue(true);
            System.out.println("Max character limit for field '"+inputElement.getAccessibleName() +"' is set as expected = '" + maxLengthInput + "'");
        }

        else {
            fail("Fail -  "+maxLengthInput+ " expected, actual - "+maxLengthDefined+"");
        }



    }

}
