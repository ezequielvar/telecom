package Tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.SCP;
import Pages.setConexion;

public class SCPPrioritarios extends TestBase{
	private WebDriver driver;
	
	@BeforeClass
	public void init() throws Exception
	{
		this.driver = setConexion.setupPablo();
		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		loginSCPAdmin(driver);
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
	}
	
	@BeforeMethod
	public void setup() {
		SCP pScp = new SCP(driver);
		pScp.goToMenu("scp");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		pScp.clickOnTabByName("cuentas");
		try {Thread.sleep(7000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	

		@Test(groups = "Fase2")
		 public void TS_SCP_Crear_Cuenta() { 
		  SCP prueba = new SCP(driver);
		
		          driver.findElement(By.className("pbButton")).findElement(By.className("btn")).click();
		  		  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}  
		  		  //nombre de la cuenta
		  		  driver.findElement(By.id("acc2")).sendKeys("PEREZ PEREZ");
		  		//razon social
		  		  driver.findElement(By.id("00N3F000000JoSt")).sendKeys("PEREZ PEREZ");
		  		  //CUIT
		  		  driver.findElement(By.id("00N3F000000JoSZ")).sendKeys("30538068892");
		  		  //numero de cliente
		  		  driver.findElement(By.id("00N3F000000JoSf")).sendKeys("0000096299");
		  		  try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		  		  driver.findElement(By.name("save")).click();
		  		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
				prueba.clickOnTabByName("cuentas");
				try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		  	
		}
		
		/*@Test(groups = "Fase2")
		 public void TS_SCP_Crear_Cuenta() { 
		  SCP prueba = new SCP(driver);
		  String[] separado;
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	      try {
	         archivo = new File ("C:\\Users\\Florangel\\Downloads\\clientes.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);

	         // Lectura del fichero
	         String linea;
	         while((linea=br.readLine())!=null) {
		          separado = linea.split(",");
		          
		          driver.findElement(By.className("pbButton")).findElement(By.className("btn")).click();
		  		  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}  
		  		  //nombre de la cuenta
		  		  driver.findElement(By.id("acc2")).sendKeys(separado[0]);
		  		//razon social
		  		  driver.findElement(By.id("00N3F000000JoSt")).sendKeys(separado[1]);
		  		  //CUIT
		  		  driver.findElement(By.id("00N3F000000JoSZ")).sendKeys(separado[2]);
		  		  //numero de cliente
		  		  driver.findElement(By.id("00N3F000000JoSf")).sendKeys(separado[3]);
		  		  try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		  		  driver.findElement(By.name("save")).click();
		  		try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
				prueba.clickOnTabByName("cuentas");
				try {Thread.sleep(8000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		  		  
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();		  
		 }
		}*/
	
}
