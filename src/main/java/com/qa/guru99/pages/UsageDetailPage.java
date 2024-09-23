package com.qa.guru99.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.guru99.utils.ElementUtil;

public class UsageDetailPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public UsageDetailPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By usageDetails = By.xpath("//table[@class='alt']//tr/td");

	public List<String> getUsageDetailsData() {
		List<WebElement> usageDetailsList = eleUtil.getElements(usageDetails);
		List<String> usageDetailsText = new ArrayList<String>();
		for (WebElement usageDetails : usageDetailsList) {
			String usage = usageDetails.getText();
			usageDetailsText.add(usage);
		}
    return usageDetailsText;
	}

}
