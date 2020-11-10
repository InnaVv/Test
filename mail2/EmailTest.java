package com.sparta.mail2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;

public class EmailTest {

    String url = "https://mail.yandex.by/";
    String mail = "qazxsw-2016@yandex.ru";
    String pass = "1234testTEST";
    String subject = "Subject88";


    EmailBox emailBox = new EmailBox();
    Message message = new Message();

    @Test
    public void sendEmail(){
        emailBox.login(url,mail,pass);
        message.sendEmail(mail, subject);
        Assert.assertEquals(emailBox.lookForMessage(), subject, "There is NO email with such subject");
    }
}
