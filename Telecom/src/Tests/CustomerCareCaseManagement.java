package Tests;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CasePage;
import Pages.Login;
import Pages.setConexion;

public class CustomerCareCaseManagement extends TestBase {

	private WebDriver driver;


	/*@AfterMethod
	public void tearDown() {
		//driver.close();
		driver.switchTo().defaultContent();
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {
		waitFor(driver, (By.className("x-toolbar-cell")));
		
		driver.findElement(By.id("ext-gen231")).click();
		} catch (NoSuchElementException e) {	
		}
		}
	*/
	
	
	@BeforeMethod
	public void setup() throws Exception {
		
		

//		setConexion.setUp();
		
		driver = setConexion.setupLeo();	
		driver.get("https://cs14.salesforce.com/console")	;
		Login page1 = new Login(driver);
		page1.ingresar();
			

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
		
	}
	
	/*@Test
	public void TS7193_CaseRelatedFieldsValuesCanalClosing(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(0));
		
		driver.findElement(By.name("newCase")).click();

		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		driver.findElement(By.id("00Nc0000001pWcr"));
		Select dateDropDown=new Select(driver.findElement(By.id("00Nc0000001pWcr")));
		dateDropDown.selectByVisibleText("App");
		dateDropDown.selectByVisibleText("Chat");
		dateDropDown.selectByVisibleText("Email");
		dateDropDown.selectByVisibleText("IVR");
		dateDropDown.selectByVisibleText("Personalizado");
		dateDropDown.selectByVisibleText("Redes Sociales");
		dateDropDown.selectByVisibleText("Sat Push");
		dateDropDown.selectByVisibleText("SMS");
		dateDropDown.selectByVisibleText("Telef�nico");
		dateDropDown.selectByVisibleText("USSD");
		dateDropDown.selectByVisibleText("Web");
	}
	
	@Test
	public void TS7090_CaseRelatedFieldsValuesSubArea(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(0));
		
		driver.findElement(By.name("newCase")).click();

		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		driver.findElement(By.id("00Nc0000001pWcx"));
		Select dateDropDown=new Select(driver.findElement(By.id("00Nc0000001pWcx")));
		dateDropDown.selectByVisibleText("Actualizaci�n de Datos del Cliente");
		dateDropDown.selectByVisibleText("Reseteo de Clave");
		dateDropDown.selectByVisibleText("Consulta t�cnica");
	}
	
	@Test
	public void TS7088_CaseRelatedFieldsValuesType(){
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(0));
		
		driver.findElement(By.name("newCase")).click();

		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		driver.findElement(By.id("00Nc0000001pWcx"));
		Select dateDropDown=new Select(driver.findElement(By.id("cas5")));
		dateDropDown.selectByVisibleText("Sample Cases");
		dateDropDown.selectByVisibleText("Trial");
		dateDropDown.selectByVisibleText("Incidente Masivo");

}
	*/
	
	
	@Test
	public void CreateCase() {
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(0));
		driver.findElement(By.name("newCase")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		driver.findElement(By.id("cas3")).sendKeys("Fernando Caree");
		driver.findElement(By.id("cas4_lkwgt")).click();

		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
		   for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		          driver.switchTo().window(windowHandle);
		          driver.manage().window().maximize();
					try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
					driver.findElement(By.xpath("//*[@id=\'lksrch\']")).sendKeys("Fernando Caree");
					driver.findElement(By.name("go")).click();
					}
		         driver.switchTo().window(parentWindow); 
		          }
		       
			
	
	}
	
		
		
	
	
	
	
	
}