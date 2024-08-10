package com.project.controller;

import java.util.List;

import com.project.entity.Tutor;
import com.project.service.TutorService;
import com.project.serviceImpl.TutorServiceImpl;

public class StudentController {
	TutorService tS = new TutorServiceImpl();

	public void updateStudentDetails() {
		// TODO Auto-generated method stub

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
