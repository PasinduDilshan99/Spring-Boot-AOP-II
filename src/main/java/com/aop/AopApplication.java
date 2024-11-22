package com.aop;

import com.aop.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    private BusinessService businessService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public AopApplication(BusinessService businessService) {
        this.businessService = businessService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("called the run method");
        logger.info("max value is : {} ", businessService.calculateMax());
    }
}
