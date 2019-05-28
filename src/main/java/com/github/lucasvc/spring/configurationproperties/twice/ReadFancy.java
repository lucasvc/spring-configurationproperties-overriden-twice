package com.github.lucasvc.spring.configurationproperties.twice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(FancyProperties.class)
public class ReadFancy
{

    private final FancyProperties properties;

    @Autowired
    public ReadFancy(final FancyProperties properties)
    {
        this.properties = properties;
    }

    public int howMuch()
    {
        return properties.getMore().getHowMuch();
    }

    @Bean
    public Object nowImAConfig()
    {
        return "this is a sample, but other methods like are in the real life :)";
    }

}
