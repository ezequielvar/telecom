package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Accounts extends BasePage {
	final WebDriver driver;
	
	@FindBy (how = How.CLASS_NAME, using = "listItemPad")
	private List<WebElement> abcFilters;
	
	@FindBy (how = How.XPATH, using = "//*[@id=\"001c000001C2CqJ_ACCOUNT_NAME\"]/a")
	private WebElement firstAccount;
	
	//Methods
	
	public Accounts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnV() {
		abcFilters.get(22).click();
	}
	
	public void clickOnFirstAccount() {
		firstAccount.click();
	}
	
}
