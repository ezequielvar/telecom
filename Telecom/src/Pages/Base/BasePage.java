package Pages.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public void setSimpleDropdown(WebElement element, String value) {
		Select field = new Select(element);
		field.deselectAll();
		field.selectByVisibleText(value);
	}
	
}
