package Tests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.Accounts;
import Pages.HomeBase;
import Pages.setConexion;

public class TechnicalCareCSRAutogestion extends TestBase {
	private WebDriver driver;
	private String cuentaNombre;
	
	@BeforeClass(groups = "Fase3") 
	public void init() throws Exception
	{
		this.driver = setConexion.setupPablo();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		HomeBase homePage = new HomeBase(driver);
	     if(driver.findElement(By.id("tsidLabel")).getText().equals("Consola FAN")) {
	    	 homePage.switchAppsMenu();
	    	 try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    	 homePage.selectAppFromMenuByName("Ventas");
	    	 try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}    
	     }
	     homePage.switchAppsMenu();
	     try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	     homePage.selectAppFromMenuByName("Consola FAN");
	     try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}            
	     goToLeftPanel2(driver, "Cuentas");
	     try {Thread.sleep(12000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	     
	}
	
	@BeforeMethod(groups = "Fase3") 
	public void setUp() throws Exception {
	     Accounts accountPage = new Accounts(driver);
	     driver.switchTo().defaultContent();
	     accountPage.accountSelect("Vista Tech");
	     try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	     WebElement account = driver.findElement(By.cssSelector(".x-grid3-cell-inner.x-grid3-col-ACCOUNT_NAME"));
		 cuentaNombre = account.findElement(By.tagName("span")).getText();
		 account.findElement(By.tagName("span")).click();
		 try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}  
		
	}
	
	@AfterMethod(groups = "Fase3") 
	 public void afterMethod() {
		driver.switchTo().defaultContent();
		List<WebElement> ctas = driver.findElement(By.cssSelector(".x-tab-strip.x-tab-strip-top")).findElements(By.tagName("li"));
		ctas.remove(0);
		for (WebElement cta : ctas) {
			if (cta.findElement(By.className("tabText")).getText().equals(cuentaNombre)) {
				Actions action = new Actions(driver);
				action.moveToElement(cta);
				action.moveToElement(cta.findElement(By.className("x-tab-strip-close"))).click().build().perform();
				break;
			}
				
		}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		  }
	
	@AfterClass(groups = "Fase3")
	public void tearDown2() {
		driver.switchTo().defaultContent();
		try{ for(WebElement e : driver.findElements(By.className("x-tab-strip-close"))) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);
		} } catch (org.openqa.selenium.StaleElementReferenceException e) {}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.findElement(By.id("tsidButton")).click();
		List<WebElement> options = driver.findElement(By.id("tsid-menuItems")).findElements(By.tagName("a"));

		for (WebElement option : options) {
			if(option.getText().toLowerCase().equals("Ventas".toLowerCase())){
				option.click();
				break;
			}
		}
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.close();
	}
	
	@Test(groups = "Fase3")
	public void TS51149_Autogestion_Verificacion_De_Que_Exista_La_Opcion_De_Autogestion() {
		 driver.switchTo().defaultContent();
		 Accounts accountPage = new Accounts(driver);
		 driver.switchTo().frame(accountPage.getFrameForElement(driver, By.className("actions-content")));
		 try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}   
		 driver.findElement(By.cssSelector(".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")).clear();
		 driver.findElement(By.cssSelector(".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")).sendKeys("autogesti");
		List<WebElement> butons = driver.findElements(By.xpath("//*[text() = 'Diagnóstico de Autogestión']"));
		assertTrue(butons.get(0).isDisplayed());
		driver.switchTo().defaultContent();
	}
	
	@Test(groups = "Fase3")
	public void TS51150_Autogestion_Verificacion_De_La_Existencia_Interfaz_De_Autogestion() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		assertTrue(driver.findElement(By.id("SelfManagementStep_nextBtn")).isDisplayed());
	}
	
	@Test(groups = "Fase3")
	public void TS51151_Autogestion_Verificacion_Del_Canal() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		assertTrue(driver.findElement(By.cssSelector(".slds-form-element__label.ng-binding")).getText().toLowerCase().equals("canal"));
	}
	
	@Test(groups = "Fase3")
	public void TS51152_Autogestion_Verificacion_Del_Servicio() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		assertTrue(driver.findElements(By.cssSelector(".slds-form-element__label.ng-binding")).get(1).getText().toLowerCase().equals("servicio"));
	}
	
	@Test(groups = "Fase3")
	public void TS51154_Autogestion_Verificacion_Del_Servicio_Asterisco_111() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*111");
	    assertTrue(listSelect.getFirstSelectedOption().getText().contains("*111"));
	}
	
	@Test(groups = "Fase3")
	public void TS51155_Autogestion_Verificacion_Del_Servicio_Asterisco_878() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*878 (Saldo Virtual)");
	    assertTrue(listSelect.getFirstSelectedOption().getText().contains("*878"));
	}
	
	@Test(groups = "Fase3")
	public void TS51156_Autogestion_Verificacion_Del_Servicio_Asterisco_150() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*150 (saldo)");
	    assertTrue(listSelect.getFirstSelectedOption().getText().contains("*150"));
	}
	
	
	@Test(groups = "Fase3")
	public void TS51172_Autogestion_Asterisco_Verificacion_De_Opciones_De_Inconvenientes() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*150 (saldo)");
		assertTrue(driver.findElements(By.cssSelector(".slds-form-element__label.ng-binding")).get(2).getText().toLowerCase().equals("motivo del inconveniente"));
		listSelect = new Select(driver.findElement(By.id("MotiveSelection")));
		listSelect.selectByIndex(1);
		assertTrue(!listSelect.getFirstSelectedOption().getText().isEmpty());
	}
	
	@Test(groups = "Fase3")
	public void TS51191_Autogestion_Verificacion_De_La_Seleccion_Canal_Asterisco_Y_Servicio_288() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Otros Asteriscos");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*288/*788 (788 asistencia en ruta)");
	    assertTrue(listSelect.getFirstSelectedOption().getText().contains("*288"));
	}
	
	@Test(groups = "Fase3")
	public void TS51173_Autogestion_Verificacion_Lista_De_Inconvenientes_Asterisco_111() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		String[] todos = {"otros","la caracteristica no existe","la linea esta muda","llamada fallo","tono ocupado","la llamada se cae","informa sistema fuera de servicio","informacion incorrecta","inconv con derivación a representante"};
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*111");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    listSelect = new Select(driver.findElement(By.id("MotiveSelection")));
	    List<WebElement> motivos = listSelect.getOptions();
	    List<String> motNoms = new ArrayList<String>();
	    for (WebElement UnMot : motivos) {
	    	motNoms.add(UnMot.getText().toLowerCase());
	    }
	    for (String uno : todos) {
			assertTrue(motNoms.contains(uno));
		}

	}
	
	@Test(groups = "Fase3")
	public void TS51174_Autogestion_Verificacion_Lista_De_Inconvenientes_Asterisco_878() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		String[] todos = {"otros ( para completar campo)","la caracteristica no existe","la linea esta muda","llamada fallo","tono ocupado","la llamada se cae","informa sistema fuera de servicio","informacion incorrecta"};
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*878 (Saldo Virtual)");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    listSelect = new Select(driver.findElement(By.id("MotiveSelection")));
	    List<WebElement> motivos = listSelect.getOptions();
	    assertTrue(verificarContenidoLista(todos,motivos));
	}
	
	@Test(groups = "Fase3")
	public void TS51175_Autogestion_Verificacion_Lista_De_Inconvenientes_Asterisco_150() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		String[] todos = {"otros ( para completar campo)","la caracteristica no existe","la linea esta muda","llamada fallo","tono ocupado","la llamada se cae","informa sistema fuera de servicio","informacion incorrecta"};
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*150 (saldo)");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    listSelect = new Select(driver.findElement(By.id("MotiveSelection")));
	    List<WebElement> motivos = listSelect.getOptions();
	    assertTrue(verificarContenidoLista(todos,motivos));

	}
	
	@Test(groups = "Fase3")
	public void TS51190_Autogestion_Verificacion_Lista_De_Inconvenientes_910() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		String[] todos = {"otros ( para completar campo)","la caracteristica no existe","la linea esta muda","llamada fallo","tono ocupado","la llamada se cae","informa sistema fuera de servicio","informacion incorrecta","inconv con derivación a representante"};
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Asteriscos TP");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("*910");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    listSelect = new Select(driver.findElement(By.id("MotiveSelection")));
	    List<WebElement> motivos = listSelect.getOptions();
	    List<String> motNoms = new ArrayList<String>();
	    for (WebElement UnMot : motivos) {
	    	motNoms.add(UnMot.getText().toLowerCase());
	    }
	    for (String uno : todos) {
			assertTrue(motNoms.contains(uno));
		}

	}
	
	@Test(groups = "Fase3")
	public void TS51224_Autogestion_Verificacion_De_La_Seleccion_Canal_Nros_De_Emergencia_Y_Servicio_100() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Nros. emergencia");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("100");
	    assertTrue(listSelect.getFirstSelectedOption().getText().contains("100"));
	}
	
	@Test(groups = "Fase3")
	public void TS51226_Autogestion_Verificacion_De_La_Seleccion_Canal_Nros_De_Emergencia_Y_Servicio_101() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("Nros. emergencia");
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("101");
	    assertTrue(listSelect.getFirstSelectedOption().getText().contains("101"));
	}
	
	@Test(groups = "Fase3")
	public void TS51286_Autogestion_APP_Mi_Linea_Visualizacion_De_Lista_De_Inconvenientes() {
		Accounts accountPage = new Accounts(driver);
		accountPage.findAndClickButton("autogestión");
		String[] todos = {"otros","inconvenientes con informa pago","informacion incorrecta","información incompleta","inconveniente con compra de packs","abre aplicacion y cierra automaticamente"};
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(accountPage.getFrameForElement(driver, By.id("SelfManagementStep_nextBtn")));
		Select listSelect = new Select(driver.findElement(By.id("ChannelSelection")));
		listSelect.selectByVisibleText("APP");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		listSelect = new Select(driver.findElement(By.id("ServiceSelection")));
		listSelect.selectByVisibleText("Mi Linea");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	    listSelect = new Select(driver.findElement(By.id("MotiveSelection")));
	    List<WebElement> motivos = listSelect.getOptions();
	    List<String> motNoms = new ArrayList<String>();
	    for (WebElement UnMot : motivos) {
	    	motNoms.add(UnMot.getText().toLowerCase());
	    }
	    for (String uno : todos) {
			assertTrue(motNoms.contains(uno));
		}

	}
}
