package com.jspider.Customer_management_System.controller;

import java.util.Scanner;

import com.jspider.Customer_management_System.Service.CustomerServiceLogic;
import com.jspider.Customer_management_System.dto.Customer;

public class CustomerController {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Customer customer = new Customer();
		CustomerServiceLogic logic = new CustomerServiceLogic();
		while (true) {
			System.out.println("Welcome to Apni Dukan !!!");
			System.out.println("New Customer ?..\n" + "Press 1 to register \n" + "Otherwise press 2");
			int x = scanner.nextInt();
			if (x == 1) {
				System.out.println("Enter Customer Id ");
				int id = scanner.nextInt();
				System.out.println("Enter Customer Name");
				String name = scanner.next();
				System.out.println("Enter Customer Email ");
				String email = scanner.next();
				System.out.println("Enter Customer Phone number");
				long phone = scanner.nextLong();
				System.out.println("Enter Customer Address");
				String address = scanner.next();
				customer.setC_Id(id);
				customer.setC_name(name);
				customer.setC_email(email);
				customer.setC_phone(phone);
				customer.setC_address(address);
				logic.saveCustomerService(customer);
				logic.getCustomerByIdService(customer.getC_Id());
			} else if (x == 2) {

				System.out.println("Press 1 to update customer \n" + "Press 2 to Display all customers \n"
						+ "Press 3 to see customer by his/her Id \n" + "Press 4 to delete customer");

				x = scanner.nextInt();

				switch (x) {

				case 1: {
					System.out.println("Enter Customer Id to Update ...");
					int id = scanner.nextInt();
					System.out.println("Press 1 to update name\n" + "Press 2 to Update email \n"
							+ "Press 3 to update Phone \n" + "Press 4 to Update Address");
					x = scanner.nextInt();
					if (x == 1) {
						System.out.println("Enter new name...");
						String y = scanner.next();
						logic.updateCustomerService(id, y);
					} else if (x == 2) {
						System.out.println("Enter new email...");
						String y = scanner.next();
						logic.updateCustomerService(id, y, y);
					} else if (x == 3) {
						System.out.println("Enter new phone...");
						long y = scanner.nextLong();
						logic.updateCustomerService(id, y);
					} else if (x == 4) {
						System.out.println("Enter new address...");
						String y = scanner.next();
						logic.updateCustomerService(y, id);
					}
					break;
				}
				case 2: {
					logic.displayAllCustomerService();
					break;
				}
				case 3: {
				System.out.println("Enter customer Id to see his/her details");
				int id = scanner.nextInt();
				logic.getCustomerByIdService(id);
					break;
				}
				case 4: {
					System.out.println("Enter customer id to delete...");
					int id = scanner.nextInt();
					logic.deleteCustomerService(id);
					break;
				}
				default: {
					System.out.println("Enter valid option !!!");
				}
				}
			}
		}
	}
}
