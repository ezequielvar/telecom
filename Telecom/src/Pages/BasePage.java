package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public void setSimpleDropdown(WebElement element, String value) {
		Select field = new Select(element);
	//	field.deselectAll();
		field.selectByVisibleText(value);
	}
	
	public void setElementFromList(WebElement element, String value, WebElement arrow) {
		Select field = new Select(element);
		field.selectByVisibleText(value);
		arrow.click();
	}
	
}
