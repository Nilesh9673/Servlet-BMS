package com.jsp.bms.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.bms.Dto.AdminDto;
import com.jsp.bms.Dto.ManagerDto;

public class AdminDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save admin
	public AdminDto saveAdmin(AdminDto admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

	// Delete admin
	public AdminDto deletetAdminById(int id) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		entityTransaction.begin();
		entityManager.remove(admin);
		entityTransaction.commit();
		return admin;
	}

	// // Update name by id
	public AdminDto updateAdminNameById(int id, String name) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		admin.setName(name);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return admin;
	}

// update email
	public AdminDto updateAdminGmailById(int id, String email) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		admin.setEmail(email);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return admin;
	}

	// update password
	public AdminDto updateAdminPasswordById(int id, String password) {
		AdminDto admin = entityManager.find(AdminDto.class, id);
		admin.setPassword(password);
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return admin;
	}

	// Get By ID
	public AdminDto getAdminById(int id) {
		return entityManager.find(AdminDto.class, id);
	}

	// get all detail
	public List<AdminDto> getAllAdmin() {
		String sql = "Select a from AdminDto a";
		Query query = entityManager.createQuery(sql);
		List<AdminDto> a = query.getResultList();
		return a;
	}

	// approver all manager
	public List<ManagerDto> approvedAllManager(int adminId) {
		AdminDto admin = entityManager.find(AdminDto.class, adminId);
		
		List<ManagerDto> managerDto = getAllManager();
		for (ManagerDto manager : managerDto) {
			if (manager.getStatus().equals("unapproved")) {
				manager.setStatus("approved");
				manager.setAdminDto(admin);
				System.out.println("manager approved");
				entityTransaction.begin();
				entityManager.merge(manager);
				entityTransaction.commit();
			}
		}
		return managerDto;
	}

	// approved manager by id
	public List<ManagerDto> approvedManagerById(int adminId, int customerId) {
		AdminDto admin = entityManager.find(AdminDto.class, adminId);
		
		List<ManagerDto> managerDto = getAllManager();
		for (ManagerDto manager : managerDto) {
			if (manager.getStatus().equals("unapproved") && manager.getId() == customerId) {
				manager.setStatus("approved");
				manager.setAdminDto(admin);
				System.out.println("manager approved");
				entityTransaction.begin();
				entityManager.merge(manager);
				entityTransaction.commit();
			}
		}
		return managerDto;
	}

	// get All Manager
	public List<ManagerDto> getAllManager() {
		String sql = "Select m from ManagerDto m";
		Query query = entityManager.createQuery(sql);
		List<ManagerDto> m = query.getResultList();
		return m;
	}
	// delete Manager
	public ManagerDto deleteManagerById(int id) {
		ManagerDto manager = entityManager.find(ManagerDto.class, id);
		entityTransaction.begin();
		entityManager.remove(manager);
		entityTransaction.commit();
		return manager;
	}
}
