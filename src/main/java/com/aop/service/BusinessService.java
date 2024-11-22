package com.aop.service;

import com.aop.annotations.TrackTime;
import com.aop.repository.DataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class BusinessService {

    private DataRepository dataRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public BusinessService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @TrackTime
    public int calculateMax() {
        logger.info("called the calculateMax method");
        int[] dataList = dataRepository.retrieveData();
        int number = Arrays.stream(dataList).max().orElse(0);
        if (number==0){
            throw new NullPointerException("There is no number");
        }
        return number;
    }
}
