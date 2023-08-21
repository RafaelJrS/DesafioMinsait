package com.saudedemo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void logarComSucesso(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        dsl = new DSL(driver);
        dsl.escrever("user-name","standard_user");
        dsl.escrever("password","secret_sauce");
        dsl.clicarId("login-button");
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Test
    public void visualizarDetalhesProduto(){
        dsl.clicarXpath("//*[@id=\"item_4_title_link\"]/div");
        Assert.assertTrue(dsl.obterTexto(By.tagName("body")).contains("Sauce Labs Backpack"));
    }

    @Test
    public void adicionarProdutoCarrinho(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        Assert.assertTrue(dsl.obterTexto(By.tagName("body")).contains("Sauce Labs Backpack"));
    }

    @Test
    public void removerProdutoCarrinho(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        Assert.assertTrue(dsl.obterTexto(By.tagName("body")).contains("Sauce Labs Backpack"));
        dsl.clicarId("remove-sauce-labs-backpack");
        Assert.assertFalse(dsl.obterTexto(By.tagName("body")).contains("Sauce Labs Backpack"));
    }

    @Test
    public void botaoContinueShopping(){
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("continue-shopping");
        Assert.assertTrue(dsl.obterTexto(By.tagName("span")).contains("Products"));
    }

    @Test
    public void botaoCheckOut(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("checkout");
        Assert.assertTrue(dsl.obterTexto(By.tagName("body")).contains("Checkout: Your Information"));
    }

    @Test
    public void errorCampoFirstName(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("checkout");
        dsl.clicarId("continue");
        Assert.assertTrue(dsl.obterTexto(By.tagName("h3")).contains("Error: First Name is required"));
    }

    @Test
    public void errorCampoLastName(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("checkout");
        dsl.escrever("first-name","Rafael");
        dsl.clicarId("continue");
        Assert.assertTrue(dsl.obterTexto(By.tagName("h3")).contains("Error: Last Name is required"));
    }

    @Test
    public void errorPostalCode(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("checkout");
        dsl.escrever("first-name","Rafael");
        dsl.escrever("last-name","Silva");
        dsl.clicarId("continue");
        Assert.assertTrue(dsl.obterTexto(By.tagName("h3")).contains("Error: Postal Code is required"));
    }

    @Test
    public void botaoContinue(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("checkout");
        dsl.escrever("first-name","Rafael");
        dsl.escrever("last-name","Silva");
        dsl.escrever("postal-code","08715530");
        dsl.clicarId("continue");
        Assert.assertTrue(dsl.obterTexto(By.tagName("body")).contains("Checkout: Overview"));
    }

    @Test
    public void botaoFinish(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("checkout");
        dsl.escrever("first-name","Rafael");
        dsl.escrever("last-name","Silva");
        dsl.escrever("postal-code","08715530");
        dsl.clicarId("continue");
        dsl.clicarId("finish");
        Assert.assertTrue(dsl.obterTexto(By.tagName("h2")).contains("Thank you for your order!"));
    }

    @Test
    public void botaoBackHome(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
        dsl.clicarId("shopping_cart_container");
        dsl.clicarId("checkout");
        dsl.escrever("first-name","Rafael");
        dsl.escrever("last-name","Silva");
        dsl.escrever("postal-code","08715530");
        dsl.clicarId("continue");
        dsl.clicarId("finish");
        dsl.clicarId("back-to-products");
        Assert.assertTrue(dsl.obterTexto(By.tagName("span")).contains("Products"));
    }
}