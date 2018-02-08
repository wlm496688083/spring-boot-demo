package com.example;

import de.codecentric.boot.admin.config.EnableAdminServer;
import javafx.scene.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableRedisHttpSession
@ServletComponentScan
@EnableTransactionManagement
@EnableAdminServer
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        //SpringApplication.run(DemoApplication.class, args);

		/*SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
		app.run(args);*/

        new SpringApplicationBuilder()
                .sources(Parent.class)
                .child(DemoApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //先执行这个
    }

}
