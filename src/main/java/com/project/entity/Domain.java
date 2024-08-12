package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_domain")
public class Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "domain_id", nullable = false, unique = true, length = 100)
	private int domainId;

	@Column(name = "domainname", nullable = false, unique = true, length = 100)
	private String domainname;

	@Column(name = "description", columnDefinition = "TEXT")
	private String description;

	public Domain(String domainname, String description) {
		super();
		this.domainname = domainname;
		this.description = description;
	}

	public Domain(int domainId, String domainname, String description) {
		super();
		this.domainId = domainId;
		this.domainname = domainname;
		this.description = description;
	}

	public Domain() {
		super();
	}

	// Getters and Setters
	public int getDomainId() {
		return domainId;
	}

	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}

	public String getDomainname() {
		return domainname;
	}

	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return " domainname=" + domainname + "]";
	}

}
