package com.web_services.instant_pot.domain.product;

import java.util.HashSet;

import com.web_services.instant_pot.dal.partner.PartnerDAL;
import com.web_services.instant_pot.dal.product.ProductDAL;
import com.web_services.instant_pot.domain.partner.Partner;
import com.web_services.instant_pot.domain.product.Product;


public class ProductLogic{
	
	
	public Product getProductByID(Long id) {
		ProductDAL pd = new ProductDAL();
		return pd.getProductByID(id);
	}
	
	public HashSet<Product> getAllProducts() {
		ProductDAL pd = new ProductDAL();
		return pd.getAllProducts();
	}
	
	public HashSet<Product> getProductsByPartner(int partnerID){
		ProductDAL pd = new ProductDAL();
		return pd.getAllProductsByPartner(partnerID);
	}
	
	public Product createProduct(Partner partner, String productName, String productDescription, double cost) {
		ProductDAL pd = new ProductDAL();
	    return pd.createProduct(partner, productName, productDescription, cost);
	}
	
	public Product deleteProduct(Long id){
		ProductDAL pd = new ProductDAL();
		return pd.deleteProduct(id);
	}
	
	public Product updateCost(int productID, double newCost) {
		ProductDAL pd = new ProductDAL();
	    return pd.updateCost(productID, newCost);
	}
	
	
}