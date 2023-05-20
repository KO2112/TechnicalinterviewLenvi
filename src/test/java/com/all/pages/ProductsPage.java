package com.all.pages;

import com.all.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    public ProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href=\"/products\"]")
    public WebElement productsClick;

    @FindBy(xpath = "//div[@class='ad']")
    public WebElement singleadd;

    @FindBy(xpath = "//div[@class='productinfo text-center']")
    public WebElement productView;

    @FindBy(xpath = "//a[contains(@class, 'add-to-cart') and contains(@data-product-id, '1')]")
    public WebElement addToCart;

    @FindBy(xpath = "//a[@href='/view_cart' and u[text()='View Cart']]")
    public WebElement viewCart;

    @FindBy(xpath = "//a[contains(@href, '/product_details/1')]")
    public WebElement displayedProduct;

    @FindBy(id = "submit_search")
    public WebElement search;

    @FindBy(xpath = "//h2[@class='title text-center' and text()='All Products']")
    public WebElement text;
}
