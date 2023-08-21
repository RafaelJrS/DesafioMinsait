package com.saucedemo.pages;

import com.saucedemo.core.DSL;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

    public WebDriver driver;
    public DSL dsl;
    public SauceDemoPage page;

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

}
