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

	@OneToOne
	@JoinColumn(name = "domain_id", referencedColumnName = "domain_id")
	private Domain domain;

	public Tutor() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// Getters and Setters
	public int getTutorId() {
		return tutorId;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
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

	public Tutor(int tutorId, User user, LocalTime availabilityStart, LocalTime availabilityEnd, Domain domain) {
		super();
		this.tutorId = tutorId;
		this.user = user;
		this.availabilityStart = availabilityStart;
		this.availabilityEnd = availabilityEnd;
		this.domain = domain;
	}

	public Tutor(User user, LocalTime availabilityStart, LocalTime availabilityEnd, Domain domain) {
		super();
		this.user = user;
		this.availabilityStart = availabilityStart;
		this.availabilityEnd = availabilityEnd;
		this.domain = domain;
	}

	@Override
	public String toString() {
		return "Tutor [tutorId=" + tutorId + ", user=" + user + ", availabilityStart=" + availabilityStart
				+ ", availabilityEnd=" + availabilityEnd + ", domain=" + domain + "]";
	}

}
