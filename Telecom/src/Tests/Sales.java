package Tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Order;
import Pages.OrdersTab;
import Pages.SalesBase;
import Pages.setConexion;


public class Sales extends TestBase {
	protected WebDriver driver;
	protected  WebDriverWait wait;
	
	//@AfterClass
	public void tearDown() {
		//driver.close();
	}
	
	@BeforeClass
	public void Init() throws Exception
	{
		this.driver = setConexion.setupEze();
		 wait = new WebDriverWait(driver, 10);
		//try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		loginAndres(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@BeforeMethod
	public void setup() throws Exception {		
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.findElement(By.id("tsidLabel")).getText().equals("Ventas")){
			driver.findElement(By.id("tsidLabel")).click();
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u41000000QWha\"]")).click();
		}
		
		driver.findElement(By.xpath("//a[@href=\'https://crm--SIT--c.cs14.visual.force.com/apex/taClientSearch']")).click();

	}
	
	
	@Test
	public void TS14278_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_ICCID(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14277_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Medio_de_Pago(){
		
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14275_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Modo_de_Entrega(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14272_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Nueva_Venta(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14274_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Seleccion_de_Linea(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14273_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Seleccionar_un_producto(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14276_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Simulacion_de_Factura(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14279_CRM_Fase_2_SalesCPQ_Ventas_NumeroOrden_Verificar_Orden_de_Venta_Abierta_Simulacion_de_Factura_Final(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14270_CRM_Fase_2_SalesCPQ_Ventas_NumeroOrden_Visualizar_Orden_de_Venta_Abierta_ICCID(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14269_Ventas_NumeroOrden_Visualizar_Orden_de_Venta_Abierta_Medio_de_Pago(){
		Assert.assertTrue(false);
		
	}
	
	@Test
	public void TS14267_Ventas_NumeroOrden_Visualizar_Orden_de_Venta_Abierta_Modo_de_Entrega(){
		Assert.assertTrue(false);

	}
	
	@Test
	public void TS14264_Ventas_NumeroOrden_Visualizar_Orden_de_Venta_Abierta_Nueva_Venta(){
		Assert.assertTrue(false);

	}
	
	@Test
	public void TS14266_Ventas_NumeroOrden_Visualizar_Orden_de_Venta_Abierta_Seleccion_de_Linea(){
		Assert.assertTrue(false);

	}
	
	@Test
	public void TS14265_Ventas_NumeroOrden_Visualizar_Orden_de_Venta_Abierta_Seleccionar_un_producto(){
		Assert.assertTrue(false);

	}
	
	@Test
	public void TS14268_Ventas_NumeroOrden_Visualizar_Orden_de_Venta_Abierta_Simulacion_de_Factura(){
		
		Assert.assertTrue(false);
	}
	
	//************FASE 3*********************
	@Test
	public void TS38688_Alta_Contacto_Busqueda_Verificar_resultado_busqueda_contacto_Sin_cuenta_asociada(){
		
	
	}
	@Test
	public void TS38689_Alta_Contacto_Busqueda_Verificar_resultado_busqueda_cliente_activo_inactivo(){
		
		
	}
	@Test
	public void TS38722_Ventas_General_Verificar_que_se_elimine_el_boton_Crear_Cuenta(){
		
			
	}
	
	@Test
	public void TS38760_Perfiles_Verificar_creacion_de_perfil_Canal_Tefonico(){
		
			
	}
	@Test
	public void TS38761_Perfiles_Verificar_creacion_de_perfil_Oficina_Comercial(){
		
			
	}
	@Test
	public void TS38762_Perfiles_Verificar_creacion_de_perfil_Oficina_Agente(){
		
			
	}
	@Test
	public void TS38763_Perfiles_Verificar_creacion_de_perfil_Oficina_Logistica(){
		
			
	}
	@Test
	public void TS38790_Alta_Cuenta_Busqueda_Verificar_nombre_de_la_busqueda(){
		
			
	}
	@Test
	public void TS38791_Alta_Cuenta_Busqueda_Verificar_secciones_de_la_busqueda_de_cliente(){
		
			
	}
	@Test
	public void TS38792_Alta_Cuenta_Busqueda_Verificar_campos_de_la_busqueda_avanzada(){
		SalesBase SB = new SalesBase(driver);
		SB.BusquedaAvanzada();
		SB.validarcamposbusqueda();
			
	}
	@Test
	public void TS38793_Alta_Cuenta_Busqueda_Verificar_Nombre_y_Apellido_separado(){
		SalesBase SB = new SalesBase(driver);
		SB.BusquedaAvanzada();
		SB.busqueda("pepe","", "", "", "");
		SB.validarespacio();
		
			
	}
	@Test
	public void TS38802_Ventas_General_Verificar_no_visualizacion_de_boton_Crear_Cuenta(){
		SalesBase SB = new SalesBase(driver);
		SB.buscarcuenta();
		SB.entrarcatalogo();
		
			
	}
	@Test
	public void TS38803_Ventas_General_Verificar_visualizacion_de_boton_Continura(){
		
			
	}
	@Test
	public void TS39554_Ventas_General_Verificar_que_se_muestre_el_estado_de_una_OV(){
		
			
	}
	
	@Test
	public void TS39641_Alta_Contacto_Busqueda_Verificar_que_se_recuerden_los_datos_de_busqueda(){
		
			
	}
}
