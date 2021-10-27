package com.qa.opencart.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class AddressPageTest extends BaseTest {

	@BeforeClass
	public void addressPageSetup() {
		loginpg.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		}
	
	@DataProvider
	public Object[][] getAddressData() {
		return new Object[][] {
			{"john","son","Tambram","chennai","24563","tamilnadu","yes"},
			{"naveen","kummar","paris","chennia","255469","tamilnadu","no"},
			{"anitha","raj","medavakkam","chennai","65234","tamilnadu","yes"}
		};
		
		
	}
	 
	
	@Test(dataProvider ="getAddressData")
	public void fillAddressbook(String firstName,String lastName,String address,String city,String pincode,String state,String defaultAdd) {
		
		addressPage.doFillAddressBook(firstName, lastName, address, city, state, pincode, state, defaultAdd);  
		
	
	
	
	
	}
}

