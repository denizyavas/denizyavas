package com.deniz.app

import org.springframework.boot.SpringApplication

/**
 * author: TRYavasU
 * date: 20/12/2014
 */
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@ComponentScan
class Application {

    static void main(args) {
        System.setProperty("server.port", getHerokuWebPort())

        SpringApplication.run(Application, args)
    }

    static String getHerokuWebPort() {
        String webPort = System.getenv("PORT")
        if (!webPort) {
            webPort = "8080"
        }
        webPort
    }
}