package com.qa.opencart.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.Utilis.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Epic: 200 - Open Cart App - Components Page")
@Story("User Story: This is components Page Test")
public class ComponentsPageTest  extends BaseTest{
	
	
	@Description("This is precondition for components page test")
	@Severity(SeverityLevel.BLOCKER)
	@BeforeClass
	public void componentsPageTestSetupTest() {
		loginpg.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
	}
	
	
	@Description("This is component page landing test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void componentsPageLandingTest() {
	  
	  Assert.assertEquals(compPage.selectComponentsMenu(),Constants.COMPONENTS_PAGE_TITILE);
		
	}
	
	
	@Description("This is refineSearch Test")
	@Test
	public void refineSearchTest() {
		compPage.getComponentsList("Monitors");
		Assert.assertTrue(compPage.refineSearchExist());
	}
	
//	@Test
	public void componentMonitorSelectTest() {
		compPage.getComponentsList("Monitors");
	}
	

}
