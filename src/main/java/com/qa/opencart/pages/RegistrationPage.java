package com.qa.opencart.pages;



import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import com.qa.opencart.Utilis.Constants;
import com.qa.opencart.Utilis.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	//By locators
	
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telePhone=By.id("input-telephone");
	
	private By password=By.id("input-password");
	private By confirmPassword=By.id("input-confirm");
	
	private By subscribeYes=By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo=By.xpath("//label[@class='radio-inline'][position()=2]/input");
	
	private By agreeCheckBox=By.name("agree");
	private By continueBtn=By.xpath("//input[@type='submit']");
	private By successMsg=By.cssSelector("div#content h1");
	
	private By failureMsg=By.id("a");
	private By logOutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	

	
	public boolean registrionForm(String firstName,String lastName,String email,String telephone,String password,String subscribe) {
		
		fillRegForm(firstName, lastName, email, telephone, password);
		selectSubscribeOption(subscribe);
		selectAgreementAndContinue();
		return getRegistrationStatus();
	}
	
	private boolean getRegistrationStatus() {
		String msg=elementUtil.doGetText(successMsg);
		if(msg.contains(Constants.REGISTER_SUCCESS_MESSAGE)) {
			elementUtil.doClick(logOutLink);
			elementUtil.doClick(registerLink);
			return true;
		}
		return false;
	}
	
	private void selectAgreementAndContinue() {
		elementUtil.doClick(agreeCheckBox);
		elementUtil.doClick(continueBtn);
		
	}
	private void selectSubscribeOption(String subscribe) {
		if(subscribe.equalsIgnoreCase("yes")) {
			elementUtil.doClick(this.subscribeYes);
		}
		else {
			elementUtil.doClick(this.subscribeNo);
		}
	}
	private void fillRegForm(String firstName,String lastName,String email,String telephone,String password) {
		elementUtil.doSendKeys(this.firstName, firstName);
		elementUtil.doSendKeys(this.lastName, lastName);
		elementUtil.doSendKeys(this.email, email);
		elementUtil.doSendKeys(this.telePhone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmPassword, password);
		
	}
	 
}
