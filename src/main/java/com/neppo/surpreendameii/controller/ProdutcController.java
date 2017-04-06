package com.neppo.surpreendameii.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neppo.surpreendameii.model.Product;
import com.neppo.surpreendameii.model.Result;
import com.neppo.surpreendameii.service.ProductService;

@Controller
@RequestMapping("/")
public class ProdutcController {
	
	@Autowired
	Result result;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody Result saveProduct(@RequestBody Product product){
		try{
			productService.saveProduct(product);
			result.setCode(1);
			result.setMessage("Product Saved!");
		}
		catch(Exception e){
			result.setCode(0);
			result.setMessage("Error: "+e);
		}
		return result;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Result editProduct(@RequestBody Product product){
		try{
			productService.editProduct(product);
			result.setCode(1);
			result.setMessage("Product Saved!");
		}
		catch(Exception e){
			result.setCode(0);
			result.setMessage("Error: "+e);
		}
		return result;
	}
	
	@RequestMapping(value = "/delete/{product_id}", method = RequestMethod.GET)
	public @ResponseBody void deleteProduct(@PathVariable int product_id){
		productService.deleteProduct(product_id);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody List<Product> getAll(){
		return productService.getAll();
	}
	
}
