package com.web_services.instant_pot.service.product;

import java.util.Set;

import javax.jws.WebService;

import com.web_services.instant_pot.service.product.representation.ProductRepresentation;


@WebService
public interface ProductService {
	public Set<ProductRepresentation> getProducts();
}
