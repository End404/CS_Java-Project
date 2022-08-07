package org.javaboy.ioc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//2.12 混合配置
@Configuration
@ImportResource("classpath:applicationContext.xml")
public class JavaConfig2 {

}
