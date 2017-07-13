package Sales;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class newAccount {
	
private WebDriver driver;

@BeforeMethod
public void setup() throws Exception {
	System.out.println(driver.getCurrentUrl());
	if (driver.getCurrentUrl() == null) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pablo\\telecom\\Telecom\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
    driver.get("www.google.com");
	}
}

@Test
public void createNewAccount() {
	
}
	
}
