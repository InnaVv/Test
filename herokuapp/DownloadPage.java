package com.sparta.herokuapp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;

public class DownloadPage {
    SelenideElement files = $(By.id("example"));
    SelenideElement foundFile = null;


    public boolean findFile(String fileName) {
        ElementsCollection filesAll = $$(By.xpath("//div[@class='example']/*"));
        System.out.println(foundFile);

        for (SelenideElement filesList: filesAll) {
            String fileFromList = filesList.getText();
            if (fileFromList.equals(fileName)){
                foundFile = filesList;
                System.out.println(foundFile);
                return true;
            }
        }
        return false;
    }

    public boolean downloadFile(String fileName) throws FileNotFoundException {
        Configuration.reportsFolder = "D:\\auto";
        File downloadedFile = foundFile.download(10000);
        System.out.println(downloadedFile.getAbsolutePath());
        return downloadedFile.canRead();

    }
}
