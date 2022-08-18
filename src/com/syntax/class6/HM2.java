package com.syntax.class6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM2 {
    /*HW
Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly*/
    public static String url="https://syntaxprojects.com/javascript-alert-box-demo.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement JavaAlert= driver.findElement(By.cssSelector("button[onclick*='myAlertFunction()']"));
        JavaAlert.click();
        Thread.sleep(2000);
        Alert simpleAlertButton = driver.switchTo().alert();
        simpleAlertButton.accept();

        WebElement JavaCofirm= driver.findElement(By.cssSelector("button[onclick*='myConfirmFunction()']"));
        JavaCofirm.click();
        Thread.sleep(2000);
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();

        WebElement AlertBox= driver.findElement(By.cssSelector("button[onclick*='myPromptFunction()']"));
        AlertBox.click();
        Thread.sleep(2000);
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("hola");
        Thread.sleep(2000);
        promptAlert.accept();
        driver.close();
    }
}

