package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constants;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;
@Epic("Epic 201:Opencart App -design Accounts page ")
@Story("US 21:Accounts page feature with some basic modules and features")

public class AccountsPageTest extends BaseTest {
@BeforeClass
public void accPageSUetp() {
	accountsPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
}

@Test
public void getAccountsPageTitleTest() {
	String accTitle=accountsPage.getAccountsPageTitle();
	System.out.println("Account page title is:"+accTitle);
	Assert.assertEquals(accTitle, Constants.ACCOUNT_PAGE_TITLE);
}

@Test
public void islogOutLinkExistTest() {
	Assert.assertTrue(accountsPage.islogOutLinkExist());
}
@Test
public void isSerachFieldExist() {
	Assert.assertTrue(accountsPage.isSerachFieldExist());
}

@Test 
public void getAccountsSecHeaderTest() {
	List<String>actualSecList=accountsPage.getAccountsSecList();
	System.out.println(actualSecList);
	Assert.assertEquals(actualSecList, Constants.EXP_ACCOUNTS_SECTIONS_LIST);
}
@DataProvider
public Object[][] productData() {
	return new Object[][] {
		{"Macbook Pro"},
		{"iMac"},
		{"MacBook"},
		{"MacBook Air"}

	};
}

@Test(dataProvider = "productData")
public void searchTest(String productName) {
resultsPage=accountsPage.doSearch(productName);
Assert.assertTrue(resultsPage.getserachProductListCount()>0);
}

@DataProvider
public Object[][] selectProductData() {
	return new Object[][] {
		{"Macbook Pro","Macbook Pro"},
		{"iMac","iMac"},
		{"MacBook","MacBook Air"},
		{"MacBook Air","MacBook Air"}


	};
}

@Test(dataProvider="selectProductData")
public void selectProduct(String productName,String mainProductName) {
	resultsPage=accountsPage.doSearch(productName);
	resultsPage.selectProduct(mainProductName);
	
}
}
