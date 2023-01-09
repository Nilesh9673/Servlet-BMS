package com.jsp.bms.Service;

import java.util.List;

import com.jsp.bms.Dao.CustomerDao;
import com.jsp.bms.Dto.BankAccountDto;
import com.jsp.bms.Dto.CustomerDto;

public class CustomerServices {
	CustomerDao customerDao = new CustomerDao();

//save customers
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		return customerDao.saveCustomer(customerDto);
	}

//update customers name by id
	public CustomerDto updateCustomersNameById(int id, String name) {
		return customerDao.updateCustomersNameById(id, name);
	}

//update customers Gender by id
	public CustomerDto updateCustomersGenderById(int id, String gender) {
		return customerDao.updateCustomersGenderById(id, gender);
	}

	// update customers dob by id
	public CustomerDto updateCustomersDobById(int id, String dob) {
		return customerDao.updateCustomersDobById(id, dob);
	}

	// update customers Adharno by id
	public CustomerDto updateCustomersAdharById(int id, String adharno) {
		return customerDao.updateCustomersAdharById(id, adharno);
	}

	// update customers password by id
	public CustomerDto updateCustomerPasswordById(int id, String password) {
		return customerDao.updateCustomerPasswordById(id, password);
	}

	// get customers by id
	public CustomerDto getCustomerById(int id) {
		return customerDao.getCustomerById(id);
	}

	// save bankAccount
	public BankAccountDto savebankDetail(int CustomerId, BankAccountDto bankAccountDto) {
		return customerDao.savebankDetail(CustomerId, bankAccountDto);
	}

	// deposite money
	public BankAccountDto depositeMoney(int customersId, int bankId, double amount) {
		return customerDao.depositeMoney(customersId, bankId, amount);
	}

	// tranfer money
	public BankAccountDto transferMoney(int customersId, int sender, int receiver, double ammountTranfer) {
		return customerDao.transferMoney(customersId, sender, receiver, ammountTranfer);
	}

// get bankaccount by id
	public BankAccountDto getBankAccById(int id) {
		return customerDao.getBankAccById(id);
	}

}
