package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task {
    /**
     * Task
     * Navigate to http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx
     * Login
     * Get title and verify
     * logout
     * close the browser
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver locator= new ChromeDriver();
        locator.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        locator.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        /* IS GOOD TO SAVE THE VALUES IN ORDER TO REUSE THE VALUE */
        WebElement username= locator.findElement(By.id("ctl00_MainContent_username"));//to store the value into webElement(object) type. for re-usability
        username.sendKeys("tester");//using username


        locator.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        /* IS GOOD TO SAVE THE VALUES IN ORDER TO REUSE THE VALUE */
        WebElement password= locator.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");


        locator.findElement(By.className("button")).click();
        String title  =locator.getTitle();
        String titleExpected="Web Orders";//after you log in you can see the title just hover over the top tap
                                          //in real life the expected tittle is given to us
        if(title.equals(titleExpected)) {
            System.out.println("Title is correct");
        }else{
            System.out.println("Title is not correct");
        }
        locator.findElement(By.linkText("Logout")).click();
        locator.quit();
    }
}
