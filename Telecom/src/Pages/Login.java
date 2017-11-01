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
		logininterno.click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		username.sendKeys("u589831");
		password.sendKeys("Testa10k");
    	//rememberMe.click();
		login.click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}

	public void ingresarAdminSCP() {
	     Ecom_User_ID.sendKeys("u585991");
	     Ecom_Password.sendKeys("Testa10k");
	     loginButton2.click();
	     try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	   }
	   
	  
	   public void ingresarUsuarioSCP() {
	     Ecom_User_ID.sendKeys("u585244");
	     Ecom_Password.sendKeys("Testa10k");
	     loginButton2.click();
	     try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	   }
	 
	   //Para el Modulo Sales tiene vinculado el perfil de Agente y Atenci�n a clientes
		public void ingresarAndres() {
			  logininterno.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			  Ecom_User_ID.sendKeys("u590422");
			  Ecom_Password.sendKeys("Testa10k");
			  loginButton2.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			 }
		
		//Para el Modulo Sales tiene vinculado el perfil de Call center
		public void ingresarElena() {
			  logininterno.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			  Ecom_User_ID.sendKeys("u580714");
			  Ecom_Password.sendKeys("Testa10k");
			  loginButton2.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			 }
		
		//Para el Modulo Sales tiene vinculado el perfil de Vendedor Oficina Comercial
		public void ingresarFrancisco() {
			  logininterno.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			  Ecom_User_ID.sendKeys("u581441");
			  Ecom_Password.sendKeys("Testa10k");
			  loginButton2.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			 }
		
		//Para el Modulo Sales tiene vinculado el perfil de Logistica
		public void ingresarNicolas() {
			  logininterno.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			  Ecom_User_ID.sendKeys("u586760");
			  Ecom_Password.sendKeys("Testa10k");
			  loginButton2.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			 }
		
		//Para el Modulo Sales tiene vinculado el perfil de Entregas y Configuraciones
		public void ingresarMarcela() {
			  logininterno.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			  Ecom_User_ID.sendKeys("u591584");
			  Ecom_Password.sendKeys("Testa10k");
			  loginButton2.click();
			  try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			 }
		
}
