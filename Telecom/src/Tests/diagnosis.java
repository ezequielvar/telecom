package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Accounts;
import Pages.diagnosisTab;
import Pages.setConexion;

public class diagnosis extends TestBase {
	
	private WebDriver driver;

	@BeforeTest
	public void mainSteup() {
		this.driver = setConexion.setupPablo();	
		login(driver);
	}

	@AfterTest
	public void tearDown2() {
//		driver.close();
		
	}

	@AfterMethod
	public void tearDown() {
//		driver.get("https://cs14.salesforce.com/home/home.jsp");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		
//		setConexion.setUp();
//		this.driver = setConexion.setupPablo();	
//		login(driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.getCurrentUrl().toString().equals("https://cs14.salesforce.com/console")){
			driver.findElement(By.id("tsidLabel")).click();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
		}
	}
	
	@Test
	public void TS6269_isExeccuteButtonPresent() {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try{ for(WebElement e : driver.findElements(By.className("x-tab-strip-close"))) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
		} } catch (org.openqa.selenium.StaleElementReferenceException e) {}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel(driver, "Cuentas");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		Accounts page0 = new Accounts(driver);
		page0.clickOnV();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page0.clickOnFirstAccount();
		driver.switchTo().defaultContent();
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accountTabs = driver.findElements(By.className("tabText"));
		accountTabs.get(2).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(2));
		List<WebElement> squares = driver.findElements(By.cssSelector(".console-card.active"));
		squares.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.xpath("//*[@id=\"j_id0:j_id5\"]/div/div/ng-include/div/div[2]/div[3]/ng-include/section[2]/div[3]/ng-transclude/div/ng-include/div/div[1]/div/ng-include/div/ul/li[3]")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame3 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame3.get(4));
		diagnosisTab page1 = new diagnosisTab(driver);
		page1.setMotive();
		Assert.assertTrue(page1.isExecuteButtonPresent());
	}
	
	@Test
	public void TS6277_verifyTroubleshootingRulesAreAvailable() {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try{ for(WebElement e : driver.findElements(By.className("x-tab-strip-close"))) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
		} } catch (org.openqa.selenium.StaleElementReferenceException e) {}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel(driver, "Cuentas");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		Accounts page0 = new Accounts(driver);
		page0.clickOnV();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page0.clickOnFirstAccount();
		driver.switchTo().defaultContent();
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accountTabs = driver.findElements(By.className("tabText"));
		accountTabs.get(2).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(2));
		List<WebElement> squares = driver.findElements(By.cssSelector(".console-card.active"));
		squares.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.xpath("//*[@id=\"j_id0:j_id5\"]/div/div/ng-include/div/div[2]/div[3]/ng-include/section[2]/div[3]/ng-transclude/div/ng-include/div/div[1]/div/ng-include/div/ul/li[3]")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame3 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame3.get(4));
		diagnosisTab page1 = new diagnosisTab(driver);
		page1.setMotive();
		page1.clickOnExeccute();
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(driver.findElements(By.cssSelector(".slds-radio.ng-scope")).size() != 0);
	}
	
	@Test
	public void TS6325_isInternetAvailable() {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try{ for(WebElement e : driver.findElements(By.className("x-tab-strip-close"))) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
		} } catch (org.openqa.selenium.StaleElementReferenceException e) {}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel(driver, "Cuentas");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement frame1 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame1);
		Accounts page0 = new Accounts(driver);
		page0.clickOnV();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page0.clickOnFirstAccount();
		driver.switchTo().defaultContent();
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accountTabs = driver.findElements(By.className("tabText"));
		accountTabs.get(2).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(2));
		List<WebElement> squares = driver.findElements(By.cssSelector(".console-card.active"));
		Assert.assertTrue(squares.get(0).getText().contains("INTERNET"));
	}

}
