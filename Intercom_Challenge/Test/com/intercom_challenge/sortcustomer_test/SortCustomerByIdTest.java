/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.sortcustomer_test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import com.intercom_challenge.customer.Customer;
import com.intercom_challenge.sort_customer.SortCustomerById;


/*
 * This class tests the functionality for SortCustomerById class
 * 
 * @version 1.0
 * @author Saathvik Shashidhar Gowrapura
 */ 
public class SortCustomerByIdTest {
	
	SortCustomerById sort;
	ArrayList<Customer> testCustomerList = new ArrayList<>();
	@Before
	public void init() {
		sort = new SortCustomerById();
		Customer customer1 = new Customer(12, 52.33, "cust1", 54.1221, -6.5472);
		Customer customer2 = new Customer(7, 12.494, "cust2 ", 53.53813, -6.56235);
		Customer customer3 = new Customer(5, 99.999, "cust3", 52.43615, -6.8157);
		Customer customer4 = new Customer(16, 87.64, "cust4", 53.1221, -7);
		testCustomerList.add(customer1);
		testCustomerList.add(customer2);
		testCustomerList.add(customer3);
		testCustomerList.add(customer4);
	}
	
	@Test
	public void testComparePass() {
		Customer customer1 = new Customer(1, 52.33, "cust1", 54.1221, -6.5472);
		Customer customer2 = new Customer(2, 12.494, "cust2 ", 53.53813, -6.56235);
		assertEquals("Testing compare functionality", -1, sort.compare(customer1, customer2));
	}
	
	@Test
	public void testCompareFail() {
		Customer customer1 = new Customer(1, 52.33, "cust1", 54.1221, -6.5472);
		Customer customer2 = new Customer(2, 12.494, "cust2 ", 53.53813, -6.56235);
		assertNotEquals("Testing compare functionality", 1, sort.compare(customer1, customer2));
	}
	
	@Test
	public void testDisplayCustomersSortedById() {
		Collections.sort(testCustomerList, sort);
		sort.displayCustomersSortedById(testCustomerList);
	}
}
