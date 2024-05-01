package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.exceptions.FrameworkException;
import com.qa.opencart.logger.Log;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionsManager optionsManager;
	public static String highlight;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");

		// System.out.println("browser is" + browserName);

		Log.info("browser is" + browserName);

		highlight = prop.getProperty("highlight");

		optionsManager = new OptionsManager(prop);

		switch (browserName.trim().toLowerCase()) {

		case "chrome":

			// driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;

		case "firefox":

			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;

		case "edge":

			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			break;

		default:

			System.out.println("please pass the right browser" + browserName);
			throw new BrowserException("browser not found" + browserName);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	public static WebDriver getDriver() {

		return tlDriver.get();
	}

	public Properties initProp() {

		FileInputStream fip = null;
		prop = new Properties();

		String envName = System.getProperty("envName");
		System.out.println("Running test cases on" + envName);
		try {
		if (envName == null) {
			System.out.println("No env is given hence running test on QA" + envName);
			fip = new FileInputStream("./src/test/resources/config/config.qa.properties");
		}
			else {
				
				switch (envName.toLowerCase().trim()) {
				case "qa":
				fip = new FileInputStream("./src/test/resources/config/config.qa.properties");
				break;
				case "dev":
				fip = new FileInputStream("./src/test/resources/config/config.dev.properties");
				break;
				case "stage":
				fip = new FileInputStream("./src/test/resources/config/config.stage.properties");
				break;
				case "uat":
				fip = new FileInputStream("./src/test/resources/config/config.uat.properties");
				break;
				case "prod":
				fip = new FileInputStream("./src/test/resources/config/config.properties");
				break;

			default:
				System.out.println("plz pass the right env" + envName);
				throw new FrameworkException(AppError.ENV_NAME_NOT_FOUND);
				}
			}
		}
		 catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}}

