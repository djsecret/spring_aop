package com.neu.calculator_introduction;

import com.neu.calculator.Calculator;
import com.neu.calculator_introduction.impl.MaxCalculatorImpl;
import com.neu.calculator_introduction.impl.MinCalculatorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 引入和通知类似，必须在aspect中声明，使用@DeclareParents注解来声明引入
 * value表示引入的目标类，引入的接口由注解字段的类型确定
 * defaultImpl表示实现这个接口的实现类
 * Created by djsecret on 14-11-17.
 */
@Aspect
@Component
public class CalculatorIntroduction
{
    @DeclareParents(
            value = "com.neu.calculator.CalculatorImpl",
            defaultImpl = MaxCalculatorImpl.class)
    public MaxCalculator maxCalculator;


    @DeclareParents(
            value = "com.neu.calculator.CalculatorImpl",
            defaultImpl = MinCalculatorImpl.class)
    public MinCalculator minCalculator;

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("calculator.xml");
        Calculator calculator = (Calculator)context.getBean("calculator");

        MaxCalculator maxCalculator = (MaxCalculator)calculator;
        maxCalculator.max(1,2);

        MinCalculator minCalculator = (MinCalculator)calculator;
        minCalculator.min(1,2);
    }
}
