package Tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CasePage;
import Pages.CustomerCasesManager;
import Pages.SelectCaseRegisterType;
import Pages.setConexion;

public class CustomerCareCaseManagement extends TestBase {

	private WebDriver driver;

	@BeforeTest
	public void mainSteup() {
		this.driver = setConexion.setupPablo();	
		login(driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.getCurrentUrl().toString().equals("https://cs14.salesforce.com/console")){
			driver.findElement(By.id("tsidLabel")).click();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
		}
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
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
		field.selectByVisibleText("Mis casos");
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		/*List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(0));
		driver.findElement(By.name("newCase")).click();*/
	}
	/*
	@AfterTest
	public void tearDown() {
		
		driver.switchTo().defaultContent();
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		waitFor(driver, (By.className("x-toolbar-cell")));
		List<WebElement> btn = driver.findElements(By.cssSelector(".x-btn-text"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn.get(5));
driver.close();
		}*/
	
	
	
	@BeforeMethod
	public void setup() throws Exception {	
	}
	
	@Test
	public void PFTA_76_CreatedAndDueTimeInHoursFormatCheck(){
		
		String dateWithHourPattern = "(\\d{2}\\/\\d{2}\\/\\d{4} \\d{2}:\\d{2})";

		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();

		CustomerCasesManager customerCasesManagerPage = new CustomerCasesManager(driver);

		customerCasesManagerPage.clickCase("00001678");
		CasePage page = new CasePage(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();

		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		System.out.println(page.getCaseDate());
		System.out.println(page.getCaseDueDate());

		Assert.assertTrue(page.getCaseDate().matches(dateWithHourPattern));
		Assert.assertTrue(page.getCaseDueDate().matches(dateWithHourPattern));
		
	}	
	
	@Test
	public void TS7193_CaseRelatedFieldsValuesCanalClosing(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		CasePage page = new CasePage(driver);
		page.ValidChannelClosing();
	}
	
	@Test
	public void TS7090_CaseRelatedFieldsValuesSubArea(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		CasePage page = new CasePage(driver);
		page.FieldsValuesSubArea();
	}
	
	@Test
	public void TS7088_CaseRelatedFieldsValuesType(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		CasePage page = new CasePage(driver);
		page.FieldsValuesType();
	}
	
		
}