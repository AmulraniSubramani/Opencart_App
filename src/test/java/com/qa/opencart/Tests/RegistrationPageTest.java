package com.qa.opencart.Tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.Base.BaseTest;
import com.qa.opencart.Utilis.Constants;
import com.qa.opencart.Utilis.ExcelUtil;

public class RegistrationPageTest  extends BaseTest{ 	

	@BeforeClass
	public void registrationPageSetup() {
		registrationPage= loginpg.navigateToRegPage();
	}
	
	@DataProvider
	public Object[][] getRegTestData() {
//		Object datas[][]=excelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		Object data[][] = ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
		return data;
	}
	public String getRandomNumer() {
		Random random=new Random();
		String email="automationlearners"+random.nextInt(100000)+"@gmail.com";
		return email;
	}
	
	@Test(dataProvider="getRegTestData")
	public void registrationFormTest(String fn,String ln,String telephe,String password,String subscribe) {
		Assert.assertTrue(registrationPage.registrionForm(fn,ln,getRandomNumer(),telephe,password,subscribe));
		
}
}
