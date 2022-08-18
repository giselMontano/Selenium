package com.syntax.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HM1 {
    /*Go to https://demoqa.com/browser-windows
click on New Tab and print the text from new tab in the console
click on New Window and print the text from new window in the console
click on New Window Message and print the text from new window in the console
Verify (compare) the titles for each page
Print out the title of the all pages
RUN WITH FIREFOX
*/

    public static String url = "https://demoqa.com/browser-windows";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get(url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        String mainPage = driver.getWindowHandle();


        WebElement NewTab = driver.findElement(By.id("tabButton"));
        NewTab.click();
        System.out.println(NewTab.getText());
        WebElement NewWindow = driver.findElement(By.id("windowButton"));
        NewWindow.click();
        System.out.println(NewWindow.getText());
        WebElement NewWindowM = driver.findElement(By.id("messageWindowButton"));
        NewWindowM.click();
        System.out.println(NewWindowM.getText());

        Set<String> AllWindowHandles = driver.getWindowHandles();
        System.out.println(AllWindowHandles.size());
        Iterator<String> it = AllWindowHandles.iterator();

        while (it.hasNext()) {//ITERATING THE TABS
            String tab = it.next();//will get one handle->window/tab
                driver.switchTo().window(tab);//IN ORDER TO GET THE DIFFERENT TITLES WE MUST SWITCH THE FOCUS
                String title = driver.getTitle();
                if (title.isEmpty()) {
                    System.out.println("No tittle found");
                } else {
                    System.out.println(title);
                }
                driver.close();
            }
        }
    }
