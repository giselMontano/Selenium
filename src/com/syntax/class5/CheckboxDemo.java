package com.syntax.class5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxDemo {
    public static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //IN ORDER TO USE THE RIGHT GROUP OF ELEMENTS WE NEED TO TRY "CLASS", "TYPE" AND OTHER ATTRIBUTES, FIND SOMETHING IN COMMON
        //UNTIL WE FIND THE RIGHT AMOUNT OF CHECKBOXES
        //IN THIS CASE WE ARE LOOKING FOR 4 CHECKBOXES AND WE FOUND THEM WITH CLASS

        List<WebElement> optionCheckboxes = driver.findElements(By.xpath("//input[@class = 'cb1-element']"));//WE STORE IN A LIST BECAUSE WE HAVE MORE THAN ONE ELEMENT
        int cantidad = optionCheckboxes.size();//storing the size inside the int.
        System.out.println(cantidad);

        //WE NEED TO CLICK ALL THE CHECKBOXES, WE ARE LOOPING THROUGH WEB ELEMENTS
        for (WebElement opciones : optionCheckboxes) {
            //opciones.click();//to click everything
            //CLICKING ONLY ONE OPTION
            String boton = opciones.getAttribute("value");//this is attached to enhance loop and looking for the values then storing the value into "boton" to perform an if condition
            if (boton.equals("Option-2")) {
                opciones.click();
                break;//after clicking option 2 we need to break the iteration.
            }
            /*if (boton.equals("Option-2") || boton.equals("Option-3")) {
                opciones.click();//IF WE HAVE TO CLICK MORE THAN ONE OPTION WE MUST REMOVE "BREAK"
            }*/
        }
    }
}

