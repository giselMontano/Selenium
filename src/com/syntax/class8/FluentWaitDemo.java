package com.syntax.class8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //INSIDE THE FLUENT WAIT WE NEED THE OBJECT THAT INTERACTS WITH THE PAGE WE ARE WORKING ON, IN THIS CASE "DRIVER"
        Wait<WebDriver> wait = new FluentWait<>(driver)
                //specify condition right away
                .withTimeout(Duration.ofSeconds(20))//SPECIFY A TIME BEFORE THROWING AN EXCEPTION (USUALLY 20 SEC)
                .pollingEvery(Duration.ofSeconds(5))//look for an element every 2 seconds
                .ignoring(NoClassDefFoundError.class);//ignores the exception
    }
}
