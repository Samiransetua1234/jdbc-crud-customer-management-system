package com.jspider.Customer_management_System.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.Customer_management_System.connection.CustomerConnection;
import com.jspider.Customer_management_System.dto.Customer;

public class CustomerDAO {
	Connection connection = CustomerConnection.getCustomerConnection();

	public Customer saveCustomer(Customer customer) {
		String insertQuery = "insert into customer values(?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, customer.getC_Id());
			preparedStatement.setString(2, customer.getC_name());
			preparedStatement.setString(3, customer.getC_email());
			preparedStatement.setLong(4, customer.getC_phone());
			preparedStatement.setString(5, customer.getC_address());

			preparedStatement.execute();

			System.out.println("Customer saved");

			return customer;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public int updateCustomer(int id, String name) {
		String updateQuery = "update customer set cName = ? where cId = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Customer Data Updated!!!");

			} else {
				System.err.println("Enter Correct Id!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int updateCustomer(int id, long phone) {
		String updateQuery = "update customer set cPhone = ? where cId = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setLong(1, phone);
			preparedStatement.setInt(2, id);

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Customer Data Updated!!!");

			} else {
				System.err.println("Enter Correct Id!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int updateCustomer(int id, String email, String s) {
		String updateQuery = "update customer set cEmail = ? where cId = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Customer Data Updated!!!");

			} else {
				System.err.println("Enter Correct Id!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int updateCustomer(String add, int id) {
		String updateQuery = "update customer set cAddress = ? where cId = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, add);
			preparedStatement.setInt(2, id);

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Customer Data Updated!!!");

			} else {
				System.err.println("Enter Correct Id!!!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int deleteCustomer(int id) {

		String deleteQuerry = "delete from customer where cId = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuerry);

			preparedStatement.setInt(1, id);

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Customer deleted successfully !!!");
			} else {
				System.out.println("Please enter a valid Id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void displayAllCustomer() {
		String displayQuery = "select * from customer";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayQuery);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("cId");
				String name = resultSet.getString("cName");
				String email = resultSet.getString("cEmail");
				long mob = resultSet.getLong("cPhone");
				String add = resultSet.getString("cAddress");
				System.out.println("Customer Id = " + id + " Customer Name = " + name + " Customer Email = " + email
						+ " Customer Mobile = " + mob + " Customer Address = " + add);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Customer getCustomerById(int id) {
		String displayOneQuery = "select * from customer where cId = ?";
		

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayOneQuery);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("cId") == id) {
					System.out.println("Customer Id = "+resultSet.getInt("cId")+"\n"
							+ "Customer Name = "+resultSet.getString("cName")+"\n"
									+ "Customer Email = "+resultSet.getString("cEmail")+"\n"
											+ "Customer Mobile = "+resultSet.getLong("cPhone")+"\n"
													+ "Customer Address = "+resultSet.getString("cAddress"));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
