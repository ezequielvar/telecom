package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class customerInformation extends BasePage {
	
	final WebDriver driver;
	
	@FindBy (how = How.ID, using = "FirstName")
	private WebElement name;
	
	@FindBy (how = How.ID, using = "LastName")
	private WebElement lastName;
	
	@FindBy (how = How.ID, using = "DocumentType")
	private WebElement documentType;
	
	@FindBy (how = How.ID, using = "DocumentNumber")
	private WebElement document;
	
	@FindBy (how = How.ID, using = "Cuil")
	private WebElement cuil;
	
	@FindBy (how = How.ID, using = "Birthdate")
	private WebElement birthDate;
	
	@FindBy (how = How.ID, using = "Gender")
	private WebElement gender;
	
	@FindBy (how = How.ID, using = "Email")
	private WebElement email;
	
	@FindBy (how = How.ID, using = "MobilePhone")
	private WebElement mobilePhone;
	
	@FindBy (how = How.ID, using = "Phone")
	private WebElement phone;
	
	@FindBy (how = How.ID, using = "OtherPhone")
	private WebElement otherPhone;
	
	@FindBy (how = How.CSS, using = ".vlc-slds-button--tertiary.ng-binding.ng-scope")
	private List<WebElement> buttons;
	
	@FindBy (how = How.CLASS_NAME, using = "ng-binding")
	private List<WebElement> update;
	
	public customerInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String isLastNameRequired() {
		return lastName.getAttribute("required").toString();
	}
	
	public String isEmailRequired() {
		return email.getAttribute("required").toString();
	}
	
	public String isDocumentRequired() {
		return document.getAttribute("required").toString();
	}
	
	public String isBirthDateRequired() {
		return birthDate.getAttribute("required").toString();
	}
	
	public String isGenderRequired() {
		return gender.getAttribute("required").toString();
	}
	
	public String isMobilePhoneRequired() {
		return mobilePhone.getAttribute("required").toString();
	}
	
	public void setFieldsWhichDontTriggerIdentityValidationProcess() {
		name.clear();
		name.sendKeys("Aaa");
		lastName.clear();
		lastName.sendKeys("Aaa");
//		setSimpleDropdown(documentType, "CUIL");
		setSimpleDropdown(gender, "Femenino");
		birthDate.clear();
		birthDate.sendKeys("11/06/1985");
		getElementFromList(update, "Actualizar").click();
	}
	
	public void setDefaultValues() {
		name.clear();
		name.sendKeys("Adrian");
		lastName.clear();
		lastName.sendKeys("Tech");
//		setSimpleDropdown(documentType, "DNI");
		document.sendKeys("32645432");
		setSimpleDropdown(gender, "Masculino");
		birthDate.clear();
		birthDate.sendKeys("06/07/2016");
		getElementFromList(update, "Actualizar").click();
	}
	
	public void setTwoFieldsWhichDontTriggerIdentityValidationProcess() {
		setSimpleDropdown(gender, "Femenino");
		birthDate.clear();
		birthDate.sendKeys("11/06/1985");
		getElementFromList(update, "Actualizar").click();
	}
	
	public void setThreeFieldsWhichTriggerIdentityValidationProcess() {
		setSimpleDropdown(gender, "Femenino");
		document.clear();
		document.sendKeys("32645423");
		birthDate.clear();
		birthDate.sendKeys("11/06/1985");
		getElementFromList(update, "Actualizar").click();
	}
	
	public Boolean isBirthDateAValidDateFormat() {
		birthDate.clear();
		birthDate.sendKeys("11A06[]1985");
		getElementFromList(update, "Actualizar").click();
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	
}
