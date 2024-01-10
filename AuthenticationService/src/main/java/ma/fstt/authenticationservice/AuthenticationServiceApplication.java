package ma.fstt.authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("ma.fstt.authenticationservice.Repository")
@ComponentScan(basePackages = "ma.fstt.authenticationservice.Configuration")
@ComponentScan(basePackages = "ma.fstt.authenticationservice.Controller")
@ComponentScan(basePackages = "ma.fstt.authenticationservice.Service")
@ComponentScan(basePackages = "ma.fstt.authenticationservice.Exception")
@ComponentScan(basePackages = "ma.fstt.authenticationservice.DTO")
@ComponentScan(basePackages = "ma.fstt.authenticationservice.Mapper")
@EntityScan(basePackages = "ma.fstt.authenticationservice.Persistence")

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationServiceApplication.class, args);
    }

}
