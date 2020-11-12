package com.sparta.mail2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    SelenideElement loginButton = $(By.xpath("//div[contains(@class,'Footer')]//a[contains(@href,'auth?')]"));
    SelenideElement emailField = $(By.xpath("//input[@id='passp-field-login']"));
    SelenideElement passwordField = $(By.xpath("//input[@id='passp-field-passwd']"));
    SelenideElement submitButton = $(By.xpath("//div[contains(@class,'sign-in-button')]/button"));


    public void login(String url, String mailAddress, String pass) {
        open(url);
        loginButton.click();
        emailField.setValue(mailAddress).pressEnter();
        passwordField.setValue(pass);
        submitButton.click();

    }
}
