package com.project.serviceImpl;

import java.util.List;

import com.project.dao.AdminDao;
import com.project.daoImpl.AdminDaoImpl;
import com.project.entity.Admin;
import com.project.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao aD = new AdminDaoImpl();

	@Override
	public boolean addAdmin(Admin admin) {
		boolean adminAdded = aD.addAdmin(admin);

		return adminAdded;
	}

	@Override
	public boolean deleteAdmin(int adminId) {
		boolean deleted = aD.deleteAdmin(adminId);
		return deleted;
	}

	@Override
	public List<Admin> showAllAdmin() {
		List<Admin> admin = aD.showAllAdmin();
		return admin;
	}

	@Override
	public Admin searchAdmin(int adminId) {
		Admin admin = aD.searchAdmin(adminId);
		return admin;
	}

}
