package com.web_services.instant_pot.service.product.workflow;

import java.util.HashSet;
//import java.util.Iterator;
import java.util.Set;

import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.product.ProductLogic;
import com.web_services.instant_pot.service.link.Link;
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
	
	public Set<ProductRepresentation> getProductsByPartner(Long id) {
		Set<ProductRepresentation> productRepresentations = new HashSet<ProductRepresentation>();
		Set<Product> products = pl.getProductsByPartner(id);
		for (Product product : products) {
			ProductRepresentation productRepresentation = getProductRepresentation(product);
			productRepresentations.add(productRepresentation);
		}
		return productRepresentations;
	}
	
	public ProductRepresentation getProductById(Long id) {
		Product product =  pl.getProductByID(id);
		ProductRepresentation pRep = getProductRepresentation(product);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateProduct", "/productservice/product/" + pRep.getId(), "application/InstantPot.Product+xml|json"));
		links.add(new Link("deleteProduct", "/productservice/product/" + pRep.getId(), null));
		links.add(new Link("getReviewsForProduct", "/reviewservice/productreviews/" + pRep.getId(), null));
		links.add(new Link("getPurchasesForProduct", "/purchaseservice/productpurchases/" + pRep.getId(), null));
		links.add(new Link("createPurchase", "/purchaseservice/purchase", "application/InstantPot.Purchase+xml|json"));
		links.add(new Link("createReview", "/reviewservice/review", "application/InstantPot.Review+xml|json"));
		links.add(new Link("getProductOwner", "/partnerservice/partner/" + pRep.getPartnerId(), null));
		pRep.setLinks(links);
		return pRep;
		
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
		ProductRepresentation pRep = getProductRepresentation(newProduct);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateProduct", "/productservice/product/" + pRep.getId(), "application/InstantPot.Product+xml|json"));
		links.add(new Link("deleteProduct", "/productservice/product/" + pRep.getId(), null));
		links.add(new Link("getReviewsForProduct", "/reviewservice/productreviews/" + pRep.getId(), null));
		links.add(new Link("getPurchasesForProduct", "/purchaseservice/productpurchases/" + pRep.getId(), null));
		links.add(new Link("createPurchase", "/purchaseservice/purchase", "application/InstantPot.Purchase+xml|json"));
		links.add(new Link("createReview", "/reviewservice/review", "application/InstantPot.Review+xml|json"));
		links.add(new Link("getProductOwner", "/partnerservice/partner/" + pRep.getPartnerId(), null));
		pRep.setLinks(links);
		return pRep;
	}
	
	public ProductRepresentation deleteProduct(Long id) {
		Product response = pl.deleteProduct(id);
		return getProductRepresentation(response);
	}
	
	public ProductRepresentation updateProduct(Long id, ProductRequest productRequest) {
		ProductRepresentation pRep =  getProductRepresentation(pl.updateProduct(id, productRequest.getProductName(), productRequest.getProductDescription(), productRequest.getCost()));
		Set<Link> links = new HashSet<>();
		links.add(new Link("deleteProduct", "/productservice/product/" + pRep.getId(), null));
		links.add(new Link("getReviewsForProduct", "/reviewservice/productreviews/" + pRep.getId(), null));
		links.add(new Link("getPurchasesForProduct", "/purchaseservice/productpurchases/" + pRep.getId(), null));
		links.add(new Link("createPurchase", "/purchaseservice/purchase", "application/InstantPot.Purchase+xml|json"));
		links.add(new Link("createReview", "/reviewservice/review", "application/InstantPot.Review+xml|json"));
		links.add(new Link("getProductOwner", "/partnerservice/partner/" + pRep.getPartnerId(), null));
		pRep.setLinks(links);
		return pRep;
	}
}
