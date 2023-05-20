package com.all.step_definitions;
import com.all.pages.Dashboard;
import com.all.pages.LoginPage;
import com.all.pages.ProductsPage;
import com.all.pages.SignupPage;
import com.all.utilities.BrowserUtils;
import com.all.utilities.ConfigurationReader;
import com.all.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Month;
import java.util.Arrays;

public class SignUpStepDefinitions {
    Dashboard dashboard = new Dashboard();
    LoginPage loginPage = new LoginPage();
    SignupPage signupPage = new SignupPage();
    ProductsPage productsPage = new ProductsPage();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();

    @Given("User is on the website")
    public void userIsOnTheWebsite() {
        Driver.getDriver().get(ConfigurationReader.getProperty("website.url"));
    }
    @Given("User navigates to login page and signs up")
    public void userNavigatesToLoginPageAndSignsUp() {
        dashboard.signupLoginButton.click();
        loginPage.name.sendKeys(faker.name().firstName());
        loginPage.email.sendKeys(faker.internet().emailAddress());
        loginPage.signupbutton.click();
    }
    @Then("user is on the signupPage")
    public void user_is_on_the_signup_page() {
        BrowserUtils.waitForPageToLoad(7000);
        String signuppagetitle = "Automation Exercise - Signup";
        Assert.assertEquals(signuppagetitle,Driver.getDriver().getTitle());
    }
    @When("User registers with valid credentials")
    public void user_enters_valid_credentials_and_clicks_create_account(){
        Select select = new Select(signupPage.daysDropdown);
        Select select1 = new Select(signupPage.monthsDropdown);
        Select select2 = new Select(signupPage.yearsDropdown);
        Select select3 = new Select(signupPage.countrydropdown);


        signupPage.title.click();

        signupPage.passowrd.sendKeys(faker.internet().password());

        select.selectByVisibleText(BrowserUtils.generateNumber1to30());

        String randomMonth = faker.options().option(Month.values()).name();
        randomMonth = randomMonth.substring(0,1).toUpperCase() + randomMonth.substring(1).toLowerCase();
        select1.selectByVisibleText(randomMonth);

        select2.selectByVisibleText(BrowserUtils.generatenumber1940to2012());

        signupPage.firstname.sendKeys(faker.name().firstName());
        signupPage.lastname.sendKeys(faker.name().lastName());
        signupPage.companyname.sendKeys(faker.company().name());
        signupPage.adress.sendKeys(faker.address().streetAddress());

        select3.selectByVisibleText("United States");

        signupPage.state.sendKeys(faker.address().state());
        signupPage.city.sendKeys(faker.address().city());
        signupPage.zipcode.sendKeys(faker.address().zipCode());
        signupPage.mobileNumber.sendKeys(faker.phoneNumber().cellPhone());
        signupPage.createaccoutbutton.click();

    }
    @And("user should see the success message")
    public void user_should_see_the_success_message() {
        BrowserUtils.waitForPageToLoad(5000);
        Assert.assertTrue(signupPage.successMessage.isDisplayed());
    }

    @Given("user navigates to products page")
    public void userNavigatesToProductsAndSelectsAnItem() {
        Actions actions = new Actions(Driver.getDriver());
        productsPage.productsClick.click();
        BrowserUtils.waitForPageToLoad(5000);
        actions.moveByOffset(0, 0).click().build().perform();
        String title = "Automation Exercise - All Products";
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Automation Exercise"));
    }

    @Then("user clicks view product and clicks add to cart")
    public void userClicksAddToCart() {
        BrowserUtils.waitForPageToLoad(100);
        productsPage.text.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(productsPage.productView).build().perform();
        js.executeScript("arguments[0].click();",productsPage.addToCart);
    }
    @When("user navigates to cart")
    public void userNavigatesToCart() {
        productsPage.viewCart.click();
    }

    @Then("user should see the item that added to cart")
    public void userShouldSeeTheItemThatAddedToCart() {
        Assert.assertEquals("Blue Top", productsPage.displayedProduct.getText());
        Driver.getDriver().quit();
    }

}

