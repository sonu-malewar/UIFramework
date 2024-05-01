package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageURLTest() {
		String actURL = accPage.getAccPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.ACC_PAGE_URL_FRACTION));
	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

	@Test
	public void isMyAccountLinkExistTest() {
		Assert.assertTrue(accPage.myAccountLinkExist());
	}

	@Test
	public void accPageHeadersTest() {
		List<String> actHeadersList = accPage.getAccountsPageHeadersList();
		System.out.println(actHeadersList);
	}

	@Test
	public boolean myaccountSubLinksTest() {
		List<String> myaccountSubLinks = accPage.getMyaccountSubLinks();
		System.out.println(myaccountSubLinks.size());
		Boolean flag = false;
		if (myaccountSubLinks.contains("Edit your account information")
				&& myaccountSubLinks.contains("Change your password")) {

			return flag;
		}
		softAssert.assertEquals(myaccountSubLinks.size(), 4);
		softAssert.assertTrue(flag);
		softAssert.assertAll();
		return flag;
	}

	@Test
	public void searchTest() {
		searchResultsPage = accPage.doSearch("macbook");
	}

}
