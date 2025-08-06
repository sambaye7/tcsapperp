package com.tcs.app;

public class CustomerService {
	
		public String getCustomerDetails(String customerId) {
		// Simulate fetching customer details
		return "Details for customer: " + customerId;
	}

	public String updateCustomerDetails(String customerId, String newDetails) {
		// Simulate updating customer details
		if (customerId == null || newDetails == null) {
			return "Invalid input: customerId and newDetails cannot be null";
		}
		if (customerId.isEmpty() || newDetails.isEmpty()) {
			return "Invalid input: customerId and newDetails cannot be empty";
		}
		if (!customerId.matches("\\d+")) {
			return "Invalid input: customerId must be numeric";
		}
		return "Updated details for customer: " + customerId + " to " + newDetails;
	}
	
	public String deleteCustomer(String customerId) {
		// Simulate deleting a customer
		return "Deleted customer with ID: " + customerId;
	}
	public String addCustomer(String customerDetails) {
		// Simulate adding a new customer
		return "Added new customer with details: " + customerDetails;
	}
	public String listCustomers() {
		// Simulate listing all customers
		return "List of all customers";
	}
	public String searchCustomer(String query) {
		// Simulate searching for a customer
		return "Search results for: " + query;
	}	
}
