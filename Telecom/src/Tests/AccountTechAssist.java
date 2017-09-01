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

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Accounts;
import Pages.Login;
import Pages.setConexion;
public class AccountTechAssist extends TestBase {



		
	private WebDriver driver;
	 	
	@AfterClass
	public void tearDown() {
			driver.close();
	}
	
	@AfterMethod
	public void alert (){
		driver.get("https://cs14.salesforce.com/console");
		try{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
		}catch(org.openqa.selenium.NoAlertPresentException e){}
	}

	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupPablo();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
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
				
		driver.switchTo().defaultContent();
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
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	
	@Test
	public void TS0000_diagnosticInternetCheck() {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try{ for(WebElement e : driver.findElements(By.className("x-tab-strip-close"))) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
		} } catch (org.openqa.selenium.StaleElementReferenceException e) {}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel(driver, "Cuentas");
		clickLeftPanel(driver);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Accounts accountPage = new Accounts(driver);
		//Selecciono Vista Tech
		driver.switchTo().defaultContent();
		driver.switchTo().frame( driver.findElement( By.xpath("//iframe") ) );

		accountPage.accountSelect("Vista Tech");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//select accountName "Robo Tech", currently has index 10.
		accountPage.selectAccountName(10);
		
		//abro el panel lateral derecho (si esta cerrado)
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

		try {
			driver.findElement(By.className("x-layout-collapsed")).click();
		}catch(NoSuchElementException noSuchElemExcept) {
			//The layout is already shown then.
		}		
		
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		//Presionar sobre el boton del panel derecho, "Asistencia Tecnica"
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		for(WebElement frame : frames) {//TODO: improve this, stop iterating when button is found.
			try {
				driver.switchTo().frame(frame);
				List<WebElement> rightActionButtons = driver.findElements(By.className("startActions-item"));
				for(WebElement actBtn : rightActionButtons) {
					if (actBtn.getText().equals("Asistencia Técnica")) {
						System.out.println("Boton encontrado");
						actBtn.click();
						break;
					}
				}
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
				continue;
			}catch(WebDriverException webDExcept) {
				driver.switchTo().defaultContent();
				continue;
			}
		}
	
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		
		
	}

		
		
		
		
		
		
		
		
		
		
		
}
