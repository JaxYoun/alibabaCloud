package com.yang.alibabamysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yang.alibabamysql.dao.mapper")
public class AlibabaMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaMysqlApplication.class, args);
    }

}
