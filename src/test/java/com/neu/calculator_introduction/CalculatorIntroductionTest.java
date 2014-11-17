package com.neu.calculator_introduction;

import com.neu.calculator.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class CalculatorIntroductionTest
{
    ApplicationContext context = new ClassPathXmlApplicationContext("calculator.xml");
    Calculator calculator = (Calculator)context.getBean("calculator");

    @Test
    public void testMax()
    {
        MaxCalculator maxCalculator = (MaxCalculator)calculator;
        assertEquals(2,maxCalculator.max(1,2),0);
    }
}