package Pages;
 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BasePage {
	
	final WebDriver driver;
	
	//Fields
	
	@FindBy (how = How.ID, using = "username")
	private WebElement username;
	
	@FindBy (how = How.ID, using = "password")
	private WebElement password;
	
	@FindBy (how = How.ID, using = "Login")
	private WebElement login;
	
	@FindBy (how = How.NAME, using = "rememberUn")
	private WebElement rememberMe;
	
	//Login de SCP 
	  
	  
	  @FindBy (how= How.NAME, using = "Ecom_User_ID")
	  private WebElement Ecom_User_ID;
	  
	  @FindBy (how= How.NAME, using = "Ecom_Password")
	  private WebElement Ecom_Password;
	  
	  @FindBy (how = How.ID, using = "loginButton2")
	  private WebElement loginButton2;
	
	//Constructor
	
	public Login(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	//Methods
	
	public void ingresar() {
		username.sendKeys("usit@telecom.sit");
		password.sendKeys("pruebas08");
    	//rememberMe.click();
		login.click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	//By: Almer
	  public void ingresarAdminSCP() {
	    Ecom_User_ID.sendKeys("u585991");
	    Ecom_Password.sendKeys("Testa10k");
	    loginButton2.click();
	    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	  }
	  
	  //By:Almer
	  public void ingresarUsuarioSCP() {
	    Ecom_User_ID.sendKeys("u585244");
	    Ecom_Password.sendKeys("Testa10k");
	    loginButton2.click();
	    try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	  }

}
