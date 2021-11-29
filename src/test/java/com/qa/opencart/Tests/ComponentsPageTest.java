package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.Utilis.Constants;


public class ComponentsPageTest  extends BaseTest{
	
	
	
	@BeforeClass
	public void componentsPageTestSetupTest() {
		loginpg.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}
	
	@Test
	public void componentsPageLandingTest() {
	  
	  Assert.assertEquals(compPage.selectComponentsMenu(),Constants.COMPONENTS_PAGE_TITILE);
		
	}
	
	
	@Test
	public void refineSearchTest() {
		Assert.assertTrue(compPage.refineSearchExist());
	}
	
	

}
