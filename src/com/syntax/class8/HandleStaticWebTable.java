package com.syntax.class8;

import jdk.swing.interop.SwingInterOpUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandleStaticWebTable {
    public static String url = "http://syntaxprojects.com/table-search-filter-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
        System.out.println(rowData.size());

        System.out.println("----------------------------------------------");
        //PRINT EVERYTHING BUT THE HEADER
        Iterator<WebElement> it = rowData.iterator();
        while (it.hasNext()) {
            WebElement row = it.next();
            String rowText = row.getText();
            System.out.println(rowText);
        }
        System.out.println("----------------------------------------------");
        //GETTING EACH AND EVERY HEADERS DATA AND PRINT IN THE CONSOLE
        List<WebElement> colsData = driver.findElements(By.xpath("//table[@id= 'task-table']/thead/tr/th"));
        for (WebElement colData : colsData) {
            String colText = colData.getText();
            System.out.println(colText);
        }
        System.out.println("----------------------------------------------");
        //THIS IS HOW YOU GET ONLY THE FIRST COLUMN
        //table[@id='task-table']/tbody/tr/td[2]
        List<WebElement> colSData = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td[2]"));
        for (WebElement colData : colSData) {
            String colText = colData.getText();
            System.out.println(colText);
        }
    }
}