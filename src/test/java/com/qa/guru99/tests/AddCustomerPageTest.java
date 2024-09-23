package com.qa.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru99.base.BaseTest;
import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.logger.Log;
import com.qa.guru99.utils.StringUtils;

public class AddCustomerPageTest extends BaseTest {

	@Test(enabled = true)
	public void addCustPageTitleTest() {
		String actTitle = addCustomerPage.getHomePageTitle();
		Assert.assertEquals(actTitle, AppConstants.HOME_PAGE_TITLE);
		Log.info("title is displayed");
	}

	@DataProvider
	public Object[][] getUserCustTestData() {
		return new Object[][] { { "gaurav", "gupta", "Wada road", "9876543212" } };
	}

	@Test
	public void getAddCustHeaderTextTest() {
		softAssert.assertEquals(addCustomerPage.getAddCustHeaderText(), "Add Customer");
		Log.info("AddCustHeaderText is displayed");

	}
	@Test(dataProvider = "getUserCustTestData", enabled = false)
	public void addCustomerWithdoneRadioCheckTest(String firstName, String lastName, String textArea, String mobile) {

		custdetail = addCustomerPage.addCustomerWithdoneRadioCheck(firstName, lastName, StringUtils.getRandomEmailId(), textArea, mobile);
		Log.info("addCustomer With Done RadioCheck is displayed");
	}

	

	@Test(dataProvider = "getUserCustTestData", enabled = false)
	public void addCustomerWithPendingCheckTest(String firstName, String lastName, String textArea, String mobile) {

		custdetail = addCustomerPage.addCustomerWithPendingCheck(firstName, lastName, StringUtils.getRandomEmailId(), textArea, mobile);
		Log.info("addCustomer With Pending RadioCheck is displayed");
	}

}
