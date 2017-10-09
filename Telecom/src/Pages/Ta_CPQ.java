package Pages;

import java.util.ArrayList;
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
	
	public enum RightPanel{DISPOSITIVOS, PLANES, BUNDLES, DATOS, ACCESORIOS}
	
	@FindBy (how = How.CSS, using = ".slds-button.slds-button--neutral.add-button")
	private List<WebElement> addToCartButtons;
		
	@FindBy (how = How.CSS, using = ".slds-button__icon.slds-button__icon--small.slds-button__icon--left.fix-slds-close-switch")
	private List<WebElement> arrowPlan;
	
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
	
	@FindBy (how = How.CSS, using = ".slds-tile.cpq-product-item")
	private List<WebElement> divsProducts;
	
	@FindBy (how = How.XPATH, using = "//button[@title=\"Delete Item\"]")
	private List<WebElement> buttonsDelete;
	
	@FindBy (how = How.XPATH, using = "//button[@class=\"slds-button slds-m-left--large slds-button--brand ta-button-brand\"]")
	private WebElement buttonNext;
	
	@FindBy (how = How.ID, using = "select-01")
	private WebElement accountSelector;
	
	@FindBy (how = How.ID, using = "-import-btn")
	private WebElement buttonNewAccount;
	
	@FindBy (how = How.XPATH, using = ".//a[@ng-class=\"{'cpq-category-item-selected' : isSelectedCategory(category.catalogName), 'cat-icon': !isSelectedCategory(category.catalogName)}\"]")
	private List<WebElement> rightPanelButtons;
	
	public Ta_CPQ(WebDriver driver){
		this.driver = driver;
	    PageFactory.initElements(driver, this);	
	}
	
	public void addPlan() {
		addToCartButtons.get(6).click();
	}
	
	public void openArrow() {
		arrowPlan.get(0).click();
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
		try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement buttonDeteleFinish = driver.findElement(By.cssSelector(".slds-button.slds-button--destructive"));
	}
	
	public Boolean isPlanPresent() {
		Boolean a = false;
		if (arrowPlan.size() > 0) {
			a = true;
		}
		return a;
	}
	
	public Boolean getPlanInformation() {
		Boolean a = false;
		if (planInformation.get(5).getText().equals("Cargo de Conexi�n")) {
			a = true;
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", planButtons.get(3));
		}
		return a;
	}
	
	public String getEmptyCartMessage() {
		return driver.findElement(By.cssSelector(".slds-grid.slds-grid--vertical-align-center.slds-grid--align-center.cpq-no-cart-items-msg")).getText();
	}
	
	public List<WebElement> getDivsProducts(){return divsProducts;}
	
	public WebElement getAccountSelector() {return (accountSelector);}
	
	public WebElement getButtonNewAccount() {return (buttonNewAccount);}
	
	public WebElement getButtonNext() {return (buttonNext);}
	
	
	/** Delete all elements from Cart.*/
	public void deleteAddedProducts() {
		buttonsDelete = driver.findElements(By.xpath("//button[@title=\"Delete Item\"]"));
		for (WebElement buttonDelete: buttonsDelete) {
			buttonDelete.click();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			WebElement buttonDeteleFinish = driver.findElement(By.cssSelector(".slds-button.slds-button--destructive"));
			buttonDeteleFinish.click();
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		}
	}
	
	/**
	 * @param receives a div WebElement refered to a product that can be added to Cart. 
	 * @return true if divProduct needs to validate prefactibility, else returns false (can be added to Cart just pressing "Add button") 
	 */
	public boolean requiresPrefactibility(WebElement divProduct) {
		return (divProduct.findElements(By.className("prefaseablitiyLabel")).size() > 0);
	}
	
	public void addAnyProductToCart() {
		divsProducts = driver.findElements(By.cssSelector(".slds-tile.cpq-product-item"));
		for (WebElement div: divsProducts) {
			if (!requiresPrefactibility(div)) {
				WebElement addToCartButton = div.findElement(By.cssSelector(".slds-button.slds-button--neutral.add-button"));
				addToCartButton.click();
				break;
			}
		}
	}
	
	/**
	 * 
	 * @return devuelve el producto del men� de la izquierda 
	 * correspondiente al �ndice pasado como par�metro 
	 */
	public WebElement getAddableDivProduct(int index) {
		divsProducts = driver.findElements(By.cssSelector(".slds-tile.cpq-product-item"));
		if (divsProducts.size() > 0) { 
			return divsProducts.get(index);
		}
		else {
			return null;
		}
	}
	
	/**
	 * Agrega un producto que requiera prefactibilidad.
	 */
	public void addAnyProductToCartThatNeedsPrefactibility() {
		divsProducts = driver.findElements(By.cssSelector(".slds-tile.cpq-product-item"));
		for (WebElement div: divsProducts) {
			if (requiresPrefactibility(div)) {
				WebElement moreButton = div.findElement(By.cssSelector(".product-link.slds-text-body--small.slds-float--right"));
				moreButton.click();
				break;
			}
		}
		try {Thread.sleep(4000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		WebElement addButton = driver.findElement(By.xpath("//button[@ng-click=\"addToCart(productObj[0])\"]"));
		addButton.click();
		WebElement closeButton = driver.findElement(By.xpath("//button[@ng-click=\"$hide()\"]"));
		closeButton.click();

	}
	
	
	/*
	 * @return "Incomplete" if no products were added to cart;
	 * 					"Sales Config" if at least one product was added to cart;
	 */
	public String getCartStatus() {
		return (buttonNext.findElement(By.xpath(".//span[not(@class=\"ng-hide\")]")).getText());
	}

	public void selectFromRightPanel(RightPanel option) {
		switch(option) {
			case DISPOSITIVOS: {
				rightPanelButtons.get(0).click();
				break;
				}
			case PLANES:{
				rightPanelButtons.get(1).click();
				break;
				}
			case BUNDLES:{
				rightPanelButtons.get(2).click();
				break;
				}		
			}
			try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	public List<String> getAddedProducts(){
		List<WebElement> divAddedProducts = driver.findElements(By.cssSelector(".cpq-root-product"));
		System.out.println("Cantidad prelista" + divAddedProducts.size());
		ArrayList<String> nameAddedProducts = new ArrayList<String>();
		for (WebElement divAddedProduct: divAddedProducts) {
			nameAddedProducts.add(divAddedProduct.findElement(By.xpath("//div[@class=\"cpq-item-no-children\"]/span")).getText());
		}
		return nameAddedProducts; 
	}
}	
	
