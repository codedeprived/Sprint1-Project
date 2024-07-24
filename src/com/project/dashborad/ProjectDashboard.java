package com.project.dashborad;

import java.util.Scanner;

import com.project.controller.UserController;

public class ProjectDashboard {

	static Scanner s = new Scanner(System.in);
	static int userCount = 0;

	public static void main(String[] args) {
		finalCode();

	}

	private static void finalCode() {
		int option = 0;

		do {
			System.out.println("Welcome to Dashboard\n=====================================");
			System.out.println(
					"1. Select 1 for User\n2. Select 2 for Product\n3. Select 3 for Cart\n4. Select 4 for Order\n5. Select 5 for Exit");
			option = s.nextInt();
			switch (option) {
			case 1:
				userUtility();
				break;
			case 2:
				productUtility();
				break;
			case 3:
				cartUtility();
				break;
			case 4:
				orderUtility();
				break;
			case 5:
				System.out.println("Exiting...");
				s.close();
				break;
			default:
				System.out.println("Invalid option. Please select again.");
				break;
			}
		} while (option != 5);

		s.close();
	}

	private static void userUtility() {
		UserController uc = new UserController();
		int optionUser = 0;
		do {
			System.out.println("1. Select 1 Add User\n2. Select 2 Delete User\n3. Select 3 Update User"
					+ "\n4. Select 4 to Show All User\n5. Select 5 to Search Any User\n6. Select 6 for Exit");
			optionUser = s.nextInt();
			switch (optionUser) {
			case 1:
				uc.createUser();
				userCount++;
				break;
			case 2:
				uc.deleteUser();
				userCount--;
				break;
			case 3:
				uc.updateUser();
				break;
			case 4:
				uc.showAllUser();
				System.out.println("Total user : " + userCount);
				break;
			case 5:
				uc.searchUser();
				break;
			case 6:
				System.out.println("Exited from User Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
				break;
			}
		} while (optionUser != 6);
	}

	private static void productUtility() {
		int optionProduct = 0;
		do {
			System.out.println("1. Select 1 Add Product\n2. Select 2 Delete Product\n3. Select 3 Update Product"
					+ "\n4. Select 4 to Show All Product\n5. Select 5 to Show Any Product\n6. Select 6 for Exit");
			optionProduct = s.nextInt();
			switch (optionProduct) {
			case 1:
				break;
			case 2:
				System.out.println("Delete Product...");
				break;
			case 3:
				System.out.println("Update Product...");
				break;
			case 4:
				System.out.println("Show All Product...");
				break;
			case 5:
				System.out.println("Show Any Product...");
				break;
			case 6:
				System.out.println("Exited from Product Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
				break;
			}
		} while (optionProduct != 6);
	}

	private static void cartUtility() {
		int optionCart = 0;
		do {
			System.out.println("1. Select 1 Add to Cart\n2. Select 2 Delete From Cart\n3. Select 3 for Exit");
			optionCart = s.nextInt();
			switch (optionCart) {
			case 1:
				System.out.println("Add to Cart...");
				break;
			case 2:
				System.out.println("Delete From Cart...");
				break;
			case 3:
				System.out.println("Exited from Cart Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
				break;
			}
		} while (optionCart != 3);
	}

	private static void orderUtility() {
		int optionOrder = 0;
		do {
			System.out.println("1. Select 1 to Book an Order\n2. Select 2 to Cancel the Order\n3. Select 3 for Exit");
			optionOrder = s.nextInt();
			switch (optionOrder) {
			case 1:
				System.out.println("Book an Order...");
				break;
			case 2:
				System.out.println("Cancel the Order...");
				break;
			case 3:
				System.out.println("Exited from Order Section Successfully...");
				break;
			default:
				System.out.println("Invalid option. Please select again.");
				break;
			}
		} while (optionOrder != 3);
	}
}
