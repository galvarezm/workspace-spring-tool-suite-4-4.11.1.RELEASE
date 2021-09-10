package cl.apiux.springboot.app.user.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"cl.apiux.springboot.app.user.common.models.entity"})
public class SpringbootAppUsersServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAppUsersServerApplication.class, args);
	}

}
