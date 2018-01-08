/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.customer_test;

import static org.junit.Assert.*;
import org.junit.Test;
/*import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;*/

import com.intercom_challenge.customer.Customer;

import org.junit.Before;

/*
 * This class tests the functionality for Customer class
 * 
 * @version 1.0
 * @author Saathvik Shashidhar Gowrapura
 */
public class CustomerTest {
	Customer customer;
	@Before
	public void init() {
		customer = new Customer();
	}
	
	@Test
	public void testGetIdPass() {
		customer.setId(1);
		assertEquals("Setting customer user id to 1", 1, customer.getId());
	}
	
	@Test
	public void testGetIdFail() {
		customer.setId(2);
		assertNotEquals("Setting customer user id to 2", 4, customer.getId());
	}
	
	@Test
	public void testGetNamePass() {
		customer.setName("name1");
		assertEquals("Setting customer name to name1", "name1", customer.getName());
	}
	
	@Test
	public void testGetNameFail() {
		customer.setName("name2");
		assertNotEquals("Setting customer name to name2", "name", customer.getName());
	}

	@Test
	public void testGetLatitudePass() {
		customer.setLatitude(52.34);
		assertEquals("Setting customer latitude to 52.34", 52.34, customer.getLatitude(), 0);
	}
	
	@Test
	public void testGetLatitudeFail() {
		customer.setLatitude(58.3412);
		assertNotEquals("Setting customer latitude to 58.3412", 52.34, customer.getLatitude(), 0);
	}
	
	@Test
	public void testGetLongitudePass() {
		customer.setLongitude(-58.34);
		assertEquals("Setting customer longitude to -58.34", -58.34, customer.getLatitude(), 116.68);
	}
	
	@Test
	public void testGetLongitudeFail() {
		customer.setLongitude(6.3251);
		assertNotEquals("Setting customer latitude to 6.3251", 6.31, customer.getLongitude(), 0);
	}
}
