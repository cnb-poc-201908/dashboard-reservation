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
 * @creation Aug 17, 2019
 */
public class BasicInfoServiceTest {

	/**
	 * Test method for {@link com.bmw.service.BasicInfoService#getAllBasicInfoList()}.
	 */
	@Test
	public void testGetAllBasicInfoList() {
		BasicInfoService bis = new BasicInfoServiceImpl();
		bis.getAllBasicInfoList();
		assertTrue(true);
	}

	/**
	 * Test method for {@link com.bmw.service.BasicInfoService#getPackageList()}.
	 */
	@Test
	public void testGetPackageList() {
		BasicInfoService bis = new BasicInfoServiceImpl();
		bis.getPackageList();
		assertTrue(true);
	}

}
