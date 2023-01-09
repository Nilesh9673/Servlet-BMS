package com.jsp.bms.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bms.Dto.BankAccountDto;
import com.jsp.bms.Dto.CustomerDto;
import com.jsp.bms.Dto.ManagerDto;

public class ManagerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save manager
	public ManagerDto saveManager(ManagerDto manager) {
		manager.setStatus("unapproved");
		entityTransaction.begin();
		entityManager.persist(manager);
		entityTransaction.commit();
		return manager;
	}

	// Update Manager name by id
	public ManagerDto updateManagerNameById(int id, String name) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		manager.setName(name);
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();
		return manager;
	}

	// Update Manager email by id
	public ManagerDto updateManagerGmailById(int id, String email) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);

		manager.setEmail(email);
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();
		return manager;
	}

	// Update Manager password by id
	public ManagerDto updateManagerPasswordById(int id, String password) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);

		manager.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(manager);
		entityTransaction.commit();
		return manager;
	}

	// get Manager ID
	public ManagerDto getManagerById(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		return manager;
	}

	// approved all customers by id
	public List<CustomerDto> approvedAllCustomers(int managerId) {
		ManagerDto manager = entityManager.find(ManagerDto.class, managerId);

		List<CustomerDto> customers = getAllCustomer();
		for (CustomerDto c : customers) {
			if (c.getStatus().equals("unapproved")) {
				c.setStatus("approved");
				c.setManagerDto(manager);
				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
			}
		}
		return customers;
	}

	// approved customers by id
	public List<CustomerDto> approvedCustomerById(int adminId, int customerId) {
		ManagerDto manager = entityManager.find(ManagerDto.class, adminId);
		List<CustomerDto> customers = getAllCustomer();
		for (CustomerDto c : customers) {
			if (c.getStatus().equals("unapproved") && c.getId() == customerId) {
				c.setStatus("approved");
				c.setManagerDto(manager);
				entityTransaction.begin();
				entityManager.merge(c);
				entityTransaction.commit();
			}
		}
		return customers;
	}

// all bank detail
	public List<BankAccountDto> allBankAccount() {
		String sql = "select b from BankAccountDto b";
		Query query = entityManager.createQuery(sql);
		List<BankAccountDto> bankacc = query.getResultList();
		return bankacc;
	}

	// delete customers by id
	public CustomerDto deleteCustomerById(int id) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		entityTransaction.begin();
		entityManager.remove(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// Get all Customers
	public List<CustomerDto> getAllCustomer() {
		String sql = "select c from CustomerDto c";
		Query query = entityManager.createQuery(sql);
		List<CustomerDto> customer = query.getResultList();
		return customer;
	}

}
