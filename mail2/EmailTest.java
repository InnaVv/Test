package com.sparta.mail2;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public class EmailTest {


    EmailPage emailPage = new EmailPage();
    MessagePage messagePage = new MessagePage();
    Faker faker = new Faker();

    @BeforeMethod
    public void clearCache() {
        clearBrowserCache();
    }

    @AfterMethod
    protected void afterTest() {
        emailPage.logout();
        clearBrowserCache();
    }

    @Test (dataProvider = "sender", dataProviderClass = DataClass.class)
    public void sendEmail(DataClass.CredentialsData credentialsData){
        String body = faker.harryPotter().quote();
        String subject = faker.harryPotter().character();

        emailPage.login(credentialsData.getUrl(),credentialsData.getMail(),credentialsData.getPass());
        messagePage.sendEmail(credentialsData.getRecipient(), subject, body);
        Assert.assertTrue(emailPage.lookForMessageSubject().contains("a4testtest@yandex.ru"), "There is NO email with such recepient");

    }
}
