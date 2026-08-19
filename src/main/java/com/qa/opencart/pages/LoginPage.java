package com.qa.opencart.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//1.Page locators-Page Objects-Object Repositories
	
	private By emeilId=By.id("input-email");
	private By password=By.id("input-password");
	private By loginButton=By.xpath("//input[@value='Login']");
	private By forgotpwdLink=By.linkText("Forgotten Password");
	private By registerLink=By.linkText("Register");


	//2.Page Constructors:
	public LoginPage(WebDriver driver) {//here i wrote public void so i got nullpointer exception so void means it will consider method instead of constructor
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//3.Page Actions/Methods/Features:
	@Step("getting login page title............")
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	@Step("getting login page url............")
	public  String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	@Step("forgot password link exist or not...........")
	public boolean isForgotPassworLinkExist() {
		return elementUtil.doIsDisplayed(forgotpwdLink);
	}
	
	@Step("register link exist or not............")
	public boolean isRegisterLinkExist() {
		return elementUtil.doIsDisplayed(registerLink);
	}
	
	@Step("login with username:{0} and password:{1}")
	public AccountsPage doLogin(String un,String pwd) {
		System.out.println("creds"+un+ ":"+pwd);
		elementUtil.doSendKeys(emeilId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);

	}
	@Step("navigating to register page")

	public RegistrationPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
	
}
