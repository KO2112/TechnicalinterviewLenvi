package com.all.pages;

import com.all.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    public SignupPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type=\"radio\" and @name=\"title\"]")
    public WebElement title;
    @FindBy(id = "password")
    public WebElement passowrd;

    @FindBy(id = "days")
    public WebElement daysDropdown;

    @FindBy(id = "months")
    public WebElement monthsDropdown;

    @FindBy(id = "years")
    public WebElement yearsDropdown;

    @FindBy(id = "first_name")
    public WebElement firstname;

    @FindBy(id = "last_name")
    public WebElement lastname;

    @FindBy(id = "company")
    public WebElement companyname;

    @FindBy(id = "address1")
    public WebElement adress;

    @FindBy(id = "country")
    public WebElement countrydropdown;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(name = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa=\"create-account\"]")
    public WebElement createaccoutbutton;

    @FindBy(xpath = "//b[text()=\"Account Created!\"]")
    public WebElement successMessage;



}
