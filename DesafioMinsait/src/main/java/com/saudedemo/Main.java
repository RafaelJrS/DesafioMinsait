package com.saudedemo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    private WebDriver driver;

    @Before
    public void logarComSucesso(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void visualizarDetalhesProduto(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).click();
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Sauce Labs Backpack"));
        driver.quit();
    }

    @Test
    public void adicionarProdutoCarrinho(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Sauce Labs Backpack"));
        driver.quit();
    }

    @Test
    public void removerProdutoCarrinho(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Sauce Labs Backpack"));
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains("Sauce Labs Backpack"));
    }

    @Test
    public void botaoContinueShopping(){
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("continue-shopping")).click();
        Assert.assertTrue(driver.findElement(By.tagName("span")).getText().contains("Products"));
    }

    @Test
    public void botaoCheckOut(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Checkout: Your Information"));
    }

    @Test
    public void errorCampoFirstName(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("continue")).click();
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Error: First Name is required"));
    }

    @Test
    public void errorCampoLastName(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Rafael");
        driver.findElement(By.id("continue")).click();
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Error: Last Name is required"));
    }

    @Test
    public void errorPostalCode(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Rafael");
        driver.findElement(By.id("last-name")).sendKeys("Silva");
        driver.findElement(By.id("continue")).click();
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Error: Postal Code is required"));
    }

    @Test
    public void botaoContinue(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Rafael");
        driver.findElement(By.id("last-name")).sendKeys("Silva");
        driver.findElement(By.id("postal-code")).sendKeys("08715530");
        driver.findElement(By.id("continue")).click();
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Checkout: Overview"));
    }

    @Test
    public void botaoFinish(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Rafael");
        driver.findElement(By.id("last-name")).sendKeys("Silva");
        driver.findElement(By.id("postal-code")).sendKeys("08715530");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        Assert.assertTrue(driver.findElement(By.tagName("h2")).getText().contains("Thank you for your order!"));
    }

    @Test
    public void botaoBackHome(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Rafael");
        driver.findElement(By.id("last-name")).sendKeys("Silva");
        driver.findElement(By.id("postal-code")).sendKeys("08715530");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();
        driver.findElement(By.id("back-to-products")).click();
        Assert.assertTrue(driver.findElement(By.tagName("span")).getText().contains("Products"));
    }
}