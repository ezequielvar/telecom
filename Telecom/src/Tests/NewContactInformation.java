package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Pages.ContactInformation;
import Pages.setConexion;

public class NewContactInformation extends ContactInformation {
	
	private WebDriver driver;
	String Name = "Pepe";
	String LastName = "Argento";
	String Email = "pepe@gmail.com";
	String DateOfBirthday = "06/07/2012";
	
	public NewContactInformation(WebDriver driver) {
		super(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@BeforeMethod
	public void Init() throws Exception
	{
		this.driver = setConexion.setupPablo();
		driver.get("https://c.cs14.visual.force.com/apex/taClientCreationProcess?id=a1zc0000003EQUYAA4&designerPreviewId=a1zc0000003EQUYAA4&previewEmbedded=true&tabKey=1499800882480#/OS/a1zc0000003EQUYAA4/scriptState/new/true/true");
	}
	
	
	@Test
	public void nonExistentContact()
	{
		setContactInformation(Name, LastName, DateOfBirthday, Email);
		driver.findElement(By.id("UpdateContact")).click();
	}
	
	public void numbersOnFieldLastName()
	{
		driver.findElement(By.id("LastName")).sendKeys("123");
		if(driver.findElement(By.className("slds-input ng-invalid ng-valid-minlength ng-valid-maxlength ng-dirty ng-valid-parse ng-empty ng-valid-pattern ng-invalid-required ng-touched")) == null)
		{
			System.out.println("No valida el ingreso de numeros en el campo Apellido");
		}
		
	}
	public void numbersOnFieldName()
	{
		driver.findElement(By.id("Name")).sendKeys("123");
		if(driver.findElement(By.className("slds-input ng-invalid ng-valid-minlength ng-valid-maxlength ng-dirty ng-valid-parse ng-empty ng-valid-pattern ng-invalid-required ng-touched")) == null)
		{
			System.out.println("No valida el ingreso de numeros en el campo Apellido");
		}
		
	}
	
	


}
