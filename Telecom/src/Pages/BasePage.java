package Pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	final WebDriver driver;
	
	@FindBy (how = How.ID, using = "tsidButton")
	private WebElement mainMenuButton;
	
	@FindBy (how = How.ID, using = "tsid-menuItems")
	private WebElement menuOptionsWrapper;
	
	@FindBy (how = How.ID, using = "tabBar")
	private WebElement tabsWrapperBar;
		
	public BasePage() {
		this.driver = null;
		//older constructor maintained.
	}
	
	public BasePage(WebDriver newDriver) {
		System.out.println(newDriver.getCurrentUrl());
		this.driver = newDriver;
		System.out.println(this.driver.getCurrentUrl());
	}
	
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
	
	public int getIndexFrame(WebDriver driver, By byForElement) { //working correctly
		//TODO: Do the same for a WebElement instead of a By.
		int index = 0;
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for(WebElement frame : frames) {
			try {
				driver.switchTo().frame(frame);
				driver.findElement(byForElement).getText(); //each element is in the same iframe.
				//System.out.println(index); //prints the used index.
				driver.switchTo().defaultContent();
				return index;
			}catch(NoSuchElementException noSuchElemExcept) {
				index++;
				driver.switchTo().defaultContent();
			}
		}
		return -1; //if this is called, the element wasnt found.
	}
	
	public WebElement getFrameForElement(WebDriver driver, By byForElement) {
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		return frames.get(getIndexFrame(driver, byForElement));
	}

	public int getIndexFrame(WebDriver driver, WebElement webElementToFind) {
		//TODO: Do the same for a WebElement instead of a By.
		int index = 0;
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for(WebElement frame : frames) {
			try {
				driver.switchTo().frame(frame);
				webElementToFind.getText();
				//System.out.println(index); //prints the used index.
				driver.switchTo().defaultContent();
				return index;
			}catch(NoSuchElementException noSuchElemExcept) {
				index++;
				driver.switchTo().defaultContent();
			}
		}
		return -1;//if this is called, the element wasnt found.
	}
	
	public WebElement getFrameForElement(WebDriver driver, WebElement webElementToFind) {
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		return frames.get(getIndexFrame(driver, webElementToFind));
	}
	
	public void switchAppsMenu() {
		mainMenuButton.click();
	}
	
	public void selectAppFromMenuByName(String optionName) {
		//each option is a menuButtonMenuLink class
//		List<WebElement> options = menuOptionsWrapper.findElements(By.className("menuButtonMenuLink"));
		List<WebElement> options = menuOptionsWrapper.findElements(By.tagName("a"));
		for (WebElement option : options) {
			if(option.getText().toLowerCase().equals(optionName.toLowerCase())){
				option.click();
				return;
			}
		}
		System.out.println("Opcion del menu principal NO encontrada.");
		switchAppsMenu();
	}

	public void selectMainTabByName(String tabName) {
//		An Alternative.
//		List<WebElement> tabs = tabsWrapperBar.findElements(By.tagName("li"));
		driver.switchTo().defaultContent();
		List<WebElement> tabs = tabsWrapperBar.findElements(By.tagName("a"));

		for(WebElement tab : tabs) {//tabs LINKS
			if(tab.getText().toLowerCase().equals(tabName.toLowerCase())){
				tab.click();
				return;
			}
		}
		System.out.println("Tab NO encontrado.");
	}
	
	
	
}
