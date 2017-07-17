package Pages.new_account;


import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Pages.Base.BasePage;


public class NewAccount extends BasePage {
	
	final WebDriver driver;
		
	@FindBy (how = How.CLASS_NAME, using = "bodySmall")
	private WebElement copyBillingAddressToShipmentAddress;
	
	//Account information
	
	@FindBy (how = How.ID, using = "accountName")
	private WebElement accountName;
	
	@FindBy (how = How.ID, using = "acc3")
	private WebElement mainAccount;
	
	@FindBy (how = How.ID, using = "acc17country")
	private WebElement country;

	@FindBy (how = How.ID, using = "acc17street")
	private WebElement street;
	
	@FindBy (how = How.ID, using = "acc17city")
	private WebElement city;
	
	@FindBy (how = How.ID, using = "acc17state")
	private WebElement state;
	
	@FindBy (how = How.ID, using = "acc17zip")
	private WebElement zipCode;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSW8")
	private WebElement curstomerPriority;
	
	@FindBy (how = How.ID, using = "00Nc0000001pWcg")
	private WebElement lastModifyEmailDate;
	
	@FindBy (how = How.ID, using = "CF00Nc0000001pSW3")
	private WebElement contact;
	
//	@FindBy (how = How.ID, using = "")
//	private WebElement documentType;
	
	@FindBy (how = How.ID, using = "00Nc0000001pWcd")
	private WebElement documentNumber;
	
	@FindBy (how = How.ID, using = "00Nc0000001pWck")
	private WebElement primaryContactName;
	
//	@FindBy (how = How.ID, using = "")
//	private WebElement taxCondition;
	
	@FindBy (how = How.ID, using = "00Nc0000001pWcc")
	private WebElement billingAddressStore;
	
	@FindBy (how = How.ID, using = "00Nc0000001pWcm")
	private WebElement shippingAddressStore;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSW6")
	private WebElement status;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSWB")
	private WebElement sla;
	
	@FindBy (how = How.ID, using = "acc18country")
	private WebElement shipmentCountry;
	
	@FindBy (how = How.ID, using = "acc18street")
	private WebElement shipmentStreet;
	
	@FindBy (how = How.ID, using = "acc18city")
	private WebElement shipmentCity;
	
	@FindBy (how = How.ID, using = "acc18state")
	private WebElement shipmentState;
	
	@FindBy (how = How.ID, using = "acc18zip")
	private WebElement shipmentZipCode;
	
	@FindBy (how = How.ID, using = "acc10")
	private WebElement phone;
	
	@FindBy (how = How.ID, using = "CF00Nc0000001pSW2")
	private WebElement premises;
	
	//TA Custom Fields
	
	@FindBy (how = How.ID, using = "00Nc0000001pWcj")
	private WebElement personalClubPoints;
	
//	@FindBy (how = How.ID, using = "")
//	private WebElement nps;
	
	@FindBy (how = How.ID, using = "00Nc0000001pWcf")
	private WebElement fol;
	
//	@FindBy (how = How.ID, using = "")
//	private WebElement personalClubCategory;
	
//	@FindBy (how = How.ID, using = "")
//	private WebElement segment;
	
	//Billing Profile

	@FindBy (how = How.ID, using = "00Nc0000001pSVi")
	private WebElement billFrequency;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSVc")
	private WebElement accountPaymentType;

	@FindBy (how = How.ID, using = "00Nc0000001pSVu")
	private WebElement enableAutopay;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSVh")
	private WebElement billDeliveryMethod;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSVj")
	private WebElement billingEmailAddress;
	
	@FindBy (how = How.ID, using = "CF00Nc0000001pSVg")
	private WebElement autoPaymentMethod;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSVe")
	private WebElement autopaymentAmount;
	
	//Contact Preferences

	@FindBy (how = How.ID, using = "00Nc0000001pSVn_unselected")
	private WebElement contactPreferences;
	
	//Directory Listing

	@FindBy (how = How.ID, using = "00Nc0000001pSVq")
	private WebElement directoryListed;
	
	//Loyalty
	
	@FindBy (how = How.ID, using = "00Nc0000001pSVk")
	private WebElement cltv;
	
	@FindBy (how = How.ID, using = "00Nc0000001pSVm")
	private WebElement churn;
	
	//Save, Save and new, Cancel
	
	@FindBy (how = How.NAME, using = "save")
	private WebElement save;
	
	@FindBy (how = How.NAME, using = "save_new")
	private WebElement save_new;
	
	@FindBy (how = How.NAME, using = "cancel")
	private WebElement cancel;
	
	//Methods
	
	public NewAccount(WebDriver driver){
		
		this.driver = driver;

        PageFactory.initElements(driver, this);

    }
	
	public void createNewAcc(String name) {
		accountName.sendKeys(name);
	}
	
	
	
	
	
	
	
}
