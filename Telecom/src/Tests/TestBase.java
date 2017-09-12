package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	
	public void goToLeftPanel2(WebDriver driver, String selection) {
		/*WebElement element = driver.findElement(By.className("x-btn-split"));
		Actions builder = new Actions(driver);   
		builder.moveToElement(element, 245, 20).click().build().perform();*/
		driver.switchTo().defaultContent();
		try {
			driver.findElement(By.className("x-btn-split"));
		}catch(NoSuchElementException noSuchElemExcept) {
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			for (WebElement frame : frames) {
				try {
					driver.findElement(By.className("x-btn-split"));
					break;
				}catch(NoSuchElementException noSuchElemExceptInside) {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(frame);
				}
			}
		}
		WebElement dropDown = driver.findElement(By.className("x-btn-split"));
		Actions builder = new Actions(driver);   
		builder.moveToElement(dropDown, 245, 20).click().build().perform();
		List<WebElement> options = driver.findElements(By.tagName("li"));
		for(WebElement option : options) {
			if(option.findElement(By.tagName("span")).getText().equals(selection)) {
				option.findElement(By.tagName("a")).click();
				System.out.println("Seleccionado");
				break;
			}
		}
		/*
		switch(selection) {
		case "Cuentas":
		driver.findElement(By.id("nav-tab-0")).click();
		break;
		case "Casos":
			driver.findElement(By.id("nav-tab-9")).click();
			break;
		}
		List<WebElement> sections = dropDown.findElements(By.className("x-menu-list-item"));
		for (WebElement section : sections) {
			if (section.getText().toLowerCase().equals(selection.toLowerCase())) {
				section.click();
				break;
			}
		}*/
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

	}	    	
	    
	public void waitFor2(WebDriver driver, By element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(element));
	}
	public void waitFor(WebDriver driver, By element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(element));
	}

	
	public void clickLeftPanel(WebDriver driver) {
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		for (WebElement btn : buttons) {
			if(btn.getAttribute("id").equals("ext-gen33")) {
				btn.click();
				break;
			}
		}
	}
	
		//}else{
		//	driver.findElement(By.id("chooser")).click();
		//}

	    
/*public void waitFor(WebDriver driver, By element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
<<<<<<< HEAD
				  .until(ExpectedConditions.presenceOfElementLocated(element));}

	public void waitFor2(WebDriver driver, By element) {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(element));
	}
=======

				  .until(ExpectedConditions.presenceOfElementLocated(element));
*/
}

