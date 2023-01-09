package com.jsp.bms.Service;

import java.util.List;

import com.jsp.bms.Dao.AdminDao;
import com.jsp.bms.Dto.AdminDto;
import com.jsp.bms.Dto.ManagerDto;

public class AdminService {

	AdminDao adminDao = new AdminDao();

	// save admin
	public AdminDto saveAdmin(AdminDto admin) {
		return adminDao.saveAdmin(admin);
	}

	// Delete admin
	public AdminDto deletetAdminById(int id) {
		return adminDao.deletetAdminById(id);
	}

	// Update name by id
	public AdminDto updateAdminNameById(int id, String name) {
		return adminDao.updateAdminNameById(id, name);
	}

	// update email
	public AdminDto updateAdminGmailById(int id, String email) {
		return adminDao.updateAdminGmailById(id, email);
	}

	// update password
	public AdminDto updateAdminPasswordById(int id, String password) {
		return adminDao.updateAdminPasswordById(id, password);
	}

	// Get By ID
	public AdminDto getAdminById(int id) {
		return adminDao.getAdminById(id);
	}

	// get all detail
	public List<AdminDto> getAllAdmin() {
		return adminDao.getAllAdmin();
	}

	// approver all manager
	public List<ManagerDto> approvedAllManager(int adminId) {
		return adminDao.approvedAllManager(adminId);
	}

	// approved manager by id
	public List<ManagerDto> approvedManagerById(int adminId, int customerId) {
		return adminDao.approvedManagerById(adminId, customerId);
	}

	// get All MAnager
	public List<ManagerDto> getAllManager() {
		return adminDao.getAllManager();
	}

	// delete Manager
	public ManagerDto deleteManagerById(int id) {
		return adminDao.deleteManagerById(id);
	}
}
