# Spring testing `@ConfigurationProperties` overriden twice

## UPDATE: Solved
After opening [Spring Boot ticket #16982](https://github.com/spring-projects/spring-boot/issues/16982), a fast comment with the correct solution.
Commit ... follows the guidelines of @wilkinsona fixing the issue.

## Use case
You have a `.properties` file with a set of values, which are loaded into a fancy and typed `@Configuration` bean.
In a test you have most of those values fixed, **but** one of them is calculated in runtime (i.e. a dynamic listening port in localmachine).
So you think: why not let Spring-Boot load the whole bean, but override that and change the only dynamic.
It does not work :(

This repo shows this.

## How-to reproduce
Execute

```
gradlew clean test
```

And will fail.