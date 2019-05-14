package com.github.lucasvc.spring.configurationproperties.twice;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.lucasvc.spring.configurationproperties.twice.ReadFancyIntegrationTest.OverrideProperties;
import com.github.lucasvc.spring.configurationproperties.twice.helper.RandomRule;


@RunWith(SpringRunner.class)
@EnableConfigurationProperties
@ContextConfiguration(
    classes = {
            ReadFancy.class,
            OverrideProperties.class
    })
public class ReadFancyIntegrationTest
{

    @ClassRule
    public static RandomRule rule = new RandomRule();

    @Configuration
    @Import(FancyProperties.class)
    public static class OverrideProperties
    {
        @Bean
        public FancyProperties properties(final FancyProperties original)
        {
            original.getMore().setHowMuch(rule.getCurrent());
            return original;
        }
    }

    @Autowired
    private ReadFancy read;

    @Test
    public void overriden()
    {
        Assert.assertEquals(rule.getCurrent(), read.howMuch());
    }

}
