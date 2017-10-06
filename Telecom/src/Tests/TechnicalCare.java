package Tests;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
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
	private String test = "defTest"; //Flag for special TestCases.
	
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
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Accounts accountPage = new Accounts(driver);
		if(test.equals("cancelar")) {
			By closeButtonBy = By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope");
			driver.switchTo().frame(accountPage.getFrameForElement(driver, closeButtonBy));
			driver.findElement(closeButtonBy).click(); //if not visible, doesn't break.
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("alert-ok-button")).click();
			//Another way to close TechCare, but less efficient and more complicated.
			/*if(accountPage.isTabOpened("Servicio Técnico")) {
				accountPage.closeAccountServiceTabByName("Servicio Técnico");	
			}*/
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		}else {
			test = "deftest"; //persistence for the rest of cases.
			//just continue openening TechCare
		}
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

	@Test(groups = "Fase2")
	public void TS11609_SST_Servicio_Indiferente_Avance_En_La_Gestion() {
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
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.continueFromSymptomExplanation();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//System.out.println(driver.findElement(By.id("TicketConfirmationText")).getText());
		driver.findElement(By.id("TicketConfirmationText"));//Su Gestión ha sido procesada, el número es: 00003282
		driver.findElement(By.id("TicketCreation_prevBtn")).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups = "Fase2")
	public void TS11627_SST_Servicio_Indiferente_Cancelar() {
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
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		By cancelButtonBy = By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope");
		driver.switchTo().frame(accPage.getFrameForElement(driver, cancelButtonBy));
		driver.findElement(cancelButtonBy).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("alert-ok-button")).click();
		test = "cancelar";
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups = "Fase2")
	public void TS11628_SST_Servicio_Indiferente_Cancelar_deshabilitado() {
		Accounts accPage = new Accounts(driver);
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.continueFromSymptomExplanation();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//System.out.println(driver.findElement(By.id("TicketConfirmationText")).getText());
		driver.findElement(By.id("TicketConfirmationText"));//Su Gestión ha sido procesada, el número es: 00003282
		By cancelButtonBy = By.cssSelector(".vlc-slds-button--tertiary.ng-binding.ng-scope");
		try {
			driver.findElement(cancelButtonBy).click();
		}catch(NoSuchElementException noSuchElemExcept) {
			//if this is called, then the button wasn't found.
			System.out.println("Cancel button NOT found.");
		}catch(WebDriverException webExcept) {
			//if this is called, then the button was found, but is not clickable. Likely.
			System.out.println("Cancel button NOT clickable.");			
		}
		driver.findElement(By.id("TicketCreation_prevBtn")).click();
		System.out.println("prevBtn clicked.");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@Test(groups = "Fase2")
	public void TS11619_SST_Servicio_Indiferente_Comentario_valido() {
		Accounts accPage = new Accounts(driver);
		String comentarioValido = "Un comentario válido.";
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.fillComments(comentarioValido);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.continueFromSymptomExplanation();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//System.out.println(driver.findElement(By.id("TicketConfirmationText")).getText());
		driver.findElement(By.id("TicketConfirmationText"));//Su Gestión ha sido procesada, el número es: 00003282
		driver.findElement(By.id("TicketCreation_prevBtn")).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@Test(groups = "Fase2")
	public void TS11615_SST_Servicio_Indiferente_Creacion() {
		Accounts accPage = new Accounts(driver);
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.continueFromSymptomExplanation();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//System.out.println(driver.findElement(By.id("TicketConfirmationText")).getText());
		driver.findElement(By.id("TicketConfirmationText"));//Su Gestión ha sido procesada, el número es: 00003282
		System.out.println(driver.findElement(By.id("TicketConfirmationText")).findElement(By.tagName("strong")).getText());
		driver.findElement(By.id("TicketCreation_prevBtn")).click();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups = "Fase2")
	public void TS11613_SST_Servicio_Indiferente_Ingreso_Por_IMEI_invalido() {
		Accounts accPage = new Accounts(driver);
		String imeiInvalido = "500020000200006";
		accPage.fillIMEI(imeiInvalido);
		accPage.continueFromImeiInput();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.id("alert-ok-button")).click();
	}

	@Test(groups = "Fase2")
	public void TS11623_SST_Servicio_Indiferente_Mas_De_Dos_Archivos() {
		Accounts accPage = new Accounts(driver);
		String filePath1 = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unDoc.doc";
		String filePath2 = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unXls.xls";
		String filePath3 = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unJpg.jpg";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(filePath1);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.attachFile(filePath2);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.attachFile(filePath3);
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals(driver.findElement(By.cssSelector(".message.description.ng-binding.ng-scope")).getText().trim(), "No se pueden adjuntar más de dos archivos.");
		accPage.continueFromSymptomExplanation();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String errorMsg = driver.findElement(By.cssSelector(".slds-modal__content.slds-p-around--medium")).getText();
		Assert.assertEquals(errorMsg, "Error: Por favor complete todos los campos requeridos"); //This will change, this isn't the right error message.
		driver.findElement(By.id("alert-ok-button")).click();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test(groups = "Fase2")
	public void TS11602_SST_Servicio_Indiferente_Tipo_De_Operaciones() {
		Accounts accPage = new Accounts(driver);
		accPage.fillIMEI(validIMEI);
		List<String> listaEsperada = Arrays.asList("-- Clear --"
				,"Consulta"
				,"Configuración"
				,"Reparación"
				,"Certificados"
				,"Demo"
				,"Reparación"
				,"Presupuesto"
				,"Express");
		accPage.continueFromImeiInput();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(accPage.areAllElementsInWEList(listaEsperada));
	}
	

@Test(groups = "Fase2") 
  public void TS16196_STT_Telefono_Alternativo_Vista() {
    Accounts accPage = new Accounts(driver);
    accPage.fillIMEI(validIMEI);
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    accPage.continueFromImeiInput();
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.switchTo().frame(accPage.getFrameForElement(driver, By.id("a1zc0000003IdKkAAK-6")));
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    Assert.assertTrue(driver.findElement(By.id("AlternativePhone")).isDisplayed());
  }
  
  @Test(groups = "Fase2") 
  public void TS16189_STT_Mail_Alternativo_Vista() {
    Accounts accPage = new Accounts(driver);
    accPage.fillIMEI(validIMEI);
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    accPage.continueFromImeiInput();
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.switchTo().frame(accPage.getFrameForElement(driver, By.id("a1zc0000003IdKkAAK-6")));
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    Assert.assertTrue(driver.findElement(By.id("AlternativeEmail")).isDisplayed());
  }
  
  @Test(groups = "Fase2") 
  public void TS16190_STT_Mail_Valido() {
    Accounts accPage = new Accounts(driver);
    accPage.fillIMEI(validIMEI);
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    accPage.continueFromImeiInput();
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.switchTo().frame(accPage.getFrameForElement(driver, By.id("a1zc0000003IdKkAAK-6")));
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.findElement(By.id("AlternativeEmail")).sendKeys("roboAlt@algo.com");
    try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.findElement(By.cssSelector(".slds-form-element.vlc-flex.ng-scope.ng-valid-required.ng-dirty.ng-valid.ng-valid-email"));
  }
  
  @Test(groups = "Fase2") 
  public void TS16191_STT_Mail_Invalido_Sin_Dominio() {
    Accounts accPage = new Accounts(driver);
    accPage.fillIMEI(validIMEI);
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    accPage.continueFromImeiInput();
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.switchTo().frame(accPage.getFrameForElement(driver, By.id("ClientInformation_nextBtn")));
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.findElement(By.id("AlternativeEmail")).sendKeys("roboAlt");
    try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    accPage.continueFromClientInfo();
    assertTrue(driver.findElement(By.id("alert-container")).isDisplayed());
  }
  
  @Test(groups = "Fase2") 
  public void TS16192_STT_Mail_Invalido_Con_Dominio() {
    Accounts accPage = new Accounts(driver);
    accPage.fillIMEI(validIMEI);
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    accPage.continueFromImeiInput();
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.switchTo().frame(accPage.getFrameForElement(driver, By.id("ClientInformation_nextBtn")));
    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    driver.findElement(By.id("AlternativeEmail")).sendKeys("*@gmail.com");
try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    accPage.continueFromClientInfo();
    try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
    Assert.assertTrue(driver.findElement(By.id("alert-container")).isDisplayed());
  }
	
}


