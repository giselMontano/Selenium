package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver locator= new ChromeDriver();
        locator.get("https://www.fb.com");
        locator.findElement(By.id("email")).sendKeys("syntax@hoklkl.com");//email-> from chick right in chrome/facebook inspect
                                                                                        // cursor/select part we need look for ID copy here->case-sensitive.
        locator.findElement(By.id("pass")).sendKeys("whatever");//sendKeys is used to send text to the web page

        //PAY ATTENTION TO THE VALUE OF (ID) OR ANY LOCATOR THAT HAVE/CONTAINS NUMERICAL VALUE MOST LIKELY WILL CHANGE IN THE NEXT EXECUTION OR IN THE FUTURE
        //DO NOT USE ANY LOCATOR THAT CONTAINS NUMERICAL VALUES!!!

        locator.findElement(By.name("login")).click();

        Thread.sleep(2000);

        //forgot passport is a link. Because it takes you to another link <a tag means a link, grab (Forgot password?) after link
        //locator.findElement(By.linkText("Forgot password?")).click();

        locator.findElement(By.partialLinkText("Forgot")).click();//we use partial link text when we have long link texts
        locator.quit();
    }
}
