package com.neu.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 指定aspect优先级，可以通过实现Ordered接口或者使用@Order注解，数字越小，优先级越高
 * Created by ubuntu on 14-11-15.
 */
@Aspect
@Order(0)
@Component
public class CalculatorValidationAspect
{
    @Before("execution(* Calculator.*(..))")
    public void validationBefore(JoinPoint joinPoint)
    {
        System.out.println("validation aspect");
        for(Object arg : joinPoint.getArgs())
        {
            validate((Double)arg);
        }
    }

    private void validate(Double arg)
    {
        if(arg < 0)
        {
            throw new IllegalArgumentException("Positive numbers only");
        }
    }
}
