package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import Pages.ContactInformation;
import Pages.setConexion;

public class NewContactInformation extends TestBase {
	


	private WebDriver driver;
	String Name = "Pepe";
	String LastName = "Argento";
	String Email = "pepe@gmail.com";
	String DateOfBirthday = "06/07/2012";
	
	//public NewContactInformation(WebDriver driver) {
		//super(driver);
	//}
	
	//@AfterMethod
	//public void tearDown() {
	//	driver.close();
	//}
	@BeforeMethod
	public void Setup() throws Exception
	{
		this.driver = setConexion.setupLeo();
		//driver.get("https://c.cs14.visual.force.com/apex/taClientCreationProcess?id=a1zc0000003EQUYAA4&designerPreviewId=a1zc0000003EQUYAA4&previewEmbedded=true&tabKey=1499800882480#/OS/a1zc0000003EQUYAA4/scriptState/new/true/true");
	}
	
	
	@Test
	public void nonExistentContact()
	{
		ContactInformation page = new ContactInformation(driver);
		page.setContactInformation(Name, LastName, DateOfBirthday, Email);
		driver.findElement(By.id("UpdateContact")).click();
	}
	@Test
	public void numbersOnFieldLastName()
	{
		driver.findElement(By.id("LastName")).sendKeys("123");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-valid-minlength.ng-valid-maxlength.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-pattern"));
	}
	@Test
	public void numbersOnFieldName()
	{
		driver.findElement(By.id("Name")).sendKeys("123");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-valid-minlength.ng-valid-maxlength.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-pattern"));	
	}	
	
	@Test
	public void Manualbirthdate() {		
		driver.findElement(By.id("Birthdate")).sendKeys(DateOfBirthday);
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-valid.ng-valid-valid"));
	}
	@Test
	public void Morethanfivedigits() {
		driver.findElement(By.id("Birthdate")).sendKeys(DateOfBirthday +"4");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	@Test
	public void birthdateletters() {
		driver.findElement(By.id("Birthdate")).sendKeys("agosto");
		driver.findElement(By.className(".slds-input ng-touched ng-dirty ng-valid-parse ng-not-empty ng-valid-required ng-invalid ng-invalid-valid"));
	}
	@Test
	public void birthdateOnemoreday() {
		driver.findElement(By.id("Birthdate")).sendKeys("32/08/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	@Test
	public void birthdateDayminusone() {
		driver.findElement(By.id("Birthdate")).sendKeys("00/08/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	@Test
	public void birthdateOnemoremonth() {
		driver.findElement(By.id("Birthdate")).sendKeys("22/13/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	@Test
	public void birthdateMonthminusone() {
		driver.findElement(By.id("Birthdate")).sendKeys("22/00/1999");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-dirty.ng-valid-parse.ng-valid-required.ng-invalid.ng-invalid-valid"));
	}
	
	@Test
	public void NoMailCheckEmpty() {
		driver.findElement(By.cssSelector(".ng-valid.ng-touched.ng-dirty.ng-valid-parse.ng-empty"));
	}
	
	public void NoMailCheckSelect () {
		driver.findElement(By.id("EmailCheck")).click();
		driver.findElement(By.cssSelector(".ng-valid.ng-touched.ng-dirty.ng-valid-parse.ng-not-empty"));
	}
	
}

