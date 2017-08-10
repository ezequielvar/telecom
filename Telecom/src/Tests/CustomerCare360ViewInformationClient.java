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
public class CustomerCare360ViewInformationClient extends TestBase {



		
	private WebDriver driver;
	 	
		//@AfterMethod
		//public void tearDown() {
			//driver.close();
		//}
		
		@BeforeMethod
		public void setup() throws Exception {
			
			

//			setConexion.setUp();
		driver = setConexion.setupLeo();	

	}

		
		
	public void TS7137_BusinessDataPanelQuickAccessButtonsAccount() {
		
		
		driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		
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

		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() ='Adrian Tech']"));
		accounts.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
