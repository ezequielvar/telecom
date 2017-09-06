package Tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.ContactMotivesManager;
import Pages.NewContactMotive;
import Pages.setConexion;

public class ABMdeMotivoAdmin extends TestBase {
	
	private WebDriver driver;
	
	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupPablo();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		//TODO: add how to get to ABM de Motivo
		String motivesAbmURL = "https://cs14.salesforce.com/a41?fcf=00Bc0000001LRma&rolodexIndex=-1&page=1";
		if (!driver.getCurrentUrl().toString().equals(motivesAbmURL)){
			driver.get(motivesAbmURL);
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		}
	}
	
	@Test
	public void TS12587_Agregar_nuevo_motivo() {
		//String newMotiveURL = "https://cs14.salesforce.com/a41/e?common.udd.actions.ActionsUtilORIG_URI=%2Fa41c00000023SvT%2Fe&retURL=%2Fa41c0000002I61F&_CONFIRMATIONTOKEN=VmpFPSxNakF4Tnkwd09TMHdPVlF4Tnpvd016b3hPUzQ0T1ROYSxHNENsbmpDWlJxcGI5Rld2eXJ2cWZvLFpEWXlOVFV6";
		//driver.get(newMotiveURL);
		driver.findElement(By.name("new")).click();
		NewContactMotive newCMPage = new NewContactMotive(driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String motiveName = "motivo Nuevo TS12587";
		String descripcion = "Descripcion para el test.";
		newCMPage.getContactMotiveName().sendKeys(motiveName);
		newCMPage.getDescripcion().sendKeys(descripcion);
		newCMPage.getActivoCheck().click();
		newCMPage.getServicio().sendKeys("Llamadas ilimitadas");
		newCMPage.save();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals(driver.findElement(By.id("Name_ileinner")).getText(), motiveName); //checks name input with current.
		Assert.assertEquals(driver.findElement(By.id("00Nc0000001pWdl_ileinner")).getText(), descripcion); //checks descripcion input with current.
		/*
		driver.findElement(By.name("del")).click(); //deletes motive.
		Alert alert = driver.switchTo().alert();
		alert.accept();
		*/
		driver.findElement(By.className("ptBreadcrumb")).findElement(By.tagName("a")).click(); //goes back to main page for ABM.
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		ContactMotivesManager cMMPage = new ContactMotivesManager(driver);
		//index 4 is the motiveName
		Assert.assertEquals(cMMPage.getMotiveByName(motiveName).findElements(By.className("x-grid3-col")).get(4).getText(), motiveName);
		cMMPage.deleteMotiveByName(motiveName);

	}
	



}
