package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactSearch extends BasePage {
	
final WebDriver driver;
	
	@FindBy (how = How.ID, using = "DocumentType")
	private WebElement documentType;
	
	@FindBy (how = How.NAME, using = "loopname")
	private WebElement document;
	
	@FindBy (how = How.CSS, using = ".slds-radio--faux.ng-scope")
	private List<WebElement> gender;
	
	@FindBy (how = How.CLASS_NAME, using = "ng-binding")
	private WebElement next;
	
	@FindBy (how = How.CSS, using = ".vlc-slds-button--tertiary.ng-binding.ng-scope")
	private WebElement cancel;
	
public ContactSearch(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
}

public void searchContact(String docType, String docValue, String genero) {
	setSimpleDropdown(documentType, docType);
	document.sendKeys(docValue);
	switch(genero) {
	case "femenino":
		gender.get(0).click();
		break;
	case "masculino":
		gender.get(1).click();
		break;
	}
	next.click();
}

}
