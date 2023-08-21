package com.saudedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DSL {
    private WebDriver driver;
    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void clicarXpath(String xpath_campo){
        driver.findElement(By.xpath(xpath_campo)).click();
    }

    public void clicarId(String id_campo){
        driver.findElement(By.id(id_campo)).click();
    }

    public void escrever(String id_campo, String texto){
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }
    public String obterTexto(By by){
        return driver.findElement(by).getText();
    }

}
