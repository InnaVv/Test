package com.sparta.mail2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    SelenideElement loginButton = $(By.xpath("//div[contains(@class,'Footer')]//a[contains(@href,'auth?')]"));
    SelenideElement emailField = $(By.id("passp-field-login"));
    SelenideElement passwordField = $(By.id("passp-field-passwd"));
    SelenideElement submitButton = $(By.cssSelector(".passp-button"));


    public void login(String url, String mailAddress, String pass) {
        open(url);
//        loginButton.click();
        emailField.setValue(mailAddress).pressEnter();
        passwordField.setValue(pass);
        submitButton.click();

    }
}
