package cl.apiux.springboot.app.service.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootAppServiceRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppServiceRepositoryApplication.class, args);
	}

}
