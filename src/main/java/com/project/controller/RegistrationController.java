package com.project.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.project.entity.Domain;
import com.project.entity.Student;
import com.project.entity.Tutor;
import com.project.entity.User;
import com.project.service.DomainService;
import com.project.service.StudentService;
import com.project.service.TutorService;
import com.project.service.UserService;
import com.project.serviceImpl.DomainServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;
import com.project.serviceImpl.TutorServiceImpl;
import com.project.serviceImpl.UserServiceImpl;

public class RegistrationController {
	UserService uS = new UserServiceImpl();
	TutorService tS = new TutorServiceImpl();
	DomainService dS = new DomainServiceImpl();
	StudentService sS = new StudentServiceImpl();
	Scanner s = new Scanner(System.in);

	public void registerAsTutor() {

		System.out.println("Enter Username:");
		String username = s.next();
		System.out.println("Enter Password:");
		String password = s.next();
		System.out.println("Enter Email:");
		String email = s.next();

		if (uS.searchUser(email)) {
			System.out.println("User already exists. Please login to continue!");
			return;
		}

		System.out.println("Enter Availability Start Time (HH:MM:SS):");
		String availabilityStart = s.next();
		System.out.println("Enter Availability End Time (HH:MM:SS):");
		String availabilityEnd = s.next();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);

		boolean userCreated = uS.addUser(user);
		if (userCreated) {
			Tutor tutor = new Tutor();
			User U = uS.getUser(email);
			List<Domain> domains = dS.showallDomain();

			for (Domain domain : domains) {
				System.out.println(domain);
			}

			System.out.println("Enter Domain ID from available domains:");
			int domainId = s.nextInt();
			Domain setDomain = dS.searchDomain(domainId);
			tutor.setUser(U);
			tutor.setDomain(setDomain);
			tutor.setAvailabilityStart(LocalTime.parse(availabilityStart));
			tutor.setAvailabilityEnd(LocalTime.parse(availabilityEnd));

			boolean tutorRegistered = tS.addTutor(tutor);
			if (tutorRegistered) {
				System.out.println("Tutor registration completed. Please login to avail all services.");
			} else {
				uS.deleteUser(U.getUserId());
				System.out.println("Registration failed. Please try again.");
			}
		}
	}

	public void registerAsStudent() {
		System.out.println("Enter Username:");
		String username = s.nextLine();
		System.out.println("Enter Password:");
		String password = s.nextLine();
		System.out.println("Enter Email:");
		String email = s.nextLine();

		if (uS.searchUser(email)) {
			System.out.println("User already exists. Please login to continue!");
			s.close();
			return;
		}

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);

		boolean userCreated = uS.addUser(user);
		if (userCreated) {
			User U = uS.getUser(email);
			Student student = new Student(U);
			boolean added = sS.addStudent(student);
			if (added) {
				System.out.println("Student registration completed.");
			} else {
				System.out.println("Registration failed. Please try again.");
			}
		}
	}

	public void checkRegistrationDetails() {

		System.out.println("Enter your Credentials!");
		System.out.println("Enter your email:");
		String email = s.next();

		boolean isUser = uS.searchUser(email);
		if (isUser) {
			User user = uS.getUser(email);
			boolean isTutor = tS.searchTutor(user.getUserId());
			boolean isStudent = sS.searchStudent(user.getUserId());

			if (isTutor) {
				System.out.println("You are successfully registered as a Tutor. Login to continue.");
			}
			if (isStudent) {
				System.out.println("You are successfully registered as a Student. Login to continue.");
			}
		} else {
			System.out.println("You are not registered. Please register to continue.");
		}
	}

	public boolean checkStudentRegistration() {

		System.out.println("Enter your email:");
		String email = s.next();

		boolean isUser = uS.searchUser(email);
		if (isUser) {
			User user = uS.getUser(email);
			return sS.searchStudent(user.getUserId());

		}
		return false;
	}

	public boolean checkTutorRegistration() {

		System.out.println("Enter your email:");
		String email = s.next();

		boolean isUser = uS.searchUser(email);
		if (isUser) {
			User U = uS.getUser(email);
			return tS.searchTutor(U.getUserId());

		}
		return false;
	}
}
