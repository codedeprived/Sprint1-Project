package com.project.controller;

import java.util.List;
import java.util.Scanner;

import com.project.entity.Tutor;
import com.project.entity.User;
import com.project.service.TutorService;
import com.project.service.UserService;
import com.project.serviceImpl.TutorServiceImpl;
import com.project.serviceImpl.UserServiceImpl;

public class StudentController {
	TutorService tS = new TutorServiceImpl();
	UserService uS = new UserServiceImpl();
	Scanner sc = new Scanner(System.in);

	public void updateStudentDetails() {
		System.out.println("Enter the email of the user you want to update :");
		String email = sc.next();

		User user = uS.getUser(email);

		if (user != null) {
			int option = 0;
			do {
				System.out.println("Select the detail you want to update : \n1. update FirstName"
						+ "\n2. update Email \n3. update password \n4. EXIT");
				option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter First Name : ");
					String name = sc.next();
					user.setUsername(name);
					break;
				case 2:
					System.out.println("Enter Email : ");
					String Email = sc.next();
					user.setEmail(Email);
					break;
				case 3:
					System.out.println("Enter password : ");
					String password = sc.next();
					user.setPassword(password);
					break;
				case 4:
					System.out.println("Exiting user update menu....");
					break;
				default:
					System.out.println("ENTER VALID INPUT!!!!");
					break;
				}
			} while (option != 4);

			boolean updated = uS.updateUser(user.getUserId(), user);
			if (updated) {
				System.out.println("User Details Updated : ");
			} else {
				System.out.println("Something went Wrong Try again ");
			}
		} else {
			System.out.println("User not found Create a User ");
		}

	}

	public void revokeStudentRole() {
		// TODO Auto-generated method stub

	}

	public void showAllTutor() {
		System.out.println("!!!!!!!!!!!!!TUTOR LIST !!!!!!!!!!!!!");
		int count = 1;
		List<Tutor> tutors = tS.showallTutors();
		for (Tutor tutor : tutors) {
			System.out.print(count++ + " : ");
			System.out.println(" Tutor name: " + tutor.getUser().getUsername() + "\n Tutor email: "
					+ tutor.getUser().getEmail() + "\n Tutor availability : " + tutor.getAvailabilityStart());

		}
	}

}
