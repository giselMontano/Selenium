package com.syntax.reviewClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Basics {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver =new ChromeDriver();
        driver.get("http://syntaxprojects.com");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link:links){
            String text = link.getText();//go to the list and take each element and take the text of them
            System.out.println(text);

        }

    }
}