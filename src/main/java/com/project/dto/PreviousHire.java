package com.project.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_previousHire")
public class PreviousHire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "previous_hire_id", nullable = false)
	private int previousHireId;

	@Column(name = "student_id", nullable = false)
	private Student student;

	@Column(name = "tutor_id", nullable = false)
	private Tutor tutor;

	@Column(name = "hire_date", nullable = false)
	private LocalDate hireDate;

	@Column(name = "start_time", nullable = false)
	private LocalTime startTime;

	@Column(name = "end_time", nullable = false)
	private LocalTime endTime;

	public int getPreviousHireId() {
		return previousHireId;
	}

	public void setPreviousHireId(int previousHireId) {
		this.previousHireId = previousHireId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
}
