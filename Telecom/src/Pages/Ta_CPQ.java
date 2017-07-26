package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ta_CPQ extends BasePage {

	final WebDriver driver;

@FindBy (how = How.CSS, using = ".slds-button.slds-button--neutral.add-button")
private List<WebElement> addToCartButtons;
	
@FindBy (how = How.CSS, using = ".slds-button__icon.slds-button__icon--small.slds-button__icon--left.fix-slds-close-switch")
private WebElement arrowPlan;

@FindBy (how = How.CLASS_NAME, using = "cpq-cart-item-currency-value")
private List<WebElement> values;

@FindBy (how = How.CSS, using = ".slds-button.slds-p-horizontal--xx-small")
private List<WebElement> planButtons;

@FindBy (how = How.CSS, using = ".slds-button__icon.slds-button__icon--")
private List<WebElement> icons;

public Ta_CPQ(WebDriver driver) {
	this.driver = driver;
    PageFactory.initElements(driver, this);	
}

public void addPlan() {
	
	addToCartButtons.get(6).click();

}

public void openArrow() {
	arrowPlan.click();
}

public String getSimCardValue() {
	String value = values.get(2).getText();
	return value;
}

public Boolean isPaperCanPresent() {
	Boolean a = false;
	for (WebElement e : icons) {
if (e.getAttribute("icon").toString().equals("'delete'")) {	
((JavascriptExecutor) driver).executeScript("arguments[0].click();", planButtons.get(3)); 
a = true;}
}
return a;
}

public String getPaperCanLabel() {
	String value = planButtons.get(3).getAttribute("title").toString();
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", planButtons.get(3));	
	return value;
}

}
