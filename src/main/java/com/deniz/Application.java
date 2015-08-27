package com.deniz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("server.port", getHerokuWebPort());

        SpringApplication.run(Application.class, args);
    }

    static String getHerokuWebPort() {
        String webPort = System.getenv("PORT");
        if (!webPort.equals("")) {
            webPort = "8080";
        }
        return webPort;
    }
}