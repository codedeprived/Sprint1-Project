package com.project.serviceImpl;

import java.util.List;

import com.project.dao.DomainDao;
import com.project.daoImpl.DomainDaoImpl;
import com.project.entity.Domain;
import com.project.service.DomainService;

public class DomainServiceImpl implements DomainService {
	DomainDao dD = new DomainDaoImpl();

	@Override
	public boolean addDomain(Domain domain) {
		boolean added = dD.addDomain(domain);
		return added;
	}

	@Override
	public boolean deleteDomain(int domainId) {
		boolean deleted = dD.deleteDomain(domainId);
		return deleted;
	}

	@Override
	public List<Domain> showallDomain() {
		return dD.showAllDomain();
	}

	@Override
	public Domain searchDomain(int domainId) {

		return dD.searchDomain(domainId);
	}

}
