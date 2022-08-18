package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionClassDemo {
    public static String url = "http://www.amazon.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement accountAndLists = driver.findElement(By.id("nav-link-accountList"));
        //create actions class object
        Actions action= new Actions(driver);//action object that helps to hover over and not click
        //perform necessary action from action class
        action.moveToElement(accountAndLists).perform();//inside the moveToElement() you need to put the element where you want ot move the courser to.

    }
}