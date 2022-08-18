package com.syntax.class12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class JSExecutorDemo3 {
    public static String url = "http://www.google.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        JavascriptExecutor js= (JavascriptExecutor) driver;
        //open a new window/tap inside single quotes ''
        //window.open()  opens a blank tab
        js.executeScript("window.open('http://www.amazon.com')");

//FOCUS STAYS IN GOOGLE BECAUSE THAT IS THE MAIN PAGE IN ORDER TO INTERACT WITH AMAZON YOU MUST SWITCH THE FOCUS TO THE NEW TAB
       //LOCATOR FOR GOOGLE SEARCH TEXTBOX
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("hola");//SENDING KEY FOR GOOGLE SEARCH TEXTBOX


    }
}