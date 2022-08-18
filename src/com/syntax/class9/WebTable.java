package com.syntax.class9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTable {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement userName=driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement passWord=driver.findElement(By.id("txtPassword"));
        passWord.sendKeys("Hum@nhrm123");
        WebElement login=driver.findElement(By.id("btnLogin"));
        login.click();
        WebElement PIM=driver.findElement(By.id("menu_pim_viewPimModule"));
        PIM.click();
        WebElement addEmployee=driver.findElement(By.id("menu_pim_addEmployee"));
        addEmployee.click();
        WebElement firstName=driver.findElement(By.id("firstName"));
        firstName.sendKeys("YaTuSabes");
        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("What");
        //get the value that is the id
        WebElement getID=driver.findElement(By.id("employeeId"));
        //everytime you get a attribute you get a string in return
        String IDtext=getID.getAttribute("value");
        WebElement saveButton=driver.findElement(By.id("btnSave"));
        saveButton.click();
        WebElement listEmployee=driver.findElement(By.id("menu_pim_viewEmployeeList"));
        listEmployee.click();

        boolean flag = true;

        while(flag) {
            List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id = 'resultTable']/tbody/tr")); // reinitialize all the element because the page gets refreshed
            for(int i = 0; i < tableRows.size(); i++) {
                String rowText = tableRows.get(i).getText();
                if(rowText.contains(IDtext)) { // compare the empId
                    flag = false; // set the boolean as false
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id = 'resultTable']/tbody/tr["+i+"]/td[1]")); // identify the checkbox "i" this is the index that is iterating through the code
                    checkBox.click();
                }

            }
            if(flag) {
                WebElement nextButton = driver.findElement(By.linkText("Next"));
                nextButton.click();
            }
        }
    }

}

//staleelementexception is the worst exception you can get