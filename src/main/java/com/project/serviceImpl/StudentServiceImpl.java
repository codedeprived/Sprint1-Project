package com.project.serviceImpl;

import java.util.List;

import com.project.dao.StudentDao;
import com.project.daoImpl.StudentDaoImpl;
import com.project.entity.Student;
import com.project.service.StudentService;

public class StudentServiceImpl implements StudentService {
	StudentDao sD = new StudentDaoImpl();

	@Override
	public boolean addStudent(Student student) {
		boolean added = sD.addStudent(student);
		return added;
	}

	@Override
	public boolean deletStudent(int studentId) {
		boolean deleted = sD.deletStudent(studentId);
		return deleted;
	}

	@Override
	public boolean updateStudent(Student student) {
		boolean updated = sD.updateStudent(student);
		return updated;
	}

	@Override
	public List<Student> showAllStudent() {

		return sD.showAllStudent();
	}

	@Override
	public boolean searchStudent(int userId) {

		return sD.searchStudent(userId);
	}

	@Override
	public Student getStudent(int studentId) {

		return sD.getStudent(studentId);
	}

	@Override
	public Student getStudentUsingUserId(int userId) {

		return sD.getStudentUsingUserId(userId);
	}

}
