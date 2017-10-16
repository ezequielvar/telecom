package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	String Name = "lolaasd";
	String LastName = "velasd";
	String DateOfBirthday = "07/06/1987";
	String DNI = "Documento Nacional de Identidad";
	String[] DocValue = {"10000000","3569874563","365","ssss","37452658"};
	int i = 0;
	private String validationType = "document";
	
	@AfterClass(groups="Fase2")
	public void tearDown2() {
		//driver.close();
	}
	
	@BeforeClass(groups="Fase2")
	public void init() throws Exception
	{
		this.driver = setConexion.setupEze();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login1(driver);
		IngresarCred(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	/*@AfterMethod
	public void tearDown() throws Exception {
		login1(driver);
		IngresarCred(driver);
	}*/
	
	@BeforeMethod(groups="Fase2")
	public void setup() throws Exception {
		//driver.get("https://goo.gl/ULLWHZ");
		//driver.get("https://goo.gl/ETjDYJ");
	  if(i==0) {
		  i++;
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ContactSearch conts = new ContactSearch(driver);
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		conts.searchContact(DNI, DocValue[4], "femenino");
		conts.sex("femenino");
		driver.findElement(By.id("ContactInfo_nextBtn")).click();
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		/*if(driver.findElement(By.id("Name")).getText().isEmpty()) {
		ContactInformation page = new ContactInformation(driver);
		page.setContactInformation(Name, LastName, DateOfBirthday);}*/
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.cssSelector(".slds-checkbox--faux")).click();
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement BenBoton = driver.findElement(By.id("Contact_nextBtn"));
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+BenBoton.getLocation().y+")");
		BenBoton.click();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ValidationMethodSelection validation = new ValidationMethodSelection(driver);
		validation.setValidationType(validationType);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\Florangel\\Downloads\\usuaria.PNG");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BenBoton = driver.findElement(By.id("DocumentMethod_nextBtn"));
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+BenBoton.getLocation().y+")");
		BenBoton.click();
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("ContactValidated_nextBtn")).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	  }
	}
	
	@Test(groups="Fase2")
	public void TS15412_CRM_Fase_2_SalesCPQ_Alta_de_linea_Verificar_default_de_modalidad_entrega_para_Canal_Ecommerce_Telefonico()
	{
		assertTrue(driver.findElement(By.id("Department")).getAttribute("value").isEmpty());
	}
	
	@Test(groups="Fase2")
	public void TS15414_CRM_Fase_2_SalesCPQ_Alta_de_linea_Verificar_default_de_modalidad_entrega_para_Canal_Presencial_Agentes()
	{
		driver.findElement(By.cssSelector(".slds-checkbox--faux")).click();
		assertFalse(driver.findElement(By.id("IdPhone")).isDisplayed());
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups="Fase2")
	public void TS15413_CRM_Fase_2_SalesCPQ_Alta_de_linea_Verificar_default_de_modalidad_entrega_para_Canal_Presencial_Oficinas_comerciales()
	{
		driver.findElement(By.id("IdPhone")).sendKeys("1234568745");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	
	@Test(groups="Fase2")
	public void TS15409_CRM_Fase_2_SalesCPQ_Alta_de_linea_Verificar_LOV_de_modalidad_entrega_para_canal_ecommerce_telefonico()
	{
		BasePage page = new BasePage();
		WebElement CI = driver.findElement(By.id("ImpositiveCondition"));
		page.setSimpleDropdown(CI, "-- Clear --");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-select-control.ng-scope.ng-dirty.ng-valid-parse.ng-invalid.ng-invalid-required"));
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups="Fase2")
	public void TS15411CRM_Fase_2_SalesCPQ_Alta_de_linea_Verificar_LOV_de_modalidad_entrega_para_Canal_Presencial_Agentes(){
		BasePage page = new BasePage();
		WebElement prov = driver.findElement(By.id("State"));
		page.setSimpleDropdown(prov, "Buenos Aires");
		driver.findElement(By.id("CityTypeAhead")).sendKeys("Almagro");
		driver.findElement(By.id("LegalStreetTypeAhead")).sendKeys("Gascon");
		driver.findElement(By.id("StreetNumber")).sendKeys("700");
		//Se debe validar unchecked de copiar datos del domicilio legal???? 
		assertTrue(driver.findElement(By.id("BillingState")).isDisplayed());		
		assertTrue(driver.findElement(By.id("BillingCityTypeAhead")).isDisplayed());
		assertTrue(driver.findElement(By.id("BillingStreetTypeAheade")).isDisplayed());
		assertTrue(driver.findElement(By.id("BillingStreetNumber")).isDisplayed());
		assertTrue(driver.findElement(By.id("BillingFloor")).isDisplayed());
		assertTrue(driver.findElement(By.id("BillingDepartment")).isDisplayed());
		assertTrue(driver.findElement(By.id("BillingPostalCodeTypeAhead")).isDisplayed());
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups="Fase2")
	public void TS15410_CRM_Fase_2_SalesCPQ_Alta_de_linea_Verificar_LOV_de_modalidad_entrega_para_Canal_Presencial_Oficinas_comerciales()
	{
		String a;
		a = driver.findElement(By.id("ContactName")).getText();
		assertEquals(a, "lolaasd velasd");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups="Fase2")
	public void TS7005_mandatoryTaxCondition()
	{
		BasePage page = new BasePage();
		WebElement CI = driver.findElement(By.id("ImpositiveCondition"));
		page.setSimpleDropdown(CI, "IVA Consumidor final");
		page.setSimpleDropdown(CI, "IVA Monotributista");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
}
