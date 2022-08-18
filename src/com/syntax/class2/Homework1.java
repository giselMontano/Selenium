package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {
  /*  HW
    navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
    fill out the form
    click on register
    close the browser
*/
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
    WebDriver find = new ChromeDriver();
    find.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
    find.findElement(By.id("customer.firstName")).sendKeys("Aladin");
    find.findElement(By.name("customer.lastName")).sendKeys("Uni");
    find.findElement(By.id("customer.address.street")).sendKeys("123 over the rainbow");
    find.findElement(By.id("customer.address.city")).sendKeys("Unicorn Land");
    find.findElement(By.id("customer.address.state")).sendKeys("New York");
    find.findElement(By.id("customer.address.zipCode")).sendKeys("11111");
    find.findElement(By.id("customer.phoneNumber")).sendKeys("1234567");
    find.findElement(By.id("customer.ssn")).sendKeys("3334455");
    find.findElement(By.id("customer.username")).sendKeys("AladinUni");
    find.findElement(By.id("customer.password")).sendKeys("helloIamAnUnicorn");
    find.findElement(By.id("repeatedPassword")).sendKeys("helloIamAnUnicor");
    find.findElement(By.className("button")).click();
    find.quit();
  }
}

