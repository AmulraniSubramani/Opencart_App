package com.qa.opencart.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.Utilis.Constants;
import com.qa.opencart.Utilis.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
@Epic("Epic No:105_OpenCart_AddressBook")
@Story("Creating Address Book")
public class AddressPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	static String name;
	public static final Logger LOG= Logger.getLogger(AddressPage.class);
	
	// constructor
	public AddressPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	// private By locators
	private By addressBook= By.linkText("Address Book");
	private By addNewAddress=By.linkText("New Address");
	private By back=By.linkText("Back");
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By addressOne=By.id("input-address-1");
	private By city=By.id("input-city");
	private By postalCode=By.id("input-postcode");
	private By selectCountry=By.xpath("//div[@class='col-sm-10']/select[@name='country_id']");
	private By selectState=By.id("input-zone");
	private By defaultAddressYes=By.xpath("//input[@value='1']");
	private By defaultAddressNo=By.xpath("//input[@value='0']");
	private By doContinue=By.xpath("//input[@value='Continue']");
//	private By editAddress=By.xpath("//a[@href='https://demo.opencart.com/index.php?route=account/address/edit&address_id=16930']//preceding::td//following::a[position()=1]");
	private By editAdd=By.xpath("//td[@class='text-left' and contains(text(),'"+name+"')]//following::a[@href='https://demo.opencart.com/index.php?route=account/address/edit&address_id=16930']");
	String editXpathName = "//td[@class='text-left' and contains(text(),";
	String editXpathPartTwo=")]//following::a[@href='https://demo.opencart.com/index.php?route=account/address/edit&address_id=16930']";
	

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
	@Severity(SeverityLevel.CRITICAL)
	public void doFillAddressBook(String fName,String lName,String addressOne,String city,String country,String state,String defaultValue) {
		addressBook(fName, lName, addressOne, city);
		selectCountry(country);
		selectRegion(state);
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
	private void addressBook(String fName,String lName,String addressOne,String city) {
		
		elementUtil.waitForElementsVisible(addressBook, Constants.DEFAULT_TIME_OUT); // click on address book
		elementUtil.doClick(this.addNewAddress);
		
		elementUtil.doSendKeys(this.firstName,fName);
		elementUtil.doSendKeys(this.lastName, lName);
		elementUtil.doSendKeys(this.addressOne, addressOne);
		elementUtil.doSendKeys(this.city, city);
	}
	@Step("Selecting the country")
	private void selectCountry(String country) {
		elementUtil.waitForElementVisible(selectCountry, Constants.DEFAULT_TIME_OUT);
		elementUtil.doClick(selectCountry);
		elementUtil.doSelectByVisibleText(this.selectCountry,country);
	}
	
	@Step("Selecting the Region/State")
	private void selectRegion(String region) {
		elementUtil.doSelectByVisibleText(this.selectState,region);
	}
	
	
	@Step("Edit the AddessBook and fill the mised information")
	@Severity(SeverityLevel.NORMAL)
	public void clickEditAddressBook(String name,String addPostalCode) {
		By editAddress=By.xpath(editXpathName + name +editXpathPartTwo);
		elementUtil.doClick(editAddress);
		LOG.info("Xpath" + editXpathName);
		elementUtil.doSendKeys(postalCode, addPostalCode);
		selectContinue();
		
	}
	
	
	}
	
	
	
	
	
	

	
	
	

