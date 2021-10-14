package com.qa.opencart.Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.Utilis.Constants;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;


@Epic("Epic 200: Open cart App - Design Accounts Page")
@Story("Usesr Story :201 - Copy the story for this testcase from the jira")
public class AccountPageTest extends BaseTest {

	@BeforeClass
	public void accPageSetup() {
		accPage=loginpg.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		System.out.println(prop.getProperty("username").trim());
		System.out.println(prop.getProperty("password").trim());
	}
	
	 	
	@Test
	public void accPageTitleTest() {
		String title= accPage.getAccPageTitle();
		System.out.println("Account page title is:" + title);
		Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
	} 
	
	@Test
	public void accPageLogoutLinkTest() {
		Assert.assertTrue(accPage.islogoutLinkExist());
	}
	
	@Test
	public void accPagesearchFieldExistTest() {
		Assert.assertTrue(accPage.isSearchFiledExist());
	}
	
	@Test
	public void accPageSecListTest() {
		List<String> actSecHeaderList=accPage.getAccountSecList();
		System.out.println(actSecHeaderList);
		Assert.assertEquals(actSecHeaderList, Constants.EXP_ACCOUNTS_SEC_LIST);
		
	}
	
	@DataProvider  // return type of dataprovider is 2d array
	public Object[][] productData() {
		return new Object[] [] {
			{"macbook"}, 
			{"iMac"},
			{"Apple"}
		};
	}
	
	@DataProvider  // return type of dataprovider is 2d array
	public Object[][] productSelectData() {
		return new Object[] [] {
			{"macbook","MacBook"}, // {searchkey},{productName}
			{"iMac","iMac"},
			{"Apple","Apple Cinema 30\""}// (/" its a escapting charachter, we are telling to java to take that/" to search the value)
		};
	}
	

	//What is datadriven ? it means driving the data from the external source
	
	@ Test(dataProvider="productData")
	public void searchTest(String productName) {
		resultPage =accPage.doSearch(productName);
		Assert.assertTrue(resultPage.searchProductListCount()>0);
	}
	@Test(dataProvider="productSelectData")
	public void selectProductTest(String productName,String mainProductName) {
		resultPage=accPage.doSearch(productName);
		resultPage.selectProductName(mainProductName);
		
	}
	
//	@Test // it executes in alphabetic order so, i commented this test
	public void accPageLogoutTest() {
		accPage.accPagelogOut();
	}
}
