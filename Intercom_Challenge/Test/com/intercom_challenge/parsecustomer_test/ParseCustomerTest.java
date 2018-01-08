/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */
package com.intercom_challenge.parsecustomer_test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.intercom_challenge.file_util.FileUtil;
import com.intercom_challenge.parse_customer.ParseCustomer;

import org.junit.Before;

/*
 * This class tests the functionality for ParseCustomer class
 * 
 * @version 1.0
 * @author Saathvik Shashidhar Gowrapura
 */ 
public class ParseCustomerTest {

	FileUtil fileUtil;
	ParseCustomer parseCustomer;
	
	@Before
	public void init() {
		fileUtil = new FileUtil();
		parseCustomer = new ParseCustomer();
		fileUtil.readFromFile();
	}
	/*@Test
	public void testGetCustomerFromJsonPass() {
		ArrayList<Customer> list = parseCustomer.getCustomersToInviteList();
		for(Customer customer: list) {
			System.out.println(customer.getId());
		}
		assertEquals("Checking get customer from json function", 1, parseCustomer.getCustomersToInviteList().size());
	}*/
	
	@Test
	public void testGetCustomerFromJsonFail() {
		assertNotEquals("Checking get customer from json function", 2, parseCustomer.getCustomersToInviteList().size());
	}
	
}
