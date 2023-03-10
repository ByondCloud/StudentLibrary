package com.cloud.studentlibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cloud.studentlibrary.mapper")
public class StudentLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentLibraryApplication.class, args);
    }

}
