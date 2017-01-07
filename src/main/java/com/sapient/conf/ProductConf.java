package com.sapient.conf;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 * 
 * @author Jagadish Bidarkoti
 *
 */
@Configuration
@ComponentScan
@EntityScan("com.sapient.entity")
@EnableJpaRepositories("com.sapient.entity")
@PropertySource("classpath:application.properties")
public class ProductConf {

	Logger logger;

	public ProductConf() {
		logger = Logger.getLogger(getClass().getName());

	}

	@Bean
	public DataSource productDataSource() {
		logger.info("productDataSource() invoked");

		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:dbscripts/schema.sql")
				.addScript("classpath:dbscripts/seeddata.sql").build();

		logger.info("dataSource = " + dataSource);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Map<String, Object>> products = jdbcTemplate.queryForList("SELECT PRODUCTNAME FROM PRODUCT");

		logger.info("System has " + products.size() + " product");

		// Populate with random balances
		Random rand = new Random();

		for (Map<String, Object> item : products) {
			String productName = (String) item.get("PRODUCTNAME");
			BigDecimal productPrice = new BigDecimal(rand.nextInt(10000000) / 100.0).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			jdbcTemplate.update("UPDATE PRODUCT SET PRODUCTPRICE = ? WHERE PRODUCTNAME = ?", productPrice, productName);
			logger.info("Product Name : " + productName + " Product Price : " + productPrice );
			
		}

		return dataSource;

	}

}
