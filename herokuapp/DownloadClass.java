package com.sparta.herokuapp;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

public class DownloadClass {
    DownloadPage downloadPage = new DownloadPage();
    String url = "https://the-internet.herokuapp.com/download";
    String fileName = "webdriverIO.png";


    @Test
    public void downloadFile() throws FileNotFoundException {
        open(url);
        Assert.assertTrue(downloadPage.findFile(fileName),"File " + fileName + "isn't found on page");
        Assert.assertTrue(downloadPage.downloadFile(fileName), fileName + " is NOT downloaded");
    }

}
