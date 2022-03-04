package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
	
	private String productBrand;
	private String productName;
	private String productDescription;
	private float productPrice;
	private int productQty;

}
