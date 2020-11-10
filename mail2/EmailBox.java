package com.sparta.mail2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class EmailBox {
    SelenideElement loginButton = $(By.xpath("//div[contains(@class,'Footer')]//a[contains(@href,'auth?')]"));
    SelenideElement emailField = $(By.xpath("//input[@id='passp-field-login']"));
    SelenideElement passwordField = $(By.xpath("//input[@id='passp-field-passwd']"));
    SelenideElement submitButton = $(By.xpath("//div[contains(@class,'sign-in-button')]/button"));
    SelenideElement newestEmailinTheList = $(By.xpath("//div[contains(@class, 'ns-view-messages-item-wrap')][1]//span[contains(@class,'MessageSnippet-Item_subject')]/span[contains(@class,'MessageSnippet-Item_subject')]"));
    SelenideElement refreshButton = $(By.xpath("//span[contains(@class,'mail-ComposeButton-Refresh')]"));


    public void login(String url, String mailAddress, String pass) {
        open(url);
        loginButton.click();
        emailField.setValue(mailAddress).pressEnter();
        passwordField.setValue(pass);
        submitButton.click();
    }

    public String lookForMessage() {
        refresh();
        return newestEmailinTheList.getText();
    }
}
