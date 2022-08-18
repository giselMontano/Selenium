package com.syntax.class6;

import org.openqa.selenium.Alert;//line 19
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {
    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // 1. simple alert - click ok, only one option
        WebElement simpleAlertButton = driver.findElement(By.id("alert"));
        simpleAlertButton.click();
        Thread.sleep(2000);
        Alert simpleAlert = driver.switchTo().alert(); // switch focus to alert, store this into "Alert object" tha comes from selenium
        simpleAlert.accept();

        //2. confirmation alert - either cancel or click ok, two options
        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();
        Thread.sleep(2000);
        Alert confirmAlert = driver.switchTo().alert();// switch focus to alert, store this into "Alert object" tha comes from selenium
        String confirmAlertText = confirmAlert.getText();//getting the text from the pop up
        System.out.println(confirmAlertText);//printing the text
        confirmAlert.dismiss();//cancel

        //3. prompt alert - enter the text and then click ok or cancel,text and two options
        WebElement promptAlertButton = driver.findElement(By.id("prompt"));
        promptAlertButton.click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Dont replace my Chromedriver!!!");
        promptAlert.accept();
    }
}
