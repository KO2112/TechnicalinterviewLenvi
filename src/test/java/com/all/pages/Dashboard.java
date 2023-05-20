package com.all.pages;

import com.all.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    public Dashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement signupLoginButton;
    @FindBy(linkText = "Logout")
    public WebElement logoutbutton;

}
