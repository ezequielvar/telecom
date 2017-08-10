package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
import Pages.setConexion;
import org.testng.Assert;

public class ta_CPQ extends TestBase {
	
	private WebDriver driver;
	
	@BeforeTest
	public void mainSteup() {
		this.driver = setConexion.setupPablo();	
		login(driver);
	}
	
	@AfterTest
	public void tearDown2() {
		driver.close();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.get("https://cs14.salesforce.com/home/home.jsp?tsid=02u41000000QWha");
	}

	@BeforeMethod
	public void setup() throws Exception {
		
//		setConexion.setUp();
		
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.findElement(By.id("tsidLabel")).getText().equals("Ventas")){
			driver.findElement(By.id("tsidLabel")).click();
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u41000000QWha\"]")).click();
		}
		OrdersTab page1 = new OrdersTab(driver);
		page1.goToOrdersTab();
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
		Assert.assertEquals("Carrito vacío", page3.getEmptyCartMessage());
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
}
