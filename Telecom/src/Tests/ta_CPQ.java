package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import Pages.BasePage;
import Pages.Bill;
import Pages.BillSimulation;
import Pages.DeliveryMethod;
import Pages.LineAssignment;
import Pages.Login;
import Pages.Order;
import Pages.OrdersTab;
import Pages.PaymentMethod;
import Pages.SerialInput;
import Pages.Ta_CPQ;
import Pages.Ta_CPQ.RightPanel;
import Pages.Ta_CPQ_Validate;
import Pages.setConexion;

import org.testng.Assert;

public class ta_CPQ extends TestBase {
	
	private String province = "Buenos Aires";
	private String locality = "BALCARCE";
	private String street = "Av. Gonzalez Chavez";
	private String streetNumber = "485";
	private String postalCode = "7620";
	private String  typeZone = "Urbano";
	
	protected WebDriver driver;
	protected  WebDriverWait wait;

	@AfterClass
	public void tearDown() {
		//driver.close();
	}
	
	@BeforeClass
	public void Init() throws Exception
	{
		this.driver = setConexion.setupEze();
		 wait = new WebDriverWait(driver, 10);
		//try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		login(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	@BeforeMethod
	public void setup() throws Exception {		
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.findElement(By.id("tsidLabel")).getText().equals("Ventas")){
			driver.findElement(By.id("tsidLabel")).click();
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u41000000QWha\"]")).click();
		}
		OrdersTab page1 = new OrdersTab(driver);
		page1.goToOrdersTab();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page1.goToRecentOrder();
		Order page2 = new Order(driver);
		page2.goToTaCPQ();
		try {Thread.sleep(12000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@Test
	public void TS6816_checkSimCardAssignment() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.openArrow();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("1", page3.getSimCardValue()); 	
	}
	
	@Test
	public void TS6830_checkPaperCanIsPresent() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(page3.isPaperCanPresent());
	}
	
	@Test
	public void TS6829_checkPlanIsDeleted() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnDelete();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertFalse(page3.isPlanPresent());
	}
	
	@Test
	public void TS6831_checkPaperCanLabel() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("Quitar el producto del carrito", page3.getPaperCanLabel());
	}
	
	@Test
	public void TS6846_checkNoLineAvailableMessageAndCancelPlan() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("No se encontro linea disponible", page4.getNoLineMessage());
		page4.cancelLineAssignment();
	}
	
	@Test
	public void TS6847_checkPlanInformation() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.openArrow();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(page3.getPlanInformation());
	}

	
	@Test
	public void TS6864_wrongICCDFormat() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		page5.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BillSimulation page6 = new BillSimulation(driver);
		page6.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		PaymentMethod page7 = new PaymentMethod(driver);
		page7.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		SerialInput page8 = new SerialInput(driver);
		page8.setICCD("123456");
		page8.clickOnValidateICCD();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("Error de formato", page8.getValidationMessage("wrong"));
	}
	
	@Test
	public void TS6866_rightICCDFormat() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		/*
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		*/
		page3.deleteAddedProducts();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		page5.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BillSimulation page6 = new BillSimulation(driver);
		page6.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		PaymentMethod page7 = new PaymentMethod(driver);
		page7.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		SerialInput page8 = new SerialInput(driver);
		page8.setICCD("1234567891");
		page8.clickOnValidateICCD();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("El ICCID fue asignado", page8.getValidationMessage("right"));
	}
	
	@Test
	public void TS6860_checkAssignButtonIsAvailable() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		page5.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BillSimulation page6 = new BillSimulation(driver);
		page6.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		PaymentMethod page7 = new PaymentMethod(driver);
		page7.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		SerialInput page8 = new SerialInput(driver);
		page8.setICCD("1234567890");
		Assert.assertEquals("Asignar", page8.getAssignButtonLabel());
	}
	
	@Test
	public void TS6865_checkOrderStatusIsPending() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		page5.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BillSimulation page6 = new BillSimulation(driver);
		page6.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		PaymentMethod page7 = new PaymentMethod(driver);
		page7.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		SerialInput page8 = new SerialInput(driver);
		page8.setICCD("1234567890");
		page8.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Bill page9 = new Bill(driver);
		Assert.assertTrue(page9.checkOrderStatusDisplays());
		Assert.assertEquals("Estado de la orden : Pendiente de pago", page9.getOrderStatus());
	}
	
	@Test
	public void TS6832_deleteAllPlans() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.addPlan();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.addPlan();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.addPlan();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.addPlan();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnDelete();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnDelete();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnDelete();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnDelete();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("Carrito vac�o", page3.getEmptyCartMessage());
	}
	
	@Test
	public void TS7007_checkCancelOrder() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		page5.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BillSimulation page6 = new BillSimulation(driver);
		page6.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		PaymentMethod page7 = new PaymentMethod(driver);
		page7.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		SerialInput page8 = new SerialInput(driver);
		page8.setICCD("1234567890");
		page8.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Bill page9 = new Bill(driver);
		page9.cancelLineAssignment();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("Ventas", driver.findElement(By.id("tsidLabel")).getText());
	}
	
	@Test
	public void TS6890_checkCashAsValueForPaymentMethod() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		page5.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BillSimulation page6 = new BillSimulation(driver);
		page6.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		PaymentMethod page7 = new PaymentMethod(driver);
		Assert.assertTrue(page7.getPaymentMethod());
	}
	
	@Test
	public void TS6889_checkPaymentMethodIsPresent() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		page5.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		BillSimulation page6 = new BillSimulation(driver);
		page6.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		PaymentMethod page7 = new PaymentMethod(driver);
		Assert.assertTrue(page7.isPaymentMethodPresent());
	}
	
	@Test
	public void TS6895_checkDefaultValueForDeliveryMethod() {
		Ta_CPQ page3 = new Ta_CPQ(driver);
		try { for(WebElement e : driver.findElements(By.className("cpq-product-name"))) {
			page3.clickOnDelete();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		} } catch (java.lang.IndexOutOfBoundsException e) {}
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.clickOnSalesConfig();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		LineAssignment page4 = new LineAssignment(driver);
		page4.clickOnNext();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		DeliveryMethod page5 = new DeliveryMethod(driver);
		Assert.assertEquals("Presencial", page5.getCurrentValueForDeliveryMethod());
	}
	
	@Test
	public void TS6821_CRM_Fase_1_SalesCPQ_Alta_Linea_Buscar_Cliente_Buscar_por_Nombre_del_plan_V360() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		WebElement inputSearch = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
		inputSearch.sendKeys("Plan Prepago Nacional");
		
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		WebElement result = driver.findElement(By.xpath(".//p"));
		Assert.assertEquals(result.getText(), "Plan Prepago Nacional");
			
	}
	
	@Test
	public void TS6826_CRM_Fase_1_SalesCPQ_Alta_Linea_Carrito_Verificar_selecci�n_de_productos() {
		Ta_CPQ cart = new Ta_CPQ (driver);
		String productName ="productName"; //productName
		String productNameAdded = "true"; //productNameAdded
		
		cart.deleteAddedProducts();
		for (WebElement div: cart.getDivsProducts()) {
			if (!cart.requiresPrefactibility(div)) {
				WebElement addToCartButton = div.findElement(By.cssSelector(".slds-button.slds-button--neutral.add-button"));
				addToCartButton.click();
				try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
				productName = div.findElement(By.cssSelector(".slds-tile__title.slds-truncate.product-name")).getText();
				try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
				productNameAdded = driver.findElement(By.xpath(".//div[@class=\"cpq-item-no-children\"]/span")).getText();
				break;
			}
		}		
		Assert.assertEquals (productNameAdded, productName);
	}


	@Test
	public void TS6827_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Boton_Siguiente() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		cart.addAnyProductToCart();
		Assert.assertNotEquals(cart.getCartStatus(),"Incomplete");
	}
	
	@Test
	public void TS6835_CRM_Fase_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Lista_de_cuentas_del_cliente() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		Assert.assertTrue(cart.getAccountSelector() != null);
	}
	
	@Test
	public void TS6836_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Nueva_Cuenta() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		Assert.assertTrue(cart.getButtonNewAccount() != null);
	}

	@Test
	public void TS6844_CRM_Fase_1_SalesCPQ_Alta_Linea_Carrito_Verificar_el_mensaje_al_vaciar_el_carrito_XX() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		cart.addAnyProductToCart();
		cart.deleteAddedProducts();

		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement messageEmptyCart = driver.findElement(By.xpath(".//div[@class=\"slds-grid slds-grid--vertical-align-center slds-grid--align-center cpq-no-cart-items-msg\"]"));
		Assert.assertEquals(messageEmptyCart.getText().trim(), "Cart is empty.");
    
	}
	
	@Test
	public void TS6845_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Buscar_nuevo_lote_de_lineas_pre_asignadas() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> buttonsRightPanel = driver.findElements(By.xpath("//a[@ng-class=\"{'cpq-category-item-selected' : isSelectedCategory(category.catalogName), 'cat-icon': !isSelectedCategory(category.catalogName)}\"]"));
		WebElement buttonShowPlans = buttonsRightPanel.get(1);
		buttonShowPlans.click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		cart.addAnyProductToCart();
		cart.getButtonNext().click();
		
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		//Deber�a mostrarse una vista en la que se muestran los planes preasignados, pero hay cargado un bug dado que no se est� mostrando esa descripci�n de los planes.
	}
	
	@Test
	public void TS6849_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Modificar_linea_pre_asignada_ultimos_cuatro_digitos() {
		//Mismo bug que el TS6845. Se pueden tomar ese test  como base para automatizar �ste hasta el Step 4 inclusive.
	}
	
	@Test
	public void TS6850_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Presionar_el_boton_Buscar() {
		//�dem TS6849
	}
	
	@Test
	public void TS6852_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Visualizar_filtros_de_localidad_y_provincia_al_modificar_linea_XX(){
		//�dem TS6849		
	}
	
	@Test
	public void TS6855_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Visualizar_mensaje_y_opciones_de_lineas_no_disponibles() {
		//�dem TS6849
	}
	
	@Test
	public void TS6857_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Visualizar_una_descripcion_por_varios_productos_iguales() {
		//�dem TS6849
	}
	
	@Test
	public void TS6858_CRM_Fase_1_SalesCPQ_Alta_Linea_Asignar_SIMCARD_Visualizar_mensaje_al_asignar_un_ICCID_No_disponible(){
		
	}
	
	@Test
	public void TS6882_CRM_Fase_1_SalesCPQ_Alta_Linea_Costo_Operacion_Validar_formato_del_monto() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.selectFromRightPanel(RightPanel.DISPOSITIVOS);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement linkMore = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".product-link.slds-text-body--small.slds-float--right"))); 
		linkMore.click();
		
		WebElement waiter = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".slds-item--detail.slds-truncate")));
		List<WebElement> values = driver.findElements(By.cssSelector(".slds-item--detail.slds-truncate"));
		String[] precissionCounter = values.get(3).getText().split(",");
		
		Assert.assertEquals(precissionCounter[1].length(), 2);
	}
	
	@Test
	public void TS6883_CRM_Fase_1_SalesCPQ_Alta_Linea_Costo_Operacion_Verificar_el_detalle_de_los_impuestos_aplicados_a_la_venta() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.selectFromRightPanel(RightPanel.DISPOSITIVOS);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.addAnyProductToCart();
		cart.getButtonNext().click();
		
		WebElement waiter = wait.until(ExpectedConditions.elementToBeClickable(By.className("ng-binding")));
		BillSimulation bill = new BillSimulation (driver);
		//presiono Siguiente 3 veces para llegar al paso "Simulaci�n de Factura"
		for (int i=0; i<2; i++) {
			bill.clickOnNext();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		}
		
		//verificar impuestos
		
	}
	
	/*
	 * TODO: el assert deber�a verificar que el dropdown con id "DeliveryMethod" ofrezca varios m�todos de entrega.
	 * Actualmente el bot�n est� bloqueado, y no se puede ver qu� opciones contiene.
	 * */
	@Test
	public void TS6885_CRM_Fase_1_SalesCPQ_Alta_Linea_Costo_Operacion_Verificar_opciones_del_carrito_Boton_Siguiente() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.selectFromRightPanel(RightPanel.DISPOSITIVOS);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.addAnyProductToCart();
		cart.getButtonNext().click();
		
		WebElement waiter = wait.until(ExpectedConditions.elementToBeClickable(By.className("ng-binding")));
		BillSimulation bill = new BillSimulation (driver);
		//presiono Siguiente 1 vezpara llegar al paso "Modo de Entrega"
		bill.clickOnNext();
		
		List<WebElement> inputDeliveryMethod = driver.findElements(By.id("DeliveryMethod"));
		Assert.assertTrue(inputDeliveryMethod.size() > 0);
	}
	
	@Test
	public void TS6887_CRM_Fase_1_SalesCPQ_Alta_Linea_Costo_Operacion_Visualizar_costo_cero_en_modo_de_entrega() {
		
	}
	
	@Test
	public void TS6893_CRM_Fase_1_SalesCPQ_Alta_Linea_Modo_de_Entrega_Seleccionar_modo_de_entrega_presencial_Producto_Tangible () {
		Ta_CPQ cart = new Ta_CPQ(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.selectFromRightPanel(RightPanel.DISPOSITIVOS);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.addAnyProductToCart();
		cart.getButtonNext().click();
		
		WebElement waiter = wait.until(ExpectedConditions.elementToBeClickable(By.className("ng-binding")));
		BillSimulation bill = new BillSimulation (driver);
		//presiono Siguiente 1 vezpara llegar al paso "Modo de Entrega"
		bill.clickOnNext();
		
		WebElement selectDeliveryMethod = driver.findElement(By.id("DeliveryMethod"));
		Select deliveryMethod = new Select(selectDeliveryMethod);
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<String> optionsDeliveryMethod = new ArrayList<String>();
		for (WebElement option: deliveryMethod.getOptions()) {
			optionsDeliveryMethod.add(option.getText());
		}
		
		Assert.assertTrue(optionsDeliveryMethod.contains("Presencial"));
	}
	
	@Test//(groups = {"Fase2"})
	public void TS11950_CRM_Fase_2_SalesCPQ_Alta_Linea_Nueva_Venta_Verificar_campo_desplegable_con_cuentas_activas() {
		TS6835_CRM_Fase_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Lista_de_cuentas_del_cliente();
	}
	
	@Test //(groups = {"Fase2"})
	public void TS11951_CRM_Fase_2_SalesCPQ_Alta_Linea_Nueva_Venta_Verificar_que_se_habilite_la_opcion_de_creacion_de_cuenta_nueva() {
		TS6836_CRM_Fase_1_SalesCPQ_Alta_Linea_Configurar_Nueva_Linea_Nueva_Cuenta();
	}
	
	@Test
	public void TS15366_CRM_Fase_2_SalesCPQ_Nueva_Venta_Orden_Venta_Verficar_ciclos_de_facturacion_disponibles(){
		/*Se verifica que el sistema muestra disponibles los ciclos de facturacion 1, 7, 14 y 21*
		 * 
		 */
		Ta_CPQ cart = new Ta_CPQ(driver);
		cart.deleteAddedProducts();
		cart.addAnyProductToCart();	
		
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.getButtonNext().click();
		
		LineAssignment lineAssignment = new LineAssignment (driver);
		lineAssignment.clickOnNext();
		BillSimulation billSimulation = new BillSimulation (driver);
		billSimulation.clickOnNext();
		DeliveryMethod deliveryMethod = new DeliveryMethod (driver);
		
		Assert.assertTrue(deliveryMethod.getBillingCycleOptions().contains("1"));
		Assert.assertTrue(deliveryMethod.getBillingCycleOptions().contains("7"));
		Assert.assertTrue(deliveryMethod.getBillingCycleOptions().contains("14"));
		Assert.assertTrue(deliveryMethod.getBillingCycleOptions().contains("21"));
	}
	
	@Test
	public void TS15365_CRM_Fase_2_SalesCPQ_Nueva_Venta_Orden_Venta_Verficar_que_se_puede_modificar_el_ciclo_de_facturacion() {
		/*Se verifica que el sistema permite modificar el ciclo de facturacion*/
		
		Ta_CPQ cart = new Ta_CPQ(driver);
		cart.deleteAddedProducts();
		cart.addAnyProductToCart();	
		
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cart.getButtonNext().click();
		
		LineAssignment lineAssignment = new LineAssignment (driver);
		lineAssignment.clickOnNext();
		BillSimulation billSimulation = new BillSimulation (driver);
		billSimulation.clickOnNext();
		DeliveryMethod deliveryMethod = new DeliveryMethod (driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Select billingCycleSelect = new Select (deliveryMethod.getBillingCycle());
		billingCycleSelect.selectByValue("7");
		Assert.assertEquals(billingCycleSelect.getFirstSelectedOption().getText(), "7");
	}
	
	
	/**
	 * Se verifica que, cuando se selecciona un producto para linea movil 
	 * del Bundle Convergente, se agrega a la vista previa del carrito 
	 * y se habilita el boton Siguiente
	 */
	@Test(groups = {"Fase2"})
	public void TS15424_CRM_Fase_2_SalesCPQ_Nueva_Venta_Seleccion_Dispositivos_Verificar_boton_siguiente_habilitado() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		cart.deleteAddedProducts();
		cart.selectFromRightPanel(RightPanel.BUNDLES);
		cart.addAnyProductToCartThatNeedsPrefactibility();
		
		Assert.assertNotEquals(cart.getCartStatus(),"Incomplete");
	}
	
	/**
	 * Se verifica que, cuando no se selecciona un producto para linea movil del 
	 * Bundle Convergente, no se agrega a la vista previa del carrito, no se encuentra habilitado el boton Siguiente
	 */
	@Test(groups = {"Fase2"})
	public void TS15423_CRM_Fase_2_SalesCPQ_Nueva_Venta_Seleccion_Dispositivos_Verificar_boton_siguiente_inhabilitado() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		cart.deleteAddedProducts();
		cart.addAnyProductToCart();
		Assert.assertEquals(cart.getCartStatus(), "Incomplete");
		Assert.assertFalse(cart.getButtonNext().isEnabled());
	}
	
	/**
	 * Se visualiza que el producto movil se incorpora en forma automatica 
	 * dentro de la familia Dispositivos cuando se agrega a la vista previa del carrito
	 */
	@Test(groups = {"Fase2"})
	public void TS15422_CRM_Fase_2_SalesCPQ_Nueva_Venta_Seleccion_Dispositivos_Verificar_producto_incorporado_Autom_Familia_Dispositivos() {
		Ta_CPQ cart = new Ta_CPQ(driver);
		cart.deleteAddedProducts();
		cart.selectFromRightPanel(RightPanel.DISPOSITIVOS);
		cart.addAnyProductToCart();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		
		WebElement leftProductDiv = cart.getAddableDivProduct(1);
		leftProductDiv = leftProductDiv.findElement(By.cssSelector(".slds-tile__title.slds-truncate.product-name"));
		String leftProductName = leftProductDiv.getText().trim();
		
		Assert.assertTrue(cart.getAddedProducts().contains(leftProductName));
	}
 	
	
}
	
	

