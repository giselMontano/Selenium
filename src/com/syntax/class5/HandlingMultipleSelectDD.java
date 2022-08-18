package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingMultipleSelectDD {
    public static String url = "https://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement statesDD = driver.findElement(By.id("multi-select"));
        Select here = new Select(statesDD);//SELECT CLASS SELENIUM that allow us to see all the options from the drop down
        boolean isMultiple = here.isMultiple();//TO CHECK IS THE DROPDOWN IS MULTIPLE OR NOT(TRUE OR FALSE) AND STORE INTO BOOLEAN
        System.out.println(isMultiple);

        if (isMultiple) {//this is a condition only and only is the dropdown is multiple.
            List<WebElement> options = here.getOptions();//we store the options inside web elements
            for (WebElement opciones : options) {
                String optionText = opciones.getText();
                here.selectByVisibleText(optionText);
            }
        }
        here.deselectByIndex(5);//texas
        here.deselectAll();//deselect all the selected values
    }
}

