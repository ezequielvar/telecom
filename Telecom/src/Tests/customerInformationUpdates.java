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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.AccountType;
import Pages.CustomerCare;
import Pages.NewAccount;
import Pages.customerInformation;
import Pages.setConexion;

public class customerInformationUpdates extends TestBase {
	
	private WebDriver driver;
	String accountName = "Aaa Aaa";



	//@AfterClass
	public void tearDown2() {
		driver.close();	
	}

	//@AfterMethod
	public void tearDown() {
		driver.switchTo().defaultContent();
		driver.findElement(By.id("navigatortab__scc-pt-0")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.xpath("//*[text() = 'Detalles']")).click();
		List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame6.get(1));
		driver.findElement(By.name("delete")).click(); 
		 for (String handle : driver.getWindowHandles()) {	 
		    driver.switchTo().window(handle);}
		List<WebElement> buttons = driver.findElements(By.cssSelector(".x-btn-text"));
		buttons.get(2).click();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.get("https://cs14.salesforce.com/home/home.jsp?tsid=02u41000000QWha");
	}
	
	@BeforeClass
	public void init() throws Exception
	{
			this.driver = setConexion.setupEze();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			login(driver);
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@BeforeMethod
	public void setUpTest() {
		if (!driver.getCurrentUrl().toString().equals("https://crm--sit.cs14.my.salesforce.com/console")){
			driver.findElement(By.id("tsidLabel")).click();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
		}
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
			field.selectByVisibleText("Todas Las cuentas");
			/*
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.name("new")).click();
			driver.switchTo().defaultContent();
			try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(frame1.get(1));
			AccountType tipo = new AccountType(driver);
			tipo.setType("Consumer");
			List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(frame2.get(1));
			NewAccount account = new NewAccount(driver);
				account.createNewAcc(accountName);
				
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.switchTo().defaultContent();
			goToLeftPanel(driver, "Cuentas");
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			WebElement frame3 = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(frame3);
			Select field1 = new Select(driver.findElement(By.name("fcf")));
			field1.selectByVisibleText("Todas Las cuentas");
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.navigate().refresh();
			*/
			WebElement frame4 = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(frame4);
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			 CustomerCare page = new CustomerCare(driver);
				page.elegircuenta("Aaa Aaa");
			driver.switchTo().defaultContent();
			page.openleftpanel();
			/*
			List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(frame5.get(5));
			waitFor(driver, (By.className("profile-edit")));		
			List<WebElement> profileEdit = driver.findElements(By.className("profile-edit"));
			profileEdit.get(0).click();
			
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));		
			driver.switchTo().frame(frame6.get(4));
		waitFor(driver, (By.id("FirstName")));
			customerInformation page = new customerInformation(driver);
		
			page.setDefaultValues();//pincha ac� porque hay un bug en el campo DNI de actualizar datos, los tests no se pueden correr
			waitFor(driver, (By.className("panel-heading")));		
			List<WebElement> text = driver.findElements(By.className("panel-heading"));
			Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
			driver.switchTo().defaultContent();
			List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
			List<WebElement> frame7 = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(frame7.get(5));
			List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
			profileEdit1.get(0).click();
			driver.switchTo().defaultContent();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			List<WebElement> frame8 = driver.findElements(By.tagName("iframe"));		
			driver.switchTo().frame(frame8.get(4));
			waitFor(driver, (By.id("FirstName")));*/
	}

	@Test	
	public void TS7175_isLastNameMandatory() {
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isLastNameRequired());
	}
	
	@Test	
	public void TS7174_isFirstNameMandatory() {
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isFirstNameRequired());
	}
	
	@Test	
	public void TS7173_isEmailMandatory() {
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isEmailRequired());
	}

	@Test	
	public void TS7170_isDocumentMandatory() {
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isDocumentRequired());
	}

	@Test	
	public void TS7171_isBirthDateMandatory() {
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isBirthDateRequired());
	}
	
	@Test	
	public void TS7169_isGenderMandatory() {
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isGenderRequired());
	}
	
	@Test	
	public void TS7172_isMobilePhoneMandatory() {
		customerInformation page = new customerInformation(driver);
		Assert.assertEquals("true", page.isMobilePhoneRequired());
	}
	
	@Test	
	public void TS7149_fieldsWhichDontTriggerIdentityValidationProcess() {
		customerInformation page = new customerInformation(driver);
		page.setFieldsWhichDontTriggerIdentityValidationProcess();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
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
		customerInformation page = new customerInformation(driver);
		page.setTwoFieldsWhichDontTriggerIdentityValidationProcess();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
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
		customerInformation page = new customerInformation(driver);
		page.setThreeFieldsWhichTriggerIdentityValidationProcess();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> text = driver.findElements(By.cssSelector(".ng-binding.ng-scope"));
		Assert.assertEquals("No se pueden modificar G�nero, N�mero de documento y Fecha de Nacimiento al mismo tiempo.", text.get(3).getText());
	}
	
	@Test	
	public void TS7153_verifyBirthDateHasValidDateFormat() {
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.isBirthDateAValidDateFormat());
	}
	
	@Test
	public void TS7155_validateBirthDateHasAYearPicker() {
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.isYearPickerPresentInBirthDatePicker());
	}
	
	@Test
	public void TS7183_modifyDocumentTwiceInAMonth() {
		customerInformation page = new customerInformation(driver);
		try{ Assert.assertFalse(page.isDocumentModifyable()); } catch (Exception e) 
		{
		page.modifyDocument("32645423");
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		//Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));
		Assert.assertFalse(page.isDocumentModifyable()); 
		}
	}
	
	@Test
	public void TS7098_cancelUpdateInformation() {
		customerInformation page = new customerInformation(driver);
		page.modifyNameAndCancel();
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));
		Assert.assertNotEquals("Test", page.getCurrentValue());
	}
	
	@Test
	public void TS7103_updateMobilePhone() {
		customerInformation page = new customerInformation(driver);
		page.modifyMobilePhone();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));
	}
	
	@Test
	public void TS7102_updateOtherPhone() {
		customerInformation page = new customerInformation(driver);
		page.modifyOtherPhone();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));
	}
	
	@Test
	public void TS7099_updateFirstName() {
		customerInformation page = new customerInformation(driver);
		page.modifyFirstName();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));
	}
	
	@Test
	public void TS7104_updateBirthDate() {
		customerInformation page = new customerInformation(driver);
		page.modifyBirthDate();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));
	}
	
	@Test
	public void TS7101_updateEmail() {
		customerInformation page = new customerInformation(driver);
		page.modifyEmail();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));
	}
	
	@Test
	public void TS7100_updateLastName() {
		customerInformation page = new customerInformation(driver);
		page.modifyLastName();
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabs.get(6));
		List<WebElement> frame4 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame4.get(5));
		List<WebElement> profileEdit1 = driver.findElements(By.className("profile-edit"));
		profileEdit1.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame5 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame5.get(4));
		waitFor(driver, (By.id("FirstName")));		
		page.setDefaultValues();
		waitFor(driver, (By.className("panel-heading")));
	}
	
	@Test
	public void TS7150_verifyNumbersAreNotAllowedInFirstNameAndLastName() {
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.areNumbersAllowedInFirstNameAndLastName());
	}
	
	@Test
	public void TS7182_modifyDniByTwoDigits() {
		customerInformation page = new customerInformation(driver);
		page.modifyDniBy("32645423");
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
	}
	
	@Test
	public void TS7186_modifyDniByOneDigits() {
		customerInformation page = new customerInformation(driver);
		page.modifyDniBy("32645422");
		waitFor(driver, (By.className("panel-heading")));		
		List<WebElement> text = driver.findElements(By.className("panel-heading"));
		Assert.assertTrue(text.get(0).getText().contains("Confirmaci�n"));
	}
	
	@Test
	public void TS7207_verifyLettersAreNotAllowedInCuil() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame6.get(4));
		waitFor(driver, (By.id("FirstName")));
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.areLettersAllowedInCuil());
	}
	

	@Test
	public void TS7097_verifyNonOwnershipChange() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame6.get(4));
		waitFor(driver, (By.id("FirstName")));
		customerInformation page = new customerInformation(driver);
		page.modifyCuil();
		Assert.assertTrue(page.notchansgetopname());
		
	}
	
	@Test
	public void TS7205_Cambios_en_la_Informacion_del_Cliente_Validar_Caracteres_Campo_Apellido() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame6.get(4));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		customerInformation page = new customerInformation(driver);
		CustomerCare page1=new CustomerCare(driver);
		page1.openleftpanel();
		Assert.assertTrue(page.validarlimitecaracterapellido());
	}
	
	@Test
	public void TS7210_Cambios_en_la_Informacion_del_Cliente_Telefono_Alternativo_No_permite_letras() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame6.get(4));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.validarcaractertelefonoalternativo());

	}
	@Test(groups= "fase2")
	public void TS7209_Cambios_en_la_Informacion_del_Cliente_Telefono_Movil_No_permite_letras() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame6.get(4));
		waitFor(driver, (By.id("FirstName")));
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.validarcaractermovilalternativo());

	}
	
	@Test(groups= "fase2")
	public void TS7151_Cambios_en_la_Informacion_del_Cliente_Validar_Nombre_Apellido_Que_tengan_caracteres_especiales() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));		
		driver.switchTo().frame(frame6.get(4));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.validarcaracterespecialesNyA());

	}
	@Test(groups= "fase2")
	public void TS12282_Reseteo_de_Claves_Manejo_de_la_Clave_Visualizar_Boton_Reseteo_Clave() {
		driver.switchTo().defaultContent();
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.validacionbtnreseteodeclave());
	}
	
	@Test (groups= "fase2")
	public void TS7161_Cambios_en_la_Informacion_del_Cliente_Validar_Tel�fono_Movil_5_digitos_Codigo_de_area() {
		driver.switchTo().defaultContent();
		customerInformation page = new customerInformation(driver);
		Assert.assertTrue(page.ValidarDigitosDelMovil());	
	}
	
}
