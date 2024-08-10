package com.project.service;

import java.util.List;

import com.project.entity.Domain;

public interface DomainService {
	boolean addDomain(Domain domain);

	boolean deleteDomain(int domainId);

	List<Domain> showallDomain();

	Domain searchDomain(int domainId);
}
