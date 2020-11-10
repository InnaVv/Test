package com.sparta.mail2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.refresh;

public class Message {

    SelenideElement writeEmailButton = $(By.xpath("//a[contains(@class,'mail-ComposeButton')]"));
    SelenideElement sendToField = $(By.xpath("//div[@class='composeYabbles']"));
    SelenideElement subjectField = $(By.xpath("//input[@name='subject']"));
    SelenideElement sendButton = $(By.xpath("//div[contains(@class,'ComposeSendButton')]/button"));


    public void sendEmail(String mailAddress, String subject) {
        writeEmailButton.waitUntil(Condition.appear,6000).click();
        sendToField.waitUntil(Condition.appear,6000).setValue(mailAddress);
        subjectField.setValue(subject);
        sendButton.click();
        refresh();
    }


}
