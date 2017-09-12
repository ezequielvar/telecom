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
}














