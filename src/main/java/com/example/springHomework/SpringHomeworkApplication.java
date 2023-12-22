package com.example.springHomework;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springhomework.mapper")
@EnableMPP
public class SpringHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHomeworkApplication.class, args);
    }

}
