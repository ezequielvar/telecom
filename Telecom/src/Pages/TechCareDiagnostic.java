package Pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Tests.TestBase;


public class TechCareDiagnostic extends BasePage  {

	final WebDriver driver;
	public TechCareDiagnostic(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
}
	//Case information
	
			@FindBy (how = How.CLASS_NAME, using = "x-grid3-row")
			private WebElement celdafile;
	
			@FindBy (how = How.XPATH, using = "//*[@id=\'00Bc0000001K9hz_rolodex\']/a[17]/span")
			private WebElement filterP;
	
			@FindBy (how = How.XPATH, using = "//*[@id=\'ext-gen11\']/div[1]/table/tbody/tr/td[9]")
			private WebElement celdavalue1;
			
			@FindBy (how = How.XPATH, using = "//*[@id=\'ext-gen11\']/div[2]/table/tbody/tr/td[9]")
			private WebElement celdavalue2; 
			
			@FindBy (how = How.XPATH, using = "//*[@id=\'00Nc0000001pWdh_selected\']")
			private WebElement listselect;
			
			@FindBy (how = How.XPATH, using = "//*[@id=\'00Nc0000001pWdh_unselected\']")
			private WebElement listunselect;
			
			@FindBy (how = How.CLASS_NAME, using = "picklistArrowLeft")
			private WebElement deselectvalue;
			
			@FindBy (how = How.CLASS_NAME, using = "picklistArrowRight")
			private WebElement selectvalue;
			
