package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.setConexion;

public class CustomerCare360ViewPanelDistribution extends TestBase {

	private WebDriver driver;


	//@AfterMethod
	//public void tearDown() {
		//driver.close();
	//}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		

//		setConexion.setUp();
	driver = setConexion.setupLeo();	
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

	List<WebElement> accounts = driver.findElements(By.xpath("//*[text() ='Andres Care']"));
	accounts.get(0).click();
	driver.switchTo().defaultContent();
}	
	
	
	
	
	@Test
	public void TS7059_VerifyDisplayPanelPromotions() {		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		try {
			driver.findElement(By.id("ext-comp-1037-xcollapsed")).click();
	    } catch (NoSuchElementException e) {	
	    }		
		
		driver.switchTo().frame(frame1.get(4));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.className("promotions-section"));
	}
	
	@Test
	public void TS7058_VerifyDisplayServiceActive() {
		
		

		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
	
		driver.findElement(By.xpath("//*[text() ='Servicios']")).click();
		driver.switchTo().frame(frame1.get(2));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	

		driver.findElement(By.cssSelector(".console-card.active"));
	}
	
	@Test
	public void TS7200_VerifyDisplayLogo() {	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		driver.findElement(By.className("sd_custom_logo"));
	}
	
	@Test
	public void TS7202_VerifyDisplayPanelAlert() {	

		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
	
		driver.findElement(By.xpath("//*[text() ='Servicios']")).click();
		driver.switchTo().frame(frame1.get(2));
		driver.findElement(By.className("ta-alertMessage-content"));	
	}
	
	@Test
	public void TS7201_VerifyDisplayfilterAccounts() {	
		try {
	        driver.findElement(By.id("eext-comp-1038-xcollapsed")).click();;
	    } catch (NoSuchElementException e) {	
	    }
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		driver.findElement(By.className("account-select")).click();	
	}
	@Test
	public void TS7066_VerifyDisplayPanelAccountsClient() {	
		try {
	        driver.findElement(By.id("eext-comp-1038-xcollapsed")).click();;
	    } catch (NoSuchElementException e) {	
	    }
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		driver.findElement(By.className("account-select-container")).click();	
	}
	@Test
	public void TS7054_VerifyDisplayPanelBusinessData() {	
		try {
	        driver.findElement(By.id("eext-comp-1038-xcollapsed")).click();;
	    } catch (NoSuchElementException e) {	
	    }
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		driver.findElement(By.className("profile-box"));	
	}
}

