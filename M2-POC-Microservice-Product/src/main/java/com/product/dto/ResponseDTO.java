package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {

	private Long productId;
	private String productBrand;
	private String productName;
	private String productDescription;
	private float productPrice;
	private int productQty;

}
