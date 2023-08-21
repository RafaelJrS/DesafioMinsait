package com.saucedemo.suites;

import com.saucedemo.testes.ECommerceTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ECommerceTeste.class
})
public class SuiteTeste {
}
