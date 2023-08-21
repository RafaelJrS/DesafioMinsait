package com.saucedemo.testes;

import com.saucedemo.core.DSL;
import com.saucedemo.pages.SauceDemoPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ECommerceTeste {

    private WebDriver driver;
    private DSL dsl;
    private SauceDemoPage page;

    @Before
    public void logarComSucesso(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        dsl = new DSL(driver);
        page = new SauceDemoPage(driver);
        page.setUserName("standard_user");
        page.setPassword("secret_sauce");
        page.clicarBotaoLogin();
    }

    @After
    public void finalizar(){
        driver.quit();
    }

    @Test
    public void visualizarDetalhesProduto(){
        page.clicarProdutoBackpack();
        Assert.assertTrue(page.obterRetornoBuscaBody().contains("Sauce Labs Backpack"));
    }

    @Test
    public void adicionarProdutoCarrinho(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        Assert.assertTrue(page.obterRetornoBuscaBody().contains("Sauce Labs Backpack"));
    }

    @Test
    public void removerProdutoCarrinho(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        Assert.assertTrue(page.obterRetornoBuscaBody().contains("Sauce Labs Backpack"));
        page.clicarRemoverProdutoBackpack();
        Assert.assertFalse(page.obterRetornoBuscaBody().contains("Sauce Labs Backpack"));
    }

    @Test
    public void botaoContinueShopping(){
        page.clicarCarrinhoCompra();
        page.clicarBotaoContinueShopping();
        Assert.assertTrue(page.obterRetornoBuscaSpan().contains("Products"));
    }

    @Test
    public void botaoCheckOut(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        Assert.assertTrue(page.obterRetornoBuscaBody().contains("Checkout: Your Information"));
    }

    @Test
    public void errorCampoFirstName(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        page.clicarBotaoContinue();
        Assert.assertTrue(page.obterRetornoBuscaH3().contains("Error: First Name is required"));
    }

    @Test
    public void errorCampoLastName(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        page.preencherCampoFirstName("Rafael");
        page.clicarBotaoContinue();
        Assert.assertTrue(page.obterRetornoBuscaH3().contains("Error: Last Name is required"));
    }

    @Test
    public void errorPostalCode(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        page.preencherCampoFirstName("Rafael");
        page.preencherCampoLastName("Silva");
        page.clicarBotaoContinue();
        Assert.assertTrue(page.obterRetornoBuscaH3().contains("Error: Postal Code is required"));
    }

    @Test
    public void botaoContinue(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        page.preencherCampoFirstName("Rafael");
        page.preencherCampoLastName("Silva");
        page.preencherCampoPostalCode("08715530");
        page.clicarBotaoContinue();
        Assert.assertTrue(page.obterRetornoBuscaBody().contains("Checkout: Overview"));
    }

    @Test
    public void botaoFinish(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        page.preencherCampoFirstName("Rafael");
        page.preencherCampoLastName("Silva");
        page.preencherCampoPostalCode("08715530");
        page.clicarBotaoContinue();
        page.clicarBotaoFinish();
        Assert.assertTrue(page.obterRetornoBuscaH2().contains("Thank you for your order!"));
    }

    @Test
    public void botaoBackHome(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        page.preencherCampoFirstName("Rafael");
        page.preencherCampoLastName("Silva");
        page.preencherCampoPostalCode("08715530");
        page.clicarBotaoContinue();
        page.clicarBotaoFinish();
        page.clicarBotaoBackHome();
        Assert.assertTrue(page.obterRetornoBuscaSpan().contains("Products"));
    }
}