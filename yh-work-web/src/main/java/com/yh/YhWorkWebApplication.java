package com.yh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 启动类
 * @author 杨恒
 */
@EnableTransactionManagement
@EnableAsync
@ComponentScan(basePackages = {"com.yh"})
@MapperScan("com.yh.dal.mapper")
@SpringBootApplication
@ServletComponentScan
public class YhWorkWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(YhWorkWebApplication.class, args);
        System.out.println("启动成功!");
    }

}
