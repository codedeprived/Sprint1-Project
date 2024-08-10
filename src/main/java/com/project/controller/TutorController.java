package com.project.controller;

import java.util.List;

import com.project.dto.Student;
import com.project.dto.User;
import com.project.service.StudentService;
import com.project.service.UserService;
import com.project.serviceImpl.StudentServiceImpl;
import com.project.serviceImpl.UserServiceImpl;

public class TutorController {
	StudentService sS = new StudentServiceImpl();
	UserService uS = new UserServiceImpl();

	public void updateTutorDetails() {
		// TODO Auto-generated method stub

	}

	public void revokeTutorRole() {
		// TODO Auto-generated method stub

	}

	public void showAllStudents() {
		List<Student> students = sS.showAllStudent();

		for (Student student : students) {
			User user = student.getUser();
			System.out.println("Student Id: " + student.getStudentId() + "Student name : " + user.getUsername()
					+ "email : " + user.getEmail());
		}

	}

}
