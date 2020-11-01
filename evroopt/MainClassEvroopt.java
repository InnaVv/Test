package com.sparta.evroopt;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class MainClassEvroopt {

    @Test
    public void priceTest() {
        open("https://e-dostavka.by/");
        $(By.xpath("//body/div[@id='body']/div[1]/div[3]/div[2]/div[1]/nav[1]/ul[1]/li[9]")).click();
        $(By.xpath("//input[@id='searchtext']")).setValue("Dallmayr молотый classic");
        $(By.xpath("//body/div[@id='body']/div[1]/div[3]/div[2]/div[1]/nav[1]/ul[1]/li[9]")).click();

        String quantityResult = $(By.xpath("//button[@id='filter_submit']")).getText();
        System.out.println("test *************** ********"  + quantityResult);

        $(By.xpath("//body/div[@id='body']/div[1]/div[3]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/a[1]/img[1]")).click();
        Double getPrice = Double.valueOf($(By.xpath("//span[contains(text(),'54.2')]")).getText()) ;
        System.out.println("Price for kg is " + getPrice);

        double price = 54.2;
        Assert.assertEquals(getPrice, price, "Prices are NOT equal");

    }

}
