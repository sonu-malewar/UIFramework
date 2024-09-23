package com.qa.guru99.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.utils.ElementUtil;
import com.qa.guru99.utils.TimeUtil;

public class CustAccessDetailPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By custAccessDetailsHeader = By.xpath("//h1[text()='Access Details to Guru99 Telecom']//ancestor::section");
	private By custAccessDetails = By.xpath("//table[@class='alt access']//td");
	private By homeButton = By.xpath("//a[text()='Home' and @class='button']//ancestor::ul");

	public CustAccessDetailPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Method

	public String getCustAccessDetailPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE,TimeUtil.DEFAULT_LONG_TIME);
		// System.out.println("login page title : " + title);
		// Log.info("Login page title : " + title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.CUST_ACCESS_PAGE_URL_FRACTION, TimeUtil.DEFAULT_LONG_TIME);
		System.out.println("login page url : " + url);
		return url;
	}

	public String getcustAccessDetailsHeaderText() {
		
		return eleUtil.waitForElementVisible(custAccessDetailsHeader,TimeUtil.DEFAULT_LONG_TIME ).getText();
	}	
	
	public List<WebElement> getcustAccessTableDetails() {
		
		return eleUtil.waitForElementsVisible(custAccessDetails,TimeUtil.DEFAULT_LONG_TIME );
	}
	
	public HomePage doClickOnHomeBtn() {
		eleUtil.doActionsClick(homeButton);
		return new HomePage(driver);
		
	}


}
