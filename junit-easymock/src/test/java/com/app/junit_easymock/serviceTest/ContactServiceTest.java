package com.app.junit_easymock.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.app.junit_easymock.controller.ContactDao;
import com.app.junit_easymock.services.ContactService;

public class ContactServiceTest {
	static ContactService cService = null;
	static ContactDao cDao = null;

	@BeforeClass
	public static void beforeClass() {
		cDao = EasyMock.createMock(ContactDao.class);
		EasyMock.expect(cDao.getName(100)).andReturn("sam");
		EasyMock.expect(cDao.getName(101)).andReturn("raj");
		// EasyMock.expect(cDao.getName(103))
		EasyMock.replay(cDao);
	}

	@Test
	public void test_getName1() {
		cService = new ContactService();
		cService.setcDao(cDao);
		String expected = cService.getName(102);
		assertNotNull(expected);

	}

	@Test
	@Ignore
	public void test_getName2() {
		cService = new ContactService();
		cService.setcDao(cDao);
		String expected = cService.getName(103);
		assertNull(expected);

	}

	@AfterClass
	public static void afterClass() {
		cService = null;
		cDao = null;
	}

}
