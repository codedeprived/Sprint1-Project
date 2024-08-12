package com.project.dao;

import java.util.List;

import com.project.entity.User;

public interface UserDao {

	boolean addUser(User user);

	boolean deleteUser(int userId);

	boolean updateUser(int userID, User user);

	List<User> showAllUser();

	boolean searchUser(String email);

	User getUser(String email);

	User getUser(int userId);
}
