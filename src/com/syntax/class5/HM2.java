package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HM2 {
    /*HW1
    Go to facebook sign up page
    Fill out the whole form
    Click signup*/
    public static String url=  "https://www.fb.com";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement create = driver.findElement(By.cssSelector("a[rel*='async']"));
        create.click();
        Thread.sleep(2000);

        WebElement name = driver.findElement(By.xpath("//input[contains(@name,'firstname')]"));
        name.sendKeys("Alejandra");
        WebElement lastName = driver.findElement(By.xpath("//input[contains(@name,'lastname')]"));
        lastName.sendKeys("Montano");
        WebElement phone = driver.findElement(By.cssSelector("input[name*='reg_email__']"));
        phone.sendKeys("12345678");
        WebElement passcode = driver.findElement(By.cssSelector("input[name*='reg_passwd__']"));
        passcode.sendKeys("123hola");
        Thread.sleep(2000);


        WebElement birthdayMonth = driver.findElement(By.id("month"));
        Select month = new Select(birthdayMonth);
        month.selectByValue("6");
        Thread.sleep(2000);
        WebElement birthdayDay = driver.findElement(By.cssSelector("select[name*='birthday_day']"));
        Select day = new Select(birthdayDay);
        day.selectByVisibleText("14");
        Thread.sleep(2000);
        WebElement birthdayYear = driver.findElement(By.cssSelector("select[name*='birthday_year']"));
        Select year = new Select(birthdayYear);
        year.selectByVisibleText("1994");
        Thread.sleep(2000);

        List<WebElement> optionCheckboxes = driver.findElements(By.cssSelector("input[name*='sex']"));
        for (WebElement opciones : optionCheckboxes) {
            opciones.click();
            break;
    }
        WebElement sign = driver.findElement(By.cssSelector("button[name*='websubmit']"));
        sign.click();;

    }
}
