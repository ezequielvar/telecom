package Tests.Sales;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.login.Login;
import Pages.new_account.AccountType;
import Pages.new_account.NewAccount;

public class newAccount {
	
private WebDriver driver;

@BeforeMethod
public void setup() throws Exception {

	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pablo\\telecom\\Telecom\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    driver.get("https://test.salesforce.com/");
    Login page = new Login(driver);
    page.ingresar();
}

@Test
public void createNewAccount() {
	driver.findElement(By.name("new")).click();
	AccountType tipo = new AccountType(driver);
	tipo.setType("Consumer");
	NewAccount account = new NewAccount(driver);
	
}
	
}
