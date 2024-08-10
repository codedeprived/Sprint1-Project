package com.project.dao;

import com.project.entity.Admin;
import com.project.entity.User;

public interface LoginDao {

	boolean adminCheck(Admin admin);

	boolean userCheck(User user);
}
