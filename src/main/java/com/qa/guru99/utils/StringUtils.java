package com.qa.guru99.utils;

public class StringUtils {

	public static String getRandomEmailId() {
		String emailId = "testautomation" +"@"+ System.currentTimeMillis() + "opencart.com";
		return emailId;
	}

}
