package com.sparta.mail2;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class EmailTest {

    Faker faker = new Faker();

//    String url = "https://mail.yandex.by/";
//    String mail = "qazxsw-2016@yandex.ru";
//    String pass = "1234testTEST";
    String subject = faker.twinPeaks().quote();


    EmailPage emailPage = new EmailPage();
    MessagePage messagePage = new MessagePage();

    @Test (dataProvider = "sender")
    public void sendEmail(DataClass.CredentialsData credentialsData){
        emailPage.login(credentialsData.getUrl1(),credentialsData.getMail1(),credentialsData.getPass1());
        messagePage.sendEmail(credentialsData.getMail1(), subject);
        Assert.assertEquals(emailPage.lookForMessage(), subject, "There is NO email with such subject");
    }
}
