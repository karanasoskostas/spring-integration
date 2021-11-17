package pydra.integration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;


@SpringBootApplication
//@Import(GlobalExceptionHandler.class)
public class IntegrationApplication {



	public static void main(String[] args) {

//		long heapsize = Runtime.getRuntime().totalMemory();
//		System.out.println("heapsize is :: " + heapsize);

		SpringApplication.run(IntegrationApplication.class, args);
	}

}
