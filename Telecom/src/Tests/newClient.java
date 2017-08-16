package Tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContactSearch;
import Pages.setConexion;
import Pages.BasePage;


public class newClient extends TestBase {
	
	private WebDriver driver;
	
	@BeforeTest
	public void mainSteup() {
		this.driver = setConexion.setupEze();
		login(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void TS6999_verifyFieldDepartmentEmpty()
	{
		assertTrue(driver.findElement(By.id("Department")).getAttribute("value").isEmpty());
	}
	
	@Test
	public void TS7000_lineaIdentificatory()
	{
		driver.findElement(By.id("IdPhone")).sendKeys("1234568745");
	}
	
	@Test
	public void TS7001_verifyCheckBoxLineIdentificatory()
	{
		driver.findElement(By.cssSelector(".slds-checkbox--faux")).click();
		assertFalse(driver.findElement(By.id("IdPhone")).isDisplayed());
	}
	
	@Test
	public void TS7002_mandatoryTaxCondition()
	{
		BasePage page = new BasePage();
		WebElement CI = driver.findElement(By.id("ImpositiveCondition"));
		page.setSimpleDropdown(CI, "-- Clear --");
		driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.vlc-slds-select-control.ng-scope.ng-dirty.ng-valid-parse.ng-invalid.ng-invalid-required"));
	}
	
	@Test
	public void TS7004_verifyFieldsNameAndLastname()
	{
		String a;
		a = driver.findElement(By.id("ContactName")).getText();
		assertEquals(a, "pepe argento");
	}
	
	@Test
	public void TS7005_mandatoryTaxCondition()
	{
		BasePage page = new BasePage();
		WebElement CI = driver.findElement(By.id("ImpositiveCondition"));
		page.setSimpleDropdown(CI, "IVA Consumidor final");
		page.setSimpleDropdown(CI, "IVA Monotributista");
	}
	
	
}
