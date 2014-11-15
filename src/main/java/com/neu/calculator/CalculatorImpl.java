package com.neu.calculator;

import org.springframework.stereotype.Component;

/**
 * Calculator接口实现类，需要使用aop添加功能
 * Created by ubuntu on 14-11-15.
 */
@Component("calculator")
public class CalculatorImpl implements Calculator
{
    @Override
    public double add(double a, double b)
    {
        double result = a + b;
        System.out.println(a + " + " + b + " = " + result);
        return result;
    }

    @Override
    public double sub(double a, double b)
    {
        double result = a - b;
        System.out.println(a + " - " + b + " = " + result);
        return result;
    }

    @Override
    public double mul(double a, double b)
    {
        double result = a * b;
        System.out.println(a + " * " + b + " = " + result);
        return result;
    }

    @Override
    public double div(double a, double b)
    {
        if(b == 0)
        {
            throw new IllegalArgumentException("Division by zero");
        }
        double result = a / b;
        System.out.println(a + " / " + b + " = " + result);
        return result;
    }
}
