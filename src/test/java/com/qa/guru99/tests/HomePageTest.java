package com.qa.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.guru99.base.BaseTest;
import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.logger.Log;
import com.qa.guru99.utils.TimeUtil;


public class HomePageTest extends BaseTest {
	
	@Test
	public void homePageTitleTest() {
		String actTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actTitle,AppConstants.HOME_PAGE_TITLE,"Guru99 Telecom");
		Log.info("title is displayed");
	}

	@Test
	public void homePageURLTest() {
		String actURL = homePage.getHomePageURL();
		Assert.assertTrue(actURL.contains(AppConstants.HOME_PAGE_URL_FRACTION));
	}
	
	
	@Test
	public void logoPresentTest() {
		Assert.assertTrue(homePage.isLogoPresent());
	}
	
	@Test
	public void homePageMenuTest() {
		Assert.assertTrue(homePage.isHomePageMenuLinkEPresent());
	}
	
	
	@Test
	public void addCustTest() {
		Assert.assertTrue(homePage.isaddCustomerLinkExist());
	}
	
	@Test
	public void addTariffCustPlanTest() {
		Assert.assertTrue(homePage.isaddTariffPlanToCustLinkExist());
	}
	@Test
	public void addTariffPlanTest() {
		Assert.assertTrue(homePage.isaddTariffPlanLinkExist());
	}
	@Test
	public void payBillTest() {
		Assert.assertTrue(homePage.ispayBillingLinkExist());
	}
	

	


}
