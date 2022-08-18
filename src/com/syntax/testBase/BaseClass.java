package com.syntax.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;//static can be access from other classes without creating an object
//TO CREATE THIS JAVADOC JUST TYPE /** AND HIT ENTER
    /**
     *
     * this method will navigate to a website by the given url-->JAVADOC, THIS CAN ONLY BE OUTSIDE THE METHODS,
     *                                                       YOU NEED TO PROVIDE JAVADOCS FOR EACH AND EVERY METHOD
     * @param url
     */
    public static void openWithSpecificUrl(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * this method will close the browser
     */
    public static void tearDown(){
        if(driver !=null) {
            driver.quit();
        }
    }
}
