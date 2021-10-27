package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utilis.ElementUtil;

import io.qameta.allure.Step;

public class AddressPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	// constructor
	public AddressPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	// private By locators
	private By addNewAddress=By.linkText("New Address");
	private By back=By.linkText("Back");
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By addressOne=By.id("input-address-1");
	private By city=By.id("input-city");
	private By postalCode=By.id("input-postcode");
	private By selectCountry=By.id("input-country");
	private By selectState=By.id("input-zone");
	private By defaultAddressYes=By.xpath("//input[@value='1']");
	private By defaultAddressNo=By.xpath("//input[@value='0']");
	private By doContinue=By.xpath("//input[@value='Continue']");
	
	
	//Page Actions

	@Step("Getting page title of AddressBook")
	public String getTitleofAddressBook() {
		return elementUtil.checkGetTitle();
	}
	
	@Step("Checking NewAddress link is exist or not")
	public boolean newAddressLinkExist() {
		return elementUtil.doIsDiplayed(addNewAddress);
	}
	
	@Step("Checking back button is exist or not")
	public boolean backBtnExist() {
		return elementUtil.doIsDiplayed(back);
	}
	
	
	@Step("Adding new address")
	public void doFillAddressBook(String fName,String lName,String addressOne,String city,String postalCode,String country,String state,String defaultValue) {
		addressBook(fName, lName, addressOne, city, postalCode, country, state);
		selectDefaultAddress(defaultValue);
		selectContinue();
	}
	
	
	@Step("Select the default address")
	private void selectDefaultAddress(String defaultAddress) {
		if(defaultAddress.equalsIgnoreCase("yes")) {
			elementUtil.doClick(this.defaultAddressYes);
		}
		else{
			elementUtil.doClick(this.defaultAddressYes);
		}
	}
	
	@Step("Click on continue button to save the address")
	private void selectContinue() {
		elementUtil.doClick(doContinue);
	}
	
	@Step("Adding address")
	private void addressBook(String fName,String lName,String addressOne,String city,String postalCode,String country,String state) {
		elementUtil.doClick(this.addNewAddress);
		elementUtil.doSendKeys(this.firstName,fName);
		elementUtil.doSendKeys(this.lastName, lName);
		elementUtil.doSendKeys(this.addressOne, addressOne);
		elementUtil.doSendKeys(this.city, city);
		elementUtil.doSendKeys(this.postalCode, postalCode);
		
		elementUtil.doSelectByValue(this.selectCountry, country);
		elementUtil.doSelectByValue(this.selectState, state);
		
			
	}
	public void selectCountry(String country) {
		elementUtil.doSelectByValue(this.selectCountry,country);
	}

	
	
	
}
