package com.neppo.surpreendameii.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ProductModel")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int product_id;
	
	@NotEmpty
	@Column(name = "product_name")
	private String product_name;
	
	@NotEmpty
	@Column(name = "product_patrimony")
	private int product_patrimony;
	
	@Column(name = "product_desc")
	private String product_desc;

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_patrimony() {
		return product_patrimony;
	}

	public void setProduct_patrimony(int product_patrimony) {
		this.product_patrimony = product_patrimony;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
		
}
