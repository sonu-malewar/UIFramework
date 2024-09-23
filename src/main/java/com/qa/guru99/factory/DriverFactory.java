package com.qa.guru99.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.guru99.errors.AppError;
import com.qa.guru99.exceptions.BrowserException;
import com.qa.guru99.exceptions.FrameworkException;
import com.qa.guru99.logger.Log;

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
			
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// remote - grid execution:
				init_remoteDriver("chrome");
			} else {

			// driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
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

	private void init_remoteDriver(String browserName) {
		
		System.out.println("Running tests on Remote GRID on browser: " + browserName);

		try {
			switch (browserName.toLowerCase().trim()) {
			case "chrome":

				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getChromeOptions()));
				break;

			case "firefox":

				tlDriver.set(
						new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getFirefoxOptions()));
				break;

			case "edge":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), optionsManager.getEdgeOptions()));
				break;

			default:
				System.out.println("plz pass thr right supported browser on GRID....");
				break;
			}

		}

		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
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
			System.out.println("No env is given hence running test on QA " );
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

