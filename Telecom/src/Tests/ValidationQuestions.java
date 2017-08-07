package Tests;

import Pages.setConexion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ValidationQuestions extends TestBase {
	
	
	private WebDriver driver;
	 	
	//@AfterMethod
	//public void tearDown() {
		//driver.close();
	//}
	
	@BeforeMethod
	public void setup() throws Exception {
		
		

//		setConexion.setUp();
	driver = setConexion.setupLeo();	

}
	
	@Test	
	public void ValidationQuestion() {
		
			/*driver.get("https://goo.gl/DZC54c");
			Login page1 = new Login(driver);
			page1.ingresar();
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			ContactSearch page2 = new ContactSearch(driver);
			driver.findElement(By.xpath("//*[@id='Sex0']/div/div[1]/label[1]/span[1]")).click();
			String docType = "DNI";
			String docValue= "33333333";
			String genero = "femenino";
			page2.searchContact(docType, docValue, genero);
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			ContactInformation page3 = new ContactInformation(driver);
			String nombre = "TestName"; 
			String apellido = "TestLastName";
			String fechaDeNacimiento = "14/05/1987";
			String mail = "asd@asd.com";
			page3.setContactInformation(nombre, apellido, fechaDeNacimiento, mail);
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("Contact_nextBtn")).click();
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			*/
		
	//Seleccion de metodo por preguntas
		driver.findElement(By.xpath("//*[@id='ValidationMethod0']/div/div[1]/label[2]/span[1]")).click();
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
 
		
		List<WebElement> radio=driver.findElements(By.xpath("//input[@name='question-0' and @type='radio']"));
		for(int i=0; i<radio.size();i++)
		{
			//WebElement local_radio= radio.get(i);
			//String value=local_radio.getAttribute("value");
			//System.out.println(value);
		}
		List<WebElement> radio1=driver.findElements(By.xpath("//input[@name='question-1' and @type='radio']"));
		for(int i=0; i<radio1.size();i++)
		{
			//WebElement local_radio= radio1.get(i);
			//String value=local_radio.getAttribute("value");
			//System.out.println(value);
		}
		
		List<WebElement> radio2=driver.findElements(By.xpath("//input[@name='question-2' and @type='radio']"));
		for(int i=0; i<radio2.size();i++)
		{
			//WebElement local_radio= radio2.get(i);
			//String value=local_radio.getAttribute("value");
			//System.out.println(value);
		}
		List<WebElement> radio3=driver.findElements(By.xpath("//input[@name='question-3' and @type='radio']"));
		for(int i=0; i<radio3.size();i++)
		{	
			//WebElement local_radio= radio3.get(i);
			//String value=local_radio.getAttribute("value");
			//System.out.println(value);
		}
	}
	
	@Test	
	public void ValidationTime() {
		//Seleccion de metodo por preguntas
		driver.findElement(By.xpath("//*[@id='ValidationMethod0']/div/div[1]/label[2]/span[1]")).click();
		try {Thread.sleep(65000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.findElement(By.xpath("//*[@id='QAForm']/div/ng-include/div/div[2]"));
		
	}
	
}