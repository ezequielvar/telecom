package Tests;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.AccountType;
import Pages.Login;
import Pages.NewAccount;
import Pages.setConexion;

public class newAccount extends TestBase {
	
private WebDriver driver;
String accountName = "Aaa Aaa";

@AfterMethod
public void tearDown() {
	driver.close();
}

@BeforeMethod
public void setup() throws Exception {
	
//	setConexion.setUp();
	setConexion.setupPablo();	
    
}

@Test	
public void createNewAccount() {
	login(driver);
	try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.findElement(By.id("ext-gen33")).click();	
	try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	WebElement frame1 = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(frame1);
	driver.findElement(By.name("new")).click();
	driver.switchTo().defaultContent();
	try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
	driver.switchTo().frame(frame2.get(1));
	AccountType tipo = new AccountType(driver);
	tipo.setType("Consumer");
	List<WebElement> frame3 = driver.findElements(By.tagName("iframe"));
	driver.switchTo().frame(frame3.get(1));
	NewAccount account = new NewAccount(driver);
	account.createNewAcc(accountName);
	try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.switchTo().defaultContent();
	driver.findElement(By.id("ext-gen33")).click();
	WebElement frame4 = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(frame4);
	Select field = new Select(driver.findElement(By.name("fcf")));
	field.selectByVisibleText("Todas Las cuentas");
	try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.navigate().refresh();
	WebElement frame5 = driver.findElement(By.tagName("iframe"));
	driver.switchTo().frame(frame5);
	List<WebElement> accounts = driver.findElements(By.cssSelector(".x-grid3-cell-inner.x-grid3-col-ACCOUNT_NAME"));
	Assert.assertEquals(accountName, accounts.get(0).getText());
	driver.switchTo().defaultContent();
	driver.findElement(By.id("navigatortab__scc-pt-0")).click();
	try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.findElement(By.id("ext-gen67")).click();
	List<WebElement> frame6 = driver.findElements(By.tagName("iframe"));
	driver.switchTo().frame(frame6.get(1));
	driver.findElement(By.name("delete")).click(); 
	 for (String handle : driver.getWindowHandles()) {	 
	    driver.switchTo().window(handle);}
	driver.findElement(By.id("ext-gen121")).click();
}

//@Test
public void test() {
	
}


}
