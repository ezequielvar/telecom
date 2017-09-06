package Pages;


import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactMotivesManager extends BasePage{
	
	//page_link = https://cs14.salesforce.com/a41?fcf=00Bc0000001LRmb&rolodexIndex=-1&page=1
	
	WebDriver driver;
	
	@FindBy (how = How.ID, using ="ext-gen10")
	private WebElement motivesList; //input.
	
	public ContactMotivesManager(WebDriver driver){
		this.driver = driver;
		driver.switchTo().defaultContent();//this is in mainPage, so no iframes.
        PageFactory.initElements(driver, this);
	}
	
	public WebElement getMotivesWrapper() {
		return motivesList;
	}
	
	public WebElement getMotiveByName(String motiveName) {
		List<WebElement> motives = getMotivesWrapper().findElements(By.className("x-grid3-row"));
		String currentMotiveName = "";
		for (WebElement motive : motives) {
			currentMotiveName = motive.findElements(By.className("x-grid3-col")).get(4).getText();//index 4 is the index.
			if (currentMotiveName.equals(motiveName)) {
				return motive;
			}
		}
		return null;
	}

	public void deleteMotiveByName(String motiveName) {
		WebElement motive = getMotiveByName(motiveName);
		motive.findElements(By.className("x-grid3-col")).get(2).findElements(By.tagName("a")).get(1).click();//3 is the index for "Eliminar"
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
}
