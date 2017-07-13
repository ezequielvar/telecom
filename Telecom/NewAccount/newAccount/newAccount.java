package newAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class newAccount extends mainPage {

	public WebElement copyBillingAddressToShipmentAddress(WebDriver driver) {
		WebElement element = driver.findElement(By.className("bodySmall"));
		return element;
	}
	
	//Account information
	
	public WebElement accountName(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc2"));
		return element;
	}
	
	public WebElement mainAccount(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc3"));
		return element;
	}
	
	public Select country(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("acc17country")));
		return select;
	}
	
	public WebElement street(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc17street"));
		return element;
	}
	
	public WebElement city(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc17city"));
		return element;
	}

	public Select state(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("acc17state")));
		return select;	
	}
	
	public WebElement zipCode(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc17zip"));
		return element;
	}
	
	public Select curstomerPriority(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSW8")));
		return select;	
	}
	
	public WebElement lastModifyEmailDate(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pWcg"));
		return element;
	}
	
	public WebElement contact(WebDriver driver) {
		WebElement element = driver.findElement(By.id("CF00Nc0000001pSW3"));
		return element;
	}
	
	public Select documentType(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("")));
		return select;		
	}
	
	public WebElement documentNumber(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pWcd"));
		return element;
	}
	
	public WebElement primaryContactName(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pWck"));
		return element;
	}
	
	public Select taxCondition(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("")));
		return select;		
	}
	
	public WebElement billingAddressStore(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pWcc"));
		return element;
	}
	
	public WebElement shippingAddressStore(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pWcm"));
		return element;
	}
	
	public Select status(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSW6")));
		return select;		
	}
	
	public Select sla(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSWB")));
		return select;		
	}
	
	public Select shipmentCountry(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("acc18country")));
		return select;		
	}
	
	public WebElement shipmentStreet(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc18street"));
		return element;
	}
	
	public WebElement shipmentCity(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc18city"));
		return element;
	}
	
	public Select shipmentState(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("acc18state")));
		return select;	
	}
	
	public WebElement shipmentZipCode(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc18zip"));
		return element;
	}
	
	public WebElement phone(WebDriver driver) {
		WebElement element = driver.findElement(By.id("acc10"));
		return element;
	}
	
	public WebElement premises(WebDriver driver) {
		WebElement element = driver.findElement(By.id("CF00Nc0000001pSW2"));
		return element;
	}
	
	//TA Custom Fields
	
	public WebElement personalClubPoints(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pWcj"));
		return element;
	}
	
	public Select nps(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("")));
		return select;		
	}
	
	public WebElement fol(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pWcf"));
		return element;
	}
	
	public Select personalClubCategory(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("")));
		return select;		
	}
	
	public Select segment(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("")));
		return select;		
	}
	
	//Billing Profile

	public Select billFrequency(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSVi")));
		return select;		
	}
	
	public Select accountPaymentType(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSVc")));
		return select;		
	}
	
	public WebElement enableAutopay(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pSVu"));
		return element;
	}
	
	public Select billDeliveryMethod(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSVh")));
		return select;		
	}
	
	public WebElement billingEmailAddress(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pSVj"));
		return element;
	}
	
	public WebElement autoPaymentMethod(WebDriver driver) {
		WebElement element = driver.findElement(By.id("CF00Nc0000001pSVg"));
		return element;
	}
	
	public Select autopaymentAmount(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSVe")));
		return select;	
	}
	
	//Contact Preferences

	public Select contactPreferences(WebDriver driver) {
		Select select = new Select(driver.findElement(By.id("00Nc0000001pSVn_unselected")));
		return select;	
	}
	
	//Directory Listing

	public WebElement directoryListed(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pSVq"));
		return element;
	}
	
	//Loyalty
	
	public WebElement cltv(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pSVk"));
		return element;
	}
	
	public WebElement churn(WebDriver driver) {
		WebElement element = driver.findElement(By.id("00Nc0000001pSVm"));
		return element;
	}
	
	//Save, Save and new, Cancel
	
	public WebElement save(WebDriver driver) {
		WebElement element = driver.findElement(By.name("save"));
		return element;
	}
	
	public WebElement save_new(WebDriver driver) {
		WebElement element = driver.findElement(By.name("save_new"));
		return element;
	}
	
	public WebElement cancel(WebDriver driver) {
		WebElement element = driver.findElement(By.name("cancel"));
		return element;
	}
	
	//Methods
	
	
	
	
	
	
	
	
	
}
