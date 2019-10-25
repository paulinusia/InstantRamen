package com.web_services.instant_pot.service.product;

import java.util.Set;

import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.workflow.ProductActivity;

public class ProductResource implements ProductService{

	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all products .............");
		ProductActivity productActivity = new ProductActivity();
		return productActivity.getProducts();	
	}

}
