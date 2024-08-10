package com.project.controller;

import java.util.List;
import java.util.Scanner;

import com.project.entity.Domain;
import com.project.entity.Hire;
import com.project.entity.Hire.Status;
import com.project.entity.Student;
import com.project.entity.Tutor;
import com.project.entity.User;
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
			System.out.println(student);
			if (student != null) {

				Hire hire = new Hire(student.getStudentId(), tutorId, tutor.getAvailabilityStart(),
						tutor.getAvailabilityEnd(), Status.PENDING);
				System.out.println(hire);
				boolean request = hS.hireRequest(hire);
				if (request) {
					System.out.println("Request is sent Please wait to check Status ");
				}
			} else {
				System.out.println("Somethign went wrong ");
			}
		}
	}

	public void cancelHire() {
		// TODO Auto-generated method stub

	}

	public void showHireStatus() {
		System.out.println("Enter your email ");
		String email = sc.next();
		User user = uS.getUser(email);

		if (user != null) {
			Student student = sS.getStudentUsingUserId(user.getUserId());
			if (student != null) {
				Hire hire = hS.getHireStatus(student.getStudentId());
				if (hire != null) {
					Tutor tutor = tS.getTutorUserTutorId(hire.getTutorId());

					System.out.println(" Tutor name : " + tutor.getUser().getUsername() + "\ntutor availabilty "
							+ tutor.getAvailabilityStart() + "\n tutor email: " + tutor.getUser().getEmail()
							+ "\nStatus : " + hire.getStatus());
				} else {
					System.out.println("no hiring record found ");
					return;
				}
			} else {
				System.out.println("student not found :");
				return;
			}
		} else {
			System.out.println("user not foudn : ");
			return;
		}

	}

}
