package com.neu.calculator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 切面类
 * 选择通知类型的原则是使用满足你的要求的最不强大的类型
 *
 * 这里使用了log4j，需要在resources中添加log4j.properties配置文件
 * Created by ubuntu on 14-11-15.
 */
@Aspect
@Order(1)
@Component
public class CalculatorLoggingAspect
{
    private Log log = LogFactory.getLog(this.getClass());

    /**
     * 重用切入点
     * 切入点主体通常为空，因为切入点定义与应用程序逻辑混合是不合理的
     * 切入点方法的访问修饰符可以控制切入点的可见性，如果为private的，则只能本类使用，
     *      如果是public，则其他类的aspect也可以使用，不过，在引用是，必须加上类名，如果不在相同的包中，还必须包含包名
     * 其他通知可以用方法名引用这个切入点
     */
    @Pointcut("execution(* Calculator.*(..))")
    private void loggingOperation(){}

    /**
     * 带参数的切入点
     * @param target
     * @param a
     * @param b
     */
    @Pointcut("execution(* *.*(..)) && target(target) && args(a,b))")
    public void parameterPointCut(Object target, double a, double b){}

    @Before("loggingOperation()")
    public void logBefore(JoinPoint joinPoint)
    {
        log.info("The method " + joinPoint.getSignature().getName() + "() begins with "
                + Arrays.toString(joinPoint.getArgs()));
    }

    @After("loggingOperation()")
    public void logAfter(JoinPoint joinPoint)
    {
        log.info("The method " + joinPoint.getSignature().getName() + "() ends");
    }

    @AfterReturning(
            pointcut = "loggingOperation()",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result)
    {
        log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
    }

    @AfterThrowing(
            pointcut = "loggingOperation()",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e)
    {
        log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
    }

    //@Around("execution(* Calculator.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        log.info("The method " + joinPoint.getSignature().getName() + "() begins with "
                + Arrays.toString(joinPoint.getArgs()));

        try
        {
            Object result = joinPoint.proceed();
            log.info("The method " + joinPoint.getSignature().getName() + "() ends with " + result);
            return result;
        }catch(IllegalArgumentException e)
        {
            log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }

    /**
     * 声明切入点参数
     * @param target 当前连接点的目标对象（被代理对象）
     * @param a
     * @param b
     */
    @Before("parameterPointCut(target,a,b)")
    public void logParameter(Object target, double a, double b)
    {
        log.info("Target class: " + target.getClass().getName());
        log.info("Arguments: " + a + ", " + b);
    }
}
