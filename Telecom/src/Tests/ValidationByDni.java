package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.setConexion;
import Pages.ContactSearch;

public class ValidationByDni extends TestBase{
	
	private WebDriver driver;
	String DNI = "DNI";
	String[] DocValue = {"52698547","3569874563","365","ssss"};
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@BeforeMethod
	public void Setup() throws Exception
	{
		this.driver = setConexion.setupEze();
		login1(driver);
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ContactSearch contact = new ContactSearch(driver);
		contact.searchContact(DNI, DocValue[0], "femenino");
		NewContactInformation ci = new NewContactInformation();
		ci.TS6901_nonExistentContact();
	}
	
	@Test
	public void TS6898_attachTwoFiles()
	{
		driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\Sofia Chardin\\Desktop\\Codigo de seguridad.PNG");
		driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\Sofia Chardin\\Desktop\\Codigo de seguridad.PNG");
	}
	
	@Test
	public void TS6900_attachTwoMbFiles()
	{
		driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\Sofia Chardin\\Downloads\\0F6.gif");
	}
	

}
