package com.project.dao;

import java.util.List;

import com.project.dto.Student;

public interface StudentDao {
	boolean addStudent(Student student);

	boolean deletStudent(int studentId);

	boolean updateStudent(Student student);

	List<Student> showAllStudent();

	Student getStudent(int userId);

	boolean searchStudent(int userId);
}
