package com.qa.guru99.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.utils.ElementUtil;
import com.qa.guru99.utils.TimeUtil;

public class AddCustomerPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	
	private By addCustomerHeaderText = By.xpath("//h1[text()='Add Customer']");
	private By addCustomerLink = By.xpath("//a[text()='Add Customer']/parent::h3");
	private By pendingRadioCheck = By.xpath("//label[@for='pending']");
	private By doneRadioCheck = By.xpath("//label[@for='done']");
	private By firstName = By.xpath("//input[@placeholder='FirstName']");
	private By lastName = By.xpath("//input[@placeholder='LastName']");
	private By email = By.xpath("//input[@placeholder='Email']");
	private By textArea = By.xpath("//textarea[@placeholder='Enter your address']");
	private By mobile = By.xpath("//input[@placeholder='Mobile Number']");
	private By submit = By.xpath("//input[@value='Submit']");

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Method

	public String getHomePageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.ADD_CUSTOMER_PAGE_TITLE, TimeUtil.DEFAULT_LONG_TIME);
		// System.out.println("login page title : " + title);
		// Log.info("Login page title : " + title);
		return title;
	}

	public String getAddCustHeaderText() {
		eleUtil.doActionsClick(addCustomerLink);
		return eleUtil.waitForElementVisible(addCustomerHeaderText,TimeUtil.DEFAULT_LONG_TIME ).getText();
		

	}
	
	

	public CustAccessDetailPage addCustomerWithPendingCheck(String firstName, String lastName, String email, String textArea,
			String mobile) {
		eleUtil.doActionsClick(addCustomerLink);
		eleUtil.clickWhenReady(pendingRadioCheck, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.textArea, textArea);
		eleUtil.doSendKeys(this.mobile, mobile);
		eleUtil.doClick(submit);
		return new CustAccessDetailPage(driver);
	}
	public CustAccessDetailPage addCustomerWithdoneRadioCheck(String firstName, String lastName, String email, String textArea,
			String mobile) {
		eleUtil.doActionsClick(addCustomerLink);
		eleUtil.clickWhenReady(doneRadioCheck, TimeUtil.DEFAULT_LONG_TIME);
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.textArea, textArea);
		eleUtil.doSendKeys(this.mobile, mobile);
		eleUtil.doClick(submit);

		/*
		 * String regSuccessMessg = eleutil.waitForElementVisible(sucessMessg,
		 * 5).getText(); System.out.println(regSuccessMessg);
		 * 
		 * if (regSuccessMessg.equals(AppConstants.USER_REG_SUCCESS_MESSG)) {
		 * eleutil.doClick(logoutLink); eleutil.doClick(registerLink); return true; }
		 * return false;
		 * 
		 * }
		 */

		return new CustAccessDetailPage(driver);
	}


}
