package Tests;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CasePage;
import Pages.CustomerCasesManager;
import Pages.HomeBase;
import Pages.SelectCaseRegisterType;
import Pages.setConexion;

public class CustomerCareCreatedCaseManagement extends TestBase {

	private WebDriver driver;

	@BeforeClass(groups = "Fase1")
	public void mainSteup() {
		this.driver = setConexion.setupPablo();	
		login(driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
	     if(driver.findElement(By.id("tsidLabel")).getText().equals("Consola FAN")) {
	    	 homePage.switchAppsMenu();
	    	 try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    	 homePage.selectAppFromMenuByName("Ventas");
	    	 try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}    
	     }
	     homePage.switchAppsMenu();
	     try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	     homePage.selectAppFromMenuByName("Consola FAN");
	}

	
	
	@BeforeMethod(groups = "Fase1")
	public void mainSetup() {
		
	     try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}    
		List<WebElement> mainTabs = driver.findElements(By.className("x-tab-strip-close"));
		for (WebElement e : mainTabs) {
		try {((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);} catch (org.openqa.selenium.StaleElementReferenceException b) {}
		}
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		goToLeftPanel2(driver, "Casos");
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		waitFor(driver, (By.name("fcf")));	
		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Mis Casos");
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@AfterClass(groups = "Fase1")
	public void tearDown() {
		driver.switchTo().defaultContent();
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		driver.get("https://cs14.salesforce.com/console");
		try{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}catch(org.openqa.selenium.NoAlertPresentException e){}
		driver.close();
	}
	
	/*
	@AfterMethod
	public void alert (){

	}*/
	
	
	
	@Test(groups = "Fase1")
	public void TS7202_CreatedAndDueTimeInHoursFormatCheck(){
		
		String dateWithHourPattern = "(\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2})";

		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();

		CustomerCasesManager customerCasesManagerPage = new CustomerCasesManager(driver);

		customerCasesManagerPage.clickCase("00001372");
		CasePage page = new CasePage(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frames.get(1));

		Assert.assertTrue(page.getCaseDate().matches(dateWithHourPattern));
		Assert.assertTrue(page.getCaseDueDate().matches(dateWithHourPattern));
		
	}
	
	@Test(groups = "Fase1")
	public void TS7082_VisualizeDueDate(){
		
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();

		CustomerCasesManager customerCasesManagerPage = new CustomerCasesManager(driver);

		customerCasesManagerPage.clickCase("00001372");
		CasePage page = new CasePage(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frames.get(1));
		
		page.getCaseDueDate();
		
	}
	
}