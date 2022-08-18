package com.syntax.test;

import com.syntax.pages.DashboardPage;
import com.syntax.pages.LoginPageWithPageFactory;
import com.syntax.testBase.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class LoginTestWithPageFactory {

    public static void main(String[] args) {
        BaseClass.openWithSpecificUrl("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        // create objects for each corresponding page first -- best practice
        LoginPageWithPageFactory loginPageWithPageFactory = new LoginPageWithPageFactory();
        DashboardPage dashboardPage = new DashboardPage();

//        loginPageWithPageFactory.username.sendKeys("Admin");
//        loginPageWithPageFactory.password.sendKeys("Hum@nhrm123");
//        loginPageWithPageFactory.loginButton.click();
        loginPageWithPageFactory.loginActions();

        TakesScreenshot ts = (TakesScreenshot)BaseClass.driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(sourceFile, new File("screenshots/HRMS/dashboard.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        dashboardPage.welcomeAdmin.click();
        dashboardPage.logout.click();

        BaseClass.tearDown();
    }
}