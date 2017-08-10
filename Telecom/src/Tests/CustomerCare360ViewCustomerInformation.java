package Tests;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Login;
import Pages.setConexion;

public class CustomerCare360ViewCustomerInformation extends TestBase  {

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
	public void TS7069_ValidationButtons () {
		

		driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		
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
		accounts.get(0).click();
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

		try {
	        driver.findElement(By.id("ext-gen133")).click();;
	    } catch (NoSuchElementException e) {	
	    }
		
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		
		
		driver.findElement(By.className("profile-links-wrapper"));
		List<WebElement> botones = driver.findElements(By.className("profile-links"));
		Integer a = 0; 
	for (WebElement e: botones) {
		System.out.println(a);
		System.out.println(e.getText());
		a++;
	}
	Assert.assertEquals("Actualizar Datos", botones.get(0).getText());
	Assert.assertEquals("| Reseteo Clave", botones.get(1).getText());

	}


	private void waitFor(WebDriver driver2, By by) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Test
	public void TS7068_ValidationFields (){

		try {
        driver.findElement(By.id("ext-gen133")).click();;
    } catch (NoSuchElementException e) {	
    }
	
	
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
	
	driver.findElements(By.className("ext-webkit.ext-chromehg"));
	List<WebElement> profileinfo = driver.findElements(By.className("client-data-detail"));
	driver.findElement(By.className("console-account-info"));
 Integer a = 0; 
	for (WebElement e: profileinfo) {
		System.out.println(a);
		System.out.println(e.getText());
		a++;
	}
	
	Assert.assertEquals("Correo Electónico:", profileinfo.get(0).getText());
	Assert.assertEquals("Teléfono:", profileinfo.get(1).getText());
	Assert.assertEquals("Club Personal:", profileinfo.get(2).getText());
	Assert.assertEquals("Categoría:", profileinfo.get(3).getText());


}


@Test
public void TS7070_ValidationClubPersonalBasico (){
	String basico = "Categoría: Basico" ;

	try {
    driver.findElement(By.id("ext-gen133")).click();;
} catch (NoSuchElementException e) {	
}


try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));

driver.findElements(By.className("ext-webkit.ext-chromehg"));
List<WebElement> profileinfo = driver.findElements(By.className("acct-info"));
driver.findElement(By.className("client-data-detail"));
Assert.assertTrue(profileinfo.get(0).getText().contains(basico)); 
}



@Test
public void TS7072_ValidationNPS(){

	try {
    driver.findElement(By.id("ext-gen133")).click();;
} catch (NoSuchElementException e) {	
}


try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));

driver.findElements(By.className("ext-webkit.ext-chromehg"));
driver.findElement(By.className("detail-card"));
List<WebElement> profileinfo = driver.findElements(By.className("detail-card"));
for(int i=1; i<20; i++){
	String b = Integer.toString(i);
	Assert.assertFalse(profileinfo.get(0).getText().contains("-"+b));
}
}

@Test
public void TS7070_ValidationClubPersonalPremium (){
	String premium = "Categoría: Premium" ;

	try {
    driver.findElement(By.id("ext-gen133")).click();;
} catch (NoSuchElementException e) {	
}


try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));

driver.findElements(By.className("ext-webkit.ext-chromehg"));
List<WebElement> profileinfo = driver.findElements(By.className("acct-info"));
driver.findElement(By.className("client-data-detail"));
Assert.assertTrue(profileinfo.get(0).getText().contains(premium)); 
}


	
	@Test
	public void TS7126_ValidationPerfilPanel (){
	
	driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		
		try {
	    driver.findElement(By.id("ext-gen133")).click();;
	} catch (NoSuchElementException e) {	
	}


	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));

	driver.findElements(By.className("ext-webkit.ext-chromehg"));
    driver.findElement(By.className("ng-hide"));
	}
	
	

	
	@Test
	public void TS7106_ValidationNumberEstatus (){
		
	driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		try {
	    driver.findElement(By.id("ext-gen133")).click();;
	} catch (NoSuchElementException e) {	
	}


	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));

	driver.findElements(By.className("ext-webkit.ext-chromehg"));
	List<WebElement> profileinfo = driver.findElements(By.className("story-field"));
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	//pasar todo a un metodo en page
	//Lista de estados posibles
	List<String> expected = new ArrayList<String>();
	expected.add("New");
	expected.add("Closed");
	for(int i=0; i<profileinfo.size(); i+=2){
		String b = (profileinfo.get(i).getText());
		b = b.replaceAll("[0-9]","");
		b = b.replaceAll("-","");
		b = b.replaceAll(" ","");
    Assert.assertTrue(expected.contains(b));
	}
	for(int i=0; i<profileinfo.size(); i+=2){
		String b = (profileinfo.get(i).getText());
		String a = Integer.toString(i);
  
    Assert.assertTrue(b.contains(a));
	}
	}
	
	
		/*@Test
		public void TS7112_ValidationDateFormat (){
		//no terminado
	driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		try {
	    driver.findElement(By.id("ext-gen133")).click();;
	} catch (NoSuchElementException e) {	
	}


	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));

	driver.findElements(By.className("ext-webkit.ext-chromehg"));
	List<WebElement> profileinfo = driver.findElements(By.className("story-field"));	
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	for(int i=1; i<profileinfo.size(); i+=2){
		String b = (profileinfo.get(i).getText()+"555");
		System.out.println(b);
		String date_s = b; 
		
		SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy"); 
		Date date = null;
		
		try {
			date = dt.parse(date_s);
		} catch (ParseException e) {

		} 
		SimpleDateFormat dt1 = new SimpleDateFormat("dd/mm/yyyy");
	System.out.println(date_s);
		Assert.assertTrue((dt1.format(date)).equals(b));
		
	}
	}*/
	
	
	
	
	
	
	
	
	@Test
	public void TS7108_ValidationCustomerTransactionsViewFilter (){
		
	driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		try {
	    driver.findElement(By.id("ext-gen133")).click();;
	} catch (NoSuchElementException e) {	
	}

		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));

	driver.findElements(By.className("ext-webkit.ext-chromehg"));
	driver.findElement(By.id("text-input-01"));
	
}
	
	@Test
	public void TS7110_ValidationCustomerTransactionsScroll(){
		
	driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		try {
	    driver.findElement(By.id("ext-gen133")).click();;
	} catch (NoSuchElementException e) {	
	}

		
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
	((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	}
	
	@Test
	public void TS7113_ValidationCustomerTransactionsIconType(){
		
	driver.get("https://cs14.salesforce.com/console?tsid=02uc0000000D6Hd")	;
		Login page1 = new Login(driver);
		page1.ingresar();
		try {
	    driver.findElement(By.id("ext-comp-1013-xcollapsed")).click();;
	} catch (NoSuchElementException e) {	
	}

		
	try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	WebElement frame1 = driver.findElement(By.id("ext-comp-1022"));
	driver.switchTo().frame(frame1);
	driver.findElement(By.className("slds-icon_container"));
	}
}