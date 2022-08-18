package com.syntax.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTask {
    /*navigate http://syntaxprojects.com/dynamic-elements-loading.php
    * click on start button
    * get the text
    * print out in console
    * */
    public static String url = "http://syntaxprojects.com/dynamic-elements-loading.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver hola = new ChromeDriver();
        hola.get(url);

        //EXPLICIT WAIT PARAMETERS MUST BE THE OBJECT THAT IS MANAGING THE PAGE IN THIS CASE "hola"
        WebElement startButton = hola.findElement(By.id("startButton"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(hola, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='finish']")));

        WebElement text= hola.findElement(By.cssSelector("div[id='finish']"));
        String printText=text.getText();
        System.out.println(printText);
        hola.close();

    }
}
