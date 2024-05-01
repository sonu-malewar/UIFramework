package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. Private By Locators

	private By logoutLink = By.linkText("Logout");
	private By myAccountLink = By.linkText("My Account");
	private By myAccount_SubLink = By.xpath("(//h2[text()='My Account']/following-sibling::ul)[1]//a");
	private By editAccountLink = By.linkText("Edit Account");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");
	

	// 2. Public Page Class Const...
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, 5);
		System.out.println("Acc page title : " + title);
		return title;
	}

	public String getAccPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.ACC_PAGE_URL_FRACTION, 5);
		System.out.println("acc page url : " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutLink, 10).isDisplayed();
	}

	public boolean myAccountLinkExist() {
		return eleUtil.waitForElementVisible(myAccountLink, 10).isDisplayed();
	}
	
	public boolean EditAccountLinkExist() {
		return eleUtil.waitForElementVisible(editAccountLink, 10).isDisplayed();
	}
	
	public List<String> getMyaccountSubLinks() {
		 List<WebElement> SubLinksEleList =  eleUtil.getElements(myAccount_SubLink);
		 List<String> SubLinksList = new ArrayList<String>();
		 for (WebElement e : SubLinksEleList) {
				String SubLink = e.getText();
				SubLinksList.add(SubLink);
			}
		 return SubLinksList;
	}
	
	

	public List<String> getAccountsPageHeadersList() {
		List<WebElement> headersEleList = eleUtil.getElements(headers);
		List<String> headersList = new ArrayList<String>();
		for (WebElement e : headersEleList) {
			String header = e.getText();
			headersList.add(header);
		}
		return headersList;
	}

	public SearchResultsPage doSearch(String SearchKey) {
		System.out.println("searching for : " + SearchKey);
		eleUtil.doSendKeys(search, SearchKey);
		eleUtil.doClick(searchIcon);
		return new SearchResultsPage(driver);
	}

}
