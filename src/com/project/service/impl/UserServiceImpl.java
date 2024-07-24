package com.project.service.impl;

import java.util.List;

import com.project.dao.UserDao;
import com.project.dao.impl.UserDaoImpl;
import com.project.dto.User;
import com.project.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	// private UserDao userDao = new UserDaoImplHibernate();

	@Override
	public boolean addUser(User user) {
		boolean userAdded = userDao.addUser(user);
		return userAdded;
	}

	@Override
	public boolean updateUser(User user) {
		boolean userUpdated = userDao.updateUser(user);
		return userUpdated;
	}

	@Override
	public boolean deleteUser(String email) {
		boolean UserDeleted = userDao.deleteUser(email);

		return UserDeleted;
	}

	@Override
	public List<User> showAllUser() {

		List<User> allUser = userDao.showAllUser();

		return allUser;

	}

	@Override
	public User searchUser(String email) {
		User user = userDao.searchUser(email);
		return user;
	}

}
