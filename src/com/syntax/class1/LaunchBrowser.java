package com.syntax.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            WebDriver driver = new ChromeDriver();//lauch the browser
            driver.get("http:/www.google.com");//open browser
            String url = driver.getCurrentUrl();//store the current url that we just navigated inside the string (url) random name
            System.out.println(url);//printing the url stored
            String title = driver.getTitle();//store the title on the tap where you are working on (Google) in this case and putting inside (title) string datatype
            System.out.println(title);
            driver.quit();
        }
    }