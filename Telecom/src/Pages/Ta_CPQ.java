package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

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

@FindBy (how = How.CSS, using = ".slds-button.slds-m-left--large.slds-button--brand.ta-button-brand")
private WebElement salesConfig;

@FindBy (how = How.CLASS_NAME, using = "cpq-cart-item-root-product")
private List<WebElement> plan;

@FindBy (how = How.CLASS_NAME, using = "cpq-cart-item-no-children")
private List<WebElement> planInformation;

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

public void clickOnSalesConfig() {
	salesConfig.click();
}

public void clickOnDelete() {
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", planButtons.get(3));
}

public Boolean isPlanPresent() {
	Boolean a = false;
	if (plan.size() > 0) {
		a = true;
	}
	return a;
}

public Boolean getPlanInformation() {
	Boolean a = false;
	if (planInformation.get(5).getText().equals("Cargo de Conexión")) {
		a = true;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", planButtons.get(3));
	}
	return a;
}

public String getEmptyCartMessage() {
	return driver.findElement(By.cssSelector(".slds-grid.slds-grid--vertical-align-center.slds-grid--align-center.cpq-no-cart-items-msg")).getText();
}

}
