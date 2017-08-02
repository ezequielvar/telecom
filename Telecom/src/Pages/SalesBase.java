package Pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SalesBase extends BasePage {
	
final WebDriver driver;
	
	@FindBy (how = How.ID, using = "phSearchInput")
	private WebElement searchInput;
	
	@FindBy (how = How.ID, using = "phSearchButton")
	private WebElement searchButton;
	
	@FindBy (how = How.ID, using = "userNavButton")
	private WebElement userSIT;
	
	@FindBy (how = How.CSS, using = ".menuButtonMenuLink.firstMenuItem")
	private WebElement myProfile;
	
	@FindBy (how = How.CLASS_NAME, using = "menuButtonMenuLink")
	private List<WebElement> userSITOptions;
	
	@FindBy (how = How.CSS, using = ".debugLogLink.menuButtonMenuLink")
	private WebElement developerConsole;
	
	@FindBy (how = How.CLASS_NAME, using = "brandZeronaryFgr")
	private WebElement helpAndInformation;
	
	@FindBy (how = How.ID, using = "tsidButton")
	private WebElement sales;
	
	@FindBy (how = How.CSS, using = ".menuButtonMenuLink.firstMenuItem")
	private WebElement services;
	
	@FindBy (how = How.CLASS_NAME, using = "menuButtonMenuLink")
	private List<WebElement> salesOptions;
	
	@FindBy (how = How.ID, using = "home_Tab")
	private WebElement homeTab;
	
	@FindBy (how = How.ID, using = "Contact_Tab")
	private WebElement contactsTab;
	
	@FindBy (how = How.ID, using = "Account_Tab")
	private WebElement accountsTab;
	
	@FindBy (how = How.ID, using = "Lead_Tab")
	private WebElement candidatesTab;
	
	@FindBy (how = How.ID, using = "Opportunity_Tab")
	private WebElement opportunitiesTab;
	
	@FindBy (how = How.ID, using = "Forecasting3_Tab")
	private WebElement forecastsTab;
	
	@FindBy (how = How.ID, using = "report_Tab")
	private WebElement reportsTab;
	
	@FindBy (how = How.ID, using = "Dashboard_Tab")
	private WebElement dashboardsTab;
	
	@FindBy (how = How.ID, using = "Chatter_Tab")
	private WebElement chatterTab;
	
	@FindBy (how = How.ID, using = "File_Tab")
	private WebElement filesTab;
	
	@FindBy (how = How.ID, using = "Product2_Tab")
	private WebElement productsTab;
	
	@FindBy (how = How.ID, using = "Quote_Tab")
	private WebElement budgetsTab;
	
	@FindBy (how = How.ID, using = "Order_Tab")
	private WebElement ordersTab;
	
	@FindBy (how = How.ID, using = "01rc0000000DZDq_Tab")
	private WebElement userSITTab;
	
	@FindBy (how = How.CLASS_NAME, using = "allTabsArrow")
	private WebElement allTabs;
	
	@FindBy (how = How.ID, using = "createNewButton")
	private WebElement createNewButton;
	
	@FindBy (how = How.CSS, using = ".menuButtonMenuLink.firstMenuItem.eventMru")
	private WebElement event;
	
	@FindBy (how = How.CSS, using = ".taskMru.menuButtonMenuLink")
	private WebElement task;
	
	@FindBy (how = How.CSS, using = ".contactMru.menuButtonMenuLink")
	private WebElement contact;
	
	@FindBy (how = How.CSS, using = ".accountMru.menuButtonMenuLink")
	private WebElement account;
	
	@FindBy (how = How.CSS, using = ".leadMru.menuButtonMenuLink")
	private WebElement candidate;
	
	@FindBy (how = How.CSS, using = ".opportunityMru.menuButtonMenuLink")
	private WebElement opportunity;
	
	@FindBy (how = How.CSS, using = ".reportMru.menuButtonMenuLink")
	private WebElement report;
	
	@FindBy (how = How.CSS, using = ".menuButtonMenuLink.contentSearchMru")
	private WebElement file;
	
	@FindBy (how = How.CSS, using = ".productMru.menuButtonMenuLink")
	private WebElement product;
	
	@FindBy (how = How.CSS, using = ".quoteMru.menuButtonMenuLink")
	private WebElement budget;
	
	@FindBy (how = How.CLASS_NAME, using = "recycleText")
	private WebElement paperCan;
	
public SalesBase(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
}

public void goToOrdersTab() {
	ordersTab.click();
}

}
