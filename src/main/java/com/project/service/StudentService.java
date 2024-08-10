package com.project.service;

import java.util.List;

import com.project.dto.Student;

public interface StudentService {

	boolean addStudent(Student student);

	boolean deletStudent(int studentId);

	boolean updateStudent(Student student);

	List<Student> showAllStudent();

	boolean searchStudent(int i);

	Student getStudent(int studentId);

}
