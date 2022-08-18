package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithKeys {
    public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        //keywork-> to tab or hit enter anything from the physical keyword
        username.sendKeys("Tester", Keys.TAB);

        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        //keywork-> to tab or hit enter anything from the physical keyword
        password.sendKeys("test", Keys.ENTER);

        //TESTING THE FUNCTIONALITY WITH THE CODE BELOW
  //      WebElement button = driver.findElement(By.className("button"));
   //     button.click();


        //keywork

    }
}