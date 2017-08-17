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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.setConexion;


public class CustomerCare360ViewFOLOption extends TestBase {

	
private WebDriver driver;
 	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
@BeforeTest
public void mainSeteup() {
	this.driver = setConexion.setupLeo();	
	login(driver);
}
@BeforeMethod
public void setUpTest() {
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
	goToLeftPanel(driver, "Cuentas");
	WebElement frame0 = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(frame0);
	waitFor(driver, (By.name("fcf")));	
	Select field = new Select(driver.findElement(By.name("fcf")));
	field.selectByVisibleText("Todas las cuentas");
	
	waitFor(driver, (By.xpath("//*[text() = 'Adrian Tech']")));	

	List<WebElement> accounts = driver.findElements(By.xpath("//*[text() ='Andres Care']"));
	accounts.get(0).click();
	driver.switchTo().defaultContent();
}

	
	 @Test
	public void TS7120_ValidationTabBillingInformation () {
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

	
	
	

