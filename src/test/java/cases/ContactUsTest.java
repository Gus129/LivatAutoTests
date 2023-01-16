package cases;

import base.BaseTest;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.ContactUsPage;

import static pages.ContactUsPage.*;


public class ContactUsTest extends BaseTest {

    @Test //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void check_ContactUsPage_AppearCorrect(){

        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.assertPageLoaded(ContactUsUrl);
        ContactUsPage.verifyTitle(ContactUsTitle);
    }

    @Test
    public void verify_NameInput(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.NameInput());
        ContactUsPage.verifyField(ContactUsPage.NameInput());
    }

    @Test
    public void verify_EmailInput(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.EmailInput());
        ContactUsPage.verifyField(ContactUsPage.EmailInput());
    }

    @Test
    public void verify_ConfirmEmailInput(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.ConfirmEmailInput());
        ContactUsPage.verifyField(ContactUsPage.ConfirmEmailInput());
    }

    @Test
    public void verify_PhoneNumberInput(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.PhoneNumberInput());
        ContactUsPage.verifyField(ContactUsPage.PhoneNumberInput());
    }

    @Test
    public void verify_MessageInput(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.MessageInput());
        ContactUsPage.verifyField(ContactUsPage.MessageInput());
    }
    //verification for all text input fields on Contact Us Page



    @Test
    public void verify_NameInputMaxLength(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.NameInput());
        ContactUsPage.verifyInputMaxLength(ContactUsPage.NameInput(), 100);
    }
    //Name - 100 expected

    @Test
    public void verify_EmailInputMaxLength(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.EmailInput());
        ContactUsPage.verifyInputMaxLength(ContactUsPage.EmailInput(), 255);
    }
    //Email - 255 expected

    @Test
    public void verify_ConfirmEmailInputMaxLength(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.ConfirmEmailInput());
        ContactUsPage.verifyInputMaxLength(ContactUsPage.ConfirmEmailInput(), 255);
    }
    //Confirm Email - 255 expected

    @Test
    public void verify_PhoneNumberInputMaxLength(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.PhoneNumberInput());
        ContactUsPage.verifyInputMaxLength(ContactUsPage.PhoneNumberInput(), 30);
    }
    //Phone Number - 30 expected

    @Test
    public void verify_MessageInputMaxLength(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.MessageInput());
        ContactUsPage.verifyInputMaxLength(ContactUsPage.MessageInput(), 4096);
    }
    //Message - 4096 expected

    @Test
    public void verify_SubmitButton_NotDisplayed_whenblankInputs_whenAgree(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.waitElementIsVisible(ContactUsPage.TermsOfUseCheckBox());
        ContactUsPage.TermsOfUseCheckBox().click();
        ContactUsPage.verifySubmitButtonInactive();
    }
    // Yellow 'Submit' button below form stays inactive with blank input fields

    @Test
    public void verify_SubmitSuccess_whenValidData(){
        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.assertPageLoaded(ContactUsUrl);
        ContactUsPage.NameInput().sendKeys("Template");
        ContactUsPage.EmailInput().sendKeys("template@gmail.com");
        ContactUsPage.ConfirmEmailInput().sendKeys("template@gmail.com");
        ContactUsPage.MessageInput().sendKeys("TemplateMessage");
        ContactUsPage.verifyTermsOfUseIsDisplayed();
        ContactUsPage.verifySubmitButtonInactive();
        ContactUsPage.TermsOfUseCheckBox().click();
        ContactUsPage.verifySubmitButtonActive();
        ContactUsPage.SubmitButton().click();
        ContactUsPage.verifySuccessMessageIsDisplayed();




    }










}
