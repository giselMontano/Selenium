package com.syntax.class4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HM1 {
    /*Task
    Open chrome browser
    Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
    Enter valid username and password (username - Admin, password - Hum@nhrm123)
    Click on login button
    Then verify Syntax Logo is displayed. if condition*/

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        WebElement logo = driver.findElement(By.cssSelector("img[src*='human']"));
        boolean checking =logo.isDisplayed();
        System.out.println(checking);

        WebElement username= driver.findElement(By.cssSelector("input#txtUsername"));
        username.sendKeys("Admin");
        Thread.sleep(2000);
        WebElement passcode = driver.findElement(By.cssSelector("input#txtPassword"));
        passcode.sendKeys("Hum@nhrm123");
        WebElement button= driver.findElement(By.cssSelector("input.button"));
        button.click();

    }
}
