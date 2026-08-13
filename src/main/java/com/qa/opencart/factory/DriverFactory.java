package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/** @author savitas
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver>tlDriver=new ThreadLocal<WebDriver>();

	/* this methid is used to initiase the webdriver on the basis of given browser name
	 * @param browser
	 * @return this method will return driver
	 */

	public WebDriver initDriver(Properties prop) {
		optionsManager=new OptionsManager(prop);
		highlight=prop.getProperty("highlight");
		String browser=prop.getProperty("browser").trim();// here i wrote browsser got null pointer exception 
		System.out.println("Browser name is: " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			//driver = new FirefoxDriver(optionsManager.getFireFoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));

		}
		else if (browser.equalsIgnoreCase("safari")) {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());

			
		} else {
			System.out.println("Please pass correct browser name..... " + browser);
		}
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get(prop.getProperty("url"));
//		return driver;

		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}
	
	public synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * this method is used to initialize the properties on the basis of given environment
	 * @return this method return the prop 
	 */
	public Properties initProp() {
		prop=new Properties();
		String env=System.getProperty("env");
		FileInputStream ip=null;
		if(env==null)
		{
		try {
			ip=new FileInputStream("./src/test/resources/config/config.properties");
		
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			else {
				System.out.println("Running on environment:"+env);
				try {
					switch(env.toLowerCase()) {
					case "qa":
						ip=new FileInputStream("./src/test/resources/config/qa.config.properties");
						break;
						
					case "stage":
						ip=new FileInputStream("./src/test/resources/config/stage.config.properties");
						break;
						
						default:
							System.out.println(".....Please pass thr right environment...."+env);

							break;

					}
				}
				catch (Exception e) {
				e.printStackTrace();
				}
				
			}
		return prop;
		
	}
	/*
	 * take screenshot
	 */

	public String getScreenshot() {
		File srcFile=((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
		File destination=new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
