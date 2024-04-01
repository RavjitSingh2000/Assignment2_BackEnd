package project.assignment2.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Assignemnt2BackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(Assignemnt2BackEndApplication.class, args);
    }

}
