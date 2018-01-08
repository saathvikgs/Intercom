/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.sort_customer;

import java.util.ArrayList;
import java.util.Comparator;

import com.intercom_challenge.customer.Customer;

/*
 * SortCustomerById class has functionality to sort list of customers based on their Ids.
 * This class implements Comparator interface to order objects of Customer class.
 *  
 * @version 1.0  
 * @author Saathvik Shashidhar Gowrapura
 */
public class SortCustomerById implements Comparator<Customer>{

	/*
	 * This method compares Id of two customers. Then returns an integer value based 
	 * 
	 * on comparison.
	 * @param customer1 is of type Customer
	 * @param customer2 is of type Customer
	 */
	@Override
	public int compare(Customer customer1, Customer customer2) throws NullPointerException,
	ClassCastException{
		if(customer1 == null || customer2 == null)
			throw new NullPointerException();
		if(customer1.getId() > customer2.getId())
			return 1;
		else if(customer1.getId() < customer2.getId())
			return -1;
		else
			return 0;
	}
	
	/*
	 * This method displays customers who are within 100km of the Dublin office.
	 * The customers are sorted in ascending order of their ids
	 * 
	 * @param customerToInviteList is of type ArrayList<Customer>
	 */
	public void displayCustomersSortedById(ArrayList<Customer> customerToInviteList) {
		if(customerToInviteList.size() >= 1) {
			System.out.println("Here's the list of customers who are within 100km of the Dublin office. "
					+ "There are " + customerToInviteList.size() + " customers who are within"
							+ " 100km of the Dublin office.");
			try {
				for(Customer customer:customerToInviteList) { 
					System.out.println(customer.getId() + " " + customer.getName());
				}
			}catch(NullPointerException ex) {
				System.out.println("Customer  cannot be null");
			}catch(ClassCastException ex) {
				System.out.println("Argument is not compatible. Should be of type Customer" + ex);
			}
		}
	}
}
