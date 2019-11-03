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
		System.out.println();
		System.out.println("GET METHOD Request for Product with ID: " + Long.toString(id));
		return productActivity.getProductById(id);
	}

	@GET
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{name}")
	public Set<ProductRepresentation> searchProducts(@PathParam("name")String name) {
		System.out.println("GET METHOD Request to search Products for names containing: " + name);
		return productActivity.searchProducts(name);	
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
