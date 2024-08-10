package com.project.dao;

import java.util.List;

import com.project.dto.Tutor;

public interface TutorDao {
	boolean addTutor(Tutor tutor);

	boolean deleteTutor(int TutorId);

	boolean updateTutorDetials(Tutor tutor);

	List<Tutor> showallTutors();

	boolean searchUser(int userId);

	Tutor getTutor(int tutorId);
}
