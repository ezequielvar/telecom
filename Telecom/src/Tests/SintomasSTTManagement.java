package Tests;

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
		this.driver = setConexion.setupEze();
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
			HomeBase homePage = new HomeBase(driver);
			homePage.openAppsMenu();
			homePage.selectAppFromMenuByName("Ventas");
			homePage.selectMainTabByName("Síntomas de STT");
		}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@AfterClass
	public void tearDown() {
		//driver.close();
	}
	
	@Test
	public void TS12605_SST_Sintomas_Consistencia(){
		SintomasSSTManager sstManagePage = new SintomasSSTManager(driver);
		//this is How the page handles the selection
		sstManagePage.selectToSeeByName("ABM de Síntomas STT");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		sstManagePage.selectToSeeByName("All");
		//TODO: wrap symptoms here, and wrap symptoms in Manager
		//manager: https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd
		//TODO: compare both, to have, same quantity of elements, and elements themselves.
	}
}
