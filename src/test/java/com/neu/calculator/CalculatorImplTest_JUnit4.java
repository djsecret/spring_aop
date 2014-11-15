package com.neu.calculator;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;
public class CalculatorImplTest_JUnit4
{
    ApplicationContext context = new ClassPathXmlApplicationContext("calculator.xml");
    Calculator calculator = (Calculator)context.getBean("calculator");

    @Test
    public void testAdd() throws Exception
    {
        calculator.add(1,2);
    }

    @Test
    public void testSub() throws Exception
    {
        assertEquals(1.0,calculator.sub(2,1),0);
    }

    @Test
    public void testMul() throws Exception
    {
        assertEquals(2,calculator.mul(1,2),0);
    }

    @Test
    public void testDiv() throws Exception
    {
        calculator.div(3,0);
    }
}