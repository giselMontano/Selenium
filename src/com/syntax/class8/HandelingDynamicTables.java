package com.syntax.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandelingDynamicTables {
    public static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");

        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        WebElement button = driver.findElement(By.className("button"));
        button.click();
        List<WebElement> rows=driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));//header is part of the body
        for(int i=1; i< rows.size(); i++){//when you use regular loop you need to get everything by the indexes,we start from 1 because header is part of the body
            String rowText= rows.get(i).getText();
            System.out.println(rowText);
            if(rowText.contains("FamilyAlbum")){//this is in common between 3 people in the dynamic table
                List<WebElement> checkboxes =driver.findElements((By.xpath("//table[@class='SampleTable']/tbody/tr/td[1]")));//textboxes start at the actual body header does not contain texbox.
                checkboxes.get(i-1).click();//this -1 is because the indexes started in the header but the texboxes starts one step ahead in the actual body, so header would have index -1 in the case of checkboxes
            }
//when my index row is one my index checkbox is one step ahead
        }
    }
}