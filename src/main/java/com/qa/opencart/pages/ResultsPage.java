package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class ResultsPage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    
	private By searchHeader=By.cssSelector("div #content h1");
	private By productResult=By.cssSelector("div.caption a");
	
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
		
	}
	
	public String getSearchHeaderName() {
		return elementUtil.doGetText(searchHeader);
	}
	
	public int getserachProductListCount() {
		return elementUtil.waitForElementsVisible(productResult, Constants.DEFAULT_TIME_OUT).size();
	}
	
	public ProductInfoPage selectProduct(String productName) {
		List<WebElement>searchList= elementUtil.waitForElementsVisible(productResult, Constants.DEFAULT_TIME_OUT);
        for(WebElement e:searchList) {
        	String text=e.getText();
        	if(text.equals(productName)) {
        		e.click();
        		break;
        	}
        }
        return new ProductInfoPage(driver);
	}

	
	
}
