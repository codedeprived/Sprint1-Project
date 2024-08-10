package com.project.dao;

import com.project.dto.Admin;
import com.project.dto.User;

public interface LoginDao {

	boolean adminCheck(Admin admin);

	boolean userCheck(User user);
}
