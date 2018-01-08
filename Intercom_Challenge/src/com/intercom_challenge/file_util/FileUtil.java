/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.file_util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.logging.*;
import javax.swing.JFileChooser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;

import com.intercom_challenge.log_util.LogUtil;
/*import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;*/
//import com.intercom_challenge.customer.Customer;
import com.intercom_challenge.parse_customer.ParseCustomer;

/*
 * FileUtil class provides functionality to read customer data from a selected text file.
 * A valid text file contains a json representation of a customer in each line
 * It has getFileLocation(), getJsonFile(), readFromFile() methods
 * 
 * @version 1.0  
 * @author Saathvik Shashidhar Gowrapura
 */
public class FileUtil {
	/*
	 * logger to take care of logging duties when an exception arises
	 */
	Logger logger;
	
	/*
	 * readFromFile() method reads json objects from a selected text file.
	 * It iterates through each line of the file and reads one json object at a time.
	 * Then it passes the json object to a method of ParseCustomer class to 
	 * get data from json object. 
	 * 
	 */
	public void readFromFile() {
	    JSONObject jsonObj;
	    File file = null; 
		String line = null;
		BufferedReader bufferedReader = null;
		ParseCustomer parseCustomer = new ParseCustomer();
		try {
			logger = LogUtil.getLogger();
			file = getJsonFile();
	        FileReader fileReader = new FileReader(file);		  // FileReader reads text files in the default encoding.

	        bufferedReader = new BufferedReader(fileReader);      // Wrap FileReader in BufferedReader.

	        while((line = bufferedReader.readLine()) != null) {
	            jsonObj = (JSONObject) new JSONParser().parse(line);
	            parseCustomer.getCustomerFromJson(jsonObj);
	        }     
	    }
		catch(FileNotFoundException ex) {
			logger.log(Level.INFO, "FileNotFoundException caught. " + "Cannot find file '" + file + "'");
			System.exit(0);
	    }
	    catch(IOException ex) {
	    	logger.log(Level.INFO, "IOException caught. " + "Error reading file '" + file + "'");
	    	System.exit(0);
	    }
		catch (NullPointerException ex) {
			logger.log(Level.INFO, "NullPointerException caught. Filename cannot be null", ex);
			System.exit(0);	
		}
		catch(IllegalArgumentException ex) {
			logger.log(Level.INFO, "IllegalArgumentException caught. ", ex);
			System.exit(0);
		}
	     catch (org.json.simple.parser.ParseException ex) {
	    	 logger.log(Level.INFO, "ParseException caught. ", ex);
	    	 System.exit(0);
		}
		catch(SecurityException ex) {
			logger.log(Level.INFO, "SecurityException caught. ", ex);
			System.exit(0);
		}
		finally {
				if (bufferedReader != null) {
				 try {
					bufferedReader.close();
				} 
				 catch (IOException ex) {
					 logger.log(Level.INFO, "IOException caught. " + "Error reading file '" + file + "'");
				}
				 catch (NullPointerException ex) {
					 logger.log(Level.INFO, "NullPointerException caught. Filename cannot be null", ex);
				 }
			}
		}
	}	
	
	/*
	 * This method creates a file and then returns the file 
	 */
    private static File getJsonFile() {
    	//final String file = "./src/customers.txt";
    	final String file = getFileLocation();
    	return new File(file); 
    }
    
    /*
     * This method provides functionality choose a file from file system.
     * It opens a dialogue box from where a user can select a file.
     * If the user chooses a file, it returns the string representation of file's location 
     * else it returns null
     */
    private static String getFileLocation() {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setCurrentDirectory(new java.io.File("."));
	    fileChooser.setDialogTitle("Select file");
	    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    fileChooser.setAcceptAllFileFilterUsed(false);
	
	    if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	      return fileChooser.getSelectedFile().toString();
	    } else {
	      return null;
	    }
    }
}

