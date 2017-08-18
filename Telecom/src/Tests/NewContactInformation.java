package Tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Pages.ContactInformation;
import Pages.ContactSearch;
import Pages.Login;
import Pages.setConexion;
import Tests.createdContact;

public class NewContactInformation extends TestBase {
	


	private WebDriver driver;
	String Name = "Pepe";
	String LastName = "Argento";
	String Email = "pepe@gmail.com";
	String DateOfBirthday = "06/07/1990";
	String[] genero = {"masculino","femenino"};
	String DNI = "DNI";
	String[] DocValue = {"52698547","3569874563","365","ssss"};
	
	//public NewContactInformation(WebDriver driver) {
		//super(driver);
	//}
	
	@AfterMethod
	public void tearDown() {
	//	driver.close();
	}
	
	@BeforeMethod
	public void Setup() throws Exception
	{
		this.driver = setConexion.setupEze();
		login1(driver);
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ContactSearch contact = new ContactSearch(driver);
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		contact.searchContact(DNI, DocValue[0], "femenino");
		contact.sex("femenino");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test
	public void TS6901_nonExistentContact()
	{
		ContactInformation page = new ContactInformation(driver);
		page.setContactInformation(Name, LastName, DateOfBirthday, Email);
		driver.findElement(By.id("UpdateContact")).click();
	}
	
	@Test
	public void TS6920_verifyValidateContact()
	{
		ContactInformation page = new ContactInformation(driver);
		page.setContactInformation(Name, LastName, DateOfBirthday, Email);
		driver.findElement(By.id("Contact_nextBtn")).click();
		driver.findElement(By.id("ValidationMethod0"));
	}
	@Test
	public void TS6909_numbersOnFieldLastName()
	{
		driver.findElement(By.id("LastName")).sendKeys("123");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-invalid.ng-valid-minlength.ng-valid-maxlength.ng-dirty.ng-valid-parse.ng-invalid-pattern.ng-valid-required"));
	}
	
	@Test
	public void TS6910_numbersOnFieldName()
	{
		driver.findElement(By.id("Name")).sendKeys("123");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-invalid.ng-valid-minlength.ng-valid-maxlength.ng-dirty.ng-valid-parse.ng-invalid-pattern.ng-valid-required"));	
	}	
	
	@Test
	public void TS6949_Manualbirthdate() 
	{
		driver.findElement(By.id("Birthdate")).sendKeys(DateOfBirthday);
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid.ng-valid-valid"));
	}
	
	@Test
	public void TS6950_MoreThanFiveDigits()
	{
		driver.findElement(By.id("Birthdate")).sendKeys(DateOfBirthday +"4");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	
	@Test
	public void birthdateLetters() 
	{
		driver.findElement(By.id("Birthdate")).sendKeys("agosto");
		driver.findElement(By.className(".slds-input ng-touched ng-dirty ng-valid-parse ng-not-empty ng-valid-required ng-invalid ng-invalid-valid"));
	}
	
	@Test
	public void TS6951_birthdateOneMoreDay() 
	{
		driver.findElement(By.id("Birthdate")).sendKeys("32/08/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	
	@Test
	public void birthdateDayminusone() 
	{
		driver.findElement(By.id("Birthdate")).sendKeys("00/08/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	
	@Test
	public void TS6952_birthdateOneMoreMonth() 
	{
		driver.findElement(By.id("Birthdate")).sendKeys("22/13/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	
	@Test
	public void birthdateMonthminusone() 
	{
		driver.findElement(By.id("Birthdate")).sendKeys("22/00/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	
	@Test
	public void TS6974_mailCheckEmpty() 
	{
		driver.findElement(By.cssSelector(".ng-valid.ng-touched.ng-dirty.ng-valid-parse.ng-empty"));
	}
	
	@Test
	public void TS6941_noMailCheckSelect () 
	{
		driver.findElement(By.id("EmailCheck")).click();
		driver.findElement(By.cssSelector(".ng-valid.ng-touched.ng-dirty.ng-valid-parse.ng-not-empty"));
	}
	

	@Test
	public void TS6934_mandatoryLastName()
	{
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-pristine.ng-scope.ng-valid-pattern.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength"));
	}
	
	@Test
	public void TS6936_mandatoryBirthDate()
	{
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-pristine.ng-scope.ng-invalid.ng-invalid-required"));
	}
	
	@Test
	public void TS6938_mandatoryName()
	{
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-pristine.ng-scope.ng-valid-pattern.ng-invalid.ng-invalid-required.ng-valid-minlength.ng-valid-maxlength"));
	}
	
	@Test
	public void TS6931_calendarBirthDate()
	{
		driver.findElement(By.id("Birthdate")).click();
		driver.findElement(By.cssSelector(".datepicker.-bottom-left-.-from-bottom-.active"));
	}

	
	
	/*@Test
	public void birthdatemask() {

		driver.findElement(By.id("Birthdate")).click(); 
		driver.findElement(By.xpath("//*[@id=\'datepickers-container\']/div[1]/div[1]/div/div[2]/div[18]")).click();
		String actualString = driver.findElement(By.xpath("//input[@id='Birthdate']")).getText(); ;;
		//Assert.assertTrue(actualString.contains("yyyy-MM-dd"));

	}*/
}

