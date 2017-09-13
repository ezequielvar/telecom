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
	
	@FindBy (how = How.NAME, using ="new")
	private WebElement newSymptomBtn; //button New.	
	
	//Symptom creation page link: https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd
	@FindBy (how = How.ID, using ="Name")
	private WebElement nameInput; //input textBox
	
	@FindBy (how = How.TAG_NAME, using ="textarea")
	private WebElement description; //textArea
	
	@FindBy (how = How.ID, using ="00Nc000000247uu")
	private WebElement activeCheckbox; //input checkBox //could not be working.
	
	@FindBy (how = How.NAME, using ="save")
	private WebElement saveBtn; //button
	
	public SintomasSSTManager(WebDriver driver){
		this.driver = driver;
		driver.switchTo().defaultContent();//this is in mainPage, so no iframes.
        PageFactory.initElements(driver, this);
	}
	
	public void selectToSeeByName(String option) {
		setSimpleDropdown(toSeeSelect, option);
	}
	
	public String getSymptomName(WebElement symptom) {
		return symptom.findElements(By.className("x-grid3-col")).get(5).getText();
	}
	
	//works for both pages! :D
	public WebElement getSymptomByName(String symptomName) {
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for(WebElement frame : frames) {
			try {
				driver.switchTo().frame(frame);
				List<WebElement> symptoms = symptomsWrapper.findElements(By.className("x-grid3-row-table"));
				for(WebElement symptom : symptoms) {
					//index 3
					//System.out.println(getSymptomName(symptom)); uncomment to see if it still works.
					//Must be the page Sintomas de STT
					if(getSymptomName(symptom).equals(symptomName)) {
						return symptom;
					}
				}
				break;
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
			}	
		}
		return null; //symptom not found.
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
	
	//deletes all symptoms in the first page with the given name
	public void deleteAllSymptomsByName(String symptomName) {
		//int i = 0; //uncomment* to show how many symptoms were deleted.
		while(getSymptomByName(symptomName) != null) {
			deleteSymptomByName(symptomName);
			//i++; //uncomment*
			//increase sleep time if needed.
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		}
		//System.out.println(Integer.toString(i) + " sintomas, fueron borrados."); //uncomment*
	}
	
	public void deleteSymptomByName(String symptomName) {
		deleteSymptom(getSymptomByName(symptomName));
	}
	
	public void deleteSymptom(WebElement symptomToDelete) {
		//3th column, 2nd "a" is delete.
		symptomToDelete.findElements(By.className("x-grid3-col")).get(2).findElements(By.tagName("a")).get(1).click();
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Alert alert = driver.switchTo().alert();
	    alert.accept();
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
	
	public void goToCreateNewSymptom() {
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for(WebElement frame : frames) {
			try {
				driver.switchTo().frame(frame);
				newSymptomBtn.click();
				break;
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
			}	
		}
	}
	
	//Create NEW Symptom Page methods
	public void fillAndSaveCustomSymptom(String name, String descripcion) {
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for(WebElement frame : frames) {
			try {
				driver.switchTo().frame(frame);
				nameInput.sendKeys(name); //each element is in the same iframe.
				break;
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
			}
		}
		description.sendKeys(descripcion);
		saveBtn.click();
	}
	
	public void fillAndSaveCustomSymptom(String name, String descripcion, boolean activated) {
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for(WebElement frame : frames) {
			try {
				driver.switchTo().frame(frame);
				nameInput.sendKeys(name); //each element is in the same iframe.
				break;
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
			}
		}
		description.sendKeys(descripcion);
		if(activated) {
			activeCheckbox.click();
		}
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}//delete, just to test
		driver.switchTo().defaultContent();
		for(WebElement frame : frames) {
			try {
				driver.switchTo().frame(frame);
				saveBtn.click();
				break;
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
			}
		}
	}
	

	
}
