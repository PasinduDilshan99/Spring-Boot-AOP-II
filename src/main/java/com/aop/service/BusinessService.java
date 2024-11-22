package com.aop.service;

import com.aop.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService {

    private DataRepository dataRepository;

    @Autowired
    public BusinessService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public int calculateMax() {
        int[] dataList = dataRepository.retrieveData();
        return Arrays.stream(dataList).max().orElse(0);
    }
}
