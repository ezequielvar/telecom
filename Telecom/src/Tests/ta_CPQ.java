package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LineAssignment;
import Pages.Login;
import Pages.Order;
import Pages.OrdersTab;
import Pages.Ta_CPQ;
import Pages.setConexion;
import org.testng.Assert;

public class ta_CPQ extends TestBase {
	
	private WebDriver driver;

	@AfterMethod
	public void tearDown() {
//		driver.close();
	}

	@BeforeMethod
	public void setup() throws Exception {
		
//		setConexion.setUp();
		this.driver = setConexion.setupPablo();	
	    
	}
	
	@Test
	public void checkSimCardAssignment() {
		login(driver);
		OrdersTab page1 = new OrdersTab(driver);
		page1.goToOrdersTab();
		page1.goToRecentOrder();
		Order page2 = new Order(driver);
		page2.goToTaCPQ();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Ta_CPQ page3 = new Ta_CPQ(driver);
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.openArrow();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("1", page3.getSimCardValue()); 	
	}
	
	@Test
	public void checkPaperCanIsPresent() {
		login(driver);
		OrdersTab page1 = new OrdersTab(driver);
		page1.goToOrdersTab();
		page1.goToRecentOrder();
		Order page2 = new Order(driver);
		page2.goToTaCPQ();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Ta_CPQ page3 = new Ta_CPQ(driver);
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(page3.isPaperCanPresent());
	}
	
	@Test
	public void checkPaperCanLabel() {
		login(driver);
		OrdersTab page1 = new OrdersTab(driver);
		page1.goToOrdersTab();
		page1.goToRecentOrder();
		Order page2 = new Order(driver);
		page2.goToTaCPQ();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Ta_CPQ page3 = new Ta_CPQ(driver);
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertEquals("Quitar el producto del carrito", page3.getPaperCanLabel());
	}
	
	@Test
	public void checkNoLineAvailableMessageAndCancelPlan() {
		login(driver);
		OrdersTab page1 = new OrdersTab(driver);
		page1.goToOrdersTab();
		page1.goToRecentOrder();
		Order page2 = new Order(driver);
		page2.goToTaCPQ();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Ta_CPQ page3 = new Ta_CPQ(driver);
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
	public void checkPlasnInformation() {
		login(driver);
		OrdersTab page1 = new OrdersTab(driver);
		page1.goToOrdersTab();
		page1.goToRecentOrder();
		Order page2 = new Order(driver);
		page2.goToTaCPQ();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Ta_CPQ page3 = new Ta_CPQ(driver);
		page3.addPlan();
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page3.openArrow();
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		Assert.assertTrue(page3.getPlanInformation());
	}

}
