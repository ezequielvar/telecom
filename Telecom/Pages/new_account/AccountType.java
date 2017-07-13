package new_account;
import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountType extends BasePage {
	
	final WebDriver driver;
	
	@FindBy (how = How.ID, using = "p3")
	private WebElement selectType;
	
	@FindBy (how = How.NAME, using = "save")
	private WebElement doYouWishToContinue;
	
	@FindBy (how = How.NAME, using = "cancel")
	private WebElement cancel;
	
	//Methods
	
	public AccountType(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, AccountType.class);
	}
	
	public void setType(WebDriver driver, String value) {
		setCombo(selectType, value);
		doYouWishToContinue.click();
	}
	
}
