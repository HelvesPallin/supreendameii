package com.neppo.surpreendameii.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.neppo.surpreendameii.model.Product;

@Repository
public class ProductRepository{
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	@Transactional
	public void saveProduct(Product product){
		entityManager.persist(product);
	}
	
	@Transactional
	public void alterProduct(Product product){
		entityManager.merge(product);
	}
	
	public Product getProduct(int product_id){
		return entityManager.find(Product.class, product_id);
	}
	
	@Transactional
	public void deleteProduct(int product_id){
		entityManager.remove(getProduct(product_id));
	}
	
	public List<Product> getAll(){
		return entityManager.createQuery("SELECT product FROM Product product ORDER BY product.product_id",
				Product.class).getResultList();
	}
	
}
