package com.web_services.instant_pot.service.product;

import java.util.Set;

import javax.jws.WebService;
//import javax.ws.rs.core.Response;

import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.representation.ProductRequest;


@WebService
public interface ProductService {
	public Set<ProductRepresentation> getProducts();
	
	public ProductRepresentation getProduct(Long id);
	
	public Set<ProductRepresentation> getProductsByPartner(Long id);
	
	public Set<ProductRepresentation> searchProducts(String name);
	
	public ProductRepresentation createProduct(ProductRequest productRequest);
	
	public ProductRepresentation updateProduct(Long id, ProductRequest productRequest);
	
	public ProductRepresentation deleteProduct(Long id);
}
