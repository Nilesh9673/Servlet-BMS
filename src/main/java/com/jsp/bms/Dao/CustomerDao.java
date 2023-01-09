package com.jsp.bms.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bms.Dto.BankAccountDto;
import com.jsp.bms.Dto.CustomerDto;
import com.jsp.bms.Dto.StatementDto;
import com.jsp.bms.Service.StatementService;

public class CustomerDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

//	 save customers
	public CustomerDto saveCustomer(CustomerDto customerDto) {
//		List<CustomerDto> c = getAllCustomer();
//		for (CustomerDto customers : c) {
//			if (customers.getAdharno() == customerDto.getAdharno()) {
//				return null;
//			}
//		}
		customerDto.setStatus("unapproved");
		entityTransaction.begin();
		entityManager.persist(customerDto);
		entityTransaction.commit();
		return customerDto;

	}

	// update customers name by id
	public CustomerDto updateCustomersNameById(int id, String name) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		customersDto.setName(name);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// update customers Gender by id
	public CustomerDto updateCustomersGenderById(int id, String gender) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		customersDto.setGender(gender);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// update customers dob by id
	public CustomerDto updateCustomersDobById(int id, String dob) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		customersDto.setDob(dob);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// update customers Adharno by id
	public CustomerDto updateCustomersAdharById(int id, String adharno) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		customersDto.setAdharno(adharno);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// update customers password by id
	public CustomerDto updateCustomerPasswordById(int id, String password) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		customersDto.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(customersDto);
		entityTransaction.commit();
		return customersDto;
	}

	// get customers by id
	public CustomerDto getCustomerById(int id) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, id);
		return customersDto;
	}

	// save bankAccount
	public BankAccountDto savebankDetail(int CustomerId, BankAccountDto bankAccountDto) {
		ManagerDao managerDao = new ManagerDao();
		List<BankAccountDto> b = managerDao.allBankAccount();
		for (BankAccountDto bankAccount : b) {
			if (bankAccount.getCustomerDto().getId() == CustomerId) {
				return null;
			}
		}
		CustomerDto customersDto = entityManager.find(CustomerDto.class, CustomerId);
		if (customersDto != null) {
			if (customersDto.getStatus().equals("approved")) {
				bankAccountDto.setCustomerDto(customersDto);
				bankAccountDto.setCname(customersDto.getName());
				bankAccountDto.setBname("jSpider_BanK");
				bankAccountDto.setAccno(49221000 + customersDto.getId());
				bankAccountDto.setIfsc("JSP0JAVA");
				entityTransaction.begin();
				entityManager.persist(bankAccountDto);
				entityTransaction.commit();
			} else {
				System.out.println("You are not approved Customers");
				return null;
			}
		} else {
			System.out.println("customers not found");
			return null;
		}
		StatementDto statement = new StatementDto();
		statement.setCustomerId(bankAccountDto.getId());
		statement.setTransactionDetail("Deposite Rs " + bankAccountDto.getBalance());
		StatementService statementServices = new StatementService();
		statementServices.saveBankStatement(statement);
		return bankAccountDto;

	}

	// deposite money
	public BankAccountDto depositeMoney(int customersId, int bankId, double amount) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, customersId);
		BankAccountDto bankAccountDto = bankAccountDto = entityManager.find(BankAccountDto.class, bankId);
		if (customersDto.getStatus().equals("approved") && bankAccountDto.getCustomerDto().getId() == customersId) {
			bankAccountDto.setBalance(bankAccountDto.getBalance() + amount);
			entityTransaction.begin();
			entityManager.merge(bankAccountDto);
			entityTransaction.commit();
		}

		StatementDto statement = new StatementDto();
		statement.setCustomerId(bankId);
		statement.setTransactionDetail("Deposite Rs " + amount);
		StatementService statementServices = new StatementService();
		statementServices.saveBankStatement(statement);

		return bankAccountDto;
	}

	// tranfer money
	public BankAccountDto transferMoney(int customersId, int sender, int receiver, double ammountTranfer) {
		CustomerDto customersDto = entityManager.find(CustomerDto.class, customersId);
		BankAccountDto bankAccount1 = entityManager.find(BankAccountDto.class, sender);
		BankAccountDto bankAccount2 = entityManager.find(BankAccountDto.class, receiver);
		// if (bankAccount1.getBalance() >= ammountTranfer) check for condition
		bankAccount1.setBalance(bankAccount1.getBalance() - ammountTranfer);
		bankAccount2.setBalance(bankAccount2.getBalance() + ammountTranfer);

		entityTransaction.begin();
		entityManager.merge(bankAccount1);
		entityManager.merge(bankAccount2);
		entityTransaction.commit();

		StatementDto statement = new StatementDto();
		statement.setCustomerId(sender);
		statement.setTransactionDetail("Debit " + ammountTranfer + " to " + bankAccount2.getCname());

		StatementDto statement1 = new StatementDto();
		statement1.setCustomerId(receiver);
		statement1.setTransactionDetail("Cridet " + ammountTranfer + "from " + bankAccount1.getCname());

		StatementService statementServices = new StatementService();
		statementServices.saveBankStatement(statement);
		statementServices.saveBankStatement(statement1);

		return bankAccount2;
	}

	// all bank Account
	public BankAccountDto getBankAccById(int id) {
		BankAccountDto bankAccount1 = entityManager.find(BankAccountDto.class, id);
		return bankAccount1;
	}
}
