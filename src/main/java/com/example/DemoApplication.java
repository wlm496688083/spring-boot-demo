package com.example;

import javafx.scene.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
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

    }

}
