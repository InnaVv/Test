package com.sparta.mail2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class MessagePage {
    SelenideElement logoUser = $(By.cssSelector(".legouser__current-account"));
    SelenideElement writeEmailButton = $(By.xpath("//a[@href=\"https://mail.yandex.by/compose\"]"));
    SelenideElement sendToField = $(By.xpath("//div[@class='composeYabbles']"));
    SelenideElement subjectField = $(By.xpath("//input[@name='subject']"));
    SelenideElement bodyTextField = $(By.cssSelector(".cke_wysiwyg_div"));
    SelenideElement sendButton = $(By.xpath("//div[contains(@class,'ComposeSendButton')]/button"));
    SelenideElement refreshButton = $(By.cssSelector(".mail-ComposeButton-Refresh"));


    public void sendEmail(String mailAddressRecepint, String subject, String body) {
        logoUser.click();
        writeEmailButton.waitUntil(Condition.appear, 6000).click();
        sendToField.waitUntil(Condition.appear, 6000).setValue(mailAddressRecepint);
        subjectField.setValue(subject);
        bodyTextField.setValue(body);
        sendButton.click();
        refresh();
    }


}
