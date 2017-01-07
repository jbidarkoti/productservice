package com.sapient.controller;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sapient.ProductApplication;
import com.sapient.entity.Product;
import com.sapient.repository.ProductRepository;
import com.sapient.service.ProductService;
import com.sapient.service.impl.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProductApplication.class})
@WebAppConfiguration
public class ProductControllerTest {


	protected static final String productName="Dell Inspiron";
	protected static final double productPrice= 229.8;
	protected static final String productType="Laptops";


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;
    
	
	@Test
	public void testFindByProductType() throws Exception{
		productService=new ProductServiceImpl(productRepository);
		List<Product> product = productService.findByProductType(productType);
		Assert.assertNotNull(product);
		Product oneProduct= product.get(0);
		Assert.assertEquals(productName, oneProduct.getProductName());

		
	}
	
	
	
	@Test
	public void testCreateProduct() throws Exception{
		productService=new ProductServiceImpl(productRepository);
		Product product=new Product(productName,productType,new BigDecimal(productPrice));
		List<Product> products=productService.createProduct(product);
		Assert.assertNotNull(product);
		Product oneProduct= products.get(0);
		Assert.assertEquals(productName, oneProduct.getProductName());
	}


	@Test
	public void testFindProductPriceByProductName() {
		productService=new ProductServiceImpl(productRepository);
		List<Product> product = productService.findProductPricebyProductName(productName);
		Assert.assertNotNull(product);
		Product oneProduct= product.get(0);
		Assert.assertEquals(productName, oneProduct.getProductName());
	}

	@Ignore
	@Test
	public void testDeleteProduct() {
		//not implemented
	}
	
	@Test
	public void testFindByProductName() {
		productService=new ProductServiceImpl(productRepository);
		List<Product> product = productService.findByProductName(productName);
		Assert.assertNotNull(product);
		Product oneProduct= product.get(0);
		Assert.assertEquals(productName, oneProduct.getProductName());
	}

	
	@Test
	public void testFindAllProducts() {
		productService=new ProductServiceImpl(productRepository);
		List<Product> product = productService.findAll();
		Assert.assertNotNull(product);
		Product oneProduct= product.get(0);
		Assert.assertEquals(productName, oneProduct.getProductName());

	}

}
