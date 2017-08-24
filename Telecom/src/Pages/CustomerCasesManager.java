package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CustomerCasesManager {

final WebDriver driver;

//Case information
	public CustomerCasesManager(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (how = How.CSS, using = "div.x-grid3-row")
	private List<WebElement> casos;
	
	@FindBy (how = How.ID, using = "phSearchInput")
	private WebElement searcher;
	
	public WebElement getCase(String numeroCaso) {
		System.out.println(casos);
		for (WebElement caso : casos) {
			System.out.println(caso.getText());
			System.out.println(caso.findElement(By.xpath("//div[@id=CASES_CASE_NUMBER]")).findElement(By.tagName("a")).getText());
			if (caso.findElement(By.xpath("//div[@id=CASES_CASE_NUMBER]")).findElement(By.tagName("a")).getText().equals(numeroCaso)) {
				return caso;
			}
		}
		return casos.get(0);
	}
	
	//returns the first search Result
	public WebElement getSearchResult(String search) {
		driver.findElement(By.id("searchBoxClearContainer")).click();
		searcher.sendKeys("00001121");
		return driver.findElement(By.className("autocompleteMatch"));
	}
	
	
}
