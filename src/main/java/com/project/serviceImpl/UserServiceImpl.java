package com.project.serviceImpl;

import java.util.List;

import com.project.dao.UserDao;
import com.project.daoImpl.UserDaoImpl;
import com.project.entity.User;
import com.project.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao uD = new UserDaoImpl();

	@Override
	public boolean addUser(User user) {
		boolean userAdded = uD.addUser(user);
		return userAdded;
	}

	@Override
	public boolean deleteUser(int userId) {
		boolean deleted = uD.deleteUser(userId);

		return deleted;
	}

	@Override
	public boolean updateUser(int userID) {
		boolean updated = uD.updateUser(userID);

		return updated;
	}

	@Override
	public List<User> showAllUser() {
		List<User> users = uD.showAllUser();

		return users;
	}

	@Override
	public boolean searchUser(String email) {
		boolean user = uD.searchUser(email);
		return user;
	}

	@Override
	public User getUser(String email) {
		User user = uD.getUser(email);
		return user;
	}

	@Override
	public User getUser(int UserId) {

		return uD.getUser(UserId);
	}

}
