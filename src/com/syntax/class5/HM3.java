package com.syntax.class5;

import com.google.common.collect.Tables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HM3 {
   /* HW2
    Go to ebay.com
    get all the categories and print them in the console
    select Computers/Tables & Networking
    click on search
    verify the header*/
   public static String url="https://www.ebay.com/";
   public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
       WebDriver driver = new ChromeDriver();
       driver.get(url);
       WebElement Ebay =driver.findElement(By.id("gh-cat"));
       Select categories = new Select(Ebay);
       List<WebElement> Todos = categories.getOptions();
       for (WebElement link : Todos) {
           String linkText = link.getText();
           if (!linkText.isEmpty()) {
               System.out.println(linkText);
           }
       }
       categories.selectByValue("58058");
       WebElement Select =driver.findElement(By.id("gh-btn"));
       Select.click();
       WebElement header = driver.findElement(By.cssSelector("span.b-pageheader__text"));
       boolean check = header.isDisplayed();
       System.out.println(check);
   }
}