package com.syntax.class7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvanceWindowHandle {
    public static String url = "https://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        String mainPage=driver.getWindowHandle();//get main page handle

        //everytime we're trying to open a new tab is interacting a link
        //By.linktexts CAN NOT have spaces in front and end!!
        ////a[text()=' Follow On Instagram '] when you identify by xpath YOU MUST INCLUDE SPACES!!

        WebElement insta=driver.findElement(By.linkText("Follow On Instagram"));
        WebElement face=driver.findElement(By.linkText("Like us On Facebook"));
        WebElement igAndFace=driver.findElement(By.linkText("Follow Instagram & Facebook"));
        //focus stays in main/parent tab``
         insta.click();
         face.click();
         igAndFace.click();
        Set<String> AllWindowHandles=driver.getWindowHandles();//contains all the tabs
        System.out.println(AllWindowHandles.size());//4

        Iterator<String> it=AllWindowHandles.iterator();

        //print each and every title we opened WE MUST SWITCH FOCUS// TO PRINT THEM ALL WE REMOVE IF CONDITION

        while(it.hasNext()){//ITERATING THE TABS
           String tab= it.next();//will get one handle->window/tab
           if(!mainPage.equals(tab)) {//WE MUST IMPLEMENT IF CONDITION TO DO THIS->closing all the windows but the main one// handle id  will never be duplicate line 32 contains tabs
               driver.switchTo().window(tab);//IN ORDER TO GET THE DIFFERENT TITLES WE MUST SWITCH THE FOCUS
               driver.manage().window().maximize(); //MAXIMIZE ALL CHILD WINDOW BEFORE I CLOSE THEM
               String title = driver.getTitle();
               System.out.println(title);
               driver.close();
           }
        }
        driver.switchTo().window(mainPage);//in order to click insta you must switch focus to main page once more
        insta.click();

    }
}