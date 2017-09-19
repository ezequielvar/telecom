package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

	@BeforeMethod
	public void setUp() throws Exception {
		//TODO: add how to get to ABM de Motivo
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
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		if(accountPage.isTabOpened("Servicio T�cnico")) {
			System.out.println("Tab Opened.");
			accountPage.goToTab("Servicio T�cnico");
		}else {
			accountPage.clickRightPanelButtonByName("Servicio T�cnico");
		}
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@AfterClass
	public void tearDown() {
		//BasePage basePage = new BasePage();
		//basePage.switchAppsMenu();
		//basePage.selectAppFromMenuByName("Ventas");
		driver.close();
	}
	
	@Test(groups = "fase2")
	public void TS11622_SST_Servicio_Indiferente_Adjunto_Formato_invalido() {
		Accounts accPage = new Accounts(driver);
		String invalidFilePath = "C:\\Users\\pablo\\Desktop\\SampleFiles\\unZip.zip";
		String mensajeParcialErrorEnPagina = "Solo se pueden adjuntar archivos de tipo .doc";
		//Literal en pagina: " Solo se pueden adjuntar archivos de tipo .doc, .docx, .xls, .xlsx, .pdf, .jpg, .jpeg "
		accPage.fillIMEI(validIMEI);
		accPage.continueFromImeiInput();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		accPage.continueFromClientInfo();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		accPage.selectOperationType("Consulta");
		accPage.selectSymptomByIndex(2);
		accPage.attachFile(invalidFilePath);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String errMessage = accPage.getMessageDescription();
		Assert.assertTrue(errMessage.trim().contains(mensajeParcialErrorEnPagina));
	}
}
