package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContactSearch;
import Pages.ValidationMethodSelection;
import Pages.setConexion;
import Pages.BasePage;
import Pages.ContactInformation;
import Tests.ValidationByDni;


public class newClient extends TestBase {
	
	private WebDriver driver;
	String Name = "Pepeasd";
	String LastName = "Argentoasd";
	String DateOfBirthday = "06/07/1988";
	String DNI = "Documento Nacional de Identidad";
	String[] DocValue = {"10000000","3569874563","365","ssss"};
	private String validationType = "document";
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	
	
	
	@BeforeMethod
	public void setup() throws Exception {
		driver.get("https://goo.gl/ULLWHZ");
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ContactSearch conts = new ContactSearch(driver);
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		conts.searchContact(DNI, DocValue[0], "femenino");
		conts.sex("femenino");
		driver.findElement(By.id("ContactInfo_nextBtn")).click();
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ContactInformation page = new ContactInformation(driver);
		page.setContactInformation(Name, LastName, DateOfBirthday);
		driver.findElement(By.cssSelector(".slds-checkbox--faux")).click();
		driver.findElement(By.id("Contact_nextBtn")).click();
		ValidationMethodSelection validation = new ValidationMethodSelection(driver);
		validation.setValidationType(validationType);
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\Sofia Chardin\\Desktop\\Codigo de seguridad.PNG");
		driver.findElement(By.id("DocumentMethod_nextBtn")).click();
	}
	
	@Test
	public void TS6999_verifyFieldDepartmentEmpty()
	{
		assertTrue(driver.findElement(By.id("Department")).getAttribute("value").isEmpty());
	}
	
	@Test
	public void TS7000_lineaIdentificatory()
	{
		driver.findElement(By.id("IdPhone")).sendKeys("1234568745");
	}
	
	@Test
	public void TS7001_verifyCheckBoxLineIdentificatory()
	{
		driver.findElement(By.cssSelector(".slds-checkbox--faux")).click();
		assertFalse(driver.findElement(By.id("IdPhone")).isDisplayed());
	}
	
	@Test
	public void TS7002_mandatoryTaxCondition()
	{
		BasePage page = new BasePage();
		WebElement CI = driver.findElement(By.id("ImpositiveCondition"));
		page.setSimpleDropdown(CI, "-- Clear --");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-select-control.ng-scope.ng-dirty.ng-valid-parse.ng-invalid.ng-invalid-required"));
	}
	
	@Test
	public void TS7004_verifyFieldsNameAndLastname()
	{
		String a;
		a = driver.findElement(By.id("ContactName")).getText();
		assertEquals(a, "pepe argento");
	}
	
	@Test
	public void TS7005_mandatoryTaxCondition()
	{
		BasePage page = new BasePage();
		WebElement CI = driver.findElement(By.id("ImpositiveCondition"));
		page.setSimpleDropdown(CI, "IVA Consumidor final");
		page.setSimpleDropdown(CI, "IVA Monotributista");
	}
	
	
}
