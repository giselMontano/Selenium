package com.syntax.class6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {
    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);


//first look for the frames-->open DOM->//iframe
        //1. by index
        driver.switchTo().frame(0);//you must switch to frame 0 index bc frame is another little window
        WebElement textbox = driver.findElement(By.id("name"));
        textbox.sendKeys("Batch 13 Forever!!!");

        driver.switchTo().defaultContent();//switching back focus to main html

        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();//switching focus into alert pop-up alert after this, the focus goes back automatically to main html
        alert.accept();

        //2. by name or id
        driver.switchTo().frame("iframe_a");//switching focus into the fame little window by value
        textbox.clear();//before we enter our new text box we must clear it, "textbox" is from line 19 reusing the code to interact with the frame.
        textbox.sendKeys("we are back to the frame");

        driver.switchTo().defaultContent();//switching back focus to main html


        //3. by web-element
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src = '/Demo.html']"));//iframe is a web-element
        driver.switchTo().frame(frameElement);//switching focus into frame little window
        textbox.clear();//we must clean the text-box before performance another action
        textbox.sendKeys("Hold your Horses!!!");
    }
}

