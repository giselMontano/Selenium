package com.syntax.class6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM1 {
    /*HOMEWORK
Task
Navigate to https://syntaxprojects.com/bootstrap-iframe.php
verify the header text Sorry, We Couldn't Find Anything For “Asksn” is displayed
verify enroll today button is enabled
*/
    public static String url="https://syntaxprojects.com/bootstrap-iframe.php";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        driver.switchTo().frame("FrameOne");
        WebElement textSorry= driver.findElement(By.cssSelector("h1[class*='heading-13']"));
        boolean check = textSorry.isDisplayed();
        System.out.println(check);

        driver.switchTo().defaultContent();

        driver.switchTo().frame("FrameTwo");
        WebElement enroll= driver.findElement(By.cssSelector("a[href*='/enroll/']"));
        boolean checking = enroll.isEnabled();
        System.out.println(checking);

    }
}
