package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {
    /*navigate to fb.com
    click on create new account
    fill up all the textboxes
    click on sign up button
    close the popup
    close the window
    */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver locate = new ChromeDriver();
        locate.get("https://www.fb.com");

        locate.findElement(By.linkText("Create new account")).click();
        Thread.sleep(2000);
        locate.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("Luis");
        locate.findElement(By.xpath("//input[contains(@name,'lastname')]")).sendKeys("LuisMontano@fhfghf.com");
        locate.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("LuisMontano123");
        locate.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]")).sendKeys("hola");
        Thread.sleep(2000);
        locate.findElement(By.xpath("//button[contains(@name,'websubmit')]")).click();
        Thread.sleep(2000);
        locate.findElement(By.xpath("//img[contains(@class,'_8idr img')]")).click();
        locate.quit();
    }
}
