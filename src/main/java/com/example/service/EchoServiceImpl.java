package com.example.service;

import com.alibaba.boot.hsf.annotation.HSFProvider;

/**
 * copy from ali
 */
@HSFProvider(serviceInterface = EchoService.class, serviceVersion = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String string) {
        return string + " ----====-------";
    }
}
