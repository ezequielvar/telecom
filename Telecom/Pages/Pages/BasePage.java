package Pages;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public void setCombo(Select field, String value) {
		field.deselectAll();
		field.selectByVisibleText(value);
	}
	
}
