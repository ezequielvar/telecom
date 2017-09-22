package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.TechCareDiagnostic;
import Pages.setConexion;


public class TechnicalCareClienteDiagnostico extends TestBase  {
	String value;
	String gestion;
	private WebDriver driver;
 	
	@BeforeClass
	public void mainSteup() {
		this.driver = setConexion.setupPablo();	
		login(driver);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
	}
//	@AfterTest
	public void tearDown() {
		value = "UP/Down";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectpage("1");
		page.selectfile("1");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue1(value);
		value = "Down/Down";
		page.selectfile("1");
		page.selectvalues(value);
		page.validvalue1(value);
		value = "UP/UP";
		page.selectfile("2");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue1(value);
	driver.close();
	}
	
	@Test(groups = "fase1")
	public void TS6755_DiagnosticsFixedBroadbandUPUP() {
		value = "UP/UP";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectpage("1");
		page.selectfile("1");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue1(value);
		page.selectfile("2");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue2(value);
}
	
	@Test(groups = "fase1")
	public void TS6756_DiagnosticsFixedBroadbandUPDOWN() {
		value = "UP/Down";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectpage("1");
		page.selectfile("1");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue1(value);
		page.selectfile("2");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue2(value);
}
	@Test
	public void TS6757_DiagnosticsFixedBroadbandDOWNDOWN() {
		value = "Down/Down";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectpage("1");
		page.selectfile("1");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue1(value);
		page.selectfile("2");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue2(value);
}
	@Test(groups = "fase1")
	public void TS6759_DiagnosticsFixedBroadbandNOTSESION() {
		value = "Sin Sesión";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectpage("1");
		page.selectfile("1");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue1(value);
		page.selectfile("2");
		page.clearvalues();
		page.selectvalues(value);
		page.validvalue2(value);
}
	@Test(groups = "fase1")
	public void TS6410_DiagnosticsServiceIndifferentEnteringTechCarefrom360view() {
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectpage("2");
}
	@Test(groups = "fase1")
	//no terminado
	public void TS6411_DiagnosticsMobileTelephonyMobileServiceEnterDomicile() {
		gestion = "Asistencia Técnica";
		TechCareDiagnostic page = new TechCareDiagnostic(driver);
		page.selectpage("2");
		page.selectaccounttech();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")).click();
			}
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.SelectGestion(gestion);
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.SelectService();
	
	}
}
