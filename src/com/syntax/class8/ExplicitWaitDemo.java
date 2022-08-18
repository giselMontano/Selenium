package com.syntax.class8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {
    public static String url = "http://syntaxprojects.com/dynamic-data-loading-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement getNewUserButton = driver.findElement(By.id("save"));
        getNewUserButton.click();


        //EXPLICIT WAIT PARAMETERS MUST BE THE OBJECT THAT IS MANAGING THE PAGE IN THIS CASE "DRIVER" IT CAN BE NAME ANYTHING THOUGH
        //AND THE TIME TO WAIT WHICH IS USUALLY 20, THEN WE SHOULD SPECIFY THE CONDITION.
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //the * identify any tag name in xpath--> "h4 tag name" tend to change, this is fond size.
        //CONDITION FOR THE WAIT TIME WITH XPATH PARAMETERS, "ExpectedConditions."<--THIS IS A CLASS
        //WAITING FOR VISIBILITY OF THE ELEMENT NAME TO APPEAR
        //THIS "EXPLICIT WAIT" WORKS ONLY FOR ONE TIME CONDITION AND ELEMENT. YOU MUST SPECIFY AND WRITE ANOTHER ONE FOR ANOTHER WAIT
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'First N')]")));
        WebElement FirstName = driver.findElement(By.xpath("//*[contains(text(), 'First N')]"));
        System.out.println(FirstName.getText());


    }

}