package com.project.dao;

import java.util.List;

import com.project.entity.Tutor;

public interface TutorDao {
	boolean addTutor(Tutor tutor);

	boolean deleteTutor(int TutorId);

	boolean updateTutorDetials(Tutor tutor);

	List<Tutor> showallTutors();

	boolean searchUser(int userId);

	Tutor getTutor(int userId);

	Tutor getTutorUsingTutorId(int tutorId);
}
