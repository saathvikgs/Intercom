/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.customer;

/*
 * Customer class represents a customer.
 * I has fields for Customer Id, Name, Distance from office, Latitude and Longitude.
 * IT has getter and setter methods to interact with these fields
 * 
 * @version 1.0  
 * @author Saathvik Shashidhar Gowrapura
 */
public class Customer {
	private long id;
	private double distance;
	private String name;
	private double latitude;
	private double longitude;
	
	public Customer() {
		super();
	}
	
	public Customer(long id, double distance, String name, double latitude, double longitude) {
		super();
		this.id = id;
		this.distance = distance;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}	
}
