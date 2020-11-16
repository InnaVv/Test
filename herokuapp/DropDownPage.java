package com.sparta.herokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DropDownPage {
    SelenideElement dropDown = $(By.id("dropdown"));
    SelenideElement SelectedDropDownElement = $(By.xpath("//select[@id='dropdown']//@selected"));

    public List<String> dropDownOptions() {
        List<String> result = null;
        ElementsCollection dropDownList = $$(By.xpath("//select[@id='dropdown']/*"));

        for (SelenideElement dropDownValues : dropDownList) {
            result.add(dropDownValues.getText());
        }
        return result;

    }

    public String selectInDropDown(String options) {
        dropDown.selectOptionContainingText(options);
        return SelectedDropDownElement.getText();
    }
}
