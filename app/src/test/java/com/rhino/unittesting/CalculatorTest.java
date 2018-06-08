package com.rhino.unittesting;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author LuoLin
 * @since Create on 2018/6/7.
 */
public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
        calculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }

    @Test
    public void sum() {
        assertEquals(1, calculator.sum(1, 1), 0);

    }
}