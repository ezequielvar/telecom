import org.openqa.selenium.support.ui.Select;

public class mainPage {
	
	public void setCombo(Select field, String value) {
		field.deselectAll();
		field.selectByVisibleText(value);
	}
	
}
