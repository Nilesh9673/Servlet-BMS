package com.jsp.bms.Service;

import java.util.List;

import com.jsp.bms.Dao.ManagerDao;
import com.jsp.bms.Dto.BankAccountDto;
import com.jsp.bms.Dto.CustomerDto;
import com.jsp.bms.Dto.ManagerDto;

public class ManagerService {
	ManagerDao managerDao = new ManagerDao();

	// save manager
	public ManagerDto saveManager(ManagerDto manager) {
		return managerDao.saveManager(manager);
	}

	// Update Manager name by id
	public ManagerDto updateManagerNameById(int id, String name) {
		return managerDao.updateManagerNameById(id, name);
	}

	// Update Manager email by id
	public ManagerDto updateManagerGmailById(int id, String email) {
		return managerDao.updateManagerGmailById(id, email);
	}

	// Update Manager password by id
	public ManagerDto updateManagerPasswordById(int id, String password) {
		return managerDao.updateManagerPasswordById(id, password);
	}

	// get Manager ID
	public ManagerDto getManagerById(int id) {
		return managerDao.getManagerById(id);
	}

	// approved all customers by id
	public List<CustomerDto> approvedAllCustomers(int managerId) {
		return managerDao.approvedAllCustomers(managerId);
	}

	// approved customers by id
	public List<CustomerDto> approvedCustomerById(int managerId, int customerId) {
		return managerDao.approvedCustomerById(managerId, customerId);
	}

	// all bank account
	public List<BankAccountDto> allBankAccount() {
		return managerDao.allBankAccount();
	}

	// delete customers by id
	public CustomerDto deleteCustomerById(int id) {
		return managerDao.deleteCustomerById(id);
	}
	// Get all Customers
		public List<CustomerDto> getAllCustomer() {
			return managerDao.getAllCustomer();
		}
}
