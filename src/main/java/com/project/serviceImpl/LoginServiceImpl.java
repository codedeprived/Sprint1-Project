package com.project.serviceImpl;

import com.project.dao.LoginDao;
import com.project.daoImpl.LoginDaoImpl;
import com.project.dto.Admin;
import com.project.dto.User;
import com.project.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao lD = new LoginDaoImpl();

	@Override
	public boolean adminCheck(Admin admin) {
		boolean check = lD.adminCheck(admin);
		return check;
	}

	@Override
	public boolean userCheck(User user) {
		boolean check = lD.userCheck(user);
		return check;
	}

}
