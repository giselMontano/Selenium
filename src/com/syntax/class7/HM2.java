package com.syntax.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HM2 {
    /*navigate to http://www.uitestpractice.com/Students/Contact
click on the link "This is a Ajax link" top of the page
get text
print out in the console*/
    public static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebElement here=driver.findElement(By.cssSelector("a[data-ajax-loading ^= '#LoadImage']"));
        here.click();

        WebElement text=driver.findElement(By.className("ContactUs"));
        String printText= text.getText();
        System.out.println(printText);
        driver.close();

    }
}
