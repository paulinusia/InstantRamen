package com.web_services.instant_pot.domain.product;

import java.util.HashSet;
import java.util.Set;

import com.web_services.instant_pot.dal.partner.PartnerDAL;
import com.web_services.instant_pot.dal.product.ProductDAL;
import com.web_services.instant_pot.dal.review.ReviewDAL;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.domain.review.Review;


public class ProductLogic{
	
	
	public Product getProductByID(Long id) {
		ProductDAL pd = new ProductDAL();
		return pd.getProductByID(id);
	}
	
	public HashSet<Product> getAllProducts() {
		ProductDAL pd = new ProductDAL();
		return pd.getAllProducts();
	}
	
	public HashSet<Product> getProductsByPartner(Long partnerID){
		ProductDAL pd = new ProductDAL();
		return pd.getAllProductsByPartner(partnerID);
	}
	
	public Product createProduct(Partner partner, String productName, String productDescription, double cost) {
		ProductDAL pd = new ProductDAL();
	    return pd.createProduct(partner, productName, productDescription, cost);
	}
	
	public Product deleteProduct(Long id){
		ProductDAL pd = new ProductDAL();
		ReviewDAL rd = new ReviewDAL();
		Product p = pd.getProductByID(id);
		Set<Review> reviews = rd.getAllReviewForProduct(id);
		for (Review r : reviews) {
			System.out.println("Deleting Review with ID: " + Long.toString(r.getId()));
			rd.deleteReview(r.getId());
		}
		System.out.println("Deleting Product...");
		return pd.deleteProduct(id);
	}
	
	public Product updateCost(Long productID, double newCost) {
		ProductDAL pd = new ProductDAL();
	    return pd.updateCost(productID, newCost);
	}
	
	public Product updateProductName(Long id, String newName) {
		ProductDAL pd = new ProductDAL();
		return pd.updateProductName(id, newName);
	}
	
	public Product updateProductDescription(Long id, String newDescription) {
		ProductDAL pd = new ProductDAL();
		return pd.updateProductDescription(id, newDescription);
	}	
	
	public Product updateProduct(Long productID, String productName, String productDescription, double cost) {
		ProductDAL pd = new ProductDAL();
		return pd.updateProduct(productID, productName, productDescription, cost);
	}
}