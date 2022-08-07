

/*
    1-12 依赖注入与控制反转的实现
 */


package com.imooc;

import com.imooc.pojo.Stu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  // 为了说明当前类为配置类，加上这个注解以后，会被容器扫描到。
public class SpringBootConfig {

    @Bean
    public Stu stu() {
        return new Stu("jack",18);
    }
}
