package com.project.dao.impl;

import java.util.List;

import com.project.dao.UserDao;
import com.project.dto.User;

public class UserDaoImplHibernate implements UserDao {

	@Override
	public boolean addUser(User user) {

		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> showAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
