package Pages;
import java.util.ArrayList;
import java.util.List;

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

	public WebElement getElementFromList(List<WebElement> elements, String field) {
		List<Integer> a = new ArrayList<>();
		Integer i = 0;
		for(WebElement e : elements) {
			if(e.getText().equals(field)) {
				a.add(i);
			}
			i++;
		}
		return elements.get(a.get(0));
	}
}
