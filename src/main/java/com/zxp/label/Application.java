package com.zxp.label;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.zxp.label.mapper")
@EnableScheduling
@SpringBootApplication
public class Application {
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }
}
