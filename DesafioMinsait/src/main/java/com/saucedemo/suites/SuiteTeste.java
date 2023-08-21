package com.saucedemo.suites;

import com.saucedemo.testes.FluxoTesteAlternativo;
import com.saucedemo.testes.FluxoTesteExcecao;
import com.saucedemo.testes.FluxoTestePrincipal;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        FluxoTestePrincipal.class,
        FluxoTesteAlternativo.class,
        FluxoTesteExcecao.class
})
public class SuiteTeste {
}
