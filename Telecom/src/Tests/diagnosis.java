package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
import Pages.diagnosisTab;
import Pages.setConexion;
import Pages.BasePage;

public class diagnosis extends TestBase {
	
	private WebDriver driver;


	@AfterClass
	public void tearDown2() {
		driver.close();
		
	}
	
	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupEze();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@AfterMethod
	public void tearDown() {
	//	driver.get("https://cs14.salesforce.com/home/home.jsp?tsid=02u41000000QWha");
	}

	@BeforeMethod
	public void setUp() throws Exception {
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
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Todas las cuentas");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Chronos Automata']"));
		accounts.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accountTabs = driver.findElements(By.className("tabText"));
		accountTabs.get(2).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(2));
		List<WebElement> squares = driver.findElements(By.cssSelector(".console-card.active"));
		for (WebElement e : squares) {
			if (e.getText().contains("INTERNET")) {
		e.click(); }
		}
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.xpath("//*[@id=\"j_id0:j_id5\"]/div/div/ng-include/div/div[2]/div[3]/ng-include/section[2]/div[3]/ng-transclude/div/ng-include/div/div[1]/div/ng-include/div/ul/li[3]")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame3 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame3.get(4));
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("SelectedMotives")).click();
		List<WebElement> drops1=driver.findElements(By.cssSelector("ul > li"));
		//driver.findElement(By.xpath("//li[contains(text(),'No me funciona internet')]")).click();
		//WebElement aa = driver.findElement(By.xpath("//*[@id=\"SelectBlock\"]/div/div/div[2]/child[2]/div/div/ng-form/div[2]/div[1]/ul/li[2]"));
		//System.out.println(aa.getTagName());
		//System.out.println(aa.getSize());
		//List<WebElement> drops1=driver.findElements(By.tagName("li"));
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//List<WebElement> list = driver.findElements(By.xpath("//*[text() = 'No me funciona internet']"));
		//list.get(0).click();
		
        System.out.println(drops1.size());
        System.out.println(drops1.get(1).getText());
        drops1.get(0).click();
        /*for(WebElement  obj1:drops1)
        {
        	JavascriptExecutor executor = (JavascriptExecutor) driver;
        	executor.executeScript("arguments[1].click();", obj1);
        	System.out.println(obj1.getText());
        }*/
		driver.findElement(By.xpath("/html/body/span/div/span/div/ng-view/div/div/bptree/child[6]/div/section/form/div[1]/div/child[3]/div/ng-form/div/div/div[2]/child[2]/div/div/ng-form/div[2]/div[1]/ul/li[4]"));
		WebElement aaa = driver.findElement(By.id("SelectedMotives"));
		BasePage base = new BasePage();
		//base.setSimpleDropdown(aa, "No me funciona internet");
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
		for (WebElement e : squares) {
			if (e.getText().contains("INTERNET")) {
		e.click(); }
		}
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
		Boolean a = false;
		for (WebElement e : squares) {
			if (e.getText().contains("INTERNET")) {
		a = true; }
		}		
		Assert.assertTrue(a == true);
	}

}
