package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ContactInformation;
import Pages.ContactSearch;
import Pages.ValidateByDniNumber;
import Pages.ValidationMethodSelection;
import Pages.setConexion;


public class NewClientCreateTest extends TestBase {

	private WebDriver driver;
	 	
	@AfterMethod
	public void tearDown() {
	driver.close();
	}

	@BeforeMethod
	public void setup() throws Exception {
		//setConexion.setUp();
		String DNI = "Documento Nacional de Identidad";
		String[] DocValue = {"52698543","3569874563","365","ssss"};
		String nombre = "alexis";
		String apellido = "ray";
		String nacimiento = "08/08/1990";
		String mail = "unmail@unhost.com";
		String validationType = "document";
		//String DNI = "DNI";
		
		this.driver = setConexion.setupPablo();
		login1(driver);
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ContactSearch contact = new ContactSearch(driver);
		driver.findElement(By.className("slds-radio--faux")).click();
		contact.searchContact(DNI, DocValue[0], "femenino");
		ContactInformation ci = new ContactInformation(driver);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ci.setContactInformation(nombre, apellido, nacimiento, mail);
		ci.nextPage();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ValidationMethodSelection validation = new ValidationMethodSelection(driver);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		validation.setValidationType(validationType);
		//validation.next(); //in the website just clicking the radio goes to the next page.
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\pablo\\Desktop\\SampleFiles\\eclipse_1.png");
		driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\pablo\\Desktop\\SampleFiles\\eclipse_1bis.png");
		ValidateByDniNumber validationByDni = new ValidateByDniNumber(driver);		
		validationByDni.next();
		try {Thread.sleep(1500);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("ContactValidated_nextBtn")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

}
		
	@Test
	public void TS6987_VerifyNumCharInputFloor() {
		driver.findElement(By.id("BillingFloor"));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

	}
	
		
}