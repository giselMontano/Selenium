package com.syntax.class12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorDemo2 {
    public static String url = "http://www.amazon.com";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //scrolling up and down
        JavascriptExecutor js = (JavascriptExecutor)driver;//THIS IS A MUST WHEN YOU USE JavascriptExecutor
        js.executeScript("window.scrollBy(0, 700)");//window.scrollBy// SCRIPT FROM JAVASCRIPT STAYS LIKE THAT
        Thread.sleep(2000);
        //WE ARE STARTING FROM 0 BC THE STATING POINT WILL ALWAYS BE 0 SINCE THE PREVIOUS SCRIPT DOES NOT KNOW WHERE IS THE END POINT
        js.executeScript("window.scrollBy(0, -500)");


        // scrolling into a specific view or element "BACK TO THE TOP"
        WebElement backToTopButton = driver.findElement(By.className("navFooterBackToTopText"));
        js.executeScript("arguments[0].scrollIntoView(true)", backToTopButton);//arguments[0].scrollIntoView(false)//<--JAVA SCRIPT STAYS LIKE THAT
    }
}

