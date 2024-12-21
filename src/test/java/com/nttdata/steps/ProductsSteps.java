package com.nttdata.steps;

import com.nttdata.screens.ProductsScreen;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ProductsSteps {

    ProductsScreen productsScreen;
//    ProductsScreen productsScreen;

//    public void login(String username, String password) {
//        loginScreen.enterUser(username);
//        loginScreen.enterPassword(password);
//        loginScreen.clickLogin();
//    }
//    public void loginSuccess() {
//        Assert.assertTrue("Do not show product title", productsScreen.isProductDisplayed());
//    }
    public void validateProductTitle(String title) {
        Assert.assertEquals("Incorrect Title", title, productsScreen.getProductTitle());
    }

    public void addProductToCart( int quantity, String productName) {
        WebElement product = productsScreen.findProduct(productName);
        productsScreen.clickAddToCartButton(product);

        if (quantity > 1) {
            productsScreen.incrementProductQuantity(product, quantity);
        }
    }
}
