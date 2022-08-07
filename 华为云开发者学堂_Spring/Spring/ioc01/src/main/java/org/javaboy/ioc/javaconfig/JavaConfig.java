package org.javaboy.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Configuration      //注解表示这是一个Java配置类，配置类的作用类似于 applicationContext.xml
@ComponentScan(basePackages = "org.javaboy.ioc", useDefaultFilters = false, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class), @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class)})    //包扫描；2.6自动配置; 2.7 对象注入
public class JavaConfig {
    @Bean("sh")
    SayHello sayHello() {
        return new SayHello();
    }
}
