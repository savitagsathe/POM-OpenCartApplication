package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.qa.opencart.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil elementUtil;

	private By productHeader=By.cssSelector("div h1");
	private By productImages=By.cssSelector("thumbnails");
	private By addToCart=By.id("button-cart");
	private By prodMetaData=By.xpath("(//div[@id='content' ]//ul[@class='list-unstyled'])[position()=1]/li");
	private By prodPriceData=By.xpath("(//div[@id='content' ]//ul[@class='list-unstyled'])[position()=2]/li");


	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}

	public String getProductHeaderText() {
		return elementUtil.doGetText(productHeader);
		
	}
	public int getProductImagesCount() {
		return elementUtil.waitForElementsVisible(productImages,Constants.DEFAULT_TIME_OUT).size();
	}

	public Map<String, String> getProductMetaData() {
		Map<String, String>prodMap=new HashMap<String, String>();
		String productName=elementUtil.doGetText(productHeader);
		prodMap.put("productName",productName);
		getProdMetaData(prodMap);
		getProdPriceData(prodMap);
		return prodMap;
		
	}
	private void getProdMetaData(Map<String, String>prodMap) {
		List<WebElement>metaList=elementUtil.getElements(prodMetaData);
		for(WebElement e: metaList) {
			String metaText=e.getText();
			String metaKey=metaText.split(":")[0].trim();
			String metaValue=metaText.split(":")[1].trim();
			prodMap.put(metaKey, metaValue);

			
		}
		
	}

	private void getProdPriceData(Map<String, String>prodMap) {
		List<WebElement>priceList=elementUtil.getElements(prodPriceData);
		System.out.println("Price List Size = " + priceList.size());
		
		for(WebElement e : priceList) {
		
		System.out.println(e.getText());
		
		}
			String actPrice=priceList.get(0).getText().trim();
			String exTaxPrice=priceList.get(1).getText().trim();
			prodMap.put("price", actPrice);
			prodMap.put("exTaxPrice", exTaxPrice.split(":")[1].trim());

			
		}
		
	}


