package com.project.dao;

import java.util.List;

import com.project.dto.User;

public interface UserDao {

	boolean addUser(User user);

	boolean updateUser(User user);

	boolean deleteUser(String email);

	List<User> showAllUser();

	User searchUser(String email);

}
