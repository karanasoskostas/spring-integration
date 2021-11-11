package pydra.integration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;


@SpringBootApplication
//@Import(GlobalExceptionHandler.class)
public class IntegrationApplication {



	public static void main(String[] args) {

//		SpringApplication application = new SpringApplication(IntegrationApplication.class);
//
//		Properties properties = new Properties();
//		properties.put("security.basic.enabled", "true");
//		properties.put("management.security.enabled","true");
//		properties.put("spring.autoconfigure.exclude[0]","");
//		application.setDefaultProperties(properties);


		SpringApplication.run(IntegrationApplication.class, args);
	}

}
