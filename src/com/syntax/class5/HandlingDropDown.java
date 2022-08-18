package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HandlingDropDown {
    public static String url = "https://syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement diasDD = driver.findElement(By.id("select-demo"));

        Select here = new Select(diasDD);//THIS IS A CLASS FROM SELENIUM CALLED "SELECT" THE PARAMETER MUST BE THE DROPDOWN ELEMENT WE FOUND

        //SELECT BY INDEX
        here.selectByIndex(3);//TUESDAY//INDEXES ARE THE OPTIONS; IN THIS CASE THE FIRST OPTION IS "PLEASE SELECT" WITH INDEX 0 SO INDEX 3 WILL BE TUESDAY
                              //ALWAYS CHECK THE DOM->OPTIONS
        Thread.sleep(1000);

        //SELECT BY VISIBLE TEXT
        here.selectByVisibleText("Thursday");//OVERRIDE THE OPTION BEFORE
        Thread.sleep(1000);

        //SELECT BY IT'S VALUE
        here.selectByValue("Friday");//IN THIS EXAMPLE VALUE IS THE SAME AS TEXT//OVERRIDE THE OPTION BEFORE


        //HOW TO KNOW HOW MANY OPTIONS DO I HAVE IN THE DROPDOWN
        List<WebElement> todasLasOpciones = here.getOptions();///STORING ALL THE OPTION, options are also web elements/LIST WEB ELEMENTS//here is coming from "select class" line 20
        int size = todasLasOpciones.size();//how many options did I store
        System.out.println(size);//8, BUT ONE OPTION IS DISABLE


        //PRINT ALL THE OPTIONS IN THE CONSOLE
        for(int i = 1; i < size; i++) {//THE STARTING POINT IN THIS CASE IS "1" BECAUSE "0"IS DISABLE.
            String todos = todasLasOpciones.get(i).getText();//I am getting a text which is a string so we store it in String
            System.out.println(todos);//print all the options


            here.selectByIndex(i);//clicking by indexes "i" is looping through all the options
            Thread.sleep(1000);


        }

    }
}
