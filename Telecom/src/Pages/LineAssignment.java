package Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LineAssignment extends BasePage {
	
	final WebDriver driver;

	@FindBy (how = How.ID, using = "SelectProvincia")
	private WebElement selectState;
	
	@FindBy (how = How.ID, using = "SelectLocalidad")
	private WebElement selectCity;
	
	@FindBy (how = How.ID, using = "Sufijo")
	private WebElement suffix;
	
	@FindBy (how = How.ID, using = "CambiarNumero")
	private WebElement search;
	
	@FindBy (how = How.CSS, using = ".slds-button__icon.slds-button__icon--small")
	private WebElement arrow;
	
	@FindBy (how = How.CLASS_NAME, using = "slds-checkbox--faux")
	private List<WebElement> checkboxes;
	
	@FindBy (how = How.CSS, using = ".vlc-slds-button--tertiary.ng-binding.ng-scope")
	private List<WebElement> buttons;
	
	@FindBy (how = How.CLASS_NAME, using = "ng-binding")
	private List<WebElement> next;
	
	@FindBy (how = How.CSS, using = ".slds-form-element__label.slds-text-color--error.ng-binding.ng-scope")
	private WebElement noLineAvailableMessage;
	
public LineAssignment(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);	
}

public void searchLineAvailable(String state, String city, String sufijo) {
	setSimpleDropdown(selectState, state);
	setSimpleDropdown(selectCity, city);
	suffix.sendKeys(sufijo);
	search.click();
}

public String getNoLineMessage() {
	arrow.click();
	return noLineAvailableMessage.getText();
}

public void cancelLineAssignment() {
	buttons.get(0).click();
	Alert alert = driver.switchTo().alert();
    alert.accept();
    driver.findElement(By.id("ext-gen25")).click();
}

public void clickOnNext() {
	next.get(18).click();
}

}
