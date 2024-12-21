package com.nttdata.stepsdefinitions;

import com.nttdata.steps.ProductsSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ProductsStepsDefs {

    @Steps
    ProductsSteps productsSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {

    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        String TitleExpected = "Products.";
        productsSteps.validateProductTitle(TitleExpected);
    }

    @When("agrego <UNIDADES> del siguiente producto {string}")
    public void agregoUNIDADESDelSiguienteProducto(int quantity,String productName) {
        productsSteps.addProductToCart(quantity,productName);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {

    }
}
