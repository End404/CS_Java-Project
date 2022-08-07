
//    1.6

package com.imooc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/*
 *  1.表明当前项目为springboot工程，是启动类，应用程序的入口类。
 *  2.启动类需要放在根包路径之下，默认扫描相关的组件，放入容器中。
 * */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")  // 3-4 使用mybatis逆向工具生成mappe与pojo
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

