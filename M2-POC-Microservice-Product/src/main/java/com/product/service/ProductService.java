package com.product.service;

import java.util.List;

import com.product.exception.NotFoundException;
import com.product.model.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long productId) throws NotFoundException;
	
	public Product createProduct(Product product);
	
	public Product updateProduct(Long productId, Product product1) throws NotFoundException;
	
	public void deleteProduct(Long productId) throws NotFoundException;
	
}