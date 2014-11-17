package com.neu.counter;

import com.neu.calculator.Calculator;
import com.neu.counter.impl.CounterImpl;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 为每个计算器引入CounterImpl
 * Created by djsecret on 14-11-17.
 */
@Aspect
@Component
public class CounterIntroduction
{
    @DeclareParents(
            value = "com.neu.calculator.CalculatorImpl",
            defaultImpl = CounterImpl.class
    )
    public Counter counter;

    /**
     * 最终通知，在每次调用一个计算器方法后增加计数器值
     * 必须取得this对象，而不是target对象，因为只有代理对象实现了Counter接口
     * @param counter this对象
     */
    @After(value = "execution(* com.neu.calculator.*.*(..)) && this(counter)", argNames = "counter")
    public void increaseCount(Counter counter)
    {
        counter.increase();
    }

    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("calculator.xml");
        Calculator calculator = (Calculator)context.getBean("calculator");
        Counter counter = (Counter)calculator;

        calculator.add(1,2);
        System.out.println(counter.getCount());

        calculator.sub(2,1);
        System.out.println(counter.getCount());

    }
}
