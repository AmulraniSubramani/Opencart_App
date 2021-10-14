package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.opencart.Utilis.Constants;
import com.qa.opencart.Utilis.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//By locators
		private By productHeader=By.cssSelector("div#content h1"); // id=content
		private By productImages= By.cssSelector("ul.thumbnails img"); // //ul[@class='thumbnails']//img
		private By productQuantity=By.id("input-quantity");
		private By addToCart =By.id("button-cart");
		private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
		private By productPriceData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
			
		
		
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	
	
	
	public String getProductHeaderText() {
		return elementUtil.doGetText(productHeader);
	}
	
	public int getProductImgCount() {
//		List<WebElement> productCount=  elementUtil.getElements(productImages);
		return elementUtil.waitForElementsVisible(productImages, Constants.DEFAULT_TIME_OUT).size();
		
	}
	
	
	public Map<String, String> getProductMetaData() {
		
		Map<String, String> proMap= new HashMap<String, String>();
		String productName=elementUtil.doGetText(productHeader);
		proMap.put("ProductName", productName);
		getProdMetaData(proMap);
		getProdPriceData(proMap);
		return proMap;
		
	}
	
	
	/*
	 * Brand: Apple
	Product Code: Product 18
	Reward Points: 800
	Availability: Out Of Stock
	 */
	
	private void getProdMetaData(Map<String, String> proMap) {
		List<WebElement> metaList=elementUtil.getElements(productMetaData);
		for(WebElement e:metaList) {
			String metaText=e.getText();
			String metaKey=metaText.split(":")[0].trim();
			String metaVakue=metaText.split(":")[1].trim();
			 proMap.put(metaKey, metaVakue); 
			}
		
	}
	
	private void getProdPriceData(Map<String, String> priceMap) {
		List<WebElement> priceList=elementUtil.getElements(productPriceData);
		String actPrice=priceList.get(0).getText().trim();
		String exTaxPrice=priceList.get(1).getText().trim();
		priceMap.put("price",actPrice);
		priceMap.put("ExTaxPrice", exTaxPrice.split(":")[1]);	
		
		
	}
}
