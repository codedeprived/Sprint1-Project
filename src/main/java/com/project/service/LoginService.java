package com.project.service;

import com.project.dto.Admin;
import com.project.dto.User;

public interface LoginService {

	boolean adminCheck(Admin admin);

	boolean userCheck(User user);
}
