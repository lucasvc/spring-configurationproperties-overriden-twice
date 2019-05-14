# Spring testing `@ConfigurationProperties` overriden twice

## Use case
You have a `.properties` file with a set of values, which are loaded into a fancy and typed `@Configuration` bean.
In a test you have most of those values fixed, **but** one of them is calculated in runtime (i.e. a dynamic listening port in localmachine).
So you think: why not let Spring-Boot load the whole bean, but override that and change the only dynamic.
It does not work :(

This repo shows this.
