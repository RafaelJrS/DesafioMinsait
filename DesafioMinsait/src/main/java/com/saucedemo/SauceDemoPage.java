package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SauceDemoPage {

    private DSL dsl;

    public SauceDemoPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setUserName(String nome){
        dsl.escrever("user-name",nome);
    }
    public void setPassword(String password){
        dsl.escrever("password",password);
    }
    public void clicarBotaoLogin(){
        dsl.clicarId("login-button");
    }
    public void clicarProdutoBackpack(){
        dsl.clicarXpath("//*[@id=\"item_4_title_link\"]/div");
    }
    public void clicarAdicionarProdutoBackpack(){
        dsl.clicarId("add-to-cart-sauce-labs-backpack");
    }
    public void clicarCarrinhoCompra(){
        dsl.clicarId("shopping_cart_container");
    }
    public void clicarRemoverProdutoBackpack(){
        dsl.clicarId("remove-sauce-labs-backpack");
    }
    public void clicarBotaoContinueShopping(){
        dsl.clicarId("continue-shopping");
    }
    public void clicarBotaoCheckOut(){
        dsl.clicarId("checkout");
    }
    public void clicarBotaoContinue(){
        dsl.clicarId("continue");
    }
    public void preencherCampoFirstName(String nome){
        dsl.escrever("first-name",nome);
    }
    public void preencherCampoLastName(String sobrenome){
        dsl.escrever("last-name",sobrenome);
    }
    public void preencherCampoPostalCode(String code){
        dsl.escrever("postal-code",code);
    }
    public void clicarBotaoFinish(){
        dsl.clicarId("finish");
    }
    public void clicarBotaoBackHome(){
        dsl.clicarId("back-to-products");
    }
    public String obterRetornoBuscaBody(){
        return dsl.obterTexto(By.tagName("body"));
    }
    public String obterRetornoBuscaSpan(){
        return dsl.obterTexto(By.tagName("span"));
    }
    public String obterRetornoBuscaH3(){
        return dsl.obterTexto(By.tagName("h3"));
    }
    public String obterRetornoBuscaH2(){
        return dsl.obterTexto(By.tagName("h2"));
    }

}
