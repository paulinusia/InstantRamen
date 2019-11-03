package com.web_services.instant_pot.service.product;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.workflow.ProductActivity;

@Path("/productservice/")
public class ProductResource implements ProductService{

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all products .............");
		ProductActivity productActivity = new ProductActivity();
		return productActivity.getProducts();	
	}

	public ProductRepresentation getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<ProductRepresentation> searchProducts(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductRepresentation createProduct(Long partnerId, String productName, String productDescription,
			double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response updateProduct(Long partnerId, String productName, String productDescription, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response deleteProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
