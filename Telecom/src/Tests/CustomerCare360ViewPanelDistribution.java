package Tests;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CustomerCare;
import Pages.Login;
import Pages.TechCareDiagnostic;
import Pages.setConexion;

public class CustomerCare360ViewPanelDistribution extends TestBase {

	private WebDriver driver;


//@AfterTest
public void tearDown() {
		driver.close();
}
@AfterMethod
public void alert (){
	driver.get("https://cs14.salesforce.com/console");
	try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	try{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}catch(org.openqa.selenium.NoAlertPresentException e){}
}

@BeforeClass
public void init() throws Exception
{

	this.driver = setConexion.setupEze();

	this.driver = setConexion.setupLeo();

	try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	login(driver);
	try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
}

@BeforeClass
public void setUpTest() {
	driver.switchTo().defaultContent();
	try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	if (!driver.getCurrentUrl().toString().contains("https://cs14.salesforce.com/console")){
		driver.findElement(By.id("tsidLabel")).click();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
	}
		
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	List<WebElement> mainTabs = driver.findElements(By.className("x-tab-strip-close"));
	for (WebElement e : mainTabs) {
	try {((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);} catch (org.openqa.selenium.StaleElementReferenceException b) {}
	}
	List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
	goToLeftPanel(driver, "Cuentas");
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	WebElement frame0 = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(frame0);
	waitFor(driver, (By.name("fcf")));	
	Select field = new Select(driver.findElement(By.name("fcf")));
	field.selectByVisibleText("Vista Care");
	waitFor(driver, (By.xpath("//*[text() = 'Andres Care']")));	
	driver.findElement(By.xpath("//*[text() ='Andres Care']")).click();;
	List<WebElement> accounts = driver.findElements(By.xpath("//*[text() ='Andres Care']"));
	accounts.get(0).click();
	
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

	driver.switchTo().defaultContent();
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
}

//@BeforeMethod
public void setUpTest2() {
	try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	try {	
		String a = driver.findElement(By.id("tsidLabel")).getText();
		driver.findElement(By.id("tsidLabel")).click();
		System.out.println(a);
		if(a.equals("Ventas"))
		{
			System.out.println("True");
			driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
		}else
		{
			System.out.println("False");
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u41000000QWha\"]")).click();
			try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("tsidLabel")).click();
			driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
		}
	}
	catch (NoSuchElementException NoSuchElemException){
		System.out.println("ErrorTime");
		try {Thread.sleep(12000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	List<WebElement> mainTabs = driver.findElements(By.className("x-tab-strip-close"));
	for (WebElement e : mainTabs) {
	try {((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);} catch (org.openqa.selenium.StaleElementReferenceException b) {}
	}
	List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
	goToLeftPanel(driver, "Cuentas");
	WebElement frame0 = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(frame0);
	waitFor(driver, (By.name("fcf")));	
	Select field = new Select(driver.findElement(By.name("fcf")));
	field.selectByVisibleText("Todas las cuentas");
	waitFor(driver, (By.xpath("//*[text() = 'Adrian Tech']")));	
	List<WebElement> accounts = driver.findElements(By.xpath("//*[text() ='Andres Care']"));
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	accounts.get(0).click();
	driver.switchTo().defaultContent();
}	
		
	@Test
	public void TS7059_Verificar_Visualizar_Panel_Promociones() {		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			}		
		
		driver.switchTo().frame(frame1.get(4));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.cssSelector(".via-slds-story-cards--header.spacer.acct-spacer"));
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void TS7058_Visualizar_Panel_Servicios_Activos() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
	
		driver.findElement(By.xpath("//*[text() ='Servicios']")).click();
		driver.switchTo().frame(frame1.get(2));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	

		driver.findElement(By.cssSelector(".console-card.active"));
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void TS7200_VerifyDisplayLogo() {	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		driver.findElement(By.className("sd_custom_logo"));
	
	}
	
	@Test
	public void TS7060_Visualizar_Panel_Alertas() {	

		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
	
		driver.findElement(By.xpath("//*[text() ='Servicios']")).click();
		driver.switchTo().frame(frame1.get(2));
		driver.findElement(By.className("ta-alertMessage-content"));	
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void TS7201_VerifyDisplayfilterAccounts() {	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			}
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		
		driver.findElement(By.className("account-select-table")).click();	
	
		driver.switchTo().defaultContent();
	}
	@Test
	public void TS7066_VerifyDisplayPanelAccountsClient() {	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			}
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		driver.findElement(By.className("account-select-container")).click();
		driver.switchTo().defaultContent();
	}
	@Test
	public void TS7054_VerifyDisplayPanelBusinessData() {	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).click();
			}
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		driver.findElement(By.className("profile-box"));	
		driver.switchTo().defaultContent();
	}
	@Test
	public void TS7061_Visualizar_Panel_Sesiones_Guiadas() {
		CustomerCare page = new CustomerCare(driver);
		page.openrightpanel();
		page.verificaciondebotonesdegestion();
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void TS7062_Visualizar_Panel_Gestiones_abandonadas() {	
		CustomerCare page = new CustomerCare(driver);
		page.openrightpanel();
		page.GestionAbandonadapanel();
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void TS7063_Contraccion_Paneles() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.panelizq("todosOFF");
		page.verificacrhideleft("todosOFF");
		page.closeleftpanel();
		page.openrightpanel();
		page.panelder("todos");
		page.verificarhideright("todosOFF");
		page.closerightpanel();
		driver.switchTo().defaultContent();
	}
	@Test
	public void TS7064_Contraccion_Panel_Datos_Comerciales() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.verificarnohidedatoscomerciales();
		driver.switchTo().defaultContent();
	}
	@Test
	public void TS7065_Expansion_Paneles() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.panelizq("todosON");
		page.verificacrhideleft("todosON");
		page.closeleftpanel();
		page.openrightpanel();
		page.panelder("todos");
		page.verificarhideright("todosON");
		page.closerightpanel();
		driver.switchTo().defaultContent();
	}	
//360 View Customer Key Metrics
	@Test
	public void TS7074_Key_Metrics_Visualizar_Picklist() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.verificarpicklist();
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void TS7075_Key_Metrics_Funcionamiento_Picklist() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.funcionamientopicklist();
		driver.switchTo().defaultContent();

	}
	@Test
	public void TS7076_Key_Metrics_Visualizar_boton_Añadir_Nuevo_Intereses_personales() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.panelizq("perfil");
		page.validarbtnsperfil("Intereses Personales");
		driver.switchTo().defaultContent();
}
	@Test
	public void TS7078_Key_Metrics_Visualizar_boton_Añadir_Nuevo_Criterios_de_compra() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.panelizq("perfil");
		page.validarbtnsperfil("Criterios de compra");
		driver.switchTo().defaultContent();
}

	@Test
	public void TS7079_Key_Metrics_Visualizar_boton_Añadir_Nuevo_Familia() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.panelizq("perfil");
		page.validarbtnsperfil("Familia");
}
	@Test
	public void TS7080_Key_Metrics_Visualizar_boton_Añadir_Nuevo_Productos_de_interes() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.panelizq("perfil");
		page.validarbtnsperfil("Productos de interes");
}
	@Test
	public void TS7081_Key_Metrics_Visualizar_boton_Añadir_Nuevo_Preocupaciones() {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.panelizq("perfil");
		page.validarbtnsperfil("Preocupaciones");
}
	@Test
	public void TS7082() throws ParseException {
		CustomerCare page = new CustomerCare(driver);
		page.openleftpanel();
		page.comparaciondefechas();
	}
	
	
}