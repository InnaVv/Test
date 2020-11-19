package com.sparta.herokuapp;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DropDownPage {
    SelenideElement dropDown = $(By.id("dropdown"));

    public List<String> dropDownOptions() {
        List<String> result = new ArrayList<>();
        ElementsCollection dropDownList = $$(By.xpath("//select[@id='dropdown']/*"));

        for (SelenideElement dropDownValues : dropDownList) {
            result.add(dropDownValues.getText());  //add all dropdown text options to result List
        }

        return result;
    }

    public String selectInDropDown(String options) {
        dropDown.selectOptionContainingText(options); //select option in SelenideElement dropDown
        return dropDown.getText();         //return text value of selected option in SelenideElement dropDown
    }

    public String getCurrentDropDownText() {
        return dropDown.getText();
    }
}
