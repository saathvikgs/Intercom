/*
 * Copyright (c) 2018, Saathvik Shashidhar Gowrapura
 * 
 * All rights reserved
 * 
 */

package com.intercom_challenge.fileutil_test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Before;
import org.junit.Rule;

import com.intercom_challenge.file_util.FileUtil;
import com.intercom_challenge.parse_customer.ParseCustomer;

/*
 * This class tests the functionality for FileUtil class
 * 
 * @version 1.0
 * @author Saathvik Shashidhar Gowrapura
 */
@RunWith(JUnit4.class)
public class FileUtilTest {
	FileUtil fileUtil;
	ParseCustomer parseCustomer;

	@Rule
    public ExpectedException expectedException = ExpectedException.none();
	@Before
	public void init() {
		fileUtil = new FileUtil();
		parseCustomer = new ParseCustomer();
	}
	@Test
	public void testReadFromFile() {
		//FileUtil fileUtil = new FileUtil();
		fileUtil.readFromFile();
		assertEquals("Checking read from file function", 1, parseCustomer.getCustomersToInviteList().size());
	}
}