package Tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.CasePage;
import Pages.CustomerCare;
import Pages.Login;
import Pages.customerInformation;
import Pages.setConexion;
public class CustomerCare360ViewInformationClient extends TestBase {



		
	private WebDriver driver;
	 	
	//@AfterClass
	public void tearDown() {
			driver.close();
	}
	
//	@AfterMethod
	public void alert (){
		driver.get("https://cs14.salesforce.com/console");
		try{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
		}catch(org.openqa.selenium.NoAlertPresentException e){}
	}

	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupEze();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}	
	@BeforeClass
	public void setUpTest() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.getCurrentUrl().toString().contains("https://crm--sit.cs14.my.salesforce.com/console")){
			driver.findElement(By.id("tsidLabel")).click();
			try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();}	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		CustomerCare page = new CustomerCare(driver);
		page.cerrarultimapestaña();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		
	}
	
	@Test
	public void TS7137_BusinessDataPanelQuickAccessButtonsAccount() {
		CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.elegircuenta("Andres Care");
		page.openleftpanel();		
		driver.findElements(By.className("ext-webkit.ext-chromehg"));
		driver.findElement(By.className("social"));
		
	}
	
	
		
	@Test
	public void TS7138_BusinessDataPanelPicklistCommercialDataAccount() {
		CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.elegircuenta("Andres Care");
		page.openleftpanel();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.className("account-select"));
		
	}
		
		
	@Test(groups= "Fase2")
	public void TS16056_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion_Funcionamiento_Boton_Sesion_Guiada() {
		CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.elegircuenta("Andres Care");
		page.openrightpanel();
		page.SelectGestion("Cambio de ciclo");
		try {Thread.sleep(30000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.ValidarCambioDeCiclo();
		
	}
		
		@Test(groups= "Fase2")
	public void TS16055_Sesion_Guiada_para_Cambios_de_Inicio_de_Ciclo_de_Facturacion__Boton_Sesion_Guiada() {
			CustomerCare page = new CustomerCare(driver);
			goToLeftPanel(driver, "Cuentas");
			page.elegircuenta("Andres Care");
			page.openrightpanel();
			page.ValidarBtnsGestion("Cambio de ciclo");
		}
		
		
		@Test(groups= "Fase2")
	public void TS15962_Sesion_Guiada_Para_Cambios_en_Condicion_Impositiva_Boton_de_sesion_guiada() {
			CustomerCare page = new CustomerCare(driver);
			goToLeftPanel(driver, "Cuentas");
			page.elegircuenta("Andres Care");
			page.openrightpanel();	
			page.ValidarBtnsGestion("Cambios de condición impositiva");
		}
			
		
		@Test(groups= "Fase2")
		//terminar
	public void TS16061_Line_Movements_Paso_0_Error_por_cliente_inactivo() {
			CustomerCare page = new CustomerCare(driver);
			goToLeftPanel(driver, "Cuentas");
			page.elegircuenta("Andres Care");
			page.openrightpanel();	
			page.SelectGestion("Cambio de ciclo");
			//page.validacion
			driver.switchTo().defaultContent();

		}
		
		
		@Test(groups= "Fase2")
		public void TS14567_Capacidades_de_Busqueda_Filtrar_Por_DNI() {
			CustomerCare page = new CustomerCare(driver);
			page.usarbuscadorsalesforce("30303030");
			//page.detectarframe();
			page.validarlabusqueda("Andres Care");
			driver.switchTo().defaultContent();

		}
		
		
		@Test(groups= "Fase2")
		public void TS14565_View_Capacidades_de_Busqueda_Visualizar_Filtro_Salesforce() {
			CustomerCare page = new CustomerCare(driver);
			page.validarbuscadorsalesforce();
			driver.switchTo().defaultContent();

		}
		
		

		@Test(groups= "Fase2")
		public void TS14570_Busqueda_de_Transacciones_Filtrar_Por_Numero_de_Caso() {
			CustomerCare page = new CustomerCare(driver);
			page.usarbuscadorsalesforce("00003035");
			//page.detectarframe();
			page.validarlabusqueda("00003035");
			driver.switchTo().defaultContent();

			
		}
		
		
		
		@Test(groups= "Fase2")
		public void TS12252_Billing_Group_User_Line_Movements_Paso_0_Error_por_cliente_inactivo() {
			CustomerCare page = new CustomerCare(driver);
			goToLeftPanel(driver, "Cuentas");
			page.editarcuenta("Fernando Care", "no", "inactive");
			page.elegircuenta("Fernando Care");
			page.SelectGestion("Movimientos de cuenta de facturaci");
			page.validarerrorpaso0();	
			driver.switchTo().defaultContent();
			page.cerrarultimapestaña();

		}
		
		
		
		@Test(groups= "Fase2")
		public void TS12251_Billing_Group_User_Line_Movements_Paso_0_Error_por_fraude_Cliente_inactivo() {
			CustomerCare page = new CustomerCare(driver);
			goToLeftPanel(driver, "Cuentas");
			page.editarcuenta("Fernando Care", "si", "inactive");
			page.elegircuenta("Fernando Care");
			page.SelectGestion("Movimientos de cuenta de facturaci");
			page.validarerrorpaso0();
			driver.switchTo().defaultContent();
			//page.cerrarultimapestaña();


		}
		@Test(groups= "Fase2")
		public void TS12262_Billing_Group_User_Line_Movements_Paso_1_Billing_Account_suspendida_por_fraude_No_se_visualiza() {
			CustomerCare page = new CustomerCare(driver);
			goToLeftPanel(driver, "Cuentas");
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			page.editarcuenta("Fernando Care", "no", "active");
			page.editarcuenta("Fernando Care Billing 1", "si", "active");
			page.editarcuenta("Fernando Care Billing 2", "no", "inactive");
			page.elegircuenta("Fernando Care");		
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();};
			page.SelectGestion("Movimientos de cuenta de facturacion");
			page.validarerrorpaso1("cuenta billing fraude no aparece");
			driver.switchTo().defaultContent();
			page.cerrarultimapestaña();


		}
		
		@Test(groups="Fase2")
		public void TS12261_Billing_Group_User_Line_Movements_Paso_1_Mover_Bundle_Se_mueven_todos_los_servicios() {
		CustomerCare page = new CustomerCare(driver);
		goToLeftPanel(driver, "Cuentas");
		page.editarcuenta("Fernando Care","no","active");
	//	page.editarcuenta("Fernando Care Billing 1", "no", "active");
	//  page.editarcuenta("Fernando Care Billing 2", "no", "active");
		page.elegircuenta("Fernando Care");
		page.SelectGestion("Movimientos de cuenta de facturaci");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();};
		page.serviciocambiadecuenta("Arnet 10 MB (Prueba)", "Fernando Care Billing 2");
		//page.SelectGestion("Movimientos de cuenta de facturacion");
		//page.validarerrorpaso1("servicio cambia de cuenta billing");

		
		}
		
		@Test(groups="Fase2")
		public void TS12244_Positive_Feedback_Suggestions_Generic_Interaction_No_Follow_up_Required_Creacion_de_los_Casos_Crear_Caso() {
		CustomerCare page = new CustomerCare(driver);
		CasePage page1 = new CasePage(driver);
		page.elegircuenta("Fernando Care");
		page.SelectGestion("sugerencia");
		page.crearsugerencia("Sugerencias", "Publicidad", "crear");
		page.cerrarultimapestaña();
		page.elegircaso();
		page1.validarcasocerrado("Sugerencias", "Publicidad");
		
		}
		
		@Test(groups="Fase2")
		public void TS12245_Positive_Feedback_Suggestions_Generic_Interaction_No_Follow_up_Required_Creacion_de_los_Casos_Crear_y_Cancelar_Gestion() {
		CustomerCare page = new CustomerCare(driver);
		CasePage page1 = new CasePage(driver);
		page.elegircuenta("Fernando Care");
		page.SelectGestion("sugerencia");
		page.crearsugerencia("Sugerencias", "Productos/Servicios", "cancel");
		page.cerrarultimapestaña();
		page.elegircaso();
		page1.validarcasocerrado("", "");
		
		
		}
		@Test(groups="Fase2")
		public void TS12302_Positive_Feedback_Suggestions_Generic_Interaction_No_Follow_up_Required_Detalle_de_Atributos_Feedback_Positivo_Generar_Gestion_Subcategoria_Atencion_Ejecutivos() {
		CustomerCare page = new CustomerCare(driver);
		CasePage page1 = new CasePage(driver);
		page.elegircuenta("Fernando Care");
		page.SelectGestion("sugerencia");
		page.crearsugerencia("Sugerencias", "Atención Ejecutivos", "crear");
		page.cerrarultimapestaña();
		page.elegircaso();
		page1.validarcasocerrado("Sugerencias", "Atención Ejecutivos");
		
		}
		
		
}
