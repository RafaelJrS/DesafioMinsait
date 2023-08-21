package com.saucedemo.testes;

import com.saucedemo.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class FluxoTestePrincipal extends LoginPage {

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
    public void botaoCheckOut(){
        page.clicarAdicionarProdutoBackpack();
        page.clicarCarrinhoCompra();
        page.clicarBotaoCheckOut();
        Assert.assertTrue(page.obterRetornoBuscaBody().contains("Checkout: Your Information"));
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
}
