package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utilis.Constants;
import com.qa.opencart.Utilis.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	//By locators 
	private By search=By.name("search");
	private By searchIcon=By.xpath("//span[@class='input-group-btn']/button");
	private By logoutLink=By.linkText("Logout");
	private By accSecHeaders=By.cssSelector("div#content h2"); // xpath=//div[@id='content']/h2
	private By component = By.linkText("Components");
	
	// constructor
	public AccountsPage(WebDriver driver) {
	this.driver=driver;	
	elementUtil= new ElementUtil(driver);
	}
	
	 //Page Actions
	
	public String getAccPageTitle() {
		return elementUtil.waitForTitleToBe(Constants.DEFAULT_TIME_OUT, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	public boolean islogoutLinkExist() {
		return elementUtil.doIsDiplayed(logoutLink);
	}
	
	public boolean isSearchFiledExist() {
		return elementUtil.doIsDiplayed(search);
	}
	
	public List<String> getAccountSecList() {
		List<WebElement> secList =elementUtil.getElements(accSecHeaders);
		List<String> secHeaderList= new ArrayList<String>();
		for(WebElement e:secList) {
			secHeaderList.add(e.getText());
		}
		
		return secHeaderList;
	}
	
	public void accPagelogOut() {
		elementUtil.doClick(logoutLink);
	}
	
	
	public ResultsPage doSearch(String productName) {
		System.out.println("Product name is  :" + productName);
		elementUtil.doSendKeys(search, productName);
		elementUtil.doClick(searchIcon);
		return new ResultsPage(driver);  // test driven development
	}
	
	
}
