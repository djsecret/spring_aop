package com.neu.calculator_introduction.impl;

import com.neu.calculator_introduction.MaxCalculator;

/**
 * Created by djsecret on 14-11-17.
 */
public class MaxCalculatorImpl implements MaxCalculator
{
    @Override
    public double max(double a, double b)
    {
        double result = a >= b ? a : b;
        System.out.println("max(" + a + "," + b + ") = " + result);
        return result;
    }

}
