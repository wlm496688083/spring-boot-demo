package com.example;

import com.taobao.pandora.boot.PandoraBootstrap;
import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@EnableAdminServer
//@ImportResource(value = {"classpath:spring/spring-hsf-consumer.xml", "classpath:spring/spring-hsf-provider.xml"})
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        // 启动 Pandora Boot 用于加载 Pandora 容器
        PandoraBootstrap.run(args);
        SpringApplication.run(DemoApplication.class, args);
        // 标记服务启动完成,并设置线程 wait。防止用户业务代码运行完毕退出后，导致容器退出。
        PandoraBootstrap.markStartupAndWait();
    }

    @Override
    public void run(String... strings) throws Exception {
        //优先执行
    }

}
