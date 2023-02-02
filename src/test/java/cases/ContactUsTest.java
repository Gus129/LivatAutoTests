package cases;

import base.BaseTest;
import org.testng.annotations.Test;
import static pages.ContactUsPage.*;


public class ContactUsTest extends BaseTest {

    @Test //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void check_ContactUsPage_AppearCorrect(){

        basePage.open(ContactUsUrl);
        basePage.assertPageLoaded(ContactUsUrl);
        basePage.verifyTitle(ContactUsTitle);
    }

    @Test
    public void verify_NameInput(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.NameInput());

        basePage.verifyField(ContactUsPage.NameInput());
    }

    @Test
    public void verify_EmailInput(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.EmailInput());

        basePage.verifyField(ContactUsPage.EmailInput());
    }

    @Test
    public void verify_ConfirmEmailInput(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.ConfirmEmailInput());

        basePage.verifyField(ContactUsPage.ConfirmEmailInput());
    }

    @Test
    public void verify_PhoneNumberInput(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.PhoneNumberInput());

        ContactUsPage.verifyField(ContactUsPage.PhoneNumberInput());
    }

    @Test
    public void verify_MessageInput(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.MessageInput());

        basePage.verifyField(ContactUsPage.MessageInput());
    }
    //verification for all text input fields on Contact Us Page



    @Test
    public void verify_NameInputMaxLength(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.NameInput());

        ContactUsPage.verifyInputMaxLength(ContactUsPage.NameInput(), 100);
    }
    //Name - 100 expected

    @Test
    public void verify_EmailInputMaxLength(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.EmailInput());

        ContactUsPage.verifyInputMaxLength(ContactUsPage.EmailInput(), 254);
    }
    //Email - 254 expected

    @Test
    public void verify_ConfirmEmailInputMaxLength(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.ConfirmEmailInput());

        ContactUsPage.verifyInputMaxLength(ContactUsPage.ConfirmEmailInput(), 255);
    }
    //Confirm Email - 254 expected

    @Test
    public void verify_PhoneNumberInputMaxLength(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.PhoneNumberInput());

        ContactUsPage.verifyInputMaxLength(ContactUsPage.PhoneNumberInput(), 30);
    }
    //Phone Number - 30 expected

    @Test
    public void verify_MessageInputMaxLength(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.MessageInput());

        ContactUsPage.verifyInputMaxLength(ContactUsPage.MessageInput(), 4096);
    }
    //Message - 4096 expected

    @Test
    public void verify_SubmitButton_NotDisplayed_whenblankInputs_whenAgree(){
        basePage.open(ContactUsUrl);
        basePage.waitElementIsVisible(ContactUsPage.TermsOfUseCheckBox());

        ContactUsPage.TermsOfUseCheckBox().click();
        ContactUsPage.verifySubmitButtonInactive();
    }
    // Yellow 'Submit' button below form stays inactive with blank input fields

    @Test
    public void verify_SubmitSuccess_whenValidData_whenAgree(){
        basePage.open(ContactUsUrl);
        basePage.assertPageLoaded(ContactUsUrl);

        ContactUsPage.NameInput().sendKeys("HelloThere");
        ContactUsPage.EmailInput().sendKeys("hello@gmail.com");
        ContactUsPage.ConfirmEmailInput().sendKeys("hello@gmail.com");
        ContactUsPage.MessageInput().sendKeys("Hello!");
        ContactUsPage.verifyTermsOfUseIsDisplayed();
        ContactUsPage.verifySubmitButtonInactive();
        ContactUsPage.TermsOfUseCheckBox().click();
        ContactUsPage.verifySubmitButtonActive();
        ContactUsPage.SubmitButton().click();
        ContactUsPage.verifySuccessMessageIsDisplayed();




    }










}
