package com.zhuzs.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description demo 入口类
 * @Author zhu_zishuang
 * @Date 2020-06-13
 */
@MapperScan("com.zhuzs.admin.mapper")
@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
