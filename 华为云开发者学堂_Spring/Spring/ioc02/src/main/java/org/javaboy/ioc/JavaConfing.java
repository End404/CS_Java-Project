
//2.8 条件注解


package org.javaboy.ioc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//2.8 条件注解
@Configuration
public class JavaConfing {
    @Bean("cmd")
    @Conditional(WindowsCondition.class)
    ShowCmd winCmd() {
        return new WindownsShowCmd();
    }

    @Bean("cmd")
    @Conditional(LinuxCondition.class)
    ShowCmd linuxCmd() {
        return new LinuxShowCmd();
    }


//    2.9 Profile 环境切换
    @Bean
    @Profile("dev")
    DataSource devDs() {
    DataSource ds = new DataSource();
    ds.setUrl("jdbc:mysql:///vhr");
    ds.setUsername("root");
    ds.setPassworld("123");
    return ds;
    }
    @Bean
    @Profile("prod")
    DataSource prodDs() {
        DataSource ds = new DataSource();
        ds.setUrl("jdbc:mysql://192.168.23.56:3306/vhr");
        ds.setUsername("root");
        ds.setPassworld("abc123def");
        return ds;
    }
}

