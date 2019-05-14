package com.github.lucasvc.spring.configurationproperties.twice.helper;

import java.util.Random;

import org.junit.rules.ExternalResource;


public class RandomRule extends ExternalResource
{

    private final Random random = new Random();

    private int current;

    @Override
    public void before() throws Throwable
    {
        current = random.nextInt(9999);
    }

    public int getCurrent()
    {
        return current;
    }

}
