package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrdersTab extends SalesBase{
	
	final WebDriver driver;
	
	@FindBy (how = How.CSS, using = ".dataCell..")
	private List<WebElement> recentOrders;
	
public OrdersTab(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);	
}
	
	public void goToRecentOrder() {
		recentOrders.get(0).click();
	}

}
