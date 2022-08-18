package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UploadingDocumentsDemo {
    public static String url = "https://the-internet.herokuapp.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement fileUploadLink = driver.findElement(By.linkText("File Upload"));
        fileUploadLink.click();
        //Identify File Upload
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //In order to get the path you can choose any documents ->right click ->get info->where... copy that
        chooseFile.sendKeys("/Users/giselmontanopatino/Desktop/hola.jpeg");//hola.jpeg that is the name and you need to add it
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
    }
}

