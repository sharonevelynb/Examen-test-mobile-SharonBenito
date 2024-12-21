package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class ProductsScreen extends PageObject {


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    public WebElement lblProductTitle;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']")
    public WebElement recyclerView;

    public String getProductTitle() {
        waitFor(ExpectedConditions.visibilityOf(lblProductTitle));
        return lblProductTitle.getText();
    }

    public List<WebElement> getAllProducts() {
         waitFor(ExpectedConditions.visibilityOf(recyclerView));
        return recyclerView.findElements(org.openqa.selenium.By.xpath("./android.view.ViewGroup"));
    }

    public WebElement findProduct(String productName) {
        List<WebElement> products = getAllProducts();
        for (WebElement product : products) {
            String title = product.findElement(org.openqa.selenium.By.xpath(".//android.widget.TextView")).getText();
            if (title.equalsIgnoreCase(productName)) {
                return product; // Devuelve el producto encontrado
            }
        }
        throw new RuntimeException("Producto no encontrado: " + productName);
    }

    public void clickAddToCartButton(WebElement product) {
        WebElement addToCartButton = product.findElement(org.openqa.selenium.By.xpath(".//android.widget.Button"));
        addToCartButton.click();
    }

    public void incrementProductQuantity(WebElement product, int quantity) {
        WebElement incrementButton = product.findElement(org.openqa.selenium.By.xpath(".//android.widget.Button[2]")); // Botón "+"
        for (int i = 1; i < quantity; i++) {
            incrementButton.click();
        }
    }
}
