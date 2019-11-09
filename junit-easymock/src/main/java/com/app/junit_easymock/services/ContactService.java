package com.app.junit_easymock.services;

import com.app.junit_easymock.controller.ContactDao;

public class ContactService {
	private ContactDao cDao;
	
	public void setcDao(ContactDao cDao) {
		this.cDao = cDao;
	}

	public String getName(int cId) {
		String name =cDao.getName(cId);
		return name;
		
	}

}
