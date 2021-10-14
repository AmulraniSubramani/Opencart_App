package com.qa.opencart.Tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.Utilis.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Epic("Epic 100: Open cart App - Design Login Page")
@Story("Usesr Story :101 - Copy the story for this testcase from the jira")

public class LoginPageTest extends BaseTest {

	@Description("Login page titile test")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageTileTest() {
		String title= loginpg.getLoginPageTile();
		System.out.println("Actual page title is: " + title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageUrlTest() {
		String url= loginpg.getLoginPageUrl();
		System.out.println("Actual page title is: " + url);
		Assert.assertTrue(url.contains(url), Constants.LOGIN_PAGE_URL_VALUE);

	}

	@Test
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginpg.forgotPwdLinkExist());
	}
	
	@Test // commenting this test since TestNg executes alphabetic order
	public void registrationLinkTest() {
		Assert.assertTrue(loginpg.registerLinkExist());
	}
	
 
	@Description("Login page Test...")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		loginpg.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
}
