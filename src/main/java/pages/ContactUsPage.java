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

    public WebElement TermsOfUseCheckBox() {return driver.findElement(By.xpath("//*[@data-sc-field-name='Rich text checkbox']"));}

    public WebElement SubmitButton(){return driver.findElement(By.xpath("//*[@type='submit']"));}





    public void verifyField (WebElement fieldName){
        Assert.assertTrue(fieldName.isDisplayed());
        System.out.println("Field '"+fieldName.getAccessibleName()+"' verified – Assert passed");
    }

    // public void verifyField_isMandatory (WebElement fieldName){ - пока не нужно, но если делать то отдельно для каждого филда



    public void verifySubmitButtonInactive(){
        Assert.assertFalse(SubmitButton().isDisplayed(), "Button 'Submit' expected to be inactive");
    }


    public void verifySubmitButtonActive(){
        Assert.assertTrue(SubmitButton().isDisplayed(), "Button 'Submit' expected to be active");
    }



    public void verifyTermsOfUseIsDisplayed(){
        Assert.assertTrue(TermsOfUseCheckBox().isDisplayed(), "Checkbox 'I have read and understood the terms...' is not displayed");
    }


    public void verifySuccessMessageIsDisplayed(){
        String text = "We have received your message and thank you for writing to us. We will get back to you within shortly.";
        List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        Assert.assertTrue(list.size() > 0, "Text '" + text + "' not found!");
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
            fail("Fail -  for field '"+inputElement.getAccessibleName() +"' "+maxLengthInput+ " maxlength expected, actual - "+maxLengthDefined+"");
        }



    }

}
