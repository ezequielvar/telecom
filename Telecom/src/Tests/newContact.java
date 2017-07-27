package Tests;

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
	setConexion.setUp();
	}
		
	@Test
	public void createdNewValidContact()
	{
		searchContact(DNI, DocValue[0], genero[0]);
			
	}
	public void createdNewInvalidContact()
	{
			
		searchContact(DNI, DocValue[2], genero[1]);
		
	}


}
