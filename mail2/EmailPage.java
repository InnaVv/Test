package com.sparta.mail2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class EmailPage extends LoginPage {
    SelenideElement newestEmailinTheList = $(By.xpath("//div[contains(@class, 'ns-view-messages-item-wrap')][1]//span[contains(@class,'MessageSnippet-Item_subject')]/span[contains(@class,'MessageSnippet-Item_subject')]"));
    SelenideElement refreshButton = $(By.cssSelector(".mail-ComposeButton-Refresh"));
    SelenideElement sentMailLink = $(By.xpath("//a[@href=\"#sent\"]"));
    SelenideElement sentMailFirst = $(By.xpath("/descendant::div[contains(@class, 'mail-MessageSnippet-Content')][1]"));

    SelenideElement logoUser = $(By.cssSelector(".legouser__current-account"));
    SelenideElement logoutButton = $(By.xpath("//span[contains(text(),'Выйти из сервисов Яндекса')]"));

    public String lookForMessage() {
        String result = null;
        ElementsCollection sentMailList = $$(By.xpath("/descendant::div[contains(@class, 'mail-MessageSnippet-Content')]"));
        SelenideElement actualSubjectValue = $(By.cssSelector(".mail-Message-Toolbar-Subject"));

        for (SelenideElement mailSubject : sentMailList) {
//            mailSubject.click();
//            actualSubjectValue.waitUntil(Condition.appear, 6000);
            result = mailSubject.find(By.cssSelector(".mail-MessageSnippet-Item_sender")).getText();

//            result = mailSubject.find(By.cssSelector(".mail-MessageSnippet-FromText")).getText();
        }
        return result;
    }

    public void logout() {
        logoUser.click();
        logoutButton.click();
    }
}
