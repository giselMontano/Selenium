package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropDown {


        public static String url = "http://www.amazon.com";

        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(url);

            //FINDING THE WEB ELEMENT
            WebElement categoriasDD = driver.findElement(By.id("searchDropdownBox"));
            Select here = new Select(categoriasDD);//SELECT IS A CLASS FROM SELENIUM. TO HANDLE DROPDOWNS WITH <SELECT TAG

            //GETTING ALL THE OPTIONS FROM "SELECT" CLASS
            List<WebElement> options = here.getOptions();
            for(WebElement opcion: options) {//OPCION=>RANDOM NAME
                String opcionTexto = opcion.getText();//TURNING EVERYTHING INTO TEXT AND STORING THEM ALL INTO STRING
                System.out.println(opcionTexto);//PRINTING ALL THE OPTIONS TEXTS
            }


            //SELECT AN OPTION WITH VALUE
            here.selectByValue("search-alias=alexa-skills");

        }
    }

