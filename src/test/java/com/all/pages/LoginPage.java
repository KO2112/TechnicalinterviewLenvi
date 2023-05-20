package com.all.pages;

import com.all.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@data-qa=\"signup-name\"]")
    public WebElement name;
    @FindBy(xpath = "//input[@data-qa='signup-email']\n")
    public WebElement email;

    @FindBy(xpath = "//button[@data-qa=\"signup-button\"]")
    public WebElement signupbutton;
}
