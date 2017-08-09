package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.customerInformation;
import Pages.setConexion;

public class customerInformationUpdates extends TestBase {
	
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
//		driver.get("https://cs14.salesforce.com/home/home.jsp?tsid=02u41000000QWha");
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
	public void TS7175_isLastNameMandatory() {
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isLastNameRequired());
	}
	
	@Test	
	public void TS7173_isEmailMandatory() {
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isEmailRequired());
	}

	@Test	
	public void TS7170_isDocumentMandatory() {
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isDocumentRequired());
	}

	@Test	
	public void TS7171_isBirthDateMandatory() {
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isBirthDateRequired());
	}
	
	@Test	
	public void TS7169_isGenderMandatory() {
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isGenderRequired());
	}
	
	@Test	
	public void TS7172_isMobilePhoneMandatory() {
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isMobilePhoneRequired());
	}
	
	@Test	
	public void TS7149_fieldsWhichDontTriggerIdentityValidationProcess() {
		waitFor(driver, (By.cssSelector(".x-border-panel")));		
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		waitFor(driver, (By.className("profile-edit")));		
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		waitFor(driver, (By.id("FirstName")));		
		customerInformation page = new customerInformation(driver);
		page.setFieldsWhichDontTriggerIdentityValidationProcess();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmación"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));		
	}
	
	@Test	
	public void TS7176_modifyTwoFieldsWhichDontTriggerIdentityValidationProcess() {
		waitFor(driver, (By.cssSelector(".x-border-panel")));		
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		waitFor(driver, (By.className("profile-edit")));		
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		waitFor(driver, (By.id("FirstName")));		
		customerInformation page = new customerInformation(driver);
		page.setTwoFieldsWhichDontTriggerIdentityValidationProcess();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmación"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));		
	}
	
	@Test	
	public void TS7177_modifyThreeFieldsWhichTriggerIdentityValidationProcess() {
		waitFor(driver, (By.cssSelector(".x-border-panel")));		
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		waitFor(driver, (By.className("profile-edit")));		
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		waitFor(driver, (By.id("FirstName")));		
		customerInformation page = new customerInformation(driver);
		page.setThreeFieldsWhichTriggerIdentityValidationProcess();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> text = driver.findElements(By.cssSelector(".ng-binding.ng-scope"));
		Assert.assertEquals("No se pueden modificar Género, Número de documento y Fecha de Nacimiento al mismo tiempo.", text.get(3).getText());
	}
	
	@Test	
	public void TS7153_verifyBirthDateHasValidDateFormat() {
		waitFor(driver, (By.cssSelector(".x-border-panel")));		
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
		List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
		accounts.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try { if(driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).isDisplayed()) {
		driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
		} } catch (org.openqa.selenium.NoSuchElementException e) {}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		waitFor(driver, (By.className("profile-edit")));		
		List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
		profileEdit.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame2.get(4));
		waitFor(driver, (By.id("FirstName")));		
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.isBirthDateAValidDateFormat());
	}
}
