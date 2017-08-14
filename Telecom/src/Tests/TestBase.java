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
		}
	}
	
	public void login(WebDriver driver) {
		driver.get("https://test.salesforce.com/");
	    Login page0 = new Login(driver);
	    page0.ingresar();
	}
	
<<<<<<< HEAD

	public void login1(WebDriver driver) {
		driver.get("https://goo.gl/ETjDYJ");
	    Login page0 = new Login(driver);
	    page0.ingresar();}

	public void waitFor(WebDriver driver, By element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(element));

=======
	public void login1(WebDriver driver) {
		driver.get("https://goo.gl/ETjDYJ");
	    Login page0 = new Login(driver);
	    page0.ingresar();
	}
	
	public void waitFor(WebDriver driver, By element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(element));
>>>>>>> 563ad577840e56168bba333399b19018a299385d
	}
}
