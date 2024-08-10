package com.project.dao;

import java.util.List;

import com.project.entity.Student;

public interface StudentDao {
	boolean addStudent(Student student);

	boolean deletStudent(int studentId);

	boolean updateStudent(Student student);

	List<Student> showAllStudent();

	Student getStudent(int studentId);

	boolean searchStudent(int userId);

	Student getStudentUsingUserId(int userId);
}
