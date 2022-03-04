package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.exception.NotFoundException;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public Product getProductById(Long productId) throws NotFoundException {
		return repository.findById(productId)
				.orElseThrow(() -> new NotFoundException("Products Not Found for this ID : " + productId));
	}

	@Override
	public Product createProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public Product updateProduct(Long productId, Product product1) throws NotFoundException {
		Product product = repository.findById(productId)
				.orElseThrow(() -> new NotFoundException("Products Not Found for this ID : " + productId));
		product.setProductBrand(product1.getProductBrand());
		product.setProductName(product1.getProductName());
		product.setProductDescription(product1.getProductDescription());
		product.setProductPrice(product1.getProductPrice());
		product.setProductQty(product1.getProductQty());
		final Product updateProduct = repository.save(product);
		return updateProduct;
	}

	@Override
	public void deleteProduct(Long productId) throws NotFoundException {
		Product product = repository.findById(productId)
				.orElseThrow(() -> new NotFoundException("Products Not Found for this ID : " + productId));
		repository.delete(product);
	}

}