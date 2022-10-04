package com.asd.backened;

//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@EnableCaching //Turning on Spring Cache annotations is the caching function
//@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        log.info("The project started successfully...");
    }
}
