package com.web_services.instant_pot.service.product.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.product.ProductLogic;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;

public class ProductActivity {
	private static ProductLogic pl = new ProductLogic();
	
	public Set<ProductRepresentation> getProducts() {
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		//employees = dao.getAllEmployees();
		products = pl.getAllProducts();
		
		for (Product product : products) {
			ProductRepresentation productRepresentation = new ProductRepresentation();
			productRepresentation.setId(product.getId());
			productRepresentation.setProductName(product.getProductName());
			productRepresentation.setProductDescription(product.getProductDescription());
			productRepresentation.setCost(product.getCost());
			
			productRepresentations.add(productRepresentation);
		}
		
		return productRepresentations;
	}
}
