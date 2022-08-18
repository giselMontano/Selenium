package com.syntax.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitDemo {
    public static String url="http://syntaxprojects.com/index.php";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //IMPLICIT WAIT MUST BE INITIALIZED IN THE BEGINNING AND THIS WILL BE APPLIED FOR THE WHOLE SCRIPT/EXECUTION
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//parameter must be (how much time, TimeUnit)
        WebElement startPracticing = driver.findElement(By.id("btn_basic_example"));
        startPracticing.click();
    }
}

