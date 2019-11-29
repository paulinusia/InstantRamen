package com.web_services.instant_pot.service.customer.workflow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.web_services.instant_pot.domain.customer.Customer;
import com.web_services.instant_pot.domain.customer.CustomerLogic;
import com.web_services.instant_pot.domain.partner.PartnerLogic;
import com.web_services.instant_pot.domain.product.Product;
import com.web_services.instant_pot.service.customer.representation.CustomerRepresentation;
import com.web_services.instant_pot.service.customer.representation.CustomerRequest;
import com.web_services.instant_pot.service.link.Link;
import com.web_services.instant_pot.service.product.representation.ProductRepresentation;

public class CustomerActivity {
	CustomerLogic customerLogic = new CustomerLogic();
	
	public CustomerRepresentation getCustomerById(Long id) {
		CustomerRepresentation cRep = getCustomerRepresentation(customerLogic.getCustomerById(id));
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateCustomer", "/customerservice/customer/" + cRep.getId(), "application/InstantPot.Customer+xml|json"));
		links.add(new Link("createAddress", "/addressservice/address", "application/InstantPot.Address+xml|json"));
		links.add(new Link("createPurchase", "/purchaseservice/purchase", "application/InstantPot.Purchase+xml|json"));
		links.add(new Link("createPayment", "/paymentservice/payment", "application/InstantPot.Payment+xml|json"));
		links.add(new Link("getPaymentsForCustomer", "/paymentservice/customerpayments/" + cRep.getId(), null));
		links.add(new Link("getAddressesForCustomer", "/addressservice/customeraddresses/" + cRep.getId(), null));
		links.add(new Link("getPurchasesForCustomer", "/purchaseservice/customerpurchases/" + cRep.getId(), null));
		cRep.setLinks(links);
		return cRep;
	}
	
	public Set<CustomerRepresentation> getCustomers() {
		Set<Customer> customers = customerLogic.getAllCustomers();
		Set<CustomerRepresentation> customerRepresentations = new HashSet<CustomerRepresentation>();
		
		for (Customer customer : customers) {
			CustomerRepresentation customerRepresentation = getCustomerRepresentation(customer);
			customerRepresentations.add(customerRepresentation);
		}
		
		return customerRepresentations;
	}
	
	private static CustomerRepresentation getCustomerRepresentation(Customer customer) {
		CustomerRepresentation cRep = new CustomerRepresentation();
		cRep.setEmail(customer.getEmail());
		cRep.setFirstName(customer.getFirstName());
		cRep.setId(customer.getId());
		cRep.setLastName(customer.getLastName());
		cRep.setPhoneNumber(customer.getPhoneNumber());
		return cRep;
	}

	public CustomerRepresentation createCustomer(CustomerRequest customerRequest) {
		CustomerLogic customerLogic = new CustomerLogic();
		Customer newCustomer =  customerLogic.createCustomer(customerRequest.getFirstName(), customerRequest.getLastName(), customerRequest.getEmail(), customerRequest.getPhoneNumber());
		CustomerRepresentation cRep = getCustomerRepresentation(newCustomer);
		Set<Link> links = new HashSet<>();
		links.add(new Link("updateCustomer", "/customerservice/customer/" + cRep.getId(), "application/InstantPot.Customer+xml|json"));
		links.add(new Link("createAddress", "/addressservice/address", "application/InstantPot.Address+xml|json"));
		links.add(new Link("createPurchase", "/purchaseservice/purchase", "application/InstantPot.Purchase+xml|json"));
		links.add(new Link("createPayment", "/paymentservice/payment", "application/InstantPot.Payment+xml|json"));
		links.add(new Link("getPaymentsForCustomer", "/paymentservice/customerpayments/" + cRep.getId(), null));
		links.add(new Link("getAddressesForCustomer", "/addressservice/customeraddresses/" + cRep.getId(), null));
		links.add(new Link("getPurchasesForCustomer", "/purchaseservice/customerpurchases/" + cRep.getId(), null));
		cRep.setLinks(links);
		return cRep;
	}

	public CustomerRepresentation updateCustomer(Long id, CustomerRequest customerRequest) {
		CustomerLogic customerLogic = new CustomerLogic();
		Customer customer = customerLogic.updateCustomer(id, customerRequest.getFirstName(), customerRequest.getLastName(), customerRequest.getEmail(), customerRequest.getPhoneNumber());
		CustomerRepresentation cRep = getCustomerRepresentation(customer);
		Set<Link> links = new HashSet<>();
		links.add(new Link("createAddress", "/addressservice/address", "application/InstantPot.Address+xml|json"));
		links.add(new Link("createPurchase", "/purchaseservice/purchase", "application/InstantPot.Purchase+xml|json"));
		links.add(new Link("createPayment", "/paymentservice/payment", "application/InstantPot.Payment+xml|json"));
		links.add(new Link("getPaymentsForCustomer", "/paymentservice/customerpayments/" + cRep.getId(), null));
		links.add(new Link("getAddressesForCustomer", "/addressservice/customeraddresses/" + cRep.getId(), null));
		links.add(new Link("getPurchasesForCustomer", "/purchaseservice/customerpurchases/" + cRep.getId(), null));
		cRep.setLinks(links);
		return cRep;
	}

	public static CustomerRepresentation deleteCustomer(Long id) {
		CustomerLogic customerLogic = new CustomerLogic();
		Customer customer = customerLogic.deleteCustomer(id);
		return getCustomerRepresentation(customer);
	}
}
