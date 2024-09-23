package com.qa.guru99.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import com.qa.guru99.constants.AppConstants;
import com.qa.guru99.utils.ElementUtil;
import com.qa.guru99.utils.JavaScriptUtil;
import com.qa.guru99.utils.TimeUtil;

public class AddTariffPlanPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	

	private By addTariffPlanLink = By.xpath("//a[text()='Add Tariff Plan']");
	private By addTariffPlanHeaderText = By.xpath("//h1[text()='Add Tariff Plans']");
	private By monthlyRental = By.id("rental1");
	private By freeLocalMin = By.id("local_minutes");
	private By freeSMSPack = By.id("sms_pack");
	private By LocalPerMinCharges = By.id("minutes_charges");
	private By InterPerMinCharges = By.id("inter_charges");
	private By sMSPerCharges = By.id("sms_charges");
	private By submitBtn = By.xpath("//input[@value='submit']");
	private By congMesg = By.xpath("//h2[text()='Congratulation you add Tariff Plan']");
	private By homeButton = By.xpath("//a[text()='Home' and @class='button']//ancestor::ul");

	public AddTariffPlanPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}

	// 3. Public Page Actions/Method
	public void doClickOnAddTariffPlanPageLink() {
		eleUtil.doActionsClick(addTariffPlanLink);
	}
	public String getAddTariffPlanPageTitle() {
		String title = eleUtil.waitForTitleIs(AppConstants.HOME_PAGE_TITLE,TimeUtil.DEFAULT_LONG_TIME);
		return title;
	}

	public String getAddTariffPlanPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.ADD_TARIFF_URL_FRACTION, TimeUtil.DEFAULT_LONG_TIME);
		System.out.println("login page url : " + url);
		return url;
	}

	public String getAddTariffPlanPageText() {

		return eleUtil.waitForElementVisible(addTariffPlanHeaderText, TimeUtil.DEFAULT_LONG_TIME).getText();
	}

	public String createTariffPlan( String monthlyRental, String freeLocalMin, String freeSMSPack,
			String LocalPerMinCharges, String InterPerMinCharges, String sMSPerCharges) {
		doClickOnAddTariffPlanPageLink();
		eleUtil.doActionsSendKeys(this.monthlyRental,monthlyRental);
		eleUtil.doActionsSendKeys(this.freeLocalMin,freeLocalMin);
		eleUtil.doActionsSendKeys(this.freeSMSPack,freeSMSPack);
		eleUtil.doActionsSendKeys(this.LocalPerMinCharges, LocalPerMinCharges);
		eleUtil.doActionsSendKeys(this.InterPerMinCharges, InterPerMinCharges);
		eleUtil.doActionsSendKeys(this.sMSPerCharges,sMSPerCharges);
		eleUtil.doClick(submitBtn);
		return eleUtil.waitForElementVisible(congMesg, TimeUtil.DEFAULT_LONG_TIME).getText();

	}

	public HomePage navigateToHomePage(String monthlyRental, String freeLocalMin, String freeSMSPack,
			String LocalPerMinCharges, String InterPerMinCharges, String sMSPerCharges) {
		doClickOnAddTariffPlanPageLink();
		eleUtil.doActionsSendKeys(this.monthlyRental,monthlyRental);
		eleUtil.doActionsSendKeys(this.freeLocalMin,freeLocalMin);
		eleUtil.doActionsSendKeys(this.freeSMSPack, freeSMSPack);
		eleUtil.doActionsSendKeys(this.LocalPerMinCharges, LocalPerMinCharges);
		eleUtil.doActionsSendKeys(this.InterPerMinCharges,  InterPerMinCharges);
		eleUtil.doActionsSendKeys(this.sMSPerCharges, sMSPerCharges);
		eleUtil.doClick(submitBtn);
		eleUtil.doActionsClick(homeButton);
		return new HomePage(driver);

	}

}