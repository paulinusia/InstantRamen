package com.web_services.instant_pot.service.product;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import com.web_services.instant_pot.service.product.representation.ProductRepresentation;
import com.web_services.instant_pot.service.product.representation.ProductRequest;
import com.web_services.instant_pot.service.product.workflow.ProductActivity;

@Path("/productservice/")
//@CrossOriginResourceSharing(allowAllOrigins=true)
public class ProductResource implements ProductService{

	//@Context
    //private HttpHeaders headers;
	
//	@OPTIONS
//	@Path("/username")
//	@LocalPreflight
//	public Response options(@PathParam("username") String username) {
//		String origin = headers.getRequestHeader("Origin").get(0);
//		return Response.ok()
//				.header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "GET")
//				.header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
//				.header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, origin)
//				.header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
//				.build();
//}
	
//	@OPTIONS
//	@Path("/")
//	@LocalPreflight
//	public Response options() {
//		String origin = headers.getRequestHeader("Origin").get(0);
//		return Response.ok()
//				.header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
//				.header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, origin)
//				.build();
//	}
	
	private static ProductActivity productActivity = new ProductActivity();
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	public Set<ProductRepresentation> getProducts() {
		System.out.println("GET METHOD Request for all Products .............");
		return productActivity.getProducts();	
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{id}")
	public ProductRepresentation getProduct(@PathParam("id") Long id) {
		System.out.println();
		System.out.println("GET METHOD Request for Product with ID: " + Long.toString(id));
		return productActivity.getProductById(id);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/partnerproducts/{id}")
	public Set<ProductRepresentation> getProductsByPartner(@PathParam("id") Long id) {
		System.out.println("GET METHOD Request for Products from Partner with ID: " + Long.toString(id));
		return productActivity.getProductsByPartner(id);
	}
	
	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{name}")
	public Set<ProductRepresentation> searchProducts(@PathParam("name")String name) {
		System.out.println("GET METHOD Request to search Products for names containing: " + name);
		return productActivity.searchProducts(name);	
	}

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/product")
	public ProductRepresentation createProduct(ProductRequest productRequest) {
		System.out.println("POST METHOD Request to create new product with name: " + productRequest.getProductName());
		return productActivity.createProduct(productRequest);
	}
	
	@PUT
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{id}")
	public ProductRepresentation updateProduct(@PathParam("id") Long id, ProductRequest productRequest) {
		System.out.println("PUT METHOD Request for Product with ID: " + Long.toString(id));
		return productActivity.updateProduct(id, productRequest);
	}

	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{id}")
	public ProductRepresentation deleteProduct(@PathParam("id") Long id) {
		System.out.println("DELETE METHOD Request for product with ID: " + Long.toString(id));
		return productActivity.deleteProduct(id);
	}
	
//	@DELETE
//	@Consumes({"application/xml" , "application/json"})
//	@Produces({"application/xml" , "application/json"})
//	@Path("/product/{id}")
//	public Response deleteProduct(@PathParam("id") Long id) {
//		System.out.println("DELETE METHOD Request for product with ID: " + Long.toString(id));
//		ProductRepresentation result = productActivity.deleteProduct(id);
//		if (result != null) return Response.status(Response.Status.OK).entity(result).build();
//		else return Response.status(Response.Status.BAD_REQUEST).build();
//	}

}
