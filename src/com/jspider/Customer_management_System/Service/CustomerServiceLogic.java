package com.jspider.Customer_management_System.Service;

import com.jspider.Customer_management_System.dao.CustomerDAO;
import com.jspider.Customer_management_System.dto.Customer;

public class CustomerServiceLogic {
	CustomerDAO customerDAO = new CustomerDAO();
	
	
	public Customer saveCustomerService(Customer customer) {
		int id = customer.getC_Id();
		String name = customer.getC_name();
		String add = customer.getC_address();
		long phn = customer.getC_phone();
		if(id >= 1000 && id <= 9999) {
			if(name.length()<=16) {
				if(phn <=9999999999l) {
					if(add.length() <= 20) {
						return customerDAO.saveCustomer(customer);
					}else {
						System.err.println("Address length should be 20 characters");
					}
				}else {
					System.err.println("Phone Number should be of 10 digits");
				}
			}else {
				System.err.println("Customer name should be less than 16 characters");
			}
		}else {
			System.err.println("Customer Id should be of 4 digits");
		}
		return null;
	}

	public int updateCustomerService(int id, String name) {
		if(id >=1000 && id <=9999) {
			if(name.length() <= 16) {
				return customerDAO.updateCustomer(id, name); 
			}else {
				System.err.println("Customer name should be less than 16 characters");
			}
		}else {
			System.err.println("Invalid Id!!!\n"
					+ "Customer Id should be of 4 digits");
		}
		return 0;
	}

	public int updateCustomerService(int id, long phone) {
		if(id >=1000 && id <=9999) {
			if(phone <= 9999999999l) {
				return customerDAO.updateCustomer(id, phone); 
			}else {
				System.err.println("Phone Number should be of 10 digits");
			}
		}else {
			System.err.println("Invalid Id!!!\n"
					+ "Customer Id should be of 4 digits");
		}
		return 0;
	}

	public int updateCustomerService(int id, String email , String s) {
		
		return customerDAO.updateCustomer(id, email, s);
	}

	public int updateCustomerService(String add, int id ) {
		if(id >=1000 && id <=9999) {
			if(add.length() <= 20) {
				return customerDAO.updateCustomer(add, id); 
			}else {
				System.err.println("Phone Number should be of 10 digits");
			}
		}else {
			System.err.println("Invalid Id!!!\n"
					+ "Customer Id should be of 4 digits");
		}
		return 0;
	}
	
	public void displayAllCustomerService() {
		
		customerDAO.displayAllCustomer();
	}
	
	public int deleteCustomerService(int id) {
		if(id >=1000 && id <=9999) {
			return customerDAO.deleteCustomer(id);
		}else {
			System.err.println("Invalid Id!!!\n"
					+ "Customer Id should be of 4 digits");
		}
		return 0;
	}
	
	public Customer getCustomerByIdService(int id) {
		if(id >=1000 && id <=9999) {
			return customerDAO.getCustomerById(id);
		}else {
			System.err.println("Invalid Id!!!\n"
					+ "Customer Id should be of 4 digits");
		}
		return null;
	}
}
