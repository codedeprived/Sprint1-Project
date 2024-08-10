package com.project.service;

import java.util.List;

import com.project.entity.Admin;

public interface AdminService {

	boolean addAdmin(Admin admin);

	boolean deleteAdmin(int adminId);

	List<Admin> showAllAdmin();

	Admin searchAdmin(int adminId);

}
