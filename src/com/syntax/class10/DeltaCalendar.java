package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeltaCalendar {
    public static String url = "http://www.delta.com";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
        calendar.click();
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
        nextButton.click();
        WebElement departureMonth = driver.findElement(By.className("dl-datepicker-month-0"));
        departureMonth.click();
        String dMonthText = departureMonth.getText();
        //click on next until month is October
        while (!dMonthText.equals("October")) {//while loop-> bc we don't know how many times we need to iterate and !dMonthText-> bc you need to click next when is not october
            nextButton.click();
            dMonthText = departureMonth.getText();//we need to get this text everytime, updating the text of each month to keep comparing.
        }
        List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
        for (WebElement fechasDePartida : departDates) {
            if (fechasDePartida.getText().equals("30")) {
                fechasDePartida.click();
                break;
            }
        }


        WebElement returnMonth = driver.findElement(By.className("dl-datepicker-month-1"));
        returnMonth.click();
        String rMonthText = returnMonth.getText();

        while (!rMonthText.equals("December")) {//while loop-> bc we don't know how many times we need to iterate and !dMonthText-> bc you need to click next when is not october
            nextButton.click();
            rMonthText = returnMonth.getText();//we need to get this text everytime, updating the text of each month to keep comparing.
        }
        List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
        for (WebElement fechasDeRetorno : returnDates) {
            if (fechasDeRetorno.getText().equals("20")) {
                fechasDeRetorno.click();
                break;
            }
        }
        WebElement doneButton=driver.findElement(By.className("donebutton"));
        doneButton.click();
    }
}