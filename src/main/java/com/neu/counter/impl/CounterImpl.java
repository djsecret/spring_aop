package com.neu.counter.impl;

import com.neu.counter.Counter;

/**
 *
 * Created by djsecret on 14-11-17.
 */
public class CounterImpl implements Counter
{
    private int count;//存储调用次数

    @Override
    public void increase()
    {
        count++;
    }

    @Override
    public int getCount()
    {
        return count;
    }
}
