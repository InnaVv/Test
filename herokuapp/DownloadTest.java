package com.sparta.herokuapp;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

public class DownloadTest {
    DownloadPage downloadPage = new DownloadPage();
    String url = "https://the-internet.herokuapp.com/download";
    String fileName = "webdriverIO.png";
    String folderForDownloadedFiles = "D:\\auto";


    @Test
    public void downloadFile() throws FileNotFoundException {
        open(url);
        SelenideElement fileElement = downloadPage.findFile(fileName);
        Assert.assertNotNull(fileElement,"File " + fileName + " isn't found on page");
        Assert.assertTrue(downloadPage.downloadFile(fileElement, folderForDownloadedFiles), fileName + " is NOT downloaded");
    }

}
