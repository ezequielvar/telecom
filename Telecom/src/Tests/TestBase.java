package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Login;


public class TestBase {
	
	public void leftDropdown(WebDriver driver, String selection) {
		driver.findElement(By.className("x-btn-mc")).click();
		switch(selection) {
		case "Cuentas":
		driver.findElement(By.id("ext-gen211")).click();;
		break;
		}
	}
	
	public void goToLeftPanel(WebDriver driver, String selection) {
		WebElement element = driver.findElement(By.className("x-btn-split"));
		Actions builder = new Actions(driver);   
		builder.moveToElement(element, 245, 20).click().build().perform();
		switch(selection) {
		case "Cuentas":
		driver.findElement(By.id("nav-tab-0")).click();
		break;
		case "Casos":
			driver.findElement(By.id("nav-tab-9")).click();
			break;
		}
	}
	
	public void login(WebDriver driver) {
		driver.get("https://test.salesforce.com/");
		try {Thread.sleep(6000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//if(driver.findElement(By.id("idcard")).isDisplayed())
		//{
	    Login page0 = new Login(driver);
	    page0.ingresar();
		//}else{
			//driver.findElement(By.id("chooser")).click();
	//	}
	}
	

	public void login1(WebDriver driver) {
		driver.get("https://goo.gl/ETjDYJ");
		try {Thread.sleep(1000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		//if(driver.findElement(By.id("idcard")).isDisplayed())
		//{
	    Login page0 = new Login(driver);
	    page0.ingresar();
		//}else{
		//	driver.findElement(By.id("chooser")).click();
		//}
	}

	    
/*public void waitFor(WebDriver driver, By element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))

				  .until(ExpectedConditions.presenceOfElementLocated(element));
*/
}

