package com.sapient.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.entity.Product;
import com.sapient.exception.ProductNotFoundException;
import com.sapient.repository.ProductRepository;
import com.sapient.service.ProductService;

/**
 * 
 * @author Jagadish Bidarkoti
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

	Logger logger=Logger.getLogger(ProductServiceImpl.class.getName());
	
	
	protected ProductRepository productRepository;
	
	protected ProductServiceImpl(){	}
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository){
		this.productRepository=productRepository;
	}
	
	@Override
	public List<Product> createProduct(Product product) {
		logger.info("products-service createProduct() invoked: " + product);
		this.productRepository.save(new Product(product.getProductName(), 
				product.getProductType(), product.getProductPrice()));
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<Product> findProductPricebyProductName(String productName) {
	
		logger.info("products-service findProductPricebyProductName() invoked: " + productName);
		//Product product = productRepository.findByType(productType);
		List<Product> product = this.productRepository.findProductPriceByProductName(productName);
		logger.info("products-service findProductPricebyProductName() found: " + product);

		if (product == null)
			throw new ProductNotFoundException(productName);
		else {
			return product;
		}
		
	}

	@Override
	public List<Product> findByProductType(String productType) {
		logger.info("products-service findByProductType() invoked: " + productType);
		List<Product> product = this.productRepository.findByProductType(productType);
		logger.info("products-service findByProductType() found: " + product);

		if (product == null)
			throw new ProductNotFoundException(productType);
		else {
			return product;
		}
	}

	@Override
	public List<Product> delete(Long productId) {
		logger.info("products-service deleteProduct() invoked: " + productId);
		this.productRepository.delete(productId);
		return (List<Product>) productRepository.findAll();	 
		
	}

	@Override
	public int countProducts() {
		int productSize=this.productRepository.countProducts();
	return productSize;
	}

	@Override
	public List<Product> findByProductName(String productName) {
		
		return productRepository.findByProductName(productName);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

}
