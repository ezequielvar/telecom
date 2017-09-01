package Tests;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CasePage;
import Pages.Login;
import Pages.SelectCaseRegisterType;
import Pages.setConexion;

public class CustomerCareCaseManagement extends TestBase {

	private WebDriver driver;
	
	
	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupEze();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@BeforeMethod
	public void mainSteup() {
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.getCurrentUrl().toString().contains("https://cs14.salesforce.com/console")){
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
		goToLeftPanel(driver, "Casos");
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		waitFor(driver, (By.name("fcf")));	
		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Mis casos");
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(0));
		driver.findElement(By.name("newCase")).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

		driver.switchTo().defaultContent();
		SelectCaseRegisterType selectCaseRegTypePage = new SelectCaseRegisterType(driver);
		selectCaseRegTypePage.continueToCreate();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();

		driver.switchTo().frame(frame1.get(0));
	}
	
	@AfterClass
	public void tearDown() {
		/*driver.switchTo().defaultContent();
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		waitFor(driver, (By.className("x-toolbar-cell")));
		List<WebElement> btn = driver.findElements(By.cssSelector(".x-btn-text"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn.get(5));*/
		driver.close();	
	}
	
	@AfterMethod
	public void alert (){
		driver.get("https://cs14.salesforce.com/console");
		try{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}catch(org.openqa.selenium.NoAlertPresentException e){}
	}

	@Test
	public void TS7083_ValidateDueTimeLogic(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frames.get(1));//CaseCreation frame
		CasePage page = new CasePage(driver);
		page.FieldsValuesType();
		page.setCaseDueDate("01/08/2017 10:47");//older than today date.
		page.setContactName("Robo Tech");
		page.save();
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		System.out.println(page.getCaseDueDate());
		System.out.println(page.getCaseDate());
		
		DateFormat dateWithHourFormat = new SimpleDateFormat("dd/mm/yyyy hh:mm");
		Date caseDueDate = null;
		try {
			caseDueDate = dateWithHourFormat.parse(page.getCaseDueDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date caseCreatedDate = null;
		try {
			caseCreatedDate = dateWithHourFormat.parse(page.getCaseDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(caseDueDate.after(caseCreatedDate) || caseDueDate.equals(caseCreatedDate));

		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
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
	
	@Test
	public void TS7195_CaseRelatedCreateValuesCheck(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for (WebElement currentFrame : frames) {
			try {
				driver.switchTo().frame(currentFrame);
				driver.findElement(By.id("ext-comp-1426"));
				break;
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

	}

}