package com.sapient.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.entity.Product;
import com.sapient.service.ProductService;

/**
 * Rest Controller for Product Catalog
 * @author Jagadish Bidarkoti
 *
 */

@RestController
public class ProductController {

	protected Logger logger = Logger.getLogger(ProductController.class.getName());
	
	@Autowired
	protected ProductService productService;
	
	protected ProductController(){}
	
	/**
	 * Just to make sure to come to home page and beginning of context
	 * @return
	 */
	@RequestMapping("/")
	public String home() {
		return "Sapient Technical Exercise \nProduct Catalogue ";
	}
	
	@RequestMapping("/products/{productType}")
	public List<Product> findByProductType(@PathVariable("productType") String productType) {
		return productService.findByProductType(productType);
	}
	
	@RequestMapping(value="/products/create", method = RequestMethod.POST)
	public List<Product> createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@RequestMapping("/products/price/{productName}")
	public List<Product> findProductPriceByProductName(@PathVariable("productName") String productName) {
		return productService.findProductPricebyProductName(productName);
	}
	
	@RequestMapping(value="/products/delete/{productId}", method = RequestMethod.DELETE)
	public List<Product> deleteProduct(@PathVariable("productId") Long productId) {
		return productService.delete(productId);
		
	}
	
	@RequestMapping("/products/name/{productName}")
	public List<Product> findByProductName(@PathVariable("productName") String productName) {
		return productService.findByProductName(productName);
	}
	
	@RequestMapping("/products/all")
	public List<Product> findAllProducts() {
		return productService.findAll();
	}
}
