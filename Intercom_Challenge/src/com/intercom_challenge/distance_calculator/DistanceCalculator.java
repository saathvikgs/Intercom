/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.distance_calculator;

/*
 * DistanceCalculator class has functionality to calculate distance of a customer 
 * from Dublin office.
 *
 * @version 1.0  
 * @author Saathvik Shashidhar Gowrapura
 */
public class DistanceCalculator {
	//private ArrayList<Customer> customersToInvite = new ArrayList<Customer>();
	/*
	 * This method converts degree to radian
	 * 
	 * @param degree: Its of type double. The value of the parameter will be in degrees 
	 * and it is converted into radian.
	 */
	public double degreeToRadian(double degree) {
		return degree * (Math.PI / 180.00);
	}
	
	/*
	 * This method converts degree to radian
	 * 
	 * @param degree: Its of type double. The value of the parameter will b  in degrees 
	 * and it is converted into radian.
	 */
	public double radianToKm(double radian) {
		return radian * 6371.00;		// radius of Earth is roughly 6371 km
	}
	
	/*
	 * This method calculates the distance between two points. First the degree is 
	 * converted to radian, then using that value, the shortest-distance on a sphere 
	 * formula is used to calculate the distance. 
	 * 
	 * @param degree: Its of type double. The value of the parameter will b  in degrees 
	 * and it is converted into radian.
	 */
	public double customerDistanceToDublin(double customerLatitude, double customerLongitude) {
		final double officeLatitude = 53.339428;
		final double officeLongitude = -6.257664;
		
		double latitude = degreeToRadian(customerLatitude - officeLatitude);
		double longitude = degreeToRadian(customerLongitude - officeLongitude);
		
		double angle = Math.pow(Math.sin(latitude/2),2) + (Math.cos(degreeToRadian(customerLatitude)) 
				* Math.cos(degreeToRadian(officeLatitude)) * Math.pow(Math.sin(longitude/2), 2));
		double dist = 2 * Math.atan2(Math.sqrt(angle), Math.sqrt(1 - angle));	//Haversine formula 
		// is best suitable for smaller distances
		return radianToKm(dist);
	}
}
