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

public class newAccount extends TestBase {
	
private WebDriver driver;
String accountName = "Aaa Aaa";

@AfterMethod
public void tearDown() {
	driver.close();
}

@BeforeMethod
public void setup() throws Exception {

	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("user-data-dir=C:\\Users\\pablo\\AppData\\Local\\Google\\Chrome\\User Data");
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    driver.get("https://test.salesforce.com/");
    Login page = new Login(driver);
    page.ingresar();
//    driver.findElement(By.id("emc")).sendKeys("45470");
//    driver.findElement(By.name("save")).click();
    
}

@Test
public void createNewAccount() {
	try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.findElement(By.id("ext-gen33")).click();	
	try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
	driver.findElement(By.name("new")).click();
	driver.switchTo().defaultContent();
	try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	try {driver.switchTo().frame(driver.findElement(By.id("ext-comp-1032")));} catch (org.openqa.selenium.NoSuchElementException e) {driver.switchTo().frame(driver.findElement(By.id("ext-comp-1023")));}
	AccountType tipo = new AccountType(driver);
	tipo.setType("Consumer");
	try {driver.switchTo().frame(driver.findElement(By.id("ext-comp-1039")));} catch (org.openqa.selenium.NoSuchElementException e) {driver.switchTo().frame(driver.findElement(By.id("ext-comp-1030")));}
	NewAccount account = new NewAccount(driver);
	account.createNewAcc(accountName);
	try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.switchTo().defaultContent();
	driver.findElement(By.id("ext-gen33")).click();
	driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
	driver.findElement(By.id("00B41000001Cfy5_refresh")).click();
	Select field = new Select(driver.findElement(By.name("fcf")));
	field.selectByVisibleText("Todas Las cuentas");
	driver.navigate().refresh();
	driver.switchTo().frame(driver.findElement(By.id("ext-comp-1005")));
	List<WebElement> accounts = driver.findElements(By.cssSelector(".x-grid3-cell-inner.x-grid3-col-ACCOUNT_NAME"));
	Assert.assertEquals(accountName, accounts.get(0).getText());
	driver.switchTo().defaultContent();
	driver.findElement(By.id("navigatortab__scc-pt-1")).click();
	try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	driver.findElement(By.id("ext-gen73")).click();
	driver.switchTo().frame(driver.findElement(By.id("ext-comp-1023")));
	driver.findElement(By.name("delete")).click(); 
	 for (String handle : driver.getWindowHandles()) {	 
	    driver.switchTo().window(handle);}
	driver.findElement(By.id("ext-gen127")).click();
}
	
}
