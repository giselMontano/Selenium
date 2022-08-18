package com.syntax.class5;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HM1 {
    /*TC 1: Facebook dropdown verification
    Open chrome browser
    Go to “https://www.facebook.com”
    click on create new account
    Verify:
    month dd has 12 month options
    day dd has 31 day options
    year dd has 115 year options
    Select your date of birth
    Quit browser
     */
    public static String url="https://www.facebook.com";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement create = driver.findElement(By.cssSelector("a[rel*='async']"));
        create.click();
        Thread.sleep(2000);

        WebElement month =driver.findElement(By.id("month"));
        Select monthCheck = new Select(month);
        List<WebElement> todasLasOpciones = monthCheck.getOptions();
        int size = todasLasOpciones.size();
        if(size==12){
        System.out.println("true");
        }else{
            System.out.println("false");
        }
        WebElement day=driver.findElement(By.id("day"));
        Select dayCheck=new Select(day);
        List<WebElement> total= dayCheck.getOptions();
        int size1= total.size();
        if(size1==31){
            System.out.println("true");
        }else{
        System.out.println("false");
    }
        WebElement year=driver.findElement(By.id("year"));
        Select yearCheck=new Select(year);
        List<WebElement> All= yearCheck.getOptions();
        int size2=All.size();
        if(size2==115) {
            System.out.println("true");
        }else{
            System.out.println("false");
            }

        WebElement birthdayMonth = driver.findElement(By.id("month"));
        Select monthG = new Select(birthdayMonth);
        monthG.selectByValue("6");
        Thread.sleep(2000);

        WebElement birthdayDay = driver.findElement(By.cssSelector("select[name*='birthday_day']"));
        Select dayG = new Select(birthdayDay);
        dayG.selectByVisibleText("14");
        Thread.sleep(2000);

        WebElement birthdayYear = driver.findElement(By.cssSelector("select[name*='birthday_year']"));
        Select yearG = new Select(birthdayYear);
        yearG.selectByVisibleText("1994");
        Thread.sleep(2000);

        driver.quit();

    }
}
