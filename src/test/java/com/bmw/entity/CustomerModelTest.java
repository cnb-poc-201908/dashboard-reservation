/**
 * 
 */
package com.bmw.entity;

import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * 
 *
 * @author bo
 * @creation Aug 19, 2019
 */
public class CustomerModelTest {

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setMagic(java.lang.String)}.
	 */
	
	CustomerModel cm = new CustomerModel();
	@Test
	public void testSetMagic() {
		cm.setMagic("magic");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getMagic()}.
	 */
	@Test
	public void testGetMagic() {
		cm.getMagic();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		cm.setTitle("title");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		cm.getTitle();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setSurname(java.lang.String)}.
	 */
	@Test
	public void testSetSurname() {
		cm.setSurname("surname");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getSurname()}.
	 */
	@Test
	public void testGetSurname() {
		cm.getSurname();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setSalute(java.lang.String)}.
	 */
	@Test
	public void testSetSalute() {
		cm.setSalute("salute");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getSalute()}.
	 */
	@Test
	public void testGetSalute() {
		cm.getSalute();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setPhone(java.lang.String)}.
	 */
	@Test
	public void testSetPhone() {
		cm.setPhone("phone");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getPhone()}.
	 */
	@Test
	public void testGetPhone() {
		cm.getPhone();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setAddress1(java.lang.String)}.
	 */
	@Test
	public void testSetAddress1() {
		cm.setAddress1("address1");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getAddress1()}.
	 */
	@Test
	public void testGetAddress1() {
		cm.getAddress1();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setAddress2(java.lang.String)}.
	 */
	@Test
	public void testSetAddress2() {
		cm.setAddress2("address2");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getAddress2()}.
	 */
	@Test
	public void testGetAddress2() {
		cm.getAddress2();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setAddress3(java.lang.String)}.
	 */
	@Test
	public void testSetAddress3() {
		cm.setAddress3("address3");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getAddress3()}.
	 */
	@Test
	public void testGetAddress3() {
		cm.getAddress3();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setAddress4(java.lang.String)}.
	 */
	@Test
	public void testSetAddress4() {
		cm.setAddress4("address4");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getAddress4()}.
	 */
	@Test
	public void testGetAddress4() {
		cm.getAddress4();
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#setPostcode(java.lang.String)}.
	 */
	@Test
	public void testSetPostcode() {
		cm.setPostcode("postcode");
	}

	/**
	 * Test method for {@link com.bmw.entity.CustomerModel#getPostcode()}.
	 */
	@Test
	public void testGetPostcode() {
		cm.getPostcode();
	}
}
