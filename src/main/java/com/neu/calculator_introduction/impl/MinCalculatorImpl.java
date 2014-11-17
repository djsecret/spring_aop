package com.neu.calculator_introduction.impl;

import com.neu.calculator_introduction.MinCalculator;

/**
 *
 * Created by djsecret on 14-11-17.
 */
public class MinCalculatorImpl implements MinCalculator
{
    @Override
    public double min(double a, double b)
    {
        double result = a <= b ? a : b;
        System.out.println("min(" + a + "," + b + ") = " + result);
        return result;
    }
}
