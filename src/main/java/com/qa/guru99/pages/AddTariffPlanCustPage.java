package com.qa.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.utils.ElementUtil;
import com.qa.guru99.utils.TimeUtil;

public class AddTariffPlanCustPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	private By addTariffPlanToCustLink = By.xpath("//a[text()='Add Tariff Plan to Customer']");
	private By addTariffPlanToCustHeaderText = By.xpath("//h1[text()='Add Tariff Plan to Customer']");
	private By enterCustIDLabel = By.xpath("//h3[text()='Enter Your Customer ID']");
	private By custIDValue = By.id("customer_id");
	private By submitBtn = By.xpath("//input[@value='submit']");

	public AddTariffPlanCustPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Method

	
	public AddTariffPlanCustPage doClickOnAddTariffPlanCustLink() {
		 eleUtil.doActionsClick(addTariffPlanToCustLink);
		 return new AddTariffPlanCustPage(driver);
	}
	public String getAddTariffPlanCustPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.ADD_TARIFF_PLAN_CUST_URL_FRACTION,
				TimeUtil.DEFAULT_LONG_TIME);
		System.out.println("login page url : " + url);
		return url;
	}

	public String getAddTariffPlanCustPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.ADD_TARIFF_PLAN_CUST_TITLE, TimeUtil.DEFAULT_LONG_TIME);

	}

	public String getAddTariffPlanCustPageHeaderText() {
		eleUtil.doActionsClick(addTariffPlanToCustLink);
		return eleUtil.waitForElementVisible(addTariffPlanToCustHeaderText, TimeUtil.DEFAULT_LONG_TIME).getText();

	}

	public String getCustIdLable() {
	
		return eleUtil.waitForElementVisible(enterCustIDLabel, TimeUtil.DEFAULT_LONG_TIME).getText();
	}

	public String getCustIdAttributeValue() {
		return eleUtil.waitForElementVisible(custIDValue, TimeUtil.DEFAULT_LONG_TIME).getAttribute("placeholder");
				
	}
	public void doEnterCustomerID() {
		eleUtil.doSendKeys(custIDValue,AppConstants.CUST_ID);
     }
	public void doClickOnSubmitBtn() {
		eleUtil.doClick(submitBtn);
	}
}