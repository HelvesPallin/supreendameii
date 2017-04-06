package com.neppo.surpreendameii.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.neppo.surpreendameii.model.Product;
import com.neppo.surpreendameii.repository.ProductRepository;
import com.neppo.surpreendameii.service.ProductService;

public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl (ProductRepository productRepository){
		this.productRepository = productRepository;
	}
	
	@Override
	public void saveProduct(Product product){
		productRepository.saveProduct(product);
	}
	
	@Override
	public void deleteProduct(int product_id){
		productRepository.deleteProduct(product_id);
	}
	
	@Override
	public void alterProduct(Product product){
		productRepository.alterProduct(product);
	}
	
	@Override
	public Product findOne(int product_id){
		return productRepository.getProduct(product_id);
	}
	
	@Override
	public List<Product> getAll(){
		return productRepository.getAll();
	}
}
