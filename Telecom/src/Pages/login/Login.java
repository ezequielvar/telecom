package Pages.login;
 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Pages.Base.BasePage;

public class Login extends BasePage {
	
	final WebDriver driver;
	
	//Fields
	
	@FindBy (how = How.ID, using = "username")
	private WebElement username;
	
	@FindBy (how = How.ID, using = "password")
	private WebElement password;
	
	@FindBy (how = How.ID, using = "Login")
	private WebElement login;
	
	//Constructor
	
	public Login(WebDriver driver){
		
		this.driver = driver;
        PageFactory.initElements(driver, this);

    }
	
	//Methods
	
	public void ingresar() {
		username.sendKeys("usit@telecom.sit");
		password.sendKeys("pruebas07");
		login.click();
	}

}
