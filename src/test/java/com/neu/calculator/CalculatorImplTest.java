package com.neu.calculator;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import javax.annotation.Resource;

import static org.testng.Assert.assertEquals;

@ContextConfiguration(locations = {"/calculator.xml"})
public class CalculatorImplTest extends AbstractTestNGSpringContextTests
{
    @Resource
    private Calculator calculator;

    @Test
    public void testAdd() throws Exception
    {
        assertEquals(3.0,calculator.add(1,2));
    }

    @Test
    public void testSub() throws Exception
    {
        assertEquals(1.0,calculator.sub(2,1));
    }

    @Test
    public void testMul() throws Exception
    {

    }

    @Test
    public void testDiv() throws Exception
    {

    }
}