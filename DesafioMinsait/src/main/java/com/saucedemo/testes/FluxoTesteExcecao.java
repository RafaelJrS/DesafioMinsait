package com.saucedemo.testes;

import com.saucedemo.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class FluxoTesteExcecao extends LoginPage {

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
}
