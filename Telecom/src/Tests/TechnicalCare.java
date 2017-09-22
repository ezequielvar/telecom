package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Accounts;
import Pages.BasePage;
import Pages.HomeBase;
import Pages.setConexion;


public class TechnicalCare extends TestBase  {
	private WebDriver driver;
	private String validIMEI = "545229703256596";
	
	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupPablo();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@BeforeClass
	public void setUp() throws Exception {
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		goToLeftPanel2(driver, "Cuentas");
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Accounts accountPage = new Accounts(driver);
		//Selecciono Vista Tech
		driver.switchTo().defaultContent();
		accountPage.accountSelect("Vista Tech");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//select accountName "Robo Tech", currently has index 10.
		accountPage.selectAccountByName("Robo Tech");
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		if(accountPage.isTabOpened("Servicio Técnico")) {
			System.out.println("Tab Opened.");
			accountPage.closeAccountServiceTabByName("Servicio Técnico");
			accountPage.clickRightPanelButtonByName("Servicio Técnico");
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		}else {
			accountPage.clickRightPanelButtonByName("Servicio Técnico");
			try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			accountPage.goToTab("Servicio Técnico");
			try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.switchTo().defaultContent();
		BasePage basePage = new BasePage(driver);
		basePage.switchAppsMenu(driver);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		basePage.selectAppFromMenuByName("Ventas");
		driver.close();
	}

	@AfterMethod
	public void closeTechCare() {
		System.out.println("AfterMethod executed.");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Accounts accountPage = new Accounts(driver);
		By closeButtonBy = By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope");
		driver.switchTo().frame(accountPage.getFrameForElement(driver, closeButtonBy));
		driver.findElement(closeButtonBy).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("alert-ok-button")).click();
		/*if(accountPage.isTabOpened("Servicio Técnico")) {
			accountPage.closeAccountServiceTabByName("Servicio Técnico");	
		}*/
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accountPage.clickRightPanelButtonByName("Servicio Técnico");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@Test(groups = "Fase2")
	public void TS11622_SST_Servicio_Indiferente_Adjunto_Formato_invalido() {
		Accounts accPage = new Accounts(driver);
		String invalidFilePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unZip.zip";
		String mensajeParcialErrorEnPagina = "Solo se pueden adjuntar archivos de tipo";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(invalidFilePath);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String errMessage = accPage.getMessageDescription();
		Assert.assertTrue(errMessage.trim().contains(mensajeParcialErrorEnPagina));
	}
	
	@Test(groups = "Fase2")
	public void TS11620_SST_Servicio_Indiferente_Adjunto_Valido_doc() {
		Accounts accPage = new Accounts(driver);
		String filePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unDoc.doc";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String textoArchivoAdjunto = accPage.getAttachedFileTxt();
		System.out.println(textoArchivoAdjunto);
		Assert.assertTrue(textoArchivoAdjunto.toLowerCase().trim().contains(".doc"));
	}
	
	@Test(groups = "Fase2")
	public void TS11631_SST_Servicio_Indiferente_Adjunto_Valido_docx() {
		Accounts accPage = new Accounts(driver);
		String filePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unDocx.docx";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String textoArchivoAdjunto = accPage.getAttachedFileTxt();
		System.out.println(textoArchivoAdjunto);
		Assert.assertTrue(textoArchivoAdjunto.toLowerCase().trim().contains(".docx"));
	}
	
	@Test(groups = "Fase2")
	public void TS11635_SST_Servicio_Indiferente_Adjunto_Valido_jpeg() {
		Accounts accPage = new Accounts(driver);
		String filePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unJpeg.jpeg";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath);
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String textoArchivoAdjunto = accPage.getAttachedFileTxt();
		System.out.println(textoArchivoAdjunto);
		Assert.assertTrue(textoArchivoAdjunto.toLowerCase().trim().contains(".jpeg"));
	}
	
	@Test(groups = "Fase2")
	public void TS11634_SST_Servicio_Indiferente_Adjunto_Valido_jpg() {
		Accounts accPage = new Accounts(driver);
		String filePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unJpg.jpg";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String textoArchivoAdjunto = accPage.getAttachedFileTxt();
		System.out.println(textoArchivoAdjunto);
		Assert.assertTrue(textoArchivoAdjunto.toLowerCase().trim().contains(".jpg"));
	}
	
	@Test(groups = "Fase2")
	public void TS11636_SST_Servicio_Indiferente_Adjunto_Valido_pdf() {
		Accounts accPage = new Accounts(driver);
		String filePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unPdf.pdf";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String textoArchivoAdjunto = accPage.getAttachedFileTxt();
		System.out.println(textoArchivoAdjunto);
		Assert.assertTrue(textoArchivoAdjunto.toLowerCase().trim().contains(".pdf"));
	}
	
	@Test(groups = "Fase2")
	public void TS11632_SST_Servicio_Indiferente_Adjunto_Valido_xls() {
		Accounts accPage = new Accounts(driver);
		String filePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unXls.xls";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath);
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String textoArchivoAdjunto = accPage.getAttachedFileTxt();
		System.out.println(textoArchivoAdjunto);
		Assert.assertTrue(textoArchivoAdjunto.toLowerCase().trim().contains(".xls"));
	}
	
	@Test(groups = "Fase2")
	public void TS11633_SST_Servicio_Indiferente_Adjunto_Valido_xlsx() {
		Accounts accPage = new Accounts(driver);
		String filePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unXlsx.xlsx";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String textoArchivoAdjunto = accPage.getAttachedFileTxt();
		System.out.println(textoArchivoAdjunto);
		Assert.assertTrue(textoArchivoAdjunto.toLowerCase().trim().contains(".xlsx"));
	}

	
	
	
	
}
