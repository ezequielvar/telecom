package Pages;


import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SintomasSSTManager extends BasePage{
	
	//page_link = https://cs14.salesforce.com/a41?fcf=00Bc0000001LRmb&rolodexIndex=-1&page=1
	//Lista de todos los motivos.
	
	WebDriver driver;
	
	@FindBy (how = How.ID, using ="fcf")
	private WebElement toSeeSelect; //selector.
	
	public SintomasSSTManager(WebDriver driver){
		this.driver = driver;
		driver.switchTo().defaultContent();//this is in mainPage, so no iframes.
        PageFactory.initElements(driver, this);
	}
	
	public void selectToSeeByName(String option) {
		setSimpleDropdown(toSeeSelect, option);
	}
	
}
