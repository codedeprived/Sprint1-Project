package com.project.service;

import com.project.dto.Hire;

public interface HireService {
	boolean hireRequest(Hire hire);

	boolean hireCancelation(int hireId);

}
