package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductResponseDTO;
import com.product.dto.RequestDTO;
import com.product.dto.ResponseDTO;
import com.product.exception.NotFoundException;
import com.product.model.Product;
import com.product.service.ProductServiceImpl;
import com.product.util.ConverterDTO;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductServiceImpl serviceImpl;
	
	@Autowired
	private ConverterDTO converterDTO;
	
	// Get ALL
	@GetMapping("/product")
	public List<ResponseDTO> getAllProducts(){
		return converterDTO.convertEntity(serviceImpl.getAllProducts());
	}
	
	
	// Get ALL
	@GetMapping("/products")
	public ProductResponseDTO listDto() {
		ProductResponseDTO response = new ProductResponseDTO();
		response.setDTo(converterDTO.convertEntity(serviceImpl.getAllProducts()));
		return response;
		
	}
	
	// Get By Id
	@GetMapping("product/{productId}")
	public ResponseEntity<ResponseDTO> getProductById(@PathVariable(name = "productId") Long productId) throws NotFoundException {
		
		Product product = serviceImpl.getProductById(productId);
		ResponseDTO responseDTO = converterDTO.convertEntity(product);
		return ResponseEntity.ok().body(responseDTO);
	}
	
	
	
		// Create product connected to DB
		@PostMapping("/products/add")
		public ResponseDTO createProducts(@RequestBody RequestDTO requestDTO) {
			Product product = converterDTO.convertProductDto(requestDTO);
			Product product2 = serviceImpl.createProduct(product);			
			return converterDTO.convertEntity(product2);
		}

		// Update product

		@PutMapping("/product/{productId}")
		public ResponseEntity<ResponseDTO> updateProduct(@PathVariable(value = "productId") Long productId,
				 @RequestBody RequestDTO productDetails) throws NotFoundException {
			Product product = converterDTO.convertProductDto(productDetails);
			Product product1 = serviceImpl.updateProduct(productId, product);
			ResponseDTO responseDTO = converterDTO.convertEntity(product1);
		return ResponseEntity.ok(responseDTO);

		}
		
		//Delete Mapping
		@DeleteMapping("/product/{productId}")
		public void deleteProduct(@PathVariable(value = "productId")Long productId) throws NotFoundException {		
			serviceImpl.deleteProduct(productId);
		}
}