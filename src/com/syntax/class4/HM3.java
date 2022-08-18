package com.syntax.class4;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM3 {
    /*HW 2
    HRMS Application Negative Login:
    Open chrome browser
    Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    Enter valid username
    Leave password field empty
    Click on login button
    Verify error message with text “Password cannot be empty” is displayed.*/
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement username = driver.findElement(By.cssSelector("input#txtUsername"));
        username.sendKeys("Ale.m");
        WebElement button= driver.findElement(By.cssSelector("input.button"));
        button.click();
        WebElement PasscodeCannotBeEmpty = driver.findElement(By.cssSelector("span#spanMessage"));
        boolean check = PasscodeCannotBeEmpty.isDisplayed();
        System.out.println(check);

    }
}
