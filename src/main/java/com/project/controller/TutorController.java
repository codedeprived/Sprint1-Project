package com.project.controller;

import java.util.List;
import java.util.Scanner;

import com.project.entity.Hire;
import com.project.entity.Hire.Status;
import com.project.entity.Student;
import com.project.entity.Tutor;
import com.project.entity.User;
import com.project.service.HireService;
import com.project.service.StudentService;
import com.project.service.TutorService;
import com.project.service.UserService;
import com.project.serviceImpl.HireServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;
import com.project.serviceImpl.TutorServiceImpl;
import com.project.serviceImpl.UserServiceImpl;

public class TutorController {
	StudentService sS = new StudentServiceImpl();
	UserService uS = new UserServiceImpl();
	TutorService tS = new TutorServiceImpl();
	HireService hS = new HireServiceImpl();
	Scanner sc = new Scanner(System.in);

	public void updateTutorDetails() {

	}

	public void deleteTutor() {
		//
	}

	public void showAllStudents() {
		List<Student> students = sS.showAllStudent();
		for (Student student : students) {
			User user = student.getUser();
			System.out.println("\nStudent Id: " + student.getStudentId() + "\nStudent name : " + user.getUsername()
					+ "\nemail : " + user.getEmail());
		}

	}

	public void hireRequests() {
		System.out.println("Enter your email..");
		String email = sc.next();
		User user = uS.getUser(email);
		if (user != null) {
			Tutor tutor = tS.getTutor(user.getUserId());
			if (tutor != null) {
				Hire hire = hS.getHireRequest(tutor.getTutorId());
				if (hire != null) {
					Student student = sS.getStudent(hire.getStudentId());
					User studentUser = student.getUser();
					System.out.println("\nStudent Name : " + studentUser.getUsername() + "\nStudent email : "
							+ studentUser.getEmail() + "\nStatus : " + hire.getStatus());
					System.out.println("do you want Accept the Hire request Y/N : ?");
					char choice = sc.next().charAt(0);
					if (choice == 'Y' || choice == 'y') {
						hire.setStatus(Status.CONFIRMED);
						boolean updated = hS.hireRequest(hire);
						if (updated) {
							System.out.println("Request Accepted :");
						}
					} else {
						hire.setStatus(Status.CANCELLED);
						boolean updated = hS.hireRequest(hire);
						if (updated) {
							System.out.println("Request Cancelled :");
						}
					}
				}
				{
					System.out.println("No pending Requests :");
				}

			} else {
				System.out.println("email not associated with any tutor :");
			}

		}

		else {
			System.out.println("enter correct email: ");
		}
	}

}
