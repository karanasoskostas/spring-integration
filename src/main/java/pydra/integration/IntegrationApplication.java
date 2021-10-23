package pydra.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pydra.integration.exception.GlobalExceptionHandler;

@SpringBootApplication
//@Import(GlobalExceptionHandler.class)
public class IntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationApplication.class, args);
	}

}
