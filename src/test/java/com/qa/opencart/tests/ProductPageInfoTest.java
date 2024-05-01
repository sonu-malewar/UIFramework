package com.qa.opencart.tests;
import java.util.Map;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductPageInfoTest extends BaseTest {

	// AAA -->UTs
	// TC -- only one hard assertion or can have multiple soft assertions

	@BeforeClass
	public void infoPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}


	@Test
	public void productImagesCountTest() {
		searchResultsPage = accPage.doSearch("imac");
		
		productInfoPage = searchResultsPage.selectProduct("imac");
		Assert.assertEquals(productInfoPage.getProductImagesCount(),3 );// actTes
	}

	@Test
	public void productInfoTest() {
		searchResultsPage = accPage.doSearch("macbook");
		productInfoPage = searchResultsPage.selectProduct("Macbook Pro");
		Map<String, String> productActMap = productInfoPage.getProductDetailsMap();
		softAssert.assertEquals(productActMap.get("Brand"), "Apple");
		softAssert.assertAll();
		//Assert.assertEquals(productActMap.get("Availability"), "In Stock");
	}

}
