package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 200:Opencart App design Login page ")
@Story("US 20: Login page feature with some basic modules and features")

public class LoginPageTest extends BaseTest {
	@Description("Login Page title test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageTiltleTest() {
		String title=loginPage.getLoginPageTitle();
		System.out.println("Actual page title is:"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Description("Login Page url test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void getLoginPageUrlTest() {
		String url=loginPage.getLoginPageUrl();
		System.out.println("Actual page url is:"+url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_UR_VALUE));
	}
	@Description("Login Page forgot pwd test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void isForgotPassworLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPassworLinkExist());
	}
	
	@Description("Login Page register test")
	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void isRegisterPassworLinkExistTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}
	
	@Description("Login Page test")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());	
}
}
