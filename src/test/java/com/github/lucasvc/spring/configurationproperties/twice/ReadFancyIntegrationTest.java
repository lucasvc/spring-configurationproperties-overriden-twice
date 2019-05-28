package com.github.lucasvc.spring.configurationproperties.twice;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.lucasvc.spring.configurationproperties.twice.ReadFancyIntegrationTest.OverrideProperties;
import com.github.lucasvc.spring.configurationproperties.twice.helper.RandomRule;


@RunWith(SpringRunner.class)
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
    public static class OverrideProperties
    {
        @Bean
        public BeanPostProcessor propertiesOverride()
        {
            return new BeanPostProcessor()
            {
                @Override
                public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException
                {
                    return bean;
                }

                @Override
                public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException
                {
                    if (bean instanceof FancyProperties)
                    {
                        ((FancyProperties) bean).getMore().setHowMuch(rule.getCurrent());
                    }
                    return bean;
                }
            };
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
