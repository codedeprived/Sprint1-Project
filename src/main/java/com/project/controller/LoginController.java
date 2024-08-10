package com.project.controller;

import java.util.Scanner;

import com.project.entity.Admin;
import com.project.entity.User;
import com.project.service.LoginService;
import com.project.serviceImpl.LoginServiceImpl;

public class LoginController {
	Scanner sc = new Scanner(System.in);
	LoginService lS = new LoginServiceImpl();

	public boolean admin() {

		System.out.println("Enter admin Credentials ");
		System.out.println("Enter email :");
		String email = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		Admin admin = new Admin(email, password);
		boolean check = lS.adminCheck(admin);
		if (!check) {
			System.out.println("Enter valid credentials : ");
		}
		return check;
	}

	public boolean user() {
		System.out.println("Enter user Credentials ");
		System.out.println("Enter email :");
		String email = sc.next();
		System.out.println("Enter password");
		String password = sc.next();

		User user = new User(email, password);
		boolean check = lS.userCheck(user);
		if (!check) {
			System.out.println("Enter valid Credentials :");
		}
		return check;
	}

}
