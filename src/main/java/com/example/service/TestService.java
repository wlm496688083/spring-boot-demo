package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by wanglimin1 on 2016/12/4.
 */
@Service
public class TestService {

    @Value("${name}")
    private String name;

    public String getNameFor() {
        return name;
    }
}
