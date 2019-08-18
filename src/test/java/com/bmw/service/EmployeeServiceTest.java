/**
 * 
 */
package com.bmw.service;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * 
 *
 * @author bo
 * @creation Aug 18, 2019
 */
public class EmployeeServiceTest {

	/**
	 * Test method for {@link com.bmw.service.EmployeeService#EmployeeServiceGetAll()}.
	 */
	@Test
	public void testEmployeeServiceGetAll() {
		EmployeeService es = new EmployeeServiceImpl();
		es.EmployeeServiceGetAll();
		assertTrue(true);
	}

	/**
	 * Test method for {@link com.bmw.service.EmployeeService#StationGetAll()}.
	 */
	@Test
	public void testStationGetAll() {
		EmployeeService es = new EmployeeServiceImpl();
		es.StationGetAll();
		assertTrue(true);
	}

}
