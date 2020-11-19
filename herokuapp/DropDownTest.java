package com.sparta.herokuapp;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;

public class DropDownTest {
    DropDownPage dropDownPage = new DropDownPage();
    String url = "https://the-internet.herokuapp.com/dropdown";

    @BeforeMethod
    public void login() {
        open(url);
    }

    @Test
    public void dropDownCurrentValueTest() {
        String expectedDefaultDropDownText = "Please select an option";
        Assert.assertEquals(dropDownPage.getCurrentDropDownText(), expectedDefaultDropDownText, "Default value is NOT " + expectedDefaultDropDownText);
    }

    @Test
    public void dropdownAllValuesTest() {
        SoftAssert softAssert = new SoftAssert();
        List<String> dropDownAllOptions = dropDownPage.dropDownOptions();

        softAssert.assertTrue(dropDownAllOptions.contains("Please select an option"), "There is NO 'Please select an option' option");
        softAssert.assertTrue(dropDownAllOptions.contains("Option 1"), "There is NO 'Option 1' option");
        softAssert.assertTrue(dropDownAllOptions.contains("Option 2"), "There is NO 'Option 2' option");
        softAssert.assertAll();
    }

    @Test
    public void selectDropdownValueTest() {
        Assert.assertEquals(dropDownPage.selectInDropDown("Option 1"), "Option 1", "Option is NOT selected");

    }
}
