/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.parse_customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;

import com.intercom_challenge.customer.Customer;
import com.intercom_challenge.distance_calculator.DistanceCalculator;
import com.intercom_challenge.log_util.LogUtil;

/*
 * ParseCustomer class has functionality to create Customer object using the json object.
 * For each json object, a new customer object is created. 
 *
 * @version 1.0  
 * @author Saathvik Shashidhar Gowrapura
 */
public class ParseCustomer {
	/*
	 * This list holds customers, who are within 100km of the Dublin office.
	 */
	static ArrayList<Customer> customersToInviteList = new ArrayList<Customer>();
	
	/*
	 * logger to take care of logging duties when an exception arises
	 */
	static Logger logger = null;
	
	/*
	 * This method accepts a json object and sets the fields of customer object to 
	 * its respective values.
	 * It calls a method of DistanceCalculator class to calculate the distance of
	 * customer from Dublin office.
	 * If the distance is within 100km, then customer is added to a list.
	 * 
	 * @param obj: This is of type JSONObject. It is a json representation of customer.
	 * It has key-value pairs. 
	 */
	public void getCustomerFromJson(JSONObject obj) throws SecurityException, IOException {
		try {
			DistanceCalculator distanceCalculator = new DistanceCalculator();
			Customer customer = new Customer();
			if(logger == null)
			logger = LogUtil.getLogger();
			
			if((long)obj.get("user_id") < 0)
				throw new NumberFormatException("User id cannot be negative");
			else if((long)obj.get("user_id") > Long.MAX_VALUE)
				throw new NumberFormatException("User id should not exceed long datatype limit");
			customer.setId((long)obj.get("user_id"));

			if((String)obj.get("name") == null || ((String)obj.get("name")).length() == 0)
				throw new NullPointerException("Name cannot be empty or null");
			customer.setName((String)obj.get("name"));
			
			if((String)obj.get("latitude") == null)
				throw new NullPointerException("Latitude cannot be null");
			else if(((String)obj.get("latitude")).length() == 0)
				throw new NumberFormatException("Latitude cannot be empty");
			customer.setLatitude(Double.parseDouble((String)obj.get("latitude")));
			
			if((String)obj.get("longitude") == null)
				throw new NullPointerException("Longitude cannot be null");
			else if(((String)obj.get("longitude")).length() == 0)
				throw new NumberFormatException("Longitude cannot be empty");
			customer.setLongitude(Double.parseDouble((String)obj.get("longitude")));
			
			double distance = distanceCalculator.customerDistanceToDublin(customer.getLatitude(), customer.getLongitude());
			customer.setDistance(distance);
			if(customer.getDistance() <= 100.00)
				customersToInviteList.add(customer);
		}
		catch(NumberFormatException ex) {
			logger.log(Level.INFO, "NumberFormatException caught. ", ex);
		}
		catch(IllegalArgumentException ex) {
			logger.log(Level.INFO, "IllegalArgumentException caught. ", ex);
		}
		catch (NullPointerException ex) {
			logger.log(Level.INFO, "NullPointerException caught. ", ex);
		}
		catch(ClassCastException ex) {
			logger.log(Level.INFO, "ClassCastException caught. ", ex);
		}		
	}
	
	/*
	 * This method returs a list of customers, who are within 100km of the Dublin Office
	 */
	public ArrayList<Customer> getCustomersToInviteList() {
		return customersToInviteList;
	}
}
