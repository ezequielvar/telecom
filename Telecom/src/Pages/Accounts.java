package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Accounts extends BasePage {
	final WebDriver driver;
	
	private List<WebElement> frames;
	private List<WebElement> accountSelectorItems;
	private List<WebElement> accountsList;
	private Select accountSelect;
	
	@FindBy (how = How.CLASS_NAME, using = "listItemPad")
	private List<WebElement> abcFilters;
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"001c000001C2CqJ_ACCOUNT_NAME\"]/a")
	private WebElement firstAccount;
	
	@FindBy (how = How.ID, using = "listSelect")
	private WebElement accountSelector;
	
	@FindBy (how = How.ID, using = "ext-gen12")
	private WebElement accountNamesWrapper;
	
	//Tab Asistencia Tecnica
	
	private List<WebElement> rightActionButtons;

	private WebElement inpSelectService;
	//Methods
	
	public Accounts(WebDriver driver) {
		this.driver = driver;
		driver.switchTo().defaultContent();
		frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		//TO do: iterate frames method.
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getAccountSelectItems() {
		try {
			accountSelectorItems = accountSelector.findElements(By.tagName("option"));
		}catch(NoSuchElementException noSuchElemEscept) {
			driver.switchTo().defaultContent();
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			for (WebElement currentFrame : frames) {
				try {
					driver.switchTo().frame(currentFrame);
					accountSelectorItems = accountSelector.findElements(By.tagName("option"));
					if (accountSelectorItems!= null) {
						break;
					}
				}
				catch(NoSuchElementException noSuchElemExcept) {
					driver.switchTo().defaultContent();
					continue;
				}
			}
		}
		return accountSelectorItems;
	}

	public List<WebElement> getAccounts() {
		accountsList = accountNamesWrapper.findElements(By.className("x-grid3-row"));
		return accountsList;
	}
	
	public void clickOnV() {
		getElementFromList(abcFilters, "V").click();
	}

	public void clickOnFirstAccount() {
		firstAccount.click();
	}
	
	public void accountSelect(String cuentaBuscar) {
		//String regexSelector = "\\w+listSelect\\b";
		accountSelect = new Select(driver.findElement(By.tagName("select")));
		accountSelect.selectByVisibleText(cuentaBuscar);;
	}
	
	public void deployWestPanel() {
		//driver.switchTo().defaultContent();
		//List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement currentFrame : frames) {
			try {
				driver.findElement(By.id("ext-comp-1012-xcollapsed"));
				//driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east"));
				//driver.findElement(By.cssSelector(".x-layout-mini.x-layout-mini-east")).click();
				System.out.println("PanelDeployed");
				break;
			}catch(NoSuchElementException noSuchElemExcept){
				//System.out.println("PanelNotDeployed");
				//System.out.println(frames.size());
				driver.switchTo().defaultContent();
				driver.switchTo().frame(currentFrame);
				/*}catch(WebDriverException WDExcept){
					
				}*/
			}
		}
	}
	
	public void clickRightPanelButtonByName(String buttonName) {
		//abro el panel lateral derecho (si esta cerrado)
		//try {
			//boton derecho para desplegar
			deployWestPanel();
		//}catch(NoSuchElementException noSuchElemExcept) {
			driver.switchTo().defaultContent();
			for(WebElement currentFrame : frames) {
				try {
					driver.switchTo().frame(currentFrame);

					driver.findElement(By.className("promotions-section-header"));//checks this is the panel's tab.

					System.out.println("Panel encontrado");
					break;
				}catch(NoSuchElementException noSuchElemExcept) {
					driver.switchTo().defaultContent();

				}
			}
		//}
		
			
		try {
			rightActionButtons = driver.findElements(By.className("startActions-item"));
			for(WebElement actBtn : rightActionButtons) {
				if (actBtn.getText().equals(buttonName)) {
					actBtn.click();
				}
			}
			
		}catch(NoSuchElementException noSuchElemExcept) {
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			for (WebElement currentFrame : frames) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(currentFrame);
				rightActionButtons = driver.findElements(By.className("startActions-item"));
				for(WebElement actBtn : rightActionButtons) {
					if (actBtn.getText().equals(buttonName)) {
						actBtn.click();
						break;
					}
				}
			}
		}catch(NullPointerException NPE) {
			if (rightActionButtons.size() == 0) {
				
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		try {
			rightActionButtons = driver.findElements(By.className("startActions-item"));
		}catch(NoSuchElementException noSuchElemExcept) {
			driver.switchTo().defaultContent();
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			for (WebElement currentFrame : frames) {
				driver.switchTo().frame(currentFrame);
				rightActionButtons = driver.findElements(By.className("startActions-item"));				
			}
		}
	}
	
	public void selectAccountByIndex(int accountIndex) {
		List<WebElement> accounts = getAccounts();
		accounts.get(accountIndex).findElements(By.tagName("a")).get(3).click();
	}
	
	public void selectAccountByName(String accountName) {
		//maybe the responsability of the page should only remain in accessing it's elements, and not assuring it can be done.
		try {
			accountsList = driver.findElements(By.className("x-grid3-row"));
		}catch(NoSuchElementException noSuchElemExcept0) {
			driver.switchTo().defaultContent();
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			for (WebElement currentFrame:frames) {
				try{
					driver.switchTo().frame(currentFrame);
					accountsList = driver.findElements(By.className("x-grid3-row"));
					break;
				}catch(NoSuchElementException noSuchElemExcept1) {
				}
			}
		}
		
		for (WebElement account : accountsList) {
			//The index for the account name is 2.
			WebElement currentAccountName = account.findElements(By.className("x-grid3-cell-inner")).get(2);
			if(currentAccountName.getText().equals(accountName)) {
				currentAccountName.findElement(By.tagName("a")).click();
			}
		}
	}
	
	public WebElement getServiceSelector() {
		driver.switchTo().defaultContent();
		for(WebElement currentFrame : frames) {
			System.out.println("nTry");
			try {
				driver.switchTo().frame(currentFrame);
				System.out.println(driver.findElement(By.id("LookupSelectofService")));
				inpSelectService = driver.findElement(By.id("LookupSelectofService"));//checks this is the panel's tab.
				System.out.println("Found.");
				return inpSelectService;
			}catch(NoSuchElementException noSuchElemExcept) {
				driver.switchTo().defaultContent();
			}
		}
		return inpSelectService;

	}
	
	
	public void clickContinueBtn() {
		for(WebElement button : driver.findElements(By.className("ng-binding"))) {
			if (button.getText().equals("Continuar")) {
				button.click();
				break;
			}
		}
	}
	
	/*public void selectTabByName(String tabName) {
		driver.switchTo().defaultContent();
		for (WebElement currentFrame : frames) {
			driver.switchTo().frame(currentFrame);
			try {
				
			}
			
		}
	}*/
	
}
