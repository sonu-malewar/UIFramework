package com.qa.guru99.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.guru99.factory.DriverFactory;
import com.qa.guru99.pages.AddCustomerPage;
import com.qa.guru99.pages.AddTariffPlanCustPage;
import com.qa.guru99.pages.AddTariffPlanPage;
import com.qa.guru99.pages.CustAccessDetailPage;
import com.qa.guru99.pages.HomePage;
import com.qa.guru99.pages.PayBillingPage;
import com.qa.guru99.pages.UsageDetailPage;

public class BaseTest {
	WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected HomePage homePage;
	protected AddCustomerPage addCustomerPage;
	protected AddTariffPlanCustPage addTariffPlanCustPage;
	protected AddTariffPlanPage addTariffPlanPage;
	protected CustAccessDetailPage custdetail;
	protected PayBillingPage payBillingPage;
	protected UsageDetailPage usageDetailPage;
	protected SoftAssert softAssert;

	
	@Parameters({"browser","browserversion","testname"})
	@BeforeTest
	public void setup(String browserName,String browserVersion,String testName) {
		df = new DriverFactory();
		prop = df.initProp();
		
		if(browserName!=null) {
			
			prop.setProperty("browser", browserName);
			prop.setProperty("browserversion", browserVersion);
			prop.setProperty("testname", testName);
		}

		driver = df.initDriver(prop);
		//registrationPage = new RegistrationPage(driver);
		
		 homePage = new HomePage(driver);
		 addCustomerPage = new AddCustomerPage(driver);
		 custdetail = new CustAccessDetailPage(driver);
		 addTariffPlanCustPage = new AddTariffPlanCustPage(driver);
		 addTariffPlanPage = new AddTariffPlanPage(driver) ;
		 payBillingPage= new PayBillingPage(driver);
		 usageDetailPage = new UsageDetailPage(driver);
		 softAssert = new SoftAssert();;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
