package com.project.service;

import java.util.List;

import com.project.entity.Tutor;

public interface TutorService {
	boolean addTutor(Tutor tutor);

	boolean deleteTutor(int TutorId);

	boolean updateTutorDetials(Tutor tutor);

	List<Tutor> showallTutors();

	boolean searchTutor(int i);

	Tutor getTutor(int userId);

	Tutor getTutorUserTutorId(int tutorId);

}
