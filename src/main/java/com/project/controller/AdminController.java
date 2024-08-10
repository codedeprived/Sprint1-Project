package com.project.controller;

import java.util.List;
import java.util.Scanner;

import com.project.entity.Admin;
import com.project.entity.Domain;
import com.project.entity.Student;
import com.project.entity.User;
import com.project.service.AdminService;
import com.project.service.DomainService;
import com.project.service.StudentService;
import com.project.service.UserService;
import com.project.serviceImpl.AdminServiceImpl;
import com.project.serviceImpl.DomainServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;
import com.project.serviceImpl.UserServiceImpl;

public class AdminController {
	AdminService aS = new AdminServiceImpl();
	StudentService sS = new StudentServiceImpl();
	UserService uS = new UserServiceImpl();

	public void manageStudents() {
		// Implement the manage students functionality here
	}

	public void manageAdmin() {
		System.out.println("Welcome to Admin Manager");
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("\nPlease select an option:");
			System.out.println("1. Add Admin");
			System.out.println("2. Delete Admin");
			System.out.println("3. Show all Admins");
			System.out.println("4. Search for Admin");
			System.out.println("5. Exit Admin Manager");
			System.out.print("Enter your choice: ");
			option = sc.nextInt();
			switch (option) {
			case 1:
				addAdmin(sc);
				break;
			case 2:
				deleteAdmin(sc);
				break;
			case 3:
				showAllAdmins();
				break;
			case 4:
				searchAdmin(sc);
				break;
			case 5:
				System.out.println("Exited from Admin Manager Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (option != 5);
	}

	private void addAdmin(Scanner sc) {
		System.out.print("Enter admin name: ");
		String name = sc.next();
		System.out.print("Enter admin password: ");
		String password = sc.next();
		System.out.print("Enter admin email: ");
		String email = sc.next();
		Admin admin = new Admin(name, password, email);
		boolean added = aS.addAdmin(admin);
		if (added) {
			System.out.println("New Admin added successfully");
		} else {
			System.out.println("Something went wrong");
		}
	}

	private void deleteAdmin(Scanner sc) {
		List<Admin> admins = aS.showAllAdmin();
		for (Admin admin : admins) {
			System.out.println(admin);
		}
		System.out.print("Select Admin ID to delete: ");
		int adminId = sc.nextInt();
		Admin admin = aS.searchAdmin(adminId);
		if (admin != null) {
			boolean deleted = aS.deleteAdmin(admin.getAdminId());
			if (deleted) {
				System.out.println("Admin deleted successfully");
			} else {
				System.out.println("Something went wrong");
			}
		}
	}

	private void showAllAdmins() {
		List<Admin> admins = aS.showAllAdmin();
		for (Admin admin : admins) {
			System.out.println(admin);
		}
	}

	private void searchAdmin(Scanner sc) {
		System.out.print("Enter Admin ID to search: ");
		int id = sc.nextInt();
		Admin admin = aS.searchAdmin(id);
		System.out.println(admin);
	}

	public void manageTutors() {
		// Implement the manage tutors functionality here
	}

	public void viewAllTutors() {
		// Implement the view all tutors functionality here
	}

	public void viewAllStudents() {
		List<Student> students = sS.showAllStudent();
		for (Student student : students) {
			User user = student.getUser();
			System.out.println("Student ID: " + student.getStudentId() + " | Name: " + user.getUsername() + " | Email: "
					+ user.getEmail());
		}
	}

	public void domainManager() {
		DomainService dS = new DomainServiceImpl();
		Scanner sc = new Scanner(System.in);
		int option = 0;
		do {
			System.out.println("\nDomain Management");
			System.out.println("1. Add Domain");
			System.out.println("2. Delete Domain");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			option = sc.nextInt();
			switch (option) {
			case 1:
				addDomain(sc, dS);
				break;
			case 2:
				deleteDomain(sc, dS);
				break;
			case 3:
				System.out.println("Exited from Domain Management Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (option != 3);
	}

	private void addDomain(Scanner sc, DomainService dS) {
		sc.nextLine(); // Consume newline
		System.out.print("Enter Domain name: ");
		String domainName = sc.nextLine();
		System.out.print("Enter description: ");
		String desc = sc.nextLine();
		Domain domain = new Domain(domainName, desc);
		boolean added = dS.addDomain(domain);
		if (added) {
			System.out.println("Domain added successfully");
		} else {
			System.out.println("Something went wrong");
		}
	}

	private void deleteDomain(Scanner sc, DomainService dS) {
		// Implement the delete domain functionality here
	}
}
