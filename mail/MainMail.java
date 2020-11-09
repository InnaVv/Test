package com.sparta.mail;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class MainMail {
    @Test
    public void emailLogin() throws InterruptedException {
        open("https://mail.yandex.by/");
        $(By.xpath("//a[span[text()='Войти']]")).click();
        $(By.xpath("//input[@id='passp-field-login']")).setValue("qazxsw-2016").pressEnter();
        $(By.xpath("//input[@id='passp-field-passwd']")).setValue("1234testTEST").pressEnter();

        sleep(1000);
        $(By.xpath("//span[contains(text(),'Написать')]")).click();
        sleep(1000);
        $(By.xpath("//div[@class='composeYabbles']")).setValue("qazxsw-2016@yandex.ru").pressEnter();
        $(By.xpath("//input[@name='subject']")).setValue("InnaAuto1");
        $(By.xpath("//button[@class='control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")).click();
        sleep(100);

        refresh();

        String mailSubject = $(By.xpath("//span[contains(text(),'InnaAuto')]")).getText();
        Assert.assertEquals(mailSubject, "InnaAuto1", "There is NO email with such subject");



    }
}
