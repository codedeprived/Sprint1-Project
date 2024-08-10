package com.project.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_hire")
public class Hire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hire_id", nullable = false)
	private int hireId;

	@Column(name = "student_id", nullable = false)
	private int studentId;

	@Column(name = "tutor_id", nullable = false)
	private int tutorId;

	@Column(name = "start_time", nullable = false)
	private LocalTime startTime;

	@Column(name = "end_time", nullable = false)
	private LocalTime endTime;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;

	public enum Status {
		PENDING, CONFIRMED, CANCELLED
	}

	// Getters and Setters
	public int getHireId() {
		return hireId;
	}

	public void setHireId(int hireId) {
		this.hireId = hireId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Hire(int studentId, int tutorId, LocalTime startTime, LocalTime endTime, Status status) {
		super();
		this.studentId = studentId;
		this.tutorId = tutorId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public Hire(int hireId, int studentId, int tutorId, LocalTime startTime, LocalTime endTime, Status status) {
		super();
		this.hireId = hireId;
		this.studentId = studentId;
		this.tutorId = tutorId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Hire [hireId=" + hireId + ", studentId=" + studentId + ", tutorId=" + tutorId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", status=" + status + "]";
	}

	public Hire() {
		super();
	}

}
