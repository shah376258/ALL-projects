package com.zuntech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zuntech.bean.Customer;
import com.zuntech.dao.CrmDao;

public class ActionController extends ActionSupport {

	private static final long serialVersionUID = 1L;
	Customer customer = new Customer();
	CrmDao crmDao = CrmDao.getCrmDao();
	 
	
	private List<Customer> customerList;
	private String successMsg = "";
	private String errorMsg = "";

	private int id;
	private String firstName;
	private String lastName;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CrmDao getCrmDao() {
		return crmDao;
	}

	public void setCrmDao(CrmDao crmDao) {
		this.crmDao = crmDao;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String addCustomer() {
		customer.setId(getId());
		customer.setFirstName(getFirstName());
		customer.setLastName(getLastName());
		customer.setEmail(getEmail());

		boolean status = crmDao.create(customer);

		if (status) {
			setSuccessMsg("1 Customer added successfully");
			getCustomers();
			return SUCCESS;
		} else {
			setErrorMsg("Something went wrong");
			return INPUT;
		}
	}

	public String getCustomers() {
		customerList = crmDao.getCustomers();
		return SUCCESS;
	}

	public String editCustomer() {
		HttpServletRequest rqst = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		int id = Integer.parseInt(rqst.getParameter("id"));
//		System.out.println("inside edit method");
		Customer c = crmDao.getCustomer(id);

		customer.setId(c.getId());
		customer.setFirstName(c.getFirstName());
		customer.setLastName(c.getLastName());
		customer.setEmail(c.getEmail());

		return SUCCESS;
	}

	public String updateCustomer() {
		customer.setId(customer.getId());
		customer.setFirstName(customer.getFirstName());
		customer.setLastName(customer.getLastName());
		customer.setEmail(customer.getEmail());
//		System.out.println("inside update method");
		boolean status = crmDao.updateCustomer(customer);

		if (status) {
			getCustomers();
			setSuccessMsg("1 Customer updated successfully");
			return SUCCESS;
		} else {
			setErrorMsg("Something went wrong");
			return INPUT;
		}
	}

	public String deleteCustomer() {
		HttpServletRequest rqst = (HttpServletRequest) ActionContext.getContext()
				.get(ServletActionContext.HTTP_REQUEST);
		int id = Integer.parseInt(rqst.getParameter("id"));

		boolean status = crmDao.removeCustomer(id);

		if (status) {
			getCustomers();
			setSuccessMsg("1 Customer deleted successfully");
			return SUCCESS;
		} else {
			setErrorMsg("Something went wrong");
			return INPUT;

		}

	}
}