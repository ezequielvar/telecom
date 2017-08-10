package Tests;
import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.setConexion;


public class CustomerCare360ViewFOLOption extends TestBase {

	
private WebDriver driver;
 	
	//@AfterMethod
	//public void tearDown() {
		//driver.close();
	//}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		

//		setConexion.setUp();
	driver = setConexion.setupLeo();	

}
	private void waitFor(WebDriver driver2, By by) {
		}
	
	 @Test
	public void TS7120_ValidationTabBillingInformation () {

		driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		List<WebElement> profileinfo = driver.findElements(By.className("tabText"));
		Assert.assertEquals("Billing Information", profileinfo.get(3).getText());
	}
	
	@Test
	public void TS7122_ValidationFieldAddFOL () {
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
 driver.findElement(By.className("slds-truncate"));
	
}
	
	@Test
	public void TS7124_ValidationFormatTable () {
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.findElement(By.cssSelector(".ext-webkit.ext-chrome"));
	
	}

	
	
	
	
	
	
	
	
}

	
	
	

