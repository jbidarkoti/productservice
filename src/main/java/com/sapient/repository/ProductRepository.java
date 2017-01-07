package com.sapient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sapient.entity.Product;

/**
 * 
 * @author Jagadish Bidarkoti
 *
 */


public interface ProductRepository extends CrudRepository<Product, Long>{

	Product save(Product product);

	List<Product> findByProductType(String productType);
	
	List<Product> findProductPriceByProductName(String productName);

	@Query("SELECT count(*) from Product")
	int countProducts();
	
	void delete(long productId);

	List<Product> findByProductName(String productName);
	
	List<Product> findAll();
}
