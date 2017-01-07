package com.sapient.exception;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Jagadish Bidarkoti
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;

	protected Logger logger= Logger.getLogger(ProductNotFoundException.class.getName());
	
	/**
	 * Exception id there are no products found
	 * @param productName
	 */
	public ProductNotFoundException(String productName){
		super("No Such Product : " + productName + " found");
		logger.warning("No Such Product : " + productName + " found");
	}
	
}
