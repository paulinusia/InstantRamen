package com.web_services.instant_pot.service.product;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.web_services.instant_pot.service.payment.workflow.PaymentActivity;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.workflow.ProductActivity;

@Path("/productservice/")
public class ProductResource implements ProductService{

	private static ProductActivity productActivity = new ProductActivity();
	
	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all Products .............");
		return productActivity.getProducts();	
	}

	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{id}")
	public ProductRepresentation getProduct(@PathParam("id") Long id) {
		System.out.println(Long.toString(id));
		System.out.println("GET METHOD Request for Product by ID .............");
		return productActivity.getProductById(id);
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
