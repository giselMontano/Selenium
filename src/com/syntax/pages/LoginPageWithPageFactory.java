package com.syntax.pages;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory extends CommonMethods {//MUST EXTEND CommonMethods IN ORDER TO HAVE ACCESS TO DRIVER
    @FindBy(id = "txtUsername")
    public WebElement username;//assignation to a variable WebElement

    @FindBy(xpath = "//input[@name = 'txtPassword']")
    public WebElement password;

    @FindBy(css = "input#btnLogin")
    public WebElement loginButton;

//@FindBy(css = "input#btnLogin")
//public List<WebElement> multipleElements;

    /**
     * this method will login
     */
    // you can put login actions and reuse the common methods
    public void loginActions() {
        sendText(username, "Admin");
        sendText(password, "Hum@nhrm123");
        loginButton.click();

    }


    //WE MUST EXTEND CommonMethods IN ORDER TO HAVE ACCESS TO DRIVER
    public LoginPageWithPageFactory() {//same name "LoginPageWithPageFactory as the class in order to initialize everything inside this class
        PageFactory.initElements(driver, this);//"this" keyword helps to initialized all the elements inside this same class
        //"PageFactory" is from selenium class
    }

}
