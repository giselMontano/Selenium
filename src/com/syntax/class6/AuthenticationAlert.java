package com.syntax.class6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert {
    public static String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
                                     //username:password@
    //IN AUTHENTICATION PAGE YOU CAN NOT INSPECT THE PAGE BECAUSE THERE IS GOING TO BE A POP-UP IMMEDIATELY
    //SO YOU MUST SEND USERNAME AND PASSWORD DIRECTLY IN FRONT OF THE URL

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
    }
}

