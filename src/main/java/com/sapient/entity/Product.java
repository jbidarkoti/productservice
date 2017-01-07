package com.sapient.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Jagadish Bidarkoti
 *
 */
@Entity
@Table(name="PRODUCT")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCTID")
	protected long productId;
	
	@NotNull
	@Column(name="PRODUCTNAME")
	protected String productName;
	
	@NotNull
	@Column(name="PRODUCTTYPE")
	protected String productType;
	
	@NotNull
	@Column(name="PRODUCTPRICE")
	protected BigDecimal productPrice;
	
	
	protected Product(){}
	
	public Product(String productName, String productType,BigDecimal productPrice){
		this.productName=productName;
		this.productType=productType;
		this.productPrice=productPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	@Override
	public String toString() {
		return productName + " [" + productType + "]: $" + productPrice;
	}

}
