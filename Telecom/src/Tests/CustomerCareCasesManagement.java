package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Pages.setConexion;

public class CustomerCareCasesManagement extends TestBase {

	private WebDriver driver;

	@BeforeTest
	public void mainSteup() {
		this.driver = setConexion.setupPablo();	
		login(driver);
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		if (!driver.getCurrentUrl().toString().equals("https://cs14.salesforce.com/console")){
			driver.findElement(By.id("tsidLabel")).click();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
		}
		try {Thread.sleep(3500);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		goToLeftPanel2(driver, "Casos");
	}
	
	@AfterTest
	public void tearDown() {
		/*
		driver.switchTo().defaultContent();
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		
		waitFor(driver, (By.className("x-toolbar-cell")));
		List<WebElement> btn = driver.findElements(By.cssSelector(".x-btn-text"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn.get(5));
driver.close();*/
	}
		
	
		
		
	
	
	
	
	
}