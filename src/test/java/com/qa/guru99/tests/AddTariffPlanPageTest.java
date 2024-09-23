package com.qa.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.guru99.base.BaseTest;
import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.logger.Log;
import com.qa.guru99.pages.HomePage;
import com.qa.guru99.utils.CSVUtil;
import com.qa.guru99.utils.ExcelUtil;
import com.qa.guru99.utils.StringUtils;

public class AddTariffPlanPageTest extends BaseTest{
	@Test
	public void navigateToAddTariffPlanTest() {
		addTariffPlanPage.doClickOnAddTariffPlanPageLink();
	}
	
	@Test
	public void addTariffPlanPageTitleTest() {
		String actTitle = addTariffPlanPage.getAddTariffPlanPageTitle();
		Assert.assertEquals(actTitle, AppConstants.HOME_PAGE_TITLE);
		Log.info("title is displayed");
	}
	@Test
	public void addTariffPlanPageURLTest() {
		String actTitle = addTariffPlanPage.getAddTariffPlanPageURL();
		Assert.assertEquals(actTitle, AppConstants.ADD_TARIFF_URL_FRACTION);
		Log.info("title is displayed");
	}

	
	@DataProvider
	public Object[][] getTariffData() {

		return new Object[][] {

				{ "500","200","100","10","5","3"}  };
	}
	
	@Test
	public void getAddTariffPlanPageHeaderTextTest() {
		softAssert.assertEquals(addTariffPlanPage.getAddTariffPlanPageText(), "Add Tariff Plans");
		Log.info("AddTariffPlanPage HeaderText is displayed");

	}
	@Test(dataProvider = "getTariffData", enabled = true)
	public void createTariffPlanTest(String monthlyRental,String freeLocalMin,String freeSMSPack,String LocalPerMinCharges,String InterPerMinCharges,String sMSPerCharges  ) {

		String confMesg = addTariffPlanPage.createTariffPlan(monthlyRental, freeLocalMin, freeSMSPack, LocalPerMinCharges, InterPerMinCharges, sMSPerCharges);
		softAssert.assertEquals(confMesg, AppConstants.CONGRATULATION_MESG);
		Log.info("TariffPlan is created");
	}
	@Test(dataProvider = "getTariffData", enabled = false)
	public void navigateToHomePageTest(String monthlyRental, String freeLocalMin, String freeSMSPack,
			String LocalPerMinCharges, String InterPerMinCharges, String sMSPerCharges) {
		
		homePage = addTariffPlanPage.navigateToHomePage(monthlyRental, freeLocalMin, freeSMSPack, LocalPerMinCharges, InterPerMinCharges, sMSPerCharges);
		Log.info("navigate To HomePage is displayed");
	}

}

	


