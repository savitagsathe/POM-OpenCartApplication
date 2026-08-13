package com.qa.opencart.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
WebDriver driver;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public void flash(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
			
		String bgcolor=element.getCssValue("backgroundcolor");
			for(int i=0;i<15;i++)
			{
				changeColor("rgb(0,200,0)",element);//1
				changeColor(bgcolor, element);//2
			}
		
	}

	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
		
	}
	
	//i have added this to test locator works or not bcoz it was asking for the Webelement
	public void clickElementByJSLocator(By locator) {
		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments(0).click();",locator);
	}
	
	public void sendKeysWithId(String id,String value) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('"+id+"').value='"+value+"'");
		
	}
	
	private void changeColor(String color, WebElement element) {
		
		JavascriptExecutor js=((JavascriptExecutor)driver);

		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			
		}
	}
	
	public String getTitleByJS()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return js.executeScript("return document.title:").toString();
	}
	
	public void refreshBrowserByJS() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("history.go(0)");

	}
	
	public void scrollPageDown() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        
	}
	public void scrollPageDown(String height) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,'"+height+"')");
        
	}
	
	public void scrollPageUp() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
	}
	
	public void scrollIntoview(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

}
