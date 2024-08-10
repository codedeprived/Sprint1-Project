package com.project.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tutor")
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tutor_id", nullable = false)
	private int tutorId;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@Column(name = "availability_start", nullable = false)
	private LocalTime availabilityStart;

	@Column(name = "availability_end", nullable = false)
	private LocalTime availabilityEnd;

	@Column(name = "domain_id")
	private int domainId;

	public Tutor() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tutor(int tutorId, User user, LocalTime availabilityStart, LocalTime availabilityEnd, int domainId) {
		super();
		this.tutorId = tutorId;
		this.user = user;
		this.availabilityStart = availabilityStart;
		this.availabilityEnd = availabilityEnd;
		this.domainId = domainId;
	}

	public Tutor(User user, LocalTime availabilityStart, LocalTime availabilityEnd, int domainId) {
		super();
		this.user = user;
		this.availabilityStart = availabilityStart;
		this.availabilityEnd = availabilityEnd;
		this.domainId = domainId;
	}

	// Getters and Setters
	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public LocalTime getAvailabilityStart() {
		return availabilityStart;
	}

	public void setAvailabilityStart(LocalTime availabilityStart) {
		this.availabilityStart = availabilityStart;
	}

	public LocalTime getAvailabilityEnd() {
		return availabilityEnd;
	}

	public void setAvailabilityEnd(LocalTime availabilityEnd) {
		this.availabilityEnd = availabilityEnd;
	}

	public int getDomainId() {
		return domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	@Override
	public String toString() {
		return "Tutor [tutorId=" + tutorId + ", availabilityStart=" + availabilityStart + ", availabilityEnd="
				+ availabilityEnd + ", domainId=" + domainId + "]";
	}
}
