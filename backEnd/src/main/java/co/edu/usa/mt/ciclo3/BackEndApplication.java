package co.edu.usa.mt.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.edu.usa.mt.ciclo3.boat.model"})
@SpringBootApplication
public class BackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}

}
