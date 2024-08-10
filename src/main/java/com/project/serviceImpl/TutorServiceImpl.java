package com.project.serviceImpl;

import java.util.List;

import com.project.dao.TutorDao;
import com.project.daoImpl.TutorDaoImpl;
import com.project.entity.Tutor;
import com.project.service.TutorService;

public class TutorServiceImpl implements TutorService {
	TutorDao tD = new TutorDaoImpl();

	@Override
	public boolean addTutor(Tutor tutor) {
		boolean added = tD.addTutor(tutor);
		return added;
	}

	@Override
	public boolean deleteTutor(int TutorId) {
		boolean deleted = tD.deleteTutor(TutorId);
		return deleted;
	}

	@Override
	public boolean updateTutorDetials(Tutor tutor) {
		boolean updated = tD.updateTutorDetials(tutor);
		return updated;
	}

	@Override
	public List<Tutor> showallTutors() {
		List<Tutor> tutors = tD.showallTutors();
		return tutors;
	}

	@Override
	public boolean searchTutor(int userId) {

		return tD.searchUser(userId);
	}

	@Override
	public Tutor getTutor(int userId) {

		return tD.getTutor(userId);
	}

	@Override
	public Tutor getTutorUserTutorId(int tutorId) {

		return tD.getTutorUsingTutorId(tutorId);
	}

}
