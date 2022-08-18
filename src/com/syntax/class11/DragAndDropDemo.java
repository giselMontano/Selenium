package com.syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {
    public static String url = "https://jqueryui.com/droppable/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0);//there is one frame where the drag and drop are
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        //action.dragAndDrop(draggable,droppable).perform();//first what are you dragging, where are you dropping it out dragAndDrop(draggable,droppable)

        //another way to drag and drop//anytime you have more than one action to perform you must have build() before perform()
        action.clickAndHold(draggable).moveToElement(droppable).release().build().perform();


        //refresh to get the drag and drop back to the original place
        //driver.navigate().refresh();
    }
}