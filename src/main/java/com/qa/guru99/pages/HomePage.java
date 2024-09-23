package com.qa.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.utils.ElementUtil;
import com.qa.guru99.utils.TimeUtil;



public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logo = By.xpath("//a[text()='Guru99 telecom']");
	private By menuLink = By.xpath("//a[@href='#menu']/span");
	private By addCustomerLink = By.xpath("//a[text()='Add Customer']/parent::h3");
	private By addTariffPlanToCustLink = By.xpath("//a[text()='Add Tariff Plan to Customer']/parent::h3");
	private By addTariffPlanLink = By.xpath("//a[text()='Add Tariff Plan']/parent::h3");
	private By payBillingLink = By.xpath("//a[text()='Pay Billing']/parent::h3");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Method

	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE, TimeUtil.DEFAULT_LONG_TIME);
		// System.out.println("login page title : " + title);
		// Log.info("Login page title : " + title);
		return title;
	}

	public String getHomePageURL() {
		String title = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_URL_FRACTION, TimeUtil.DEFAULT_LONG_TIME);
		// System.out.println("login page title : " + title);
		// Log.info("Login page title : " + title);
		return title;
	}

	public boolean isLogoPresent() {
		return eleUtil.isElementDisplayed(logo);
	}

	public boolean isHomePageMenuLinkEPresent() {
		return eleUtil.isElementDisplayed(menuLink);

	}

	public boolean isaddCustomerLinkExist() {
		return eleUtil.isElementDisplayed(addCustomerLink);
	}
	
	

	public boolean isaddTariffPlanToCustLinkExist() {
		return eleUtil.isElementDisplayed(addTariffPlanToCustLink);
	}
	
	

	public boolean isaddTariffPlanLinkExist() {
		return eleUtil.isElementDisplayed(addTariffPlanLink);
	}

	public boolean ispayBillingLinkExist() {
		return eleUtil.isElementDisplayed(payBillingLink);
	}

}



