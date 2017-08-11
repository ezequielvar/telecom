package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeliveryMethod extends BasePage{
	
	final WebDriver driver;

	@FindBy (how = How.ID, using = "DlvMethod")
	private WebElement deliveryMethod;
	
	@FindBy (how = How.CSS, using = ".vlc-slds-button--tertiary.ng-binding.ng-scope")
	private List<WebElement> buttons;
	
	@FindBy (how = How.CLASS_NAME, using = "ng-binding")
	private List<WebElement> nextAndPrevious;

	public DeliveryMethod(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);	
}
	
public void clickOnNext() {
	getElementFromList(nextAndPrevious, "Siguiente").click();
}
	
public String getCurrentValueForDeliveryMethod() {
	Select dropdown = new Select(deliveryMethod);
	 return dropdown.getFirstSelectedOption().getText();
}
}
