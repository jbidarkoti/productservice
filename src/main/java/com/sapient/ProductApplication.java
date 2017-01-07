package com.sapient;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * 
 * @author Jagadish Bidarkoti
 *
 */

@SpringBootApplication
@ComponentScan({"com"})
@EntityScan("com.sapient.entity")
@EnableJpaRepositories("com.sapient.repository")
@EnableTransactionManagement
public class ProductApplication {

	Logger logger= Logger.getLogger(ProductApplication.class.getName());
	
	public static void main(String[] args) {
		
		SpringApplication.run(ProductApplication.class, args);
		
	}
}
