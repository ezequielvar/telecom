package Pages;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import Tests.TestBase;

public class CustomerCare extends BasePage {

	final WebDriver driver;
	public CustomerCare(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
}
	
	
	
	//Case information
	
	@FindBy (how = How.CSS, using = ".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")
	private WebElement panelder;
	
	@FindBy (how = How.CSS, using = ".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")
	private WebElement panelizq;
	
	@FindBy (how = How.CSS, using = ".slds-text-body_regular.spacer.acct-spacer")
	private WebElement paneldatospersonaleson;
	
	@FindBy (how = How.CSS, using = ".acct-info.ng-hide")
	private WebElement paneldatospersonalesoff;
	
	@FindBy (how = How.CSS, using = ".slds-p-right--x-small.via-slds-story-cards--header-title")
	private WebElement ultimasgestioneson;
	
	@FindBy (how = How.CLASS_NAME, using = "ng-hide")
	private WebElement ultimasgestonesoff;
	
	@FindBy (how =How.CLASS_NAME, using = "sidebar-actions-header")
	private WebElement iniciargestionespanel;
	
	@FindBy(how = How.CLASS_NAME, using = "promotions-section-header")
	private WebElement promocionespanel;
	
	@FindBy (how = How.CLASS_NAME, using = "abandoned-section")
	private WebElement gestionesabandonadaspanel;
	
	@FindBy (how = How.CLASS_NAME, using = "profile-box")
	private WebElement datoscomerciales;
	
	@FindBy (how = How.ID, using = "text-input-01")
	private WebElement picklistperfil;
	
	@FindBy (how = How.CSS, using = ".slds-button.slds-button--neutral.profile-tags-btn")
	private WebElement btnsperfil;
	
	@FindBy(how = How.XPATH, using = "//input[@id='phSearchInput']")
	private WebElement buscador;
	
	@FindBy(how = How.ID, using = "00Nc0000001pSW6_ileinner")
	private WebElement editstatus;
	
	@FindBy(how = How.ID, using= "00Nc0000001pSW6")
	private WebElement listeditstatus;
	
	@FindBy(how = How.ID, using= "00Nc0000001pSVd_ileinner")
	private WebElement editstatus2;
	
	@FindBy(how = How.ID, using= "00Nc0000001pSVd")
	private WebElement listeditstatus2;
	
	@FindBy(how = How.ID, using= "00Nc0000001iLaY_ileinner")
	private WebElement editfraude;
	
	@FindBy(how = How.XPATH, using= "//*[@id=\'00Nc0000001iLaY\']")
	private WebElement checkfraude;
	
	@FindBy(how= How.XPATH, using= "//*[@id=\'topButtonRow\']/input[1]")
	private WebElement editsave;
	
	@FindBy(how=How.CSS, using= ".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")
	private WebElement buscargestion;
	

	
	//method
	public void goToLeftPanel(WebDriver driver, String selection) {
		WebElement element = driver.findElement(By.className("x-btn-split"));
		Actions builder = new Actions(driver);   
		builder.moveToElement(element, 245, 20).click().build().perform();
		switch(selection) {
		case "Cuentas":
		driver.findElement(By.id("nav-tab-0")).click();
		break;
		case "Casos":
			driver.findElement(By.id("nav-tab-9")).click();
			break;
		}
	}
	public void obligarclick(WebElement element) {
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
	    element.click();
	}
	
	public void elegircaso() {
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		goToLeftPanel(driver, "Casos");
		driver.switchTo().defaultContent();
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Mis Casos");		
	}
	
