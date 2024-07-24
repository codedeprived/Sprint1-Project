package com.project.controller;

import java.util.List;
import java.util.Scanner;

import com.project.dto.User;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;

public class UserController {

	Scanner sc = new Scanner(System.in);
	UserService uS = new UserServiceImpl();

	public void createUser() {
		System.out.println("Enter frist name ");
		String firstname = sc.next();
		System.out.println("Enter last name ");
		String lastname = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		System.out.println("Enter password ");
		String password = sc.next();

		User user = new User(firstname, lastname, email, password);

		boolean userCreated = uS.addUser(user);
		if (userCreated) {
			System.out.println("user Created successfully ");
		} else {
			System.out.println("something went wrong ");
		}

	}

	public void updateUser() {

		System.out.println("Enter the email of the user you want to update :");
		String email = sc.next();

		User user = uS.searchUser(email);

		if (user != null) {
			int option = 0;
			do {
				System.out.println("Select the detail you want to update : \n1. update FirstName"
						+ " \n2. update LastName \n3. update Email \n4. update password \n5. EXIT");
				option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter FirtName : ");
					String firstName = sc.next();
					user.setFirstName(firstName);
					break;
				case 2:
					System.out.println("Enter LastName : ");
					String LastName = sc.next();
					user.setLastName(LastName);
					break;
				case 3:
					System.out.println("Enter Email : ");
					String Email = sc.next();
					user.setEmail(Email);
					break;
				case 4:
					System.out.println("Enter password : ");
					String password = sc.next();
					user.setPassword(password);
					break;
				case 5:
					System.out.println("Exiting user update menu....");
					break;
				default:
					System.out.println("ENTER VALID INPUT!!!!");
					break;
				}
			} while (option != 5);
			boolean updated = uS.updateUser(user);
			if (updated) {
				System.out.println("User Details Updated : ");
			} else {
				System.out.println("Something went Wrong Try again ");
			}
		} else {
			System.out.println("User not found Create a User ");
		}

	}

	public void deleteUser() {

		System.out.println("Enter the email of the user you want to delete : ");
		String email = sc.next();
		boolean userDeleted = uS.deleteUser(email);
		if (userDeleted) {
			System.out.println("user Deleted successfully ");
		} else {
			System.out.println("something went wrong ");
		}

	}

	public void searchUser() {
		System.out.println("Enter the email to search the user : ");
		String email = sc.next();
		User user = uS.searchUser(email);

		if (user != null) {
			System.out.println("user found \n" + user);
		} else {
			System.out.println("User with email \"" + email + "\" does not exist");
		}
		return;

	}

	public void showAllUser() {
		List<User> allUsers = uS.showAllUser();

		for (User user : allUsers) {
			System.out.println(user);
		}
		return;
	}
}
