package com.sparta.mail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class MainMail {
    @Test
    public void emailLogin() throws InterruptedException {
        open("https://mail.yandex.by/");
        $(By.xpath("//div[contains(@class,'Footer')]//a[contains(@href,'auth?')]")).click();
        $(By.xpath("//input[@id='passp-field-login']")).setValue("qazxsw-2016").pressEnter();
        $(By.xpath("//input[@id='passp-field-passwd']")).setValue("1234testTEST").pressEnter();

        sleep(1000);
        $(By.xpath("//a[contains(@class,'mail-ComposeButton')]")).click();
        sleep(1000);
        $(By.xpath("//div[@class='composeYabbles']")).setValue("qazxsw-2016@yandex.ru").pressEnter();
        $(By.xpath("//input[@name='subject']")).setValue("InnaAuto2");
        $(By.xpath("//div[contains(@class,'ComposeSendButton')]/button")).click();
        sleep(1000);

        refresh();

        String mailSubject = $(By.xpath("//div[contains(@class, 'ns-view-messages-item-wrap')][1]")).getText();
        Assert.assertEquals(mailSubject, "InnaAuto2", "There is NO email with such subject");



    }
}
