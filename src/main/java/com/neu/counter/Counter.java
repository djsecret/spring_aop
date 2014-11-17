package com.neu.counter;

/**
 * 希望跟踪每个计算器对象的调用次数，因为在原来的计算器类中没有保存计数器字段，必须用AOP引入一个
 * Created by djsecret on 14-11-17.
 */
public interface Counter
{
    void increase();
    int getCount();
}
