package com.project.service;

import java.util.List;

import com.project.dto.Tutor;

public interface TutorService {
	boolean addTutor(Tutor tutor);

	boolean deleteTutor(int TutorId);

	boolean updateTutorDetials(Tutor tutor);

	List<Tutor> showallTutors();

	boolean searchTutor(int i);

	Tutor getTutor(int tutorId);

}
