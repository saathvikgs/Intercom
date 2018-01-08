/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge;

import java.util.ArrayList;
import java.util.Collections;

import com.intercom_challenge.customer.Customer;
import com.intercom_challenge.file_util.*;
import com.intercom_challenge.parse_customer.ParseCustomer;
import com.intercom_challenge.sort_customer.SortCustomerById;

public class Invitation {

	public static void main(String[] args) {
		FileUtil fileUtil = new FileUtil();
		fileUtil.readFromFile();

		ParseCustomer parseCustomer = new ParseCustomer();
		ArrayList<Customer> customerToInviteList = parseCustomer.getCustomersToInviteList();
		
		SortCustomerById sort = new SortCustomerById();
		try {
		Collections.sort(customerToInviteList, sort);
		} catch(NullPointerException ex) {
			System.out.println("Customer cannot be null. " + ex);
		}
		catch(ClassCastException ex) {
			System.out.println("Arguments are not compatible. " + ex);
		}
		finally {
			System.gc();
		}
		sort.displayCustomersSortedById(customerToInviteList);
	}

}
