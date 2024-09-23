package com.qa.guru99.tests;

import java.util.List;

import org.testng.annotations.Test;

import com.qa.guru99.base.BaseTest;

public class UsageDetailPageTest extends BaseTest{
	@Test
	public void getUsageDetailsDataTest() {
		
		List<String> tableData = usageDetailPage.getUsageDetailsData();
		softAssert.assertTrue(tableData.contains("Local Minutes"));
		softAssert.assertTrue(tableData.contains("International Minutes"));
		softAssert.assertTrue(tableData.contains("SMS Pack"));
		softAssert.assertTrue(tableData.contains("Tariff Plan Amount"));
		softAssert.assertTrue(tableData.contains("Usage Charges"));
		softAssert.assertTrue(tableData.contains("Total Bill"));
		
		
	}
}
