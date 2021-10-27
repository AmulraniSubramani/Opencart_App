package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Utilis.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("Epic 100: Open cart App - Design Login Page")
@Story("Usesr Story :101 - Copy the story for this testcase from the jira")
public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//1.By locators - Page object/ Object Repository
	private By username=By.id("input-email");
	private By password= By.id("input-password");
	private By loginButton=By.xpath("//input[@value='Login']");
	private By forgotPwdLink=By.linkText("Forgotten Password");
	private By registerLink=By.linkText("Register");
	private By addressBook=By.linkText("Address Book");
	
	//2.Page constructor:
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	
	// 3.Page actions /methods/features:
	
	@Step("getting login title")
	public String getLoginPageTile() {
		return  driver.getTitle();
	}
	
	@Step("getting login page url .....")
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	@Step("Checking forgot password link is exist or not ")
	public boolean forgotPwdLinkExist() {
		System.out.println("Checking - forwardPasswirdLinkExist hi ");
		return elementUtil.doIsDiplayed(forgotPwdLink);
	}
	@Step("Checking forgot Register link is exist or not ")
	public boolean registerLinkExist() {
		return elementUtil.doIsDiplayed(registerLink);
	}
	
	@Step("Login with username : {0} and password : {1}")
	public AccountsPage doLogin(String um,String pwd) {
		elementUtil.doSendKeys(username, um);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);
		
	}
	
	@Step("Navigating to Registration page")
	public RegistrationPage navigateToRegPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}
	
	@Step("Navigating to AddressBook Page")
	public AddressPage navigatingToAddressBook() {
		elementUtil.doClick(addressBook);
		return new AddressPage(driver);
	}
}
