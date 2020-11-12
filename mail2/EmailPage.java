package com.sparta.mail2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class EmailPage extends LoginPage {
    SelenideElement newestEmailinTheList = $(By.xpath("//div[contains(@class, 'ns-view-messages-item-wrap')][1]//span[contains(@class,'MessageSnippet-Item_subject')]/span[contains(@class,'MessageSnippet-Item_subject')]"));
    SelenideElement refreshButton = $(By.cssSelector(".mail-ComposeButton-Refresh"));
    // $(By.xpath("//a[contains(@class,'mail-ComposeButton-Refresh')]"));


    public String lookForMessage() {
        refresh();
        return newestEmailinTheList.getText();
    }
}
