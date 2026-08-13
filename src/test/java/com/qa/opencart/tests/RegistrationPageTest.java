package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ExcelUtil;

public class RegistrationPageTest extends BaseTest {

	@BeforeClass
	public void regPageSetUp() {
		registartionPage=loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][] getRegTestData() {
		Object data[][]=ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	public String getRandomNumber() {
		Random random=new Random();
		String email="testautomation"+random.nextInt(1000)+"@gmail.com";
		return email;
	}
	@Test(dataProvider="getRegTestData")
	public void registrationTest(String firstName,String lastName,String telephone,String password,String subscribe
) {
		Assert.assertTrue(registartionPage.registration(firstName,lastName,getRandomNumber(),telephone,password,subscribe));
	}
	
}
