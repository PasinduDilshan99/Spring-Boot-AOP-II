package com.aop.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public int[] retrieveData() {
        logger.info("called the retrieveData method");
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

}
