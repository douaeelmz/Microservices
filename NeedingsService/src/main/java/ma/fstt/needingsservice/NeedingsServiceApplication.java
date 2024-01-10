package ma.fstt.needingsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("ma.fstt.Repository")
@ComponentScan(basePackages = "ma.fstt.Service")
@ComponentScan(basePackages = "ma.fstt.Controller")
@ComponentScan(basePackages = "ma.fstt.Exception")
@ComponentScan(basePackages = "ma.fstt.DTO")
@EntityScan(basePackages = "ma.fstt.Persistence")

@SpringBootApplication
@EnableDiscoveryClient
public class NeedingsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeedingsServiceApplication.class, args);
	}

}
