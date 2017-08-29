package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectCaseRegisterType extends BasePage {
	
	final WebDriver driver;
	WebElement continueBtn;

	public SelectCaseRegisterType(WebDriver driver){
		this.driver = driver;
		continueBtn = driver.findElement(By.xpath("//input[@name=\"save\" and @value=\"¿Desea continuar?\"]"));
	}

	public void continueToCreate() {
		continueBtn.click();
	}
	
}
