/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.distnace_calculator_test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.intercom_challenge.customer.Customer;
import com.intercom_challenge.distance_calculator.DistanceCalculator;

import org.junit.Before;

/*
 * This class tests the functionality for Distance Calculator class
 * 
 * @version 1.0
 * @author Saathvik Shashidhar Gowrapura
 */
public class DistanceCalculatorTest {
	
	DistanceCalculator distanceCalculator;
	ArrayList<Customer> testCustomerList = new ArrayList<Customer>();
	@Before
	public void init() {
		distanceCalculator = new DistanceCalculator();
		Customer customer1 = new Customer(1, 52.33, "cust1", 54.1221, -6.5472);
		Customer customer2 = new Customer(2, 12.494, "cust2 ", 53.53813, -6.56235);
		Customer customer3 = new Customer(1, 99.999, "cust3", 52.43615, -6.8157);
		Customer customer4 = new Customer(1, 100.001, "cust4", 53.1221, -7);
		testCustomerList.add(customer1);
		testCustomerList.add(customer2);
		testCustomerList.add(customer3);
		testCustomerList.add(customer4);
	}
	
	@Test
	public void degreeToRadianTestPass() {
		assertEquals("Testing degree to radian conversion", 0.783072 * (Math.PI/ 180.00), distanceCalculator.degreeToRadian(0.783072), 0);
	}
	
	@Test
	public void degreeToRadianTestFail() {
		assertNotEquals("Testing degree to radian conversion", 0.01366714, distanceCalculator.degreeToRadian(0.783072), 0);
	}
	
	@Test
	public void radiantoKmTestPass() {
		assertEquals("Testing radian to kilometer conversion", 87.07334894, distanceCalculator.radianToKm(0.01366714), 0);
	}
	
	@Test
	public void radiantoKmTestFail() {
		assertNotEquals("Testing radian to kilometer conversion", 100.073, distanceCalculator.radianToKm(0.01366714), 0);
	}
	
	@Test
	public void customerDistanceToDublinTestPass() {
		assertEquals("Testting customer distance to Dublin office", 62.23170226292825, distanceCalculator.customerDistanceToDublin(53, -7), 0);
	}
	
	@Test
	public void customerDistanceToDublinTestFail() {
		assertNotEquals("Testting customer distance to Dublin office", 62.23170, distanceCalculator.customerDistanceToDublin(53, -7), 0);
	}
}
