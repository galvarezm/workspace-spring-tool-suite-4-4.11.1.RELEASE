package cl.apiux.springboot.app.zuul.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class SpringbootAppZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppZuulServerApplication.class, args);
	}

}