	public void elegircuenta(String cuenta) {
		goToLeftPanel(driver, "Cuentas");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Todas Las cuentas");		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accounts2 = driver.findElements(By.xpath("//*[text() ='"+cuenta+"']"));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		accounts2.get(0).click();
		accounts2.get(0).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
	
	}
	public void openrightpanel() {
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-east.x-layout-cmini-east")).size() != 0) {
			panelder.click();
			}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

	}
	
	public void openleftpanel() {
		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-collapsed.x-layout-collapsed-west.x-layout-cmini-west")).size() != 0) {
			panelizq.click();
			}
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(5));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

	}
	public void closeleftpanel() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-mini.x-layout-mini-west.x-layout-mini-custom-logo")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-mini.x-layout-mini-west.x-layout-mini-custom-logo")).click();
			driver.findElement(By.cssSelector(".x-layout-mini.x-layout-mini-west.x-layout-mini-custom-logo")).click();
			}
	}
	
	public void closerightpanel() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		if(driver.findElements(By.cssSelector(".x-layout-mini.x-layout-mini-east.x-layout-mini-custom-logo")).size() != 0) {
			driver.findElement(By.cssSelector(".x-layout-mini.x-layout-mini-east.x-layout-mini-custom-logo")).click();
			}
	}
	public void leftpanel() {
		List <WebElement> btns = driver.findElements(By.className("ext-webkit ext-chrome"));
	System.out.println(btns.size());
	
	}
	
	public void GestionAbandonadapanel() {
		driver.findElement(By.className("abandoned-section")).click();
	}
	
	
	public void panelizq(String panel) {
		List <WebElement> asd = driver.findElements(By.cssSelector(".slds-p-right--x-small.via-slds-story-cards--header-title"));	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

		switch(panel) {
		case "todosOFF":
			paneldatospersonaleson.click();
			asd.get(1).click();
			break;
		case "todosON":
			paneldatospersonaleson.click();
			asd.get(0).click();
			asd.get(1).click();
			break;
		case "perfil":
			asd.get(0).click();
			break;
			}		
	}

	public void verificacrhideleft(String panel) {
		List <WebElement> hides = driver.findElements(By.className("ng-hide"));
		switch(panel) {
		//validacionesindividuales
		case "datospersonales":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
		case "perfil":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
		case "ultimasgestiones":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
			////
		case "todosOFF":
			Assert.assertTrue(hides.get(0).isEnabled());
			Assert.assertTrue(hides.get(1).isEnabled());
			Assert.assertTrue(hides.get(2).isEnabled());
			break;
		case "todosON":
			List <WebElement> hides2 = driver.findElements(By.className("ng-hide"));
			if (hides2.size()!=0)
				Assert.assertTrue(true);
			break;
		}
	}
	
	public void panelder(String panel) {
		
		switch(panel) {
		
		case "iniciargestiones":
			iniciargestionespanel.click();
			break;
		case "promociones":
			promocionespanel.click();
			break;
		case "gestionesabandonadas":
			gestionesabandonadaspanel.click();
			break;
		case "todos":
			iniciargestionespanel.click();
			promocionespanel.click();
			gestionesabandonadaspanel.click();
			break;
		}
	}
	
	public void verificarhideright(String panel) {
		List <WebElement> hides = driver.findElements(By.className("ng-hide"));
		switch(panel) {
		case "iniciargestiones":
			Assert.assertTrue(driver.findElement(By.cssSelector(".actions-content.ng-hide")).isEnabled());
			break;
		case "promociones":
			Assert.assertTrue(hides.get(0).isEnabled());
			break;
		case "gestionesabandonadas":
			Assert.assertTrue(driver.findElement(By.cssSelector(".abandoned-content.ng-hide")).isEnabled());
			break;
		case "todosOFF":
			Assert.assertTrue(driver.findElement(By.cssSelector(".actions-content.ng-hide")).isEnabled());
			Assert.assertTrue(hides.get(0).isEnabled());
			Assert.assertTrue(driver.findElement(By.cssSelector(".abandoned-content.ng-hide")).isEnabled());
			break;
		case "todosON":
			List <WebElement> hides2 = driver.findElements(By.className("ng-hide"));
			if (hides2.size()!=0)
				Assert.assertTrue(true);
			if (driver.findElements(By.cssSelector(".actions-content.ng-hide")).size()!=0)
				Assert.assertTrue(true);
			if (driver.findElements(By.cssSelector(".abandoned-content.ng-hide")).size()!=0)
				Assert.assertTrue(true);
		}
	}
	
	public void verificarnohidedatoscomerciales() {
		Assert.assertTrue(datoscomerciales.isEnabled());
	}
	public void verificaciondebotonesdegestion() {
		List <WebElement> btns = driver.findElements(By.cssSelector(".slds-text-body_regular.ta-button-font"));
		for(int i=0; i < 22; i++){
			btns.get(i).isEnabled();}
		Assert.assertEquals(btns.size(),22);	
	}
	
	public void verificarpicklist() {
		picklistperfil.isEnabled();
	}
	public void funcionamientopicklist() {
		List <WebElement> asl = driver.findElements(By.cssSelector(".slds-lookup__item-action.slds-lookup__item-action--label.customer-story-label"));
			for(int i=0; i<6; i++){
				picklistperfil.click();
		asl.get(i).click();
			
		}
	}
	
	public void validarbtnsperfil(String btn) {
		
		List <WebElement> asl = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.profile-tags-btn"));
		System.out.println(asl.size());
		switch (btn) {
		case "Preocupaciones":
			asl.get(0).isEnabled();
			break;
		case "Productos de interes":
			asl.get(1).isEnabled();
			break;
		case "Criterios de compra":
			asl.get(2).isEnabled();
			break;
		case "Familia":
			asl.get(3).isEnabled();
			break;
		case "Intereses Personales":
			asl.get(4).isEnabled();
			break;
		}
	}
	
	public void comparaciondefechas() throws ParseException {
		List<String> expected = new ArrayList<String>();
		List<WebElement> profileinfo = driver.findElements(By.className("story-field"));	
		for(int i=1; i<profileinfo.size(); i+=2){
			String b = (profileinfo.get(i).getText());	
			expected.add(b);
		}
		String d1 = expected.get(0);
		String d2 = expected.get(1);
		System.out.println(d1);
		System.out.println(d2);
		d1.compareTo(d2);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse(d1);
        Date date2 = sdf.parse(d2);

        System.out.println("date1 : " + sdf.format(date1));
        System.out.println("date2 : " + sdf.format(date2));

        if (date1.compareTo(date2) > 0) {
            System.out.println("Date1 despues Date2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 antes Date2");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 igual Date2");
        } else {
            System.out.println("How to get here?");
        }

    }
	
	public void usarpanelcentral(String pestaña) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		switch(pestaña){
		case "Detalles":
			driver.findElement(By.xpath("//*[text() ='Detalles']")).click();
			driver.findElement(By.cssSelector(".x-tab-right.primaryPalette")).click();
			break;
		case "Servicios":
			driver.findElement(By.xpath("//*[text() ='Servicios']")).click();
			driver.findElement(By.xpath("//*[text() ='Servicios']")).click();

			break;
		case "Facturacion":
			driver.findElement(By.xpath("//*[text() ='Facturacion']")).click();
			driver.findElement(By.xpath("//*[text() ='Facturacion']")).click();

			break;
		case "Cambio de ciclo":
			driver.findElement(By.xpath("//*[text() ='Cambio de ciclo']")).click();
			driver.findElement(By.xpath("//*[text() ='Cambio de ciclo']")).click();

			break;
		}
		
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(1));
	}
	
	public void validarstatus(String status) {
		driver.findElement(By.xpath("//*[@id=\'00Nc0000001pSW6_ileinner\']"));
		
	List <WebElement> asl = driver.findElements(By.xpath("//*[@id=\'00Nc0000001pSW6_ileinner\']"));
	switch(status) {
	case "Active":
		Assert.assertEquals(asl.get(0).getText(), status);	
		break;
	case "Inactive":
		Assert.assertEquals(asl.get(0).getText(), status);	
		break;	
	case "Expired":
		Assert.assertEquals(asl.get(0).getText(), status);	
		break;
	case "Pending":
		Assert.assertEquals(asl.get(0).getText(), status);	
		break;
	case "Suspended":
		Assert.assertEquals(asl.get(0).getText(), status);	
		break;
	}
	}
	public void SelectGestion(String gestion) {
		openrightpanel();	
		driver.findElement(By.cssSelector(".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")).sendKeys(gestion);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> btns = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.slds-truncate"));
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+btns.get(0).getLocation().y+")");
			btns.get(0).click();
			driver.switchTo().defaultContent();}
	
	
	public void detectarframe() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

