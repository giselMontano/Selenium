package com.syntax.class7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandle {
    public static String url="http://accounts.google.com/signup";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        String mainPageHandle= driver.getWindowHandle();//gets the id main page of the tab/window we just navigated
        System.out.println(mainPageHandle);
        WebElement help=driver.findElement(By.linkText("Help"));
        help.click();

        //Have all the tap id on hand, SINCE WE HAVE MORE THAT ONE TAB OPEN
        Set<String> AllWindowHandles=driver.getWindowHandles();//store all the tabs/window id inside the "Set"

        //HOW MANY WINDOW HANDLE I HAVE INSIDE MY SET
        System.out.println(AllWindowHandles.size());//2 because we have two tabs open

        //main tab/window =parent handle
        //second tab/window =child handle

        //Assigning which one will be the first step
        Iterator<String> it= AllWindowHandles.iterator();//Have an iterator in order to iterate through the handles or tabs
        mainPageHandle=it.next();//take the first step and  assign it to the main page handle "Parent handle"

        //Asssigning the second step
        String childHandle= it.next();//take the second step and have a child handle/tab
        System.out.println(childHandle);
        //driver.close();//ONCE WE OPEN CHILD TAB THE FOCUS STAYS IN THE PARENT, BECAUSE WE DID NOT SWITCH THE FOCUS THEREFORE PARENT TAB WILL CLOSE

        Thread.sleep(2000);
        driver.switchTo().window("childHandle");//IN ORDER TO CLOSE CHILD TAB WE NEED TO SWITCH FOCUS THEN CLOSE
        driver.close();//ONCE SWITCH FOCUS TO CHILD TAB THEN WE CAN CLOSE CHILD TAB

        driver.switchTo().window(mainPageHandle);//in order to click on help again fOrm parent tab, we need to switch focus again to parent tab then "click help" again otherwise it will fail because child is tab is closed
        help.click();


        //driver.close(); close the tab your focus is on
        //driver.quit();closes everything
    }

}
