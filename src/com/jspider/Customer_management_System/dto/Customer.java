package com.jspider.Customer_management_System.dto;

public class Customer {
	private int c_Id;
	private String c_name;
	private String c_email;
	private long c_phone;
	private String c_address;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int c_Id, String c_name, String c_email, long c_phone, String c_address) {
		super();
		this.c_Id = c_Id;
		this.c_name = c_name;
		this.c_email = c_email;
		this.c_phone = c_phone;
		this.c_address = c_address;
	}

	public int getC_Id() {
		return c_Id;
	}

	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_email() {
		return c_email;
	}

	public void setC_email(String c_email) {
		this.c_email = c_email;
	}

	public long getC_phone() {
		return c_phone;
	}

	public void setC_phone(long c_phone) {
		this.c_phone = c_phone;
	}

	public String getC_address() {
		return c_address;
	}

	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	
	
}
