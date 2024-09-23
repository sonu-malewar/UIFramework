package com.qa.guru99.tests;

import org.testng.annotations.Test;
import com.qa.guru99.base.BaseTest;
import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.logger.Log;

public class PayBillingPageTest extends BaseTest {
	
	

	@Test
	public void payBillingPageTestTitleTest() {
		String actTitle = payBillingPage.getPayBillPageTitle();
		softAssert.assertEquals(actTitle, AppConstants.PAY_BILL_TITLE, "Guru99 Telecom Billing");
		Log.info("title is displayed");
	}


	@Test
	public void payBillingPageHeaderTextTest() {
		softAssert.assertEquals(payBillingPage.getPayBillingPageHeaderText(), "Pay Billing");
		Log.info("Cust Access Details Header Text is displayed");
	}
	
	@Test
	public void searchCustIDAndSubmitTest() {
		payBillingPage.doEnterCustomerID();
		usageDetailPage= payBillingPage.doClickOnSubmitBtn();
		Log.info("Navigate to Usage detail page");
		
	}
	
	
		

}
