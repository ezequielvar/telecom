package Pages;
 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BasePage {
	
	final WebDriver driver;
	
	//Fields
	
	@FindBy (how = How.NAME, using = "Ecom_User_ID")
	private WebElement username;
	
	@FindBy (how = How.NAME, using = "Ecom_Password")
	private WebElement password;

	@FindBy (how = How.ID, using = "loginButton2")
	private WebElement login;
	
	@FindBy (how = How.NAME, using = "rememberUn")
	private WebElement rememberMe;
	
	@FindBy(how = How.ID, using = "idp_section_buttons")
	private WebElement logininterno;
	
	//Constructor
	
	public Login(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	//Methods
	
	public void ingresar() {
		logininterno.click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		username.sendKeys("u589831");
		password.sendKeys("Testa10k");
    	//rememberMe.click();
		login.click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

}
