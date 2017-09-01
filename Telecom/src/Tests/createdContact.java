package Tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContactSearch;
import Pages.setConexion;
import Pages.BasePage;


public class createdContact extends TestBase {


	
	private WebDriver driver;
	String[] genero = {"masculino","femenino"};
	String DNI = "Documento Nacional de Identidad";
	String[] DocValue = {"10000000","3569874563","365","ssss"};
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}
	
	@BeforeClass
	public void Init() throws Exception
	{
		this.driver = setConexion.setupEze();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.get("https://goo.gl/ETjDYJ");
		login1(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@BeforeMethod
	public void Setup() throws Exception
	{
		driver.get("https://goo.gl/ETjDYJ");
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	BasePage base = new BasePage();
	
	@Test
	public void createdNewValidContact()
	{
		ContactSearch contact = new ContactSearch(driver);
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		contact.searchContact(DNI, DocValue[0], "femenino");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("ContactInfo_nextBtn")).click();
		
	}
	
	@Test
	public void TS6965_verifiedFieldDNIShortNumer()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, DNI);
		driver.findElement(By.id("DNIDocument")).sendKeys("123");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-valid-min-int.ng-valid-max-int.ng-invalid.ng-dirty.ng-valid-parse.ng-invalid-pattern.ng-valid-required"));
	}
	
	@Test
	public void TS6918_generFemale()
	{
		ContactSearch contact = new ContactSearch(driver);
		contact.sex("femenino");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test
	public void TS6919_generMale()
	{
		ContactSearch contact = new ContactSearch(driver);
		contact.sex("masculino");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test
	public void TS6964_verifiedFieldDNILongNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, DNI);
		driver.findElement(By.id("DNIDocument")).sendKeys("1234567894");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-valid-min-int.ng-valid-max-int.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-pattern"));
	}
	
	@Test
	public void TS6967_mandatoryType()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "-- Clear --");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-select-control.ng-scope.ng-dirty.ng-valid-parse.ng-invalid.ng-invalid-required"));
	}
	
	@Test
	public void TS6967_mandatorySex()
	{
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-radio-control.ng-pristine.ng-scope.ng-invalid.ng-invalid-required"));
	}
	
	@Test
	public void TS6966_mandatoryDNI()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, DNI);
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-pristine.ng-scope.ng-valid-pattern.ng-valid-min-int.ng-valid-max-int.ng-invalid.ng-invalid-required"));
	}
	
	@Test
	public void TS6914_verifiedShortPassportNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "Pasaporte");
		driver.findElement(By.id("PassportDocument")).sendKeys("1");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-invalid.ng-valid-minlength.ng-valid-maxlength.ng-dirty.ng-valid-parse.ng-invalid-pattern.ng-valid-required"));
	}
	
	@Test
	public void TS6915_verifiedLongPassportNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "Pasaporte");
		driver.findElement(By.id("PassportDocument")).sendKeys("1231231234");
	}
	
	@Test
	public void TS6916_PassportNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "Pasaporte");
		driver.findElement(By.id("PassportDocument")).sendKeys("123123123");
	}
	
	@Test
	public void TS6912_DNINumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, DNI);
		driver.findElement(By.id("DNIDocument")).sendKeys("12312312");
	}
	
	@Test
	public void TS6911_CUITNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "CUIT");
		driver.findElement(By.id("CuitDocument")).sendKeys("22-35689987-4");
	}
	
	@Test
	public void TS6943_PassportNumberWithLetters()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "Pasaporte");
		driver.findElement(By.id("PassportDocument")).sendKeys("AAA1231AA");
	}
	
	@Test
	public void TS6945_ceroCUITNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "CUIT");
		driver.findElement(By.id("CuitDocument")).sendKeys("00256987450");
	}
	
	@Test
	public void TS6944_lettersCUITNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "CUIT");
		driver.findElement(By.id("CuitDocument")).sendKeys("aa");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-tel.ng-scope.ng-dirty.ng-valid-mask.ng-valid-parse.ng-valid-pattern.ng-valid-minlength.ng-valid-maxlength.ng-invalid.ng-invalid-required"));
	}
	
	@Test
	public void TS6935_verifyFieldCUITNumber()
	{
		WebElement type = driver.findElement(By.id("DocumentType"));
		base.setSimpleDropdown(type, "CUIT");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-tel.ng-pristine.ng-scope.ng-valid-mask.ng-valid-pattern.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength"));
	}

}
