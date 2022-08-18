package com.syntax.class10;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakingScreensShots {
    public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement button = driver.findElement(By.className("button"));
        button.click();

        //start taking the screenshots
        //downcasting of the interface "TakesScreenshot" to driver in order to interact with webpage
        //interface can not create an object
        TakesScreenshot ts=(TakesScreenshot) driver;//ts-> is an object
        File scrFile =ts.getScreenshotAs(OutputType.FILE);//most of the time the parameter is a FILE and needs to be assigned to File

        //specify where do we want to store a copy of the screenshot
        //what is my file? and where am I putting that file?->inside parenthesis of copyFile

        //hover over "copyFile"->more actions-> surrender by try and catch
        try {                                              //folder/another folder/name of the file.extention
            FileUtils.copyFile(scrFile,new File("screenshots/SmartBear/adminPage.png"));//always png
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}