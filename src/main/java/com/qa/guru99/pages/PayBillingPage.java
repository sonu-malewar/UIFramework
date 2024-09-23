package com.qa.guru99.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.utils.ElementUtil;
import com.qa.guru99.utils.TimeUtil;

public class PayBillingPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By submitBtn = By.xpath("//input[@value='submit']");
	private By paybillHeaderText = By.xpath("//h1[text()='Pay Billing']");
	private By custIDinput = By.id("customer_id");
	private By custIDLabel = By.xpath("//h3[text()='Enter Your Customer ID']");
	private By payBillingLink = By.xpath("//a[text()='Pay Billing']/parent::h3");

	public PayBillingPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Public Page Actions/Method
	public void doClickOnPayBillingPageLink() {
		eleUtil.doActionsClick(payBillingLink);
	}
	public String getPayBillPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.PAY_BILL_TITLE, TimeUtil.DEFAULT_LONG_TIME);
		return title;
	}

	public String getPayBillingPageHeaderText() {
		
		return eleUtil.waitForElementVisible(paybillHeaderText,TimeUtil.DEFAULT_LONG_TIME ).getText();
	}
	
	public String getCustIdLable() {
		return eleUtil.doGetElementText(custIDLabel);
	}

	public String getCustIdAttributeValue() {
		return eleUtil.doElementGetAttribute(custIDinput, "placeholder");
	}
	public void doEnterCustomerID() {
		eleUtil.doSendKeys(custIDinput,AppConstants.CUST_ID);
     }
	public UsageDetailPage doClickOnSubmitBtn() {
		eleUtil.doClick(submitBtn);
		return new UsageDetailPage(driver);
	}
	
}