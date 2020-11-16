package com.sparta.mail2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class EmailPage extends LoginPage {

    SelenideElement logoUser = $(By.cssSelector(".legouser__current-account"));
    SelenideElement sendMAilsMenu = $(By.xpath("//a[@href=\"#sent\"]"));
    SelenideElement logoutButton = $(By.xpath("//span[contains(text(),'Выйти из сервисов Яндекса')]"));

    public List<String> lookForMessageSubject() {
        sendMAilsMenu.click();
        sleep(3000);
        List <String> result = new ArrayList<>();
        ElementsCollection sentMailList = $$(By.xpath("/descendant::div[contains(@class, 'mail-MessageSnippet-Content')]"));

        for (SelenideElement mailSubject : sentMailList) {
            result.add(mailSubject.find(By.cssSelector(".mail-MessageSnippet-FromText")).getAttribute("title")) ;
            System.out.println(mailSubject.find(By.cssSelector(".mail-MessageSnippet-FromText")).getAttribute("title"));
        }
        return result;
    }

    public void logout() {
        logoUser.click();
        logoutButton.click();
    }
}
