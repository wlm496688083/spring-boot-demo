package com.example.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wanglimin1 on 2016/12/2.
 */
@RestController
public class ShutDown implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @GetMapping("/web")
    public int shutDown() {

        ExitCodeGenerator exitCodeGenerator = new ExitCodeGenerator() {

            @Override
            public int getExitCode() {
                return 500;
            }

        };

        SpringApplication.exit(applicationContext, exitCodeGenerator);

        return exitCodeGenerator.getExitCode();
    }

    @GetMapping("/name")
    public String getName() throws Exception {
        /*return testService.getNameFor();*/
        throw new Exception("rrrrrrrrrrrrrr");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
