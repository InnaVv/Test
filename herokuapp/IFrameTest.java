package com.sparta.herokuapp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;


public class IFrameTest {
    String url = "https://the-internet.herokuapp.com/iframe";
    SelenideElement iFrame = $(By.id("mce_0_ifr"));
    SelenideElement iFrameTextArea = $x("//body[@id=\"tinymce\"]/p");
    SelenideElement italicButton = $x("//div[@aria-label=\"Italic\"]");

    @BeforeMethod
    public void login() {
        SelenideElement damnPopupOkButton = $x("//button[.='Ok']");
        open(url);
        damnPopupOkButton.waitUntil(Condition.appears, 3000).click();
    }

    @Test
    public void removeContent() {

        Selenide.switchTo().frame(iFrame);
        iFrameTextArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        iFrameTextArea.sendKeys(Keys.DELETE);
        Assert.assertEquals(iFrameTextArea.getAttribute("p"),null,"Text area is NOT empty. Text " + iFrameTextArea.getText() + " is placed here");
    }

    @Test
    public void typeTextInFrame() {

        String textInput = "Belarusian life matters";

        Selenide.switchTo().frame(iFrame);
        iFrameTextArea.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        iFrameTextArea.clear();
        iFrameTextArea.sendKeys(textInput);
        System.out.println("+++" + iFrameTextArea.getText());
        Assert.assertEquals(iFrameTextArea.getText(), textInput, "Text area is NOT empty. Text " + iFrameTextArea.getText() + " is placed here");
    }


//    @Test
//    public void updateTextDesign() {
//
//        Selenide.switchTo().frame(iFrame);
//        italicButton.click();
//        iFrameTextArea.getAttribute("em");
//        System.out.println("++++" + iFrameTextArea.getAttribute("em"));
//    }
}