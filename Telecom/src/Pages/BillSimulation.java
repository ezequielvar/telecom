package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BillSimulation extends BasePage {
	
	final WebDriver driver;

	@FindBy (how = How.CSS, using = ".vlc-slds-button--tertiary.ng-binding.ng-scope")
	private List<WebElement> buttons;
	
	@FindBy (how = How.CLASS_NAME, using = "ng-binding")
	private List<WebElement> nextAndPrevious;
	
public BillSimulation(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);	
}

public void clickOnNext() {
getElementFromList(nextAndPrevious, "Siguiente").click();
}
}
