package com.project.service;

import com.project.entity.Admin;
import com.project.entity.User;

public interface LoginService {

	boolean adminCheck(Admin admin);

	boolean userCheck(User user);
}
