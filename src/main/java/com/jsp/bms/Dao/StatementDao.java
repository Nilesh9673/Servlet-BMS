package com.jsp.bms.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bms.Dto.StatementDto;

public class StatementDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save Statement
	public StatementDto saveBankStatement(StatementDto statement) {
		entityTransaction.begin();
		entityManager.persist(statement);
		entityTransaction.commit();
		return statement;
	}

	// get All statement
	// get statement expresssion
	public List<StatementDto> customersStatement(int Customerid) {
		
		String sql = "select s from StatementDto s";
		Query query = entityManager.createQuery(sql);
		List<StatementDto> statement = query.getResultList();
		return statement;
	}
}
