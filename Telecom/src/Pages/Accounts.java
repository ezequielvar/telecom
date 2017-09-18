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

	@FindBy (how = How.ID, using = "SelectServiceStep_nextBtn")
	private WebElement serviceSelectedContinue; //button

	@FindBy (how = How.ID, using = "SelectMotiveDiagnosis_nextBtn")
	private WebElement motiveSelectedContinue; //button	
	
	@FindBy (how = How.ID, using = "RemoteActionInternet")
	private WebElement executeDiagnosisBtn; //button
	
	//Tab Servicio Tecnico
	@FindBy (how = How.ID, using = "ImeiInput_nextBtn")
	private WebElement imeiInputNextBtn; //button
	
	@FindBy (how = How.ID, using = "ClientInformation_nextBtn")
	private WebElement clientInfoNextBtn; //button	
	
	@FindBy (how = How.ID, using = "SelectOperationType")
	private WebElement selectOperationType; //selector
	
	@FindBy (how = How.ID, using = "SelectSymptomType")
	private WebElement selectSymptomType; //selector
	
	//Methods
	
	public Accounts(WebDriver driver) {
		this.driver = driver;
		driver.switchTo().defaultContent();
		frames = driver.findElements(By.tagName("iframe"));
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

	public void clickOnLetter(String letter) {
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		//try {
			for(WebElement frame : frames) {
				driver.switchTo().frame(frame);
				if(!abcFilters.isEmpty()) {
					getElementFromList(abcFilters, letter).click();
					break;
				}
			}
		//}catch(){}
	}
	
	public void clickOnFirstAccount() {
		firstAccount.click();
	}

	public void accountSelect(String cuentaBuscar) {
		//String regexSelector = "\\w+listSelect\\b";
		accountSelect = new Select(driver.findElement(By.tagName("select")));
		accountSelect.selectByVisibleText(cuentaBuscar);
	}
	
	public void deployEastPanel() {
		driver.switchTo().defaultContent();
		try {
			driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")).click();
			try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		}catch(NoSuchElementException noSuchElemExcept){
		}
	}
	
	public void clickRightPanelButtonByName(String buttonName) {
		//abro el panel lateral derecho (si esta cerrado)
		deployEastPanel();
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		driver.switchTo().defaultContent();
		List<WebElement> frames2 = driver.findElements(By.tagName("iframe"));
		for (int i=0; i < frames2.size();i++) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(frames2.get(i));
			try {
				driver.findElement(By.className("startActions-item")).getText();//checks this is the panel's tab.
				break;
			}catch(NoSuchElementException noElemExcept) {
				//System.out.println("Buttons Not Found");
			}
		}
		try {
			rightActionButtons = driver.findElements(By.className("startActions-item"));
			//System.out.println(rightActionButtons.size());
			for(WebElement actBtn : rightActionButtons) {
				if (actBtn.getText().equals(buttonName)) {
					actBtn.findElement(By.tagName("button")).click();
				}
			}
		}catch(NoSuchElementException noSuchElemExcept) {
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			for (WebElement currentFrame : frames) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(currentFrame);
				rightActionButtons = driver.findElements(By.className("startActions-item"));
				for(WebElement actBtn : rightActionButtons) {
					if (actBtn.getText().toLowerCase().equals(buttonName.toLowerCase())) {
						actBtn.click();
						break;
					}
				}
			}
		}
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
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
			for (WebElement currentFrame : frames) {
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
			try {
				//WebElement inputSelect = driver.findElement(By.cssSelector(".slds-input.ng-pristine.ng-untouched.ng-empty.ng-valid-validate-val-lookup.ng-invalid.ng-invalid-required"));
				//WebElement inputSelect = driver.findElement(By.id("LookupSelectofService"));
				WebElement inputSelect = driver.findElement(By.cssSelector(".slds-form-element__label.ng-binding"));
				//System.out.println("Found.");
				return inputSelect;//TODO: Get Input
			}catch(NoSuchElementException noSuchElemExcept) {
				System.out.println("Select not found.");
				driver.switchTo().defaultContent();
				driver.switchTo().frame(currentFrame);
			}
		}
		WebElement inputSelect = null;
		return inputSelect;
	}
	
	public void clickContinueBtn() {
		for(WebElement button : driver.findElements(By.className("ng-binding"))) {
			if (button.getText().equals("Continuar")) {
				button.click();
				break;
			}
		}
	}
	
	public void continueFromService() {
		serviceSelectedContinue.click();
	}
	
	public void continueFromMotive() {
		motiveSelectedContinue.click();
	}
	
	public boolean isExecuteButtonPresent() {
		try {
			executeDiagnosisBtn.isDisplayed();
			return true;
		}catch(NoSuchElementException noSuchElemExcept) {
			return false;
		}
	}
	
	public void executeInternetDiagnosis() {
		executeDiagnosisBtn.click();
	}

	public boolean isTextInTogglersPresent(String textToFind) {
		driver.switchTo().defaultContent();
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		List<WebElement> togglers = driver.findElements(By.className("slds-form-element__label--toggleText"));
		
		for(WebElement frame : frames) {
			driver.switchTo().frame(frame);
			togglers = driver.findElements(By.className("slds-form-element__label--toggleText"));
			if(togglers.size() > 3) {
				break;
			}
			driver.switchTo().defaultContent();
		}
		
		for (WebElement toggle : togglers) {
			if (toggle.getText().toLowerCase().contains(textToFind.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isTabOpened(String tabName) {
		//account must be opened
		//2nd x-tab-strip-wrap is the wrapper for : Detalles, Servicios, Facturacion, etc.
		driver.switchTo().frame(getFrameForElement(driver, driver.findElement(By.className("x-tab-strip-wrap"))));
		WebElement tabWrapper = driver.findElements(By.className("x-tab-strip-wrap")).get(1);
		List<WebElement> tabsNames = tabWrapper.findElements(By.id("ext-comp-1009__"));
		for(WebElement tab : tabsNames){
			if(tab.findElement(By.className("tabText")).getText().equals(tabName)) {
				return true;
			}
		}
		return false;
	}
	
	public void goToTab(String tabName) {
		driver.switchTo().frame(getFrameForElement(driver, driver.findElement(By.className("x-tab-strip-wrap"))));
		WebElement tabWrapper = driver.findElements(By.className("x-tab-strip-wrap")).get(1);
		List<WebElement> tabsNames = tabWrapper.findElements(By.id("ext-comp-1009__"));
		for(WebElement tab : tabsNames){
			if(tab.findElement(By.className("tabText")).getText().equals(tabName)) {
				tab.click();
				break;
			}
		}
	}
	
	//Servicio Tecnico Methods
	
	public void fillIMEI(String IMEI) {
		WebElement imeiId = driver.findElement(By.id("ImeiCode"));
		driver.switchTo().frame(getFrameForElement(driver, imeiId));
		imeiId.sendKeys(IMEI);
	}
	
	public void continueFromImeiInput() {
		driver.switchTo().frame(getFrameForElement(driver, imeiInputNextBtn));
		imeiInputNextBtn.click();
	}

	public void continueFromClientInfo() {
		driver.switchTo().frame(getFrameForElement(driver, clientInfoNextBtn));
		clientInfoNextBtn.click();
	}
	
	public void selectOperationType(String operationName) {
		setSimpleDropdown(selectOperationType, operationName);
	}
	
	public void selectSymptomType(String symptomName) {
		setSimpleDropdown(selectSymptomType, symptomName);
	}
	
	public void attachFile(String filePath) {
		//TODO: Complete with sendkeys
		//example in validationByDni
		//driver.findElement(By.id("FileDocumentImage")).sendKeys("C:\\Users\\Sofia Chardin\\Downloads\\0F6.gif");
	}
	
}