// System.out.println(asl.get(0).getText());
List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
int i = 0;
String b;
for (WebElement frame2: frame1){
	try {
		driver.switchTo().frame(frame2);
		/////////////////
		driver.findElement(By.cssSelector(".x-grid3-cell-inner.x-grid3-col-CASES_CASE_NUMBER"));
//////////////////////////
 b =	Integer.toString(i);
	System.out.println("frame1 : "+ b);
break;
	}catch(NoSuchElementException noSuchElementExcept) { b =Integer.toString(i);System.out.println(b+ " no"); driver.switchTo().defaultContent();i++;}
}
	

	}
	
	public void ValidarCambioDeCiclo() {
		driver.switchTo().defaultContent();
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(4));
		//driver.findElement(By.cssSelector("slds-form-element__control"));
		List <WebElement> asl = driver.findElements(By.className("slds-form-element__control"));
		Assert.assertEquals("En este formulario podrás cambiar la fecha en la cual se te empieza a facturar cada mes.", asl.get(0).getText());
		
	}
	public void ValidarBtnsGestion(String gestion) {
		openrightpanel();	
		driver.findElement(By.cssSelector(".slds-input.actionSearch.ng-pristine.ng-untouched.ng-valid.ng-empty")).sendKeys(gestion);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List <WebElement> btns = driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.slds-truncate"));
		Assert.assertTrue(btns.get(0).getText().equals(gestion));
	}
	
	
	public void usarbuscadorsalesforce(String busqueda) {
		buscador.sendKeys(busqueda);
		buscador.submit();
	}
	
	public void validarbuscadorsalesforce() {
		Assert.assertTrue(buscador.isEnabled());
	}
	
	public void btnsdetallesedit(String btn) {
		switch(btn) {
		case "Guardar":
			driver.findElement(By.xpath("//*[@id=\'topButtonRow\']/input[1]")).click();
			break;
		case "Cancelar":
			driver.findElement(By.xpath("//*[@id=\'topButtonRow\']/input[2]")).click();
			break;
		}
			//driver.findElement(By.xpath("//*[@id=\'topButtonRow\']/input[1]"))
	}
	
	public void validarlabusqueda(String busqueda) {
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(6));
		List<WebElement>asl = driver.findElements(By.cssSelector(".list0"));
		//System.out.println(asl.size());
		//System.out.println(asl.get(0).getText());
		Assert.assertTrue(asl.get(0).getText().contains(busqueda));
	}
	
	public void validarvistaconsumidor() {
		Assert.assertTrue(driver.findElement(By.cssSelector(".ng-not-empty.ng-valid")).isEnabled());}
	
	public void clienteinactivo() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	Actions action = new Actions(driver);   
	try {
		action.moveToElement(editstatus).doubleClick().perform();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		setSimpleDropdown(listeditstatus, "Inactive");
	} catch (NoSuchElementException e) {}
	try {
			action.moveToElement(editstatus2).doubleClick().perform();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			setSimpleDropdown(listeditstatus2, "No");
	} catch (NoSuchElementException e) {}
	
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}


	}

	public void clienteactivo() {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	Actions action = new Actions(driver);  
try {
		action.moveToElement(editstatus).doubleClick().perform();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		setSimpleDropdown(listeditstatus, "Active");
	} catch (NoSuchElementException e) {}
try {
		action.moveToElement(editstatus2).doubleClick().perform();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		setSimpleDropdown(listeditstatus2, "Yes");
} catch (NoSuchElementException e) {}
	}
	
	public void seleccionarfraude(String check) {
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

		Actions action = new Actions(driver);   
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+editfraude.getLocation().y+")");
	    editfraude.click();
		action.moveToElement(editfraude).doubleClick().perform();
		switch(check) {
		case "si":
			if ( !driver.findElement(By.id("00Nc0000001iLaY")).isSelected() )
		{driver.findElement(By.id("00Nc0000001iLaY")).click();}
			break;
		case "no":
			if ( driver.findElement(By.id("00Nc0000001iLaY")).isSelected() )
			{driver.findElement(By.id("00Nc0000001iLaY")).click();}
			break;
		}
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}


	}
	public void cerrarultimapestaña() {
		driver.switchTo().defaultContent();
		try {
			driver.findElement(By.name("cancel")).click();;
		} catch (NoSuchElementException e) {}
		List<WebElement> asl = driver.findElements(By.className("x-tab-strip-close"));
		for (WebElement e : asl) {
			
			try {((JavascriptExecutor) driver).executeScript("arguments[0].click();", e);} catch (org.openqa.selenium.StaleElementReferenceException b) {}
		}
		List<WebElement> mainTabs1 = driver.findElements(By.className("x-tab-strip-close"));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", mainTabs1.get(1));
	

		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

	}
	public void validarerrorpaso0() {
		driver.switchTo().defaultContent();
		try {Thread.sleep(15000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		List <WebElement> asl = driver.findElements(By.className("slds-form-element__control"));
	Assert.assertEquals(asl.get(3).getText(), "El cliente no está activo.");
		/*for(int i=0; i<asl.size() ; i++){
			System.out.println("index: " + i + " "+asl.get(i).getText());
			if(asl.get(i).getText().equals("El cliente no está activo.")) {
				service.get(i).click();
				}
		}*/
		driver.switchTo().defaultContent();

	}
	
	public void validarerrorpaso1(String valid) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("Validaciones_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("OrderReview_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		switch (valid) {
		case "cuenta billing fraude no aparece":
		List<WebElement> asl = driver.findElements(By.id("tree0-node1__label"));
		Assert.assertEquals(asl.size(),3);	
		break;
		case "servicio cambia de cuenta billing":
			
			break;
		}
	}
	
	
	
	public void editarcuenta(String cuenta, String fraude,String Status) {
		WebElement frame0 = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame0);
		Select field = new Select(driver.findElement(By.name("fcf")));
		field.selectByVisibleText("Todas Las cuentas");		
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		List<WebElement> accounts2 = driver.findElements(By.xpath("//*[text() ='"+cuenta+"']"));
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}	
		accounts2.get(0).click();
		accounts2.get(0).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		usarpanelcentral("Detalles");
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		switch(Status) {
		case "active":
			clienteactivo();
			break;
		case "inactive":
			clienteinactivo();
			break;
		}
		seleccionarfraude(fraude);
		obligarclick(editsave);
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		cerrarultimapestaña();
	}
	
	public void serviciocambiadecuenta(String servicio, String cuenta) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("Validaciones_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		obligarclick(driver.findElement(By.id("OrderReview_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> service = driver.findElements(By.cssSelector(".slds-checkbox__label"));
		//System.out.println("Tamaño: "+service.size());
		for(int i=0; i<service.size() ; i++){
			if(service.get(i).getText().equals(servicio)) {
				service.get(i).click();
				}
			}
		obligarclick(driver.findElement(By.id("BillingAccountFrom_nextBtn")));
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> cuentas = driver.findElements(By.cssSelector(".slds-radio"));
		List<WebElement> radiobtn = driver.findElements(By.xpath("//input[@name='options' and @type='radio']"));
		int a;
		for(int i=0; i<cuentas.size() ; i++){

			if(cuentas.get(i).getText().equals(cuenta)) {
				WebElement local_radio= radiobtn.get(i);
				String value=local_radio.getAttribute("value");
				System.out.println(value);
				a= i - 2;
				System.out.println(a);
				}
			}
	}
	
	
	public void crearsugerencia(String categoria, String subcategoria, String gestion) {
		driver.switchTo().defaultContent();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		List<WebElement> frame1= driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(3));
		setSimpleDropdown(driver.findElement(By.id("Category")), categoria);
		setSimpleDropdown(driver.findElement(By.id("Subcategory")), subcategoria);
		driver.findElement(By.id("Comment")).sendKeys("Esto es un comentario");
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}

		
		switch(gestion) {
		case "crear":
			obligarclick(driver.findElement(By.id("ManagementType_nextBtn")));
			break;
		case "cancel":
			driver.findElement(By.className("vlc-slds-button--tertiary.ng-binding.ng-scope")).click();
			try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
			driver.findElement(By.id("alert-ok-button")).click();
			break;
		}				
	}
	
	
	public void clickContinueError() {
		List <WebElement> emergente= driver.findElements(By.cssSelector(".slds-button.slds-button--neutral.ng-binding.ng-scope"));
		emergente.get(1).click();
		try {Thread.sleep(5000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
	}
	
	
	public void validarCheckBox() {
		WebElement opb= driver.findElement(By.cssSelector(".slds-radio--faux.ng-scope"));
		boolean a=false;
		if(opb.isDisplayed())
			a=true;
		assertTrue(a);
	}
	
	public void validarDniACuit() {
		WebElement dni= driver.findElement(By.cssSelector(".slds-form-element__label.ng-binding.ng-scope"));
		boolean a=false;
		if(dni.isDisplayed())
			a=true;
		assertTrue(a);
	}
	
	public void validarError() {
		WebElement error = driver.findElement(By.id("prompt-heading-id"));
		boolean a = false;
		if (error.isDisplayed()) {
			a = true;
			assertTrue(a);
		}
		
	}
	public boolean ElementPresent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else
		return false;
	}
	public void clickSiguiente(WebElement element) {
		try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		element.click();
	}
	public void billings(List<WebElement> element) {
		for (int i = 0; i < element.size(); i++) {
			element.get(i).click();
		}
		
	}
}
