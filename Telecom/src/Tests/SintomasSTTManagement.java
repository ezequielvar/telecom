package Tests;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomeBase;
import Pages.SintomasSSTManager;
import Pages.setConexion;

//page link: https://cs14.salesforce.com/a44?fcf=00Bc0000001LRmd

public class SintomasSTTManagement extends TestBase {
	
	private WebDriver driver;
	private String symptomsListURL = "https://cs14.salesforce.com/a44";
	private String validDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
			+ "Morbi bibendum erat sit amet metus molestie egestas. Phasellus facilisis tortor sapien, quis "
			+ "consequat orci dapibus vel. Praesent interdum consectetur neque tempor sagittis. "
			+ "Nulla facilisi volutpat.";
	
	private String invalidDescription = "Alorem ipsum dolor sit amet, consectetur adipiscing elit. "
			+ "Morbi bibendum erat sit amet metus molestie egestas. Phasellus facilisis tortor sapien, quis "
			+ "consequat orci dapibus vel. Praesent interdum consectetur neque tempor sagittis. "
			+ "Nulla facilisi volutpat.";
	
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
		if (!driver.getCurrentUrl().toString().startsWith(symptomsListURL)){
			HomeBase homePage = new HomeBase(driver);
			homePage.switchAppsMenu();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			homePage.selectAppFromMenuByName("Ventas");
			driver.get(symptomsListURL); //TODO: change to actual path.
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}			
		}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void TS12605_SST_Sintomas_Consistencia(){
		
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		homePage.selectAppFromMenuByName("Ventas");
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		homePage.selectMainTabByName("Síntomas de STT");
		
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		//this is How the page handles the selection
		sstManagerPage.selectToSeeByName("ABM de Síntomas STT");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.selectToSeeByName("All");
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<String> symptomsRegInSSTView = sstManagerPage.getSymptomsRegisterNumbers();
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<String> symptomsRegInSSTViewForAdmin = sstManagerPage.getSymptomsRegisterNumbersForAdmin();
		Assert.assertTrue((new HashSet(symptomsRegInSSTViewForAdmin)).equals((new HashSet(symptomsRegInSSTView))));
		//symptomsRegInSSTView.add("unStringDeMas"); //this proves HashSet.equals() is working correctly.
		//Assert.assertFalse((new HashSet(symptomsRegInSSTViewForAdmin)).equals((new HashSet(symptomsRegInSSTView))));
	}

	@Test
	public void TS11561_Admin_Desactivacion_De_Sintoma(){
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement activeSymptom = sstManagerPage.getFirstActiveSymptom();
		boolean isActive = sstManagerPage.isSymptomActive(activeSymptom);
		Assert.assertTrue(isActive);//checks condition, that symptom is active.
		sstManagerPage.setSymptomState(activeSymptom, false);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertFalse(sstManagerPage.isSymptomActive(activeSymptom));
	}

	@Test
	public void TS11558_Creacion_De_Sintoma_Descripcion_255(){
		String nombreSintomaNuevo = "TS11558 Sintoma nuevo.255";
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.goToCreateNewSymptom();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.fillAndSaveCustomSymptom(nombreSintomaNuevo, validDescription);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(sstManagerPage.getSymptomByName(nombreSintomaNuevo) != null); //verifies that the symptom was found.
	}

	@Test
	public void TS11559_Creacion_De_Sintoma_Descripcion_256(){
		//the creation is allowed, it just cuts down what exceeds the 255 limit.
		String nombreSintomaNuevo = "TS11559 Sintoma nuevo.256";
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.goToCreateNewSymptom();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.fillAndSaveCustomSymptom(nombreSintomaNuevo, invalidDescription);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(sstManagerPage.getSymptomByName(nombreSintomaNuevo) != null); //verifies that the symptom was found.
	}
	
	@Test
	public void TS11557_Creacion_De_Sintoma_Descripcion_letra(){
		String nombreSintomaNuevo = "TS11557 Sintoma con desc 1 letra.";
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.goToCreateNewSymptom();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.fillAndSaveCustomSymptom(nombreSintomaNuevo, "a");//1 letter, should be allowed to create.
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(sstManagerPage.getSymptomByName(nombreSintomaNuevo) != null); //verifies that the symptom was found.
	}
	
	@Test
	public void TS11556_Creacion_De_Sintoma_Descripcion_numero(){
		String nombreSintomaNuevo = "TS11557 Sintoma con desc 1 numero.";
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.goToCreateNewSymptom();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.fillAndSaveCustomSymptom(nombreSintomaNuevo, "9");//1 number, should be allowed to create.
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(sstManagerPage.getSymptomByName(nombreSintomaNuevo) != null); //verifies that the symptom was found.
	}
	
	@Test
	public void TS11555_Creacion_De_Sintoma_Descripcion_simbolo(){
		String nombreSintomaNuevo = "TS11555 Sintoma con desc 1 simbolo.";
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.goToCreateNewSymptom();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.fillAndSaveCustomSymptom(nombreSintomaNuevo, "®");//1 symbol, should NOT be allowed to create.
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(sstManagerPage.getSymptomByName(nombreSintomaNuevo) != null); //verifies that the symptom was found.
	}

	@Test
	public void TS11546_Creacion_De_Sintoma_Ejecucion_activado(){
		String nombreSintomaNuevo = "TS11546: Sintoma ACTIVADO";
		String activadoDescripcion = "Se creo activado.";
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
		homePage.switchAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.deleteAllSymptomsByName(nombreSintomaNuevo); //this should be done in the tearDown method. afterClass.
		sstManagerPage.goToCreateNewSymptom();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.fillAndSaveCustomSymptom(nombreSintomaNuevo, activadoDescripcion, true);
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel2(driver, "Síntomas de STT");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement newSymptom = sstManagerPage.getSymptomByName(nombreSintomaNuevo);
		Assert.assertTrue(newSymptom != null); //verifies that the symptom was found.
		Assert.assertTrue(sstManagerPage.isSymptomActive(newSymptom));
	}
}














