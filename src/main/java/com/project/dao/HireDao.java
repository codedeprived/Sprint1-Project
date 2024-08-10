package com.project.dao;

import com.project.dto.Hire;

public interface HireDao {
	boolean hireRequest(Hire hire);

	boolean hireCancelation(int hireId);

}
