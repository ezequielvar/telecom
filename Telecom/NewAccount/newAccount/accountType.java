package newAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class accountType extends mainPage {

	public Select selectType(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("p3")));
		return select;	
	}
	
	public WebElement doYouWishToContinue(WebDriver driver) {
		WebElement element = driver.findElement(By.name("save"));
		return element;
	}
	
	public WebElement cancel(WebDriver driver) {
		WebElement element = driver.findElement(By.name("cancel"));
		return element;
	}
	
}
