package Pages;


import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewContactMotive extends BasePage{
	
	WebDriver driver;
	
	@FindBy (how = How.ID, using ="Name")
	private WebElement contactMotiveName; //input.
	
	@FindBy (how = How.ID , using ="00Nc0000001pWdl")
	private WebElement descripcion; //input. id doesnt change.
	
	@FindBy (how = How.ID , using ="00Nc0000001pWdn")
	private WebElement activo; //check. id doesnt change.
	
	@FindBy (how = How.ID , using ="00Nc0000001pWdp")
	private WebElement asociableAIncidente; //check. id doesnt change.	
	
	@FindBy (how = How.ID , using ="CF00Nc000000247mX")
	private WebElement servicio; //input. id doesnt change.

	@FindBy (how = How.NAME , using ="save")
	private WebElement saveBtn; //button. id doesnt change.
	
	public NewContactMotive(WebDriver driver){
		this.driver = driver;
		driver.switchTo().defaultContent();//this is in mainPage, so no iframes.
        PageFactory.initElements(driver, this);
	}
/*	
	public WebElement getFrame() {//frame
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		for (WebElement currentFrame : frames) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(currentFrame);
			try {
				contactMotiveName.getText();//confirms that this element exists in this frame.
				System.out.println(contactMotiveName.getText());
				return currentFrame;
			}catch(NoSuchElementException noSuchElemExcept){
				System.out.println("Exception here!");
			}
		}
		return null;
	}*/
	
	public WebElement getContactMotiveName() {
		return driver.findElement(By.id("Name"));
	}

	public WebElement getDescripcion() {
		return descripcion;
	}
	
	public WebElement getActivoCheck() {
		return activo;
	}
	
	public WebElement getAsociableAIncidente() {
		return asociableAIncidente;
	}
	
	public WebElement getServicio() {
		return servicio;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void save() {
		saveBtn.click();
	}
}
