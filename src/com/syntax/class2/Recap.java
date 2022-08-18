package com.syntax.class2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recap {
    public static void main(String[] args) {
        //System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.fb.com");
        driver.manage().window().maximize();
        String title=driver.getTitle();//Actual title name (meaning this is what is actally in the window)
        String expectedTitle="Facebook - log in or sign up";//expected title, should look like this

        if(title.equals(expectedTitle)) {//compare two titles
            System.out.println("Title is correct");
        }else{
            System.out.println("Title is not correct");
        }
        driver.quit();
    }
}
