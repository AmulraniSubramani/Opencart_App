package com.qa.opencart.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.Utilis.Constants;
import com.qa.opencart.pages.ProductInfoPage;

public class ProductInfoTest extends BaseTest{

	@BeforeClass
	public void productInfoPageSetup() {
		accPage=loginpg.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
	
	@DataProvider
	public Object[][] productHeader() {
		return new Object[][] {
			{"macbook","MacBook Pro","MacBook Pro"},
			{"imac","iMac","iMac"},
			{"apple","Apple Cinema 30\"","Apple Cinema 30\""}
			
	};
	}
	
	@Test(dataProvider="productHeader")
	public void productHeaderTest(String searchProductName,String mainProductName,String productHeaderName) {
		resultPage= accPage.doSearch(searchProductName);
		productInfoPage=resultPage.selectProductName(mainProductName);
		String actualHeader=productInfoPage.getProductHeaderText();
		Assert.assertEquals(actualHeader,productHeaderName);
		
	}
	
	@DataProvider
	public Object[][] getImagecount() {
		return new Object[][] {
			{"macbook","MacBook Pro", 4},
			{"imac","iMac",3},
			{"apple","Apple Cinema 30\"",6}
		};
	}
	@Test(dataProvider="getImagecount")
	public void productImageCountTest(String searchProductName,String mainProductName, int imageCount) {
		resultPage=accPage.doSearch(searchProductName);
		productInfoPage=resultPage.selectProductName(mainProductName);
		Assert.assertEquals(productInfoPage.getProductImgCount(),imageCount);
	}
	
	@Test
	public void productMetaDataTest() {
		resultPage= accPage.doSearch("macbook");
		productInfoPage=resultPage.selectProductName("MacBook Pro");
	     Map<String, String> actProdMap=	productInfoPage.getProductMetaData();
//	     System.out.println(actProdMap);
	     actProdMap.forEach((k,v)-> System.out.println(k + ":" + v));
	     softAssert.assertEquals(actProdMap.get("ProductName"),"MacBook Pro1");// adding 1 after pro for fail the case
	     softAssert.assertEquals(actProdMap.get("Brand") , "Apple");
	     softAssert.assertEquals(actProdMap.get("Product Code"), "Product 18");
	     softAssert.assertAll();
		
		
		
	}
}
