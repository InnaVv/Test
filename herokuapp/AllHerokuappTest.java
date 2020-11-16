package com.sparta.herokuapp;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class AllHerokuappTest {
    DropDownPage dropDownPage = new DropDownPage();
    SoftAssert softAssert = new SoftAssert();
    String url = "https://the-internet.herokuapp.com/dropdown";

    @Test
    public void DropdownDefaultValuesTest(){
        open(url);
        List<String> dropDownAlloptions = dropDownPage.dropDownOptions();
        softAssert.assertTrue(dropDownAlloptions.contains("Please select an option"), "There is NO 'Please select an option' option");
        softAssert.assertTrue(dropDownAlloptions.contains("Option 1"), "There is NO 'Option 1' option");
        softAssert.assertTrue(dropDownAlloptions.contains("Option 2"), "There is NO 'POption 2' option");
        softAssert.assertAll("Check dropdown options");
    }

    @Test
    public void SelectDropdownValue(){
        open(url);
        Assert.assertEquals(dropDownPage.selectInDropDown("Option 1"), "Option 1", "Option is selected");

    }
}
