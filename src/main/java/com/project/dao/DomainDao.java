package com.project.dao;

import java.util.List;

import com.project.entity.Domain;

public interface DomainDao {

	List<Domain> showAllDomain();

	boolean addDomain(Domain domain);

	boolean deleteDomain(int domainId);

	Domain searchDomain(int domainId);
}
