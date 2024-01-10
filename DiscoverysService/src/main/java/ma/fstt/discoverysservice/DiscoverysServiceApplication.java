package ma.fstt.discoverysservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverysServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverysServiceApplication.class, args);
    }

}