			@FindBy (how = How.XPATH, using = "//*[@id=\'saveButton\']")
			private WebElement save;
			
			
		//Pages
		public void selectpage(String module) {
			switch(module) {
			case "1":
			driver.get("https://cs14.salesforce.com/a3y?fcf=00Bc0000001LRmc");
			break;
			case "2":
				if (!driver.getCurrentUrl().toString().equals("https://cs14.salesforce.com/console")){
					driver.findElement(By.id("tsidLabel")).click();
					try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
					driver.findElement(By.xpath("//a[@href=\"/console?tsid=02uc0000000D6Hd\"]")).click();
				}
					waitFor(driver, (By.cssSelector(".x-border-panel")));		
					List<WebElement> mainTabs = driver.findElements(By.className("x-tab-strip-close"));
					for (WebElement e : mainTabs) {
							try {((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);} catch (org.openqa.selenium.StaleElementReferenceException b) {}
							}
					List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
					TestBase test = new TestBase();
					test.goToLeftPanel(driver, "Cuentas");
					WebElement frame0 = driver.findElement(By.tagName("iframe"));
					driver.switchTo().frame(frame0);
					waitFor(driver, (By.name("fcf")));	
					Select field = new Select(driver.findElement(By.name("fcf")));
					field.selectByVisibleText("Vista Tech");
			break;
			}
		}
		private void waitFor(WebDriver driver2, By by) {
			// TODO Auto-generated method stub
			
		}
		//Methods
		public void selectfile(String value) {
			Actions action = new Actions(driver);   
			filterP.click();
			switch(value) {
			case "1":
				try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
				action.moveToElement(celdavalue1).doubleClick().perform();
			case "2":
				try {Thread.sleep(2000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
				action.moveToElement(celdavalue2).doubleClick().perform();}
			
			}
			
			
		public void clearvalues() {
			Select dateDropDown=new Select(listselect);
			for(int i=0; i<=15; i++) {
			try {String b = Integer.toString(i);
			dateDropDown.selectByValue(b);
			deselectvalue.click();}catch (org.openqa.selenium.NoSuchElementException e){}}
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}}
		
		public void selectvalues(String value) {
			switch(value) {
			case "UP/UP":
				setSimpleDropdown(listunselect, value);
				break;
			case "UP/Down":
				setSimpleDropdown(listunselect, value);
				break;
			case "Down/Down":
				setSimpleDropdown(listunselect, value);
				break;
			case "Sin Sesión":
				setSimpleDropdown(listunselect, value);
				break;
			case " ":
				break;}
			selectvalue.click();
			save.click();}
		
		public void validvalue1(String value) {
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			switch(value) {
			case "UP-UP":
				Assert.assertEquals(celdavalue1.getText() ,value);
				break;
			case "UP-DOWN":
				Assert.assertEquals(celdavalue1.getText() ,value);
				break;
			case "DOWN-DOWN":
				Assert.assertEquals(celdavalue1.getText() ,value);
				break;
			case "Sin Sesion":
				Assert.assertEquals(celdavalue1.getText() ,value);
				break;
			case "":
				Assert.assertEquals(celdavalue1.getText() ,value);
				break;}
			}
		public void validvalue2(String value) {
			try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			switch(value) {
			case "UP-UP":
				Assert.assertEquals(celdavalue2.getText() ,value);
				break;
			case "UP-DOWN":
				Assert.assertEquals(celdavalue2.getText() ,value);
				break;
			case "DOWN-DOWN":
				Assert.assertEquals(celdavalue2.getText() ,value);
				break;
			case "Sin Sesion":
				Assert.assertEquals(celdavalue2.getText() ,value);
				break;
			case "":
				Assert.assertEquals(celdavalue2.getText() ,value);
				break;}
			}
		public void openrightpanel() {
			if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")).size() != 0) {
				driver.findElement(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")).click();
				}
		}
		
		public void selectaccounttech() {
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.navigate().refresh();
			WebElement frame4 = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(frame4);
			waitFor(driver, (By.xpath("//*[text() = 'Adrian Tech']")));	
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			List<WebElement> accounts = driver.findElements(By.xpath("//*[text() = 'Adrian Tech']"));
			accounts.get(0).click();
			driver.switchTo().defaultContent();
		}
			
		public void SelectGestion(String gestion) {
			List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
			driver.switchTo().frame(frame1.get(4));
			driver.findElement(By.cssSelector(".slds-text-body_regular.ta-button-font"));
			//driver.findElement(By.cssSelector(".slds-text-body_regular.ta-button-font"));
			
			List <WebElement> btns = driver.findElements(By.cssSelector(".slds-text-body_regular.ta-button-font"));
			/*Integer a = 0; 
			for (WebElement e: btns) {
				System.out.println(a);
				System.out.println(e.getText());
				a++;
			}*/
			switch (gestion){
			case "Actualizar Pago":
				btns.get(0).click();
				break;
			case "Pague su Factura":
				btns.get(1).click();
				break;
			case "Cambie su Dirección de Facturación":
				btns.get(2).click();
				break;
			case "Reporte Falla de Servicio":
				btns.get(3).click();
				break;
			case "Reporte Problema con Packs":
				btns.get(4).click();
				break;
			case "Añadir Familiar":
				btns.get(5).click();
				break;
			case "Ver Uso":
				btns.get(6).click();
				break;
			case "Actualización del servicio":
				btns.get(7).click();
				break;
			case "Asistencia Técnica":
				btns.get(8).click();
				break;
			case "Ver Prefactibilidad":
				btns.get(9).click();
				break;
			case "Nueva Venta":
				btns.get(10).click();
				break;
			case "Sugerencias":
				btns.get(11).click();
				break;
			case "Movimientos de cuenta de facturación":
				btns.get(12).click();
				break;
			case "Servicio Técnico":
				btns.get(13).click();
				break;
			case "Eventos Masivos":
				btns.get(14).click();
				break;
			case	"Detalle de Consumos":
				btns.get(15).click();
				break;
			case	"Cambios de condición impositiva":
				btns.get(16).click();
				break;
			case	"Cambio de ciclo":
				btns.get(17).click();
				break;
			case	"Knowledge":
				btns.get(18).click();
				break;
			}driver.switchTo().defaultContent();}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
