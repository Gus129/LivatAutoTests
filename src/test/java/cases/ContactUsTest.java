package cases;

import base.BaseTest;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import static pages.ContactUsPage.*;


public class ContactUsTest extends BaseTest {

    @Test //(timeOut = 5000) - выполняется >5000 мс = fail, (invocationCount = 2)  - количество раз сколько нужно выполнить тест, (successPercentage = 100) - процент успеха теста чтобы он не упал
    public void checkContactUsPageAppearCorrect(){

        ContactUsPage.open(ContactUsUrl);
        ContactUsPage.assertPageLoaded(ContactUsUrl);
        ContactUsPage.verifyTitle(ContactUsTitle);
    }

    @Test
    public void verify_NameInput_ContactUsPage(){ContactUsPage.verifyField(ContactUsPage.NameInput());}

    @Test
    public void verify_EmailInput_ContactUsPage(){ContactUsPage.verifyField(ContactUsPage.EmailInput());}

    @Test
    public void verify_ConfirmEmailInput_ContactUsPage(){ContactUsPage.verifyField(ContactUsPage.NameInput());}

    @Test
    public void verify_PhoneNumberInput_ContactUsPage(){ContactUsPage.verifyField(ContactUsPage.PhoneNumberInput());}

    @Test
    public void verify_MessageInput_ContactUsPage(){ContactUsPage.verifyField(ContactUsPage.MessageInput());}





    @Test
    public void verify_NameInputMaxLength_ContactUsPage(){ContactUsPage.verifyInputMaxLength(ContactUsPage.NameInput(), 100);}
    //Name - 100 expected

    @Test
    public void verify_EmailInputMaxLength_ContactUsPage(){ContactUsPage.verifyInputMaxLength(ContactUsPage.EmailInput(), 255);}
    //Email - 255 expected

    @Test
    public void verify_ConfirmEmailInputMaxLength_ContactUsPage(){ContactUsPage.verifyInputMaxLength(ContactUsPage.ConfirmEmailInput(), 255);}
    //Confirm Email - 255 expected

    @Test
    public void verify_PhoneNumberInputMaxLength_ContactUsPage(){ContactUsPage.verifyInputMaxLength(ContactUsPage.PhoneNumberInput(), 30);}
    //Phone Number - 30 expected

    @Test
    public void verify_MessageInputMaxLength_ContactUsPage(){ContactUsPage.verifyInputMaxLength(ContactUsPage.MessageInput(), 4096);}
    //Message - 4096 expected










}
