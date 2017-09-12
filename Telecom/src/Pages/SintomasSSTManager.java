package Pages;


import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SintomasSSTManager extends BasePage{
	
	//page_link = https://cs14.salesforce.com/a41?fcf=00Bc0000001LRmb&rolodexIndex=-1&page=1
	//Lista de todos los motivos.
	
	WebDriver driver;
	
	@FindBy (how = How.NAME, using ="fcf")
	private WebElement toSeeSelect; //selector.

	@FindBy (how = How.CLASS_NAME, using ="x-grid3-scroller")
	private WebElement symptomsWrapper;
	
	//ADMIN manager elements
	@FindBy (how = How.ID, using ="ext-gen10")
	private WebElement symptomsWrapperForAdmin; //selector.
	
	public SintomasSSTManager(WebDriver driver){
		this.driver = driver;
		driver.switchTo().defaultContent();//this is in mainPage, so no iframes.
        PageFactory.initElements(driver, this);
	}
	
	public void selectToSeeByName(String option) {
		setSimpleDropdown(toSeeSelect, option);
	}
	
	public List<String> getSymptomsRegisterNumbers(){
		driver.switchTo().defaultContent();
		List<String> symptomsRegNums = new ArrayList<String>();
		List<WebElement> symptoms = symptomsWrapper.findElements(By.className("x-grid3-row-table"));
		for(WebElement symptom : symptoms) {
			//index 3
			symptomsRegNums.add(symptom.findElements(By.className("x-grid3-col")).get(3).getText());
		}
		return symptomsRegNums;
	}
	
	//ADMIN Manager methods
	
	public List<WebElement> getSymptoms(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));//The first iframe is the right one.
		List<WebElement> symptoms = symptomsWrapperForAdmin.findElements(By.className("x-grid3-row"));
		return symptoms;
	}	
	
	public List<String> getSymptomsRegisterNumbersForAdmin(){
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));//The first iframe is the right one.
		List<String> symptomsRegNums = new ArrayList<String>();
		for(WebElement symptom : getSymptoms()) {
			//index 3
			symptomsRegNums.add(symptom.findElements(By.className("x-grid3-col")).get(3).getText());
		}
		return symptomsRegNums;
	}	
	
	public boolean isSymptomActive(WebElement symptom) {
		String imgAttrSelected = symptom.findElements(By.className("x-grid3-col")).get(7).findElement(By.tagName("img")).getAttribute("alt");
		if(imgAttrSelected.toLowerCase().contains("no")){//"No seleccionado" is the alt text for checkbox img.
			return false;
		}else {
			return true;
		}
	}
	
	public WebElement getFirstActiveSymptom() {
		for(WebElement symptom : getSymptoms()) {
			if(isSymptomActive(symptom)) {
				return symptom;
			}
		}
		return null;
	}
	
	public void setSymptomState(WebElement symptom, boolean active) {
		WebElement checkBox = symptom.findElements(By.className("x-grid3-col")).get(7);
		if(isSymptomActive(symptom) == active) {
			//do nothing, the state is already the desired
			//should say No seleccionado
		}else {
			Actions action = new Actions(driver);
			action.moveToElement(checkBox).doubleClick().perform();
			try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("massEditFieldDiv")).findElement(By.tagName("input")).click();
			driver.findElement(By.id("saveButton")).click();
		}
	}
	

	
}
