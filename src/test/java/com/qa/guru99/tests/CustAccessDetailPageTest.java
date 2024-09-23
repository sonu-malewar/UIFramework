package com.qa.guru99.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.guru99.base.BaseTest;
import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.logger.Log;
import com.qa.guru99.pages.CustAccessDetailPage;

public class CustAccessDetailPageTest extends BaseTest {

	@BeforeClass
	public void addCustPageSetup() {
		custdetail = addCustomerPage.addCustomerWithdoneRadioCheck("Leena", "Kharadkat", "leenakh@cde.com",
				"Downtown 562546", "4125678612");
	}

	@Test
	public void custAccessDetailPageTitleTest() {
		String actTitle = custdetail.getCustAccessDetailPageTitle();
		Assert.assertEquals(actTitle, AppConstants.HOME_PAGE_TITLE, "Guru99 Telecom");
		Log.info("title is displayed");
	}

	@Test
	public void custAccessDetailPageURLTest() {
		String actTitle = custdetail.getCustAccessDetailPageTitle();
		Assert.assertEquals(actTitle, AppConstants.HOME_PAGE_TITLE, "Guru99 Telecom");
		Log.info("URL is displayed");
	}

	@Test
	public void custAccessDetailsHeaderTextTest() {
		softAssert.assertEquals(custdetail.getcustAccessDetailsHeaderText(), "Access Details to Guru99 Telecom");
		Log.info("Cust Access Details Header Text is displayed");
	}

	@Test(enabled = true)
	public void custAccessDetailsCountTest() {
		List<WebElement> custDetailsList = custdetail.getcustAccessTableDetails();
		List<String> custdetail = new ArrayList<String>();
		for (WebElement custDetails : custDetailsList) {
			String custText = custDetails.getText();
			custdetail.add(custText);
			System.out.println(custdetail);
		}
		softAssert.assertEquals(custdetail.size(), 3);
		Log.info("Cust Access Details Count is displayed");
	}
	
	@Test(enabled = true)
	public void getcustAccessTableDetailsTest() {
		List<WebElement> custDetailsList = custdetail.getcustAccessTableDetails();
		List<String> custdetail = new ArrayList<String>();
		for (WebElement custDetails : custDetailsList) {
			String custText = custDetails.getText();
			custdetail.add(custText);
			System.out.println(custdetail);
		}
		softAssert.assertTrue(custdetail.contains("Customer ID"));
		softAssert.assertTrue(custdetail.contains("Please Note Down Your CustomerID"));
		Log.info("Customer ID and Please Note Down Your CustomerID is displayed ");
	}
	@Test
	public void homeButtonTest() {
		homePage = custdetail.doClickOnHomeBtn();
		  softAssert.assertEquals(homePage.getHomePageTitle(),AppConstants.HOME_PAGE_TITLE);
			Log.info("Home page title is displayed ");
	}


}
