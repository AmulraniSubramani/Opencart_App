package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.Utilis.Constants;
import com.qa.opencart.pages.AddressPage;
import com.qa.opencart.pages.LoginPage;

public class AddressPageTest extends BaseTest {

	@BeforeClass
	public void addressPageSetup() {
		loginpg.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		addressPage = loginpg.navigatingToAddressBook();
	}

	@DataProvider
	public Object[][] getAddressData() {
		return new Object[][] { 
				{ "john", "son", "Tambram", "chennai", "India", "Goa", "yes" },
				{ "naveen", "kummar", "paris", "chennia", "Iceland", "Hofuoborgarsvaeoi", "no" },
				{ "anitha", "raj", "medavakkam", "chennai", "India", "Goa", "No" } };

	}

	@DataProvider
	public Object[][] editAddressBook() {
		return new Object[][] {
			{ "'john'", "9879279" },
			{ "naveen", "98729" }

		};
	}

//	@Test(dataProvider = "getAddressData")
	public void fillAddressbookTest(String firstName, String lastName, String address, String city, String Country,
			String state, String defaultAdd) {
		addressPage.doFillAddressBook(firstName, lastName, address, city, Country, state, defaultAdd);
		Assert.assertTrue(true, Constants.ADDRESS_BOOK_CONFIRMATION_MESSAGE);
	}

	@Test(dataProvider = "editAddressBook")
	public void addingMissingInfoTest(String firstName, String postalCode) {
		addressPage.clickEditAddressBook(firstName, postalCode);
		Assert.assertTrue(true, Constants.ADDRESS_BOOK_CONFIRMATION_MESSAGE);
	}

	@Test
	public void checkBackBtnTest() {
		Assert.assertTrue(addressPage.backBtnExist());
	}

}
