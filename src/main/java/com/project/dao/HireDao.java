package com.project.dao;

import com.project.entity.Hire;

public interface HireDao {
	boolean hireRequest(Hire hire);

	boolean hireCancelation(int hireId);

	Hire getHireRequest(int tutorId);

	Hire getHireStatus(int studentId);

}
