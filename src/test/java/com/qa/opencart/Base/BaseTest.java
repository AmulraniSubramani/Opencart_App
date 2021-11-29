package com.qa.opencart.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import com.qa.opencart.Factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.AddressPage;
import com.qa.opencart.pages.ComponentsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	public WebDriver driver; // rightnow its pointing to null
	public Properties prop;
	public DriverFactory df;
	public LoginPage loginpg;
	public AccountsPage accPage;
	public ResultsPage resultPage;
	public ProductInfoPage productInfoPage;
	public RegistrationPage registrationPage;
	public AddressPage addressPage;
	public ComponentsPage compPage;
	

	public SoftAssert softAssert;
	
	
	//@Parameters({"browser","browserversion"}) // accessing this parameters from testng xml file
	@Parameters({"browser", "browserversion"})
	@BeforeTest
	public void setUp(String browser, String browserVersion) {
		df = new DriverFactory();
		prop = df.initProp();
		
		if(browser!=null) {
			prop.setProperty("browser", browser);
			prop.setProperty("browserversion", browserVersion);
		}
		
		driver = df.initDriver(prop); // now only it gets value
		loginpg = new LoginPage(driver);
		softAssert = new SoftAssert();
		compPage= new ComponentsPage(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}	
