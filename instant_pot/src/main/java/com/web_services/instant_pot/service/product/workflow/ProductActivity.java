package com.web_services.instant_pot.service.product.workflow;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.product.ProductLogic;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.representation.ProductRequest;

public class ProductActivity {
	private static ProductLogic pl = new ProductLogic();
	
	public Set<ProductRepresentation> getProducts() {
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		products = pl.getAllProducts();
		
		for (Product product : products) {
			ProductRepresentation productRepresentation = getProductRepresentation(product);
			productRepresentations.add(productRepresentation);
		}
		
		return productRepresentations;
	}
	
	public ProductRepresentation getProductById(Long id) {
		Product product =  pl.getProductByID(id);
		return getProductRepresentation(product);
		
	}
	
	private static ProductRepresentation getProductRepresentation(Product product) {
		ProductRepresentation productRepresentation = new ProductRepresentation();
		
		productRepresentation.setId(product.getId());
		productRepresentation.setProductName(product.getProductName());
		productRepresentation.setProductDescription(product.getProductDescription());
		productRepresentation.setCost(product.getCost());
		productRepresentation.setPartnerId(product.getProductOwner().getId());
		
		return productRepresentation;
	}
	
	public Set<ProductRepresentation> searchProducts(String name) {
		Set<Product> products = new HashSet<Product>();
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		products = pl.getAllProducts();
		
		for (Product product : products) {
			if (product.getProductName().contains(name)) {
				ProductRepresentation productRepresentation = getProductRepresentation(product);
				productRepresentations.add(productRepresentation);
			}
		}
		
		return productRepresentations;
	}
	
	public ProductRepresentation createProduct(ProductRequest productRequest) {
		PartnerLogic partnerLogic = new PartnerLogic();
		Product newProduct =  pl.createProduct(partnerLogic.getPartner(productRequest.getPartnerId()), productRequest.getProductName(), productRequest.getProductDescription(), productRequest.getCost());
		return getProductRepresentation(newProduct);
	}
	
	public ProductRepresentation deleteProduct(Long id) {
		Product response = pl.deleteProduct(id);
		return getProductRepresentation(response);
	}
}
