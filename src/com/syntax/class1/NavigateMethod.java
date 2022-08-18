package com.syntax.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {

    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver =new ChromeDriver();//this open a tap of chrome if you need two you must create another one of this
        driver.get("http:/www.facebook.com");//open facebook first
        driver.navigate().to("http://www.google.com");//open google after
        driver.navigate().back();//goes back to facebook
        driver.navigate().forward();//goes to google
        Thread.sleep(2000);//pause the execution for 2 seconds
        driver.navigate().refresh();//refresh google

        driver.close();//close the current tap
        driver.quit();//close the whole browser
    }
}
