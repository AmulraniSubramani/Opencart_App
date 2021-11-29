package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.Utilis.ElementUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("EpicNo:106_Components")
@Story("Search all components")
public class ComponentsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	public ComponentsPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	
	
	private By desktop = By.linkText("Desktops");
	private By component = By.linkText("Components");
	private By showAllCom = By.linkText("Show All Components");
	private By refineSearchSec = By.xpath("//div[@id='content']/h3[contains(text(),'Refine Search')]");
	private By getAllComList = By.xpath("//div[@class='row']/parent::div[@id='content']//following-sibling::ul/li");
	private By monitorsTab = By.xpath("//div[@id='content']/h2[contains(text(),'Monitors')]");
	
	
	

	
	@Step("Landing on All components Page")
	public String selectComponentsMenu() {
		try {
			elementUtil.parentChildMenuHandle(component, showAllCom);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return elementUtil.checkGetTitle();
	}

	@Step("Checking Refine Search is exist or not")
	public boolean refineSearchExist() {
		return elementUtil.doIsDiplayed(refineSearchSec);
	}

	public void getComponentsList(String comNam) {

		List<WebElement> getComList = driver.findElements(getAllComList);
		for (int i = 0; i >= getComList.size(); i++) {
			String comName = getComList.get(i).getText();
			if (comName.equals(comNam)) {
				getComList.get(i).click();
				break;
			}
		}
	}

	public boolean monitorTabExist() {
		return elementUtil.doIsDiplayed(monitorsTab);
	}

}
