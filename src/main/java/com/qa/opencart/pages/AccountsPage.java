package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By search=By.name("search");
	private By searchIcon=By.cssSelector("div #search span");
	private By logoutLink=By.linkText("Logout");
	private By accSecHeaders=By.xpath("div #content h2");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}

	
	public String getAccountsPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	public boolean islogOutLinkExist() {
		return elementUtil.doIsDisplayed(logoutLink);
	}
	
	public boolean isSerachFieldExist() {
		return elementUtil.doIsDisplayed(search);
	}
	public List<String> getAccountsSecList() {
		List<WebElement>secList=elementUtil.getElements(accSecHeaders);
		List<String>secHeaderList=new ArrayList<String>();
		for(WebElement e:secList) {
			secHeaderList.add(e.getText());
		}
		return secHeaderList;
	}
	
	public ResultsPage doSearch(String productName) {
		System.out.println("Product name is:"+productName);
		elementUtil.doSendKeys(search, productName);
		elementUtil.doClick(searchIcon);
		return new ResultsPage(driver);
	}
}
