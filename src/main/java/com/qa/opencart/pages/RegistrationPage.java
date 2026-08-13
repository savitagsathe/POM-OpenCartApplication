package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class RegistrationPage {
private WebDriver driver;
private ElementUtil elementUtil;
	
private By firstName=By.id("input-firstname");
private By lastName=By.id("input-lastname");
private By email=By.id("input-email");
private By telephone=By.id("input-telephone");
private By password=By.id("input-password");
private By confirmPassword=By.id("input-confirm");

private By subscribeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
private By subscribeNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input");

private By agreeCheckBox=By.name("agree");
private By continueBtn=By.xpath("//input[@type='submit' and @value='Continue']");
private By successMsg=By.cssSelector("div# content h1");

private By logOutLink=By.linkText("Logout");
private By registerLink=By.linkText("Register");

public RegistrationPage(WebDriver driver) {
	this.driver=driver;
	elementUtil=new ElementUtil(driver);
}


public Boolean registration(String firstName,String lastName,String email,String telephone,String password,String subscribe) {
	fillRegForm(firstName, lastName, email, telephone, password);
	subscriptionOption(subscribe);
	selectagreeAndContinue();
	return getRegistrationStatus();
	
}

private void fillRegForm(String firstName,String lastName,String email,String telephone,String password) {
	elementUtil.doSendKeys(this.firstName, firstName);
	elementUtil.doSendKeys(this.lastName, lastName);
	elementUtil.doSendKeys(this.email, email);
	elementUtil.doSendKeys(this.telephone, telephone);
	elementUtil.doSendKeys(this.password, password);
	elementUtil.doSendKeys(this.confirmPassword, password);
	
}

private void subscriptionOption(String subscribe) {
	if(subscribe.equalsIgnoreCase("yes")) {
		elementUtil.doClick(subscribeYes);
	}
	else {
		elementUtil.doClick(subscribeNo);
	}
}

private void selectagreeAndContinue() {
	elementUtil.doClick(agreeCheckBox);
	elementUtil.doClick(continueBtn);
	
}

private boolean getRegistrationStatus() {
	String mesg=elementUtil.doGetText(successMsg);
	if(mesg.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
		elementUtil.doClick(logOutLink);
		elementUtil.doClick(registerLink);
		return true;
	}
	return false;
}




}
