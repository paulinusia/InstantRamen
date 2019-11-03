package com.web_services.instant_pot.service.product;

import java.util.Set;

import javax.jws.WebService;
import javax.ws.rs.core.Response;

import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;


@WebService
public interface ProductService {
	public Set<ProductRepresentation> getProducts();
	
	public ProductRepresentation getProduct(Long id);
	
	public Set<ProductRepresentation> searchProducts(String name);
	
	public ProductRepresentation createProduct(Long partnerId, String productName, String productDescription, double cost);
	
	public Response updateProduct(Long partnerId, String productName, String productDescription, double cost);
	
	public Response deleteProduct(Long productId);
}
