package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class HandleDDWithIterator {
    public static String url = "http://www.amazon.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement categoriesDD = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(categoriesDD);

        List<WebElement> options = select.getOptions();
        Iterator<WebElement> it = options.iterator();//we are getting in return options which are web elements so we put the the data type inside <>
        while(it.hasNext()) {//condition that checks if something inside the options
            WebElement DDopcion = it.next();//storing the first element inside web element
            String optionText = DDopcion.getText();//turning the option or web element into text
            System.out.println(optionText);
        }

    }
}

