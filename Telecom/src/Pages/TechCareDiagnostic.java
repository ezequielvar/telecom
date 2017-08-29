package Pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TechCareDiagnostic extends BasePage  {

	final WebDriver driver;
	public TechCareDiagnostic(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
}
	//Case information
	
			@FindBy (how = How.CLASS_NAME, using = "x-grid3-row")
			private WebElement celdafile;
	
			@FindBy (how = How.XPATH, using = "//*[@id=\'00Bc0000001K9hz_rolodex\']/a[17]/span")
			private WebElement filterP;
	
			@FindBy (how = How.XPATH, using = "//*[@id=\'ext-gen11\']/div[1]/table/tbody/tr/td[9]")
			private WebElement celdavalue;
			
			@FindBy (how = How.XPATH, using = "//*[@id=\'00Nc0000001pWdh_selected\']")
			private WebElement listselect;
			
			@FindBy (how = How.XPATH, using = "//*[@id=\'00Nc0000001pWdh_unselected\']")
			private WebElement listunselect;
			
			@FindBy (how = How.CLASS_NAME, using = "picklistArrowLeft")
			private WebElement deselectvalue;
			
			@FindBy (how = How.CLASS_NAME, using = "picklistArrowRight")
			private WebElement selectvalue;
			
			@FindBy (how = How.XPATH, using = "//*[@id=\'saveButton\']")
			private WebElement save;
			
		//Methods
		public void selectfile() {
			Actions action = new Actions(driver);   
			filterP.click();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			action.moveToElement(celdavalue).doubleClick().perform();}
			
		public void clearvalues() {
			Select dateDropDown=new Select(listselect);
			for(int i=0; i<=15; i++) {
			try {String b = Integer.toString(i);
			dateDropDown.selectByValue(b);
			deselectvalue.click();}catch (org.openqa.selenium.NoSuchElementException e){}}
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}}
		
		public void selectvalues(String value) {
			switch(value) {
			case "UP/UP":
				setSimpleDropdown(listunselect, value);
				break;
			case "UP/DOWN":
				setSimpleDropdown(listunselect, value);
				break;
			case "DOWN/DOWN":
				setSimpleDropdown(listunselect, value);
				break;
			case "Sin Sesion":
				setSimpleDropdown(listunselect, value);
				break;
			}
			
			selectvalue.click();
			save.click();}
		
		public void validvalue(String value) {
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			switch(value) {
			case "UP-UP":
				Assert.assertEquals(celdavalue.getText() ,value);
				break;
			case "UP-DOWN":
				Assert.assertEquals(celdavalue.getText() ,value);
				break;
			case "DOWN-DOWN":
				Assert.assertEquals(celdavalue.getText() ,value);
				break;
			case "Sin Sesion":
				Assert.assertEquals(celdavalue.getText() ,value);
				break;}
			}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
