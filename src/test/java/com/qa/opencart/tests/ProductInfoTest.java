package com.qa.opencart.tests;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class ProductInfoTest extends BaseTest{
	@BeforeClass
	public void productInfoSUetUp() {
		accountsPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	
	@DataProvider
	public Object[][] ProductHeaderData() {
		return new Object[][] {

			{"macbook","MacBook Pro","MacBook Pro"},
			{"iMac","iMac","iMac"},
			{"Apple","Apple Cinema 30\"","Apple Cinema 30\""},
			{"MacBook Air","MacBook Air","MacBook Air"}

		};
	}
	@Test(dataProvider="ProductHeaderData")
	public void getProductHeaderTextTest(String productName,String mainproduct,String productHeader) {
		resultsPage=accountsPage.doSearch(productName);
		productInfoPage=resultsPage.selectProduct(mainproduct);
		String actHeader=productInfoPage.getProductHeaderText();
		Assert.assertEquals(actHeader, productHeader);
	}
	@DataProvider
	public Object[][]  getImageData() {
		return new Object[][] {
			{"macbook","MacBook Pro",4},
		{"iMac","iMac",3},
		{"Apple","Apple Cinema 30\"",6},
		{"MacBook Air","MacBook Air",4}

		};
	}
	@Test(dataProvider="getImageData")

	public void getProductImagesCountTest(String productName,String mainproduct,int imageCount) {
		resultsPage=accountsPage.doSearch(productName);
		productInfoPage=resultsPage.selectProduct(mainproduct);
		Assert.assertEquals(productInfoPage.getProductImagesCount(), imageCount);
	}
	
	@Test
	public void getProductMetaDataTest() {
		resultsPage=accountsPage.doSearch("macbook");
		productInfoPage=resultsPage.selectProduct("MacBook Pro");
		Map<String, String>actProdMap=productInfoPage.getProductMetaData();
		actProdMap.forEach((k,v)->System.out.println(k +":"+ v));
		softAssert.assertEquals(actProdMap.get("productName"),"MacBook Pro");
		softAssert.assertEquals(actProdMap.get("Brand"),"Apple");
		softAssert.assertEquals(actProdMap.get("Product Code"),"Product 18");
		softAssert.assertEquals(actProdMap.get("price"),"$2,000.00");
		softAssert.assertAll();



	}
}
