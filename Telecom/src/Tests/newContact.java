package Tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ContactSearch;
import Pages.setConexion;


public class newContact extends ContactSearch {

	public newContact(WebDriver driver) {
		super(driver);
	}
	
	private WebDriver driver;
	String[] genero = {"masculino","femenino"};
	String DNI;
	String[] DocValue = {"52698547","3569874563","365","ssss"};
	ContactSearch contac = new ContactSearch(driver);
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	
	@BeforeMethod
	public void Init() throws Exception
	{
//	setConexion.setUp();
	this.driver = setConexion.setupPablo();	

	}
		
	@Test
	public void createdNewValidContact()
	{
		searchContact(DNI, DocValue[0], genero[0]);
		if (driver.findElement(By.className("slds-select ng-touched ng-dirty ng-valid-parse ng-not-empty ng-valid ng-valid-required")) == null)
		{
			System.out.println("Caso ");
		}
	}
	public void createdNewInvalidContact()
	{
			
		searchContact(DNI, DocValue[2], genero[1]);
		
		if (driver.findElement(By.className("slds-select ng-touched ng-dirty ng-valid-parse ng-empty ng-invalid ng-invalid-required")) == null);
		{
			System.out.println("Caso ");
		}
	}
	public void verifiedFieldDNI()
	{
		driver.findElement(By.id("document")).sendKeys("123");;
		if (driver.findElement(By.className("slds-select ng-touched ng-dirty ng-valid-parse ng-empty ng-invalid ng-invalid-required")) == null)
		{
			driver.findElement(By.id("document")).clear();
			driver.findElement(By.id("document")).sendKeys("1234567894");
		}else
		{
			System.out.println("No valida valores menor a 7 digitos en el campo dni");
		}
		if(driver.findElement(By.className("slds-select ng-touched ng-dirty ng-valid-parse ng-empty ng-invalid ng-invalid-required")) == null)
		{
			System.out.println("No valida valores mayor a 9 digitos en el campo dni");
		}
	}


}
