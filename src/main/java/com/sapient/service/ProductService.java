package com.sapient.service;

import java.util.List;

import com.sapient.entity.Product;

public interface ProductService {

	/**
	 * Create the product and list the fresh set of products.
	 * @param product
	 * @return
	 */
	List<Product> createProduct(Product product);
	
	/**
	 * List all product and price based on the name
	 * @param productName
	 * @return
	 */
	List<Product> findProductPricebyProductName(String productName);
	
	/**
	 * Finds the product based of the type
	 * @param productType
	 * @return
	 */
	List<Product> findByProductType(String productType);
	
	/**
	 * Delete the product and returns all available products 
	 * @param productId
	 * @return
	 */
	List<Product> delete(Long productId);
	
	/**
	 * get product size
	 * @return
	 */
	
	int countProducts();

	/**
	 * Find product by name
	 * @param productName
	 * @return
	 */
	List<Product> findByProductName(String productName);
	
	/**
	 * Retrieve ALL products (not to expose this endpoint due to scalability)
	 * @param productName
	 * @return
	 */
	List<Product> findAll();
	
}
