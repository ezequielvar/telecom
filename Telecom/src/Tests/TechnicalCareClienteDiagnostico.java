package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.TechCareDiagnostic;
import Pages.customerInformation;
import Pages.setConexion;


public class TechnicalCareClienteDiagnostico extends TestBase  {
	String value;
	private WebDriver driver;
 	
	@BeforeTest
	public void mainSteup() {
		this.driver = setConexion.setupLeo();	
		login(driver);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.get("https://cs14.salesforce.com/a3y?fcf=00Bc0000001LRmc");
	}
//	@AfterTest
	public void tearDown() {
	driver.close();
	}
	
	@Test
	public void DiagnosticsFixedBroadbandUPUP() {
		value = "UP/UP";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectfile();
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue(value);
}
	
	@Test
	public void DiagnosticsFixedBroadbandUPDOWN() {
		value = "UP/DOWN";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectfile();
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue(value);
}
	@Test
	public void DiagnosticsFixedBroadbandDOWNDOWN() {
		value = "DOWN/DOWN";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectfile();
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue(value);
}
	@Test
	public void DiagnosticsFixedBroadbandNOTSESION() {
		value = "Sin Sesion";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectfile();
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue(value);
}
}
