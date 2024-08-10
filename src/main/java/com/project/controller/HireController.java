package com.project.controller;

import java.util.List;
import java.util.Scanner;

import com.project.dto.Domain;
import com.project.dto.Hire;
import com.project.dto.Hire.Status;
import com.project.dto.Student;
import com.project.dto.Tutor;
import com.project.dto.User;
import com.project.service.DomainService;
import com.project.service.HireService;
import com.project.service.StudentService;
import com.project.service.TutorService;
import com.project.service.UserService;
import com.project.serviceImpl.DomainServiceImpl;
import com.project.serviceImpl.HireServiceImpl;
import com.project.serviceImpl.StudentServiceImpl;
import com.project.serviceImpl.TutorServiceImpl;
import com.project.serviceImpl.UserServiceImpl;

public class HireController {
	Scanner sc = new Scanner(System.in);
	TutorService tS = new TutorServiceImpl();
	UserService uS = new UserServiceImpl();
	DomainService dS = new DomainServiceImpl();
	StudentService sS = new StudentServiceImpl();
	HireService hS = new HireServiceImpl();

	public void hireTutor() {
		List<Tutor> tutors = tS.showallTutors();
		for (Tutor tutor : tutors) {
			User user = tutor.getUser();
			Domain domain = dS.searchDomain(tutor.getDomainId());
			System.out.println("Tutor id : " + tutor.getTutorId() + " Tutor Name : " + "" + user.getUsername()
					+ " Email : " + user.getEmail() + " Domain Name : " + domain.getDomainname());
		}
		System.out.println("Select Tutor to Hire :");
		System.out.println("Tutor ID : ");
		int tutorId = sc.nextInt();
		Tutor tutor = tS.getTutor(tutorId);
		System.out.println("Enter your email to confirm Hiring : ");
		String email = sc.next();
		User userStudent = uS.getUser(email);
		if (userStudent != null) {
			Student student = sS.getStudent(userStudent.getUserId());
			if (student != null) {
				Hire hire = new Hire(tutorId, student.getStudentId(), tutor.getAvailabilityStart(),
						tutor.getAvailabilityEnd(), Status.PENDING);
				boolean request = hS.hireRequest(hire);
				if (request) {
					System.out.println("Request is sent Please wait to check Status ");
				}
			}
		}
	}

	public void cancelHire() {
		// TODO Auto-generated method stub

	}

	public void showPreviousHires() {
		// TODO Auto-generated method stub

	}

}
