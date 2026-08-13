package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {
	public WebDriver driver;
	public DriverFactory df;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public ResultsPage resultsPage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registartionPage;
	public SoftAssert softAssert;
	@BeforeTest
	public void setUp() {
		df=new DriverFactory();
		prop=df.initProp();
		driver=df.initDriver(prop);
		loginPage=new LoginPage(driver);//pass driver otherwise give null pointer
		softAssert=new SoftAssert();
		
		
	}
	
@AfterTest
public void tearDown() {
	driver.quit();
}
}
