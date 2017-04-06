package com.neppo.surpreendameii.service;

import java.util.List;

import com.neppo.surpreendameii.model.Product;

public interface ProductService {
	
	public void saveProduct(Product product);
	
	public void deleteProduct(int product_id);
	
	public void alterProduct(Product product);
	
	public Product findOne(int product_id);
	
	public List<Product> getAll();
}
