package Tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
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
			driver.get(symptomsListURL); //TODO: change to actual path.
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			/*
			HomeBase homePage = new HomeBase(driver);
			homePage.openAppsMenu();
			homePage.selectAppFromMenuByName("Ventas");
			homePage.selectMainTabByName("Síntomas de STT");
			*/
		}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void TS12605_SST_Sintomas_Consistencia(){
		SintomasSSTManager sstManagerPage = new SintomasSSTManager(driver);
		//this is How the page handles the selection
		sstManagerPage.selectToSeeByName("ABM de Síntomas STT");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagerPage.selectToSeeByName("All");
		//TODO: wrap symptoms here, and wrap symptoms in Manager
		//to be tested
		List<String> symptomsRegInSSTView = sstManagerPage.getSymptomsRegisterNumbers();
		
		//TODO: get the symptomsRegInAdmin
		HomeBase homePage = new HomeBase(driver);
		homePage.openAppsMenu();
		homePage.selectAppFromMenuByName("Consola FAN");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		//manager: https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd
		//TODO: compare both, to have, same quantity of elements, and elements themselves.
	}
}








