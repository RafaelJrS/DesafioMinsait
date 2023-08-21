package com.saucedemo.testes;

import com.saucedemo.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class FluxoTesteAlternativo extends LoginPage {

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
