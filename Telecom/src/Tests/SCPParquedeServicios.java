package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.SCP;
import Pages.setConexion;

import static org.testng.Assert.assertTrue;

import java.awt.Button;
import java.util.List;

import org.openqa.selenium.*;
public class SCPParquedeServicios extends TestBase{
	private WebDriver driver;
	String categoria = "Categoria1";
	String servicio = "Servicio 1";
	String color = "Red";
	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupEze();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	loginSCPAdmin(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
		
	@BeforeMethod
	public void setup(){
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		String a = driver.findElement(By.id("tsidLabel")).getText();
		driver.findElement(By.id("tsidLabel")).click();
		if(a.equals("Ventas"))
		{
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u3F000000CjqC\"]")).click();
		}else
		{
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u41000000QWha\"]")).click();
			try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("tsidLabel")).click();
			driver.findElement(By.xpath("//a[@href=\"/home/home.jsp?tsid=02u3F000000CjqC\"]")).click();
		}
	}
	
	@AfterMethod
	public void after(){
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+driver.findElement(By.id("home_Tab")).getLocation().y+")");
		driver.findElement(By.id("home_Tab")).click();
	}
	
	@Test
	public void TS112781_Parque_de_Servicios_Agregar_Nuevo_Servicio(){
	
		SCP page = new SCP(driver);
		page.clickOnTabByName("cuentas");
		page.clickOnFirstAccRe();
		page.moveToElementOnAccAndClick("segundoTitulo", "//*[@id='segundoTitulo']/div/ul/li[2]/a");
		page.nuevoservicio(categoria, servicio, color);
		Assert.assertTrue(page.validarservicionuevo(categoria, servicio, color));
		
	}
	
	@Test
	public void TS112782_Parque_de_Servicios_Borrar(){
	
		SCP page = new SCP(driver);
		page.clickOnTabByName("cuentas");
		page.clickOnFirstAccRe();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.moveToElementOnAccAndClick("segundoTitulo", "//*[@id='segundoTitulo']/div/ul/li[2]/a");
		page.nuevoservicio(categoria, servicio, color);
		Assert.assertFalse(page.validarservicioborrado(categoria, servicio, color));
	}
	
		
	@Test
	public void TS112785_Parque_de_Servicios_Exportar_a_Excel(){
		
		SCP page = new SCP(driver);
		page.clickOnTabByName("cuentas");
		page.clickOnFirstAccRe();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		page.moveToElementOnAccAndClick("segundoTitulo", "//*[@id='segundoTitulo']/div/ul/li[2]/a");
		page.servicioexportarexcel();
	}
		@Test
		public void TS112786_Parque_de_Servicios_Guardar(){
			SCP page = new SCP(driver);
			page.clickOnTabByName("cuentas");
			page.clickOnFirstAccRe();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			page.moveToElementOnAccAndClick("segundoTitulo", "//*[@id='segundoTitulo']/div/ul/li[2]/a");
			page.servicioguardar();
		}
		
	
}
