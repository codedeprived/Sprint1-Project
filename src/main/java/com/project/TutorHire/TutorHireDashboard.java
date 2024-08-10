package com.project.TutorHire;

import java.util.Scanner;

import com.project.controller.AdminController;
import com.project.controller.HireController;
import com.project.controller.LoginController;
import com.project.controller.RegistrationController;
import com.project.controller.StudentController;
import com.project.controller.TutorController;

public class TutorHireDashboard {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		loginPage();
	}

	private static void loginPage() {
		LoginController lC = new LoginController();
		boolean check = false;
		int choice = 0;
		do {
			System.out.println("********************************************");
			System.out.println("*            Welcome to Tutor Hire         *");
			System.out.println("********************************************");
			System.out.println("Please Select login to continue:");
			System.out.println("\n1. Admin");
			System.out.println("2. User");
			System.out.println("3. User Registration");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = s.nextInt();
			System.out.println("********************************************");
			switch (choice) {
			case 1:
				check = lC.admin();
				if (check) {
					adminUtility();
				}
				break;
			case 2:
				check = lC.user();
				if (check) {
					finalCode();
				}
				break;
			case 3:
				registrationUtility();
				break;
			case 4:
				System.out.println("Thank you for using Tutor Hire. Goodbye!");
				break;
			default:
				System.out.println("Invalid input. Please enter a valid choice.");
			}
		} while (choice != 4);
		s.close();
	}

	private static void finalCode() {
		int option = 0;
		do {
			System.out.println("********************************************");
			System.out.println("*          Tutor Hire Dashboard            *");
			System.out.println("********************************************");
			System.out.println("1. Tutor");
			System.out.println("2. Student");
			System.out.println("3. Hire");
			System.out.println("4. Exit");
			System.out.print("Select an option: ");
			option = s.nextInt();
			System.out.println("********************************************");
			switch (option) {
			case 1:
				tutorUtility();
				break;
			case 2:
				studentUtility();
				break;
			case 3:
				hireUtility();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (option != 4);
	}

	private static void adminUtility() {
		AdminController ac = new AdminController();
		int optionAdmin = 0;
		do {
			System.out.println("********************************************");
			System.out.println("*             Admin Section                *");
			System.out.println("********************************************");
			System.out.println("1. Manage Admin");
			System.out.println("2. Manage Students");
			System.out.println("3. Manage Tutors");
			System.out.println("4. Manage Domains");
			System.out.println("5. View All Students");
			System.out.println("6. Exit");
			System.out.print("Select an option: ");
			optionAdmin = s.nextInt();
			System.out.println("********************************************");
			switch (optionAdmin) {
			case 1:
				ac.manageAdmin();
				break;
			case 2:
				ac.manageStudents();
				break;
			case 3:
				ac.manageTutors();
				break;
			case 4:
				ac.domainManager();
				break;
			case 5:
				ac.viewAllStudents();
				break;
			case 6:
				System.out.println("Exited from Admin Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (optionAdmin != 6);
	}

	private static void registrationUtility() {
		RegistrationController rc = new RegistrationController();
		int optionRegistration = 0;
		do {
			System.out.println("********************************************");
			System.out.println("*         Registration Section             *");
			System.out.println("********************************************");
			System.out.println("1. Register as a Tutor");
			System.out.println("2. Register as a Student");
			System.out.println("3. Check Your Registration Details");
			System.out.println("4. Exit");
			System.out.print("Select an option: ");
			optionRegistration = s.nextInt();
			System.out.println("********************************************");
			switch (optionRegistration) {
			case 1:
				rc.registerAsTutor();
				break;
			case 2:
				rc.registerAsStudent();
				break;
			case 3:
				rc.checkRegistrationDetails();
				break;
			case 4:
				System.out.println("Exited from Registration Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (optionRegistration != 4);
	}

	private static void tutorUtility() {
		TutorController tutorController = new TutorController();
		RegistrationController rC = new RegistrationController();
		int optionTutor = 0;
		if (!rC.checkTutorRegistration()) {
			System.out.println("You are not registered as Tutor.");
			return;
		}
		do {
			System.out.println("********************************************");
			System.out.println("*              Tutor Section               *");
			System.out.println("********************************************");
			System.out.println("1. Update Your Tutor Details");
			System.out.println("2. Delete Tutor profile");
			System.out.println("3. Show All Students");
			System.out.println("4. Hire Requests");
			System.out.println("5. Exit");
			System.out.print("Select an option: ");
			optionTutor = s.nextInt();
			System.out.println("********************************************");
			switch (optionTutor) {
			case 1:
				tutorController.updateTutorDetails();
				break;
			case 2:
				tutorController.deleteTutor();
				;
				break;
			case 3:
				tutorController.showAllStudents();
				break;
			case 4:
				tutorController.hireRequests();
				break;
			case 5:
				System.out.println("Exited from Tutor Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (optionTutor != 5);
	}

	private static void studentUtility() {
		RegistrationController rC = new RegistrationController();
		StudentController studentController = new StudentController();
		int optionStudent = 0;
		if (!rC.checkStudentRegistration()) {
			System.out.println("You are not registered as Student.");
			return;
		}
		do {
			System.out.println("********************************************");
			System.out.println("*             Student Section              *");
			System.out.println("********************************************");
			System.out.println("1. Update Your Student Details");
			System.out.println("2. Delete Student Profile");
			System.out.println("3. Show All Tutors");
			System.out.println("4. Exit");
			System.out.print("Select an option: ");
			optionStudent = s.nextInt();
			System.out.println("********************************************");
			switch (optionStudent) {
			case 1:
				studentController.updateStudentDetails();
				break;
			case 2:
				studentController.revokeStudentRole();
				break;
			case 3:
				studentController.showAllTutor();
				break;
			case 4:
				System.out.println("Exited from Student Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (optionStudent != 4);
	}

	private static void hireUtility() {
		HireController hireController = new HireController();
		int optionHire = 0;
		do {
			System.out.println("********************************************");
			System.out.println("*               Hire Section               *");
			System.out.println("********************************************");
			System.out.println("1. Hire Tutor");
			System.out.println("2. Cancel Hire");
			System.out.println("3. Show Hire Status");
			System.out.println("4. Exit");
			System.out.print("Select an option: ");
			optionHire = s.nextInt();
			System.out.println("********************************************");
			switch (optionHire) {
			case 1:
				hireController.hireTutor();
				break;
			case 2:
				hireController.cancelHire();
				break;
			case 3:
				hireController.showHireStatus();
				break;
			case 4:
				System.out.println("Exited from Hire Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
			}
		} while (optionHire != 4);
	}
}
