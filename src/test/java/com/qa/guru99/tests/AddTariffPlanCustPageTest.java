package com.qa.guru99.tests;


import org.testng.annotations.Test;
import com.qa.guru99.base.BaseTest;
import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.logger.Log;

public class AddTariffPlanCustPageTest extends BaseTest{
	
	
	@Test(enabled = true)
	public void addTariffPlanCustPageTest() {
		addTariffPlanCustPage = addTariffPlanCustPage.doClickOnAddTariffPlanCustLink();
		String custIDLabel = addTariffPlanCustPage.getCustIdLable();
		String custIDLabelValue = addTariffPlanCustPage.getCustIdAttributeValue();
		softAssert.assertEquals(custIDLabel, "Enter Your Customer ID");
		softAssert.assertEquals(custIDLabelValue, "Enter Your Customer ID");
		
		//Log.info("custIDLabel,custIDLabelValue are displayed");
	}
	

	@Test
	public void getAddTariffPlanPageTitleTest() {
		String actTitle = addTariffPlanCustPage.getAddTariffPlanCustPageTitle();
		softAssert.assertEquals(actTitle, AppConstants.ADD_TARIFF_PLAN_CUST_TITLE);
		//Log.info("title is displayed");
	}

	@Test(priority = 2)
	public void getAddTariffPlanlPageURLTest() {
		String actTitle = addTariffPlanCustPage.getAddTariffPlanCustPageURL();
		softAssert.assertEquals(actTitle, AppConstants.ADD_TARIFF_PLAN_CUST_URL_FRACTION);
		//Log.info("URL is displayed");
	}

	@Test
	public void getAddTariffPlanHeaderTextTest() {
		softAssert.assertEquals(addTariffPlanCustPage.getAddTariffPlanCustPageHeaderText(), "Add Tariff Plan to Customer");
		//Log.info("Cust Access Details Header Text is displayed");
	}
	
	@Test
	public void searchCustIDAndSubmitTest() {
		addTariffPlanCustPage.doEnterCustomerID();
		addTariffPlanCustPage.doClickOnSubmitBtn();
	}
}
