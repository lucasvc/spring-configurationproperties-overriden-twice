package com.github.lucasvc.spring.configurationproperties.twice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:my-module-fancy.properties")
@ConfigurationProperties(prefix = "fancy")
public class FancyProperties
{

    public static class More
    {
        private String good;
        private int howMuch;
        private String better;

        public String getGood()
        {
            return good;
        }

        public void setGood(final String good)
        {
            this.good = good;
        }

        public int getHowMuch()
        {
            return howMuch;
        }

        public void setHowMuch(final int howMuch)
        {
            this.howMuch = howMuch;
        }

        public String getBetter()
        {
            return better;
        }

        public void setBetter(final String better)
        {
            this.better = better;
        }

    }

    private More more;
    private String first;

    public More getMore()
    {
        return more;
    }

    public void setMore(final More more)
    {
        this.more = more;
    }

    public String getFirst()
    {
        return first;
    }

    public void setFirst(final String first)
    {
        this.first = first;
    }

}
