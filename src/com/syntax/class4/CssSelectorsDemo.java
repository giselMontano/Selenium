package com.syntax.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorsDemo {
    public static void main(String[] args) throws InterruptedException {
        /*HW
        Navigate to http://syntaxprojects.com
        Click on start practicing
        click on simple form demo
        enter any text on first text box
        click on show message
        quit the browser*/

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");WebDriver driver =new ChromeDriver();
        driver.get("http://syntaxprojects.com");
        WebElement startPractice = driver.findElement(By.cssSelector("a#btn_basic_example"));
        startPractice.click();
        Thread.sleep(2000);
        WebElement simpleForm = driver.findElement(By.xpath("//a[text() = 'Check Box Demo']/preceding-sibling::a"));
        simpleForm.click();
        Thread.sleep(2000);
        WebElement enterText =driver.findElement(By.cssSelector("input[placeholder^='Please']"));
        enterText.sendKeys("Zameer loves absolute xpath");
        WebElement showText =driver.findElement(By.cssSelector("button[onclick*='show']"));
        showText.click();
        Thread.sleep(2000);
        driver.quit();

    }
}
