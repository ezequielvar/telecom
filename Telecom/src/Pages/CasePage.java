		package Pages;


import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CasePage extends BasePage {

	final WebDriver driver;
	
	//Case information
	
		@FindBy (how = How.ID, using = "cas3")
		private WebElement casename;
		
		@FindBy (how = How.ID, using = "cas4_lkwgt")
		private WebElement searchaccount;
		
		@FindBy (how = How.ID, using = "CF00Nc0000001pScS")
		//send keys
		private WebElement serviceid;

		@FindBy (how = How.ID, using = "CF00Nc0000001pScS_lkwgt")
		//click
		private WebElement searchid;	
		
		@FindBy (how = How.ID, using = "00Nc0000001pWcv")
		private WebElement 	ownerteam;
		
		@FindBy (how = How.ID, using = "00Nc0000001pWcp")
		private WebElement 	casearea;
				
		@FindBy (how = How.ID, using = "00Nc0000001pWcx" )
		private WebElement 	casesubarea;
	
		//Additional Information
		
		@FindBy (how = How.ID, using = "cas7" )
		private WebElement casestatus;
		
		@FindBy (how = How.ID, using =  "cas5")
		private WebElement casetype;	
		
		@FindBy (how = How.ID, using = "cas6")
		private WebElement casereason;
		
		@FindBy (how = How.ID, using = "00Nc0000001pWcr")
		private WebElement caseclosingchannel;
		
		@FindBy (how = How.ID, using = "cas11")
		private WebElement caseorigin;
				
		@FindBy (how = How.ID, using = "00Nc0000001pWcs")
		private WebElement caseduedate;
		
		@FindBy (how = How.ID, using = "00Nc0000001pWcs_ileinner")
		private WebElement rawcaseduedate;
		
		@FindBy (how = How.ID, using = "CreatedDate_ileinner")
		private WebElement caseDate;
		
		@FindBy (how = How.ID, using = "cas8")
		private WebElement casepriority;
		
		@FindBy (how = How.ID, using = "00Nc0000001pWcw")
		private WebElement casecomment;

		//description
		
		@FindBy (how = How.ID, using = "cas14")
		private WebElement casesubject;
		
		@FindBy (how = How.ID, using = "cas15")
		private WebElement casedescription;
		
		@FindBy (how = How.ID, using = "cas16")
		private WebElement caseinternalcomments;
		
		//optional
		
		//check
		@FindBy (how = How.ID, using = "cas21")
		private WebElement caseassignrules;
		
		//check
		@FindBy (how = How.ID, using = "cas22")
		private WebElement casenotification;

		@FindBy (how = How.NAME, using = "save")
		private WebElement save;
		
		@FindBy (how = How.NAME, using = "save_close")
		private WebElement saveandclose;
		
		@FindBy (how = How.NAME, using = "save_new")
		private WebElement saveandnew;
		
		@FindBy (how = How.NAME, using = "cancel")
		private WebElement cancel;
		
		//Interaction log		
		@FindBy (how = How.ID, using = "ext-comp-1042")
		private WebElement interactionname;
		
		@FindBy (how = How.ID, using = "ext-comp-1045")
		private WebElement interactionrelatedto;

		@FindBy (how = How.ID, using = "tsk5_471200f65a3952ee1e2d2a38960b20e615d7ee39468z51abba8615207551")
		private WebElement interactionreason;
		
		@FindBy (how = How.ID, using = "tsk6_471200f65a3952ee1e2d2a38960b20e615d7ee39468z51abba8615207551")
		private WebElement interactionnote;
		
		@FindBy (how = How.ID, using = "ext-gen219")
		private WebElement saveregist;
		
		@FindBy (how = How.ID, using = "ext-gen220")
		private WebElement saveregist_new;
		
		@FindBy (how = How.ID, using = "ext-gen221")
		private WebElement deleteregist;
		
		
		public CasePage(WebDriver driver){
			this.driver = driver;
	        PageFactory.initElements(driver, this);
	}
		//Methods
		public void newcase(String namecase, String cid, String caseteam, String casedate,
				String comments, String subject, String description,
				String intcomments) {
		
			casename.sendKeys(namecase);	
			searchaccount.click();
			serviceid.sendKeys(cid);
			searchid.click();
			ownerteam.sendKeys(caseteam);
			caseduedate.sendKeys(casedate);
			casecomment.sendKeys(comments);
			casesubject.sendKeys(subject);
			casedescription.sendKeys(description);
			caseinternalcomments.sendKeys(intcomments);
			save.click();
			saveandclose.click();
			saveandnew.click();
			cancel.click();
			
			//check
			caseassignrules.click();
			casenotification.click();
			
			//Interaction log		
			saveregist.click();
			saveregist_new.click();
			deleteregist.click();
					
			//listbox
			//casearea, value
			//casesubarea, value
			//casestatus, value
			//casetype, value
			//casereason, value
			//caseclosingchannel, value
			//caseorigin, value
			//casepriority, value
			//interactionname, value
			//interactionrelatedto, value	
			//interactionreason, value
			//interactionnote, value
			

			
		}
		
	public void CreateCase() {
		List<WebElement> frame1 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame1.get(0));
		driver.findElement(By.name("newCase")).click();
		try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
		driver.switchTo().defaultContent();
		List<WebElement> frame2 = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(frame2.get(1));
		driver.findElement(By.id("cas3")).sendKeys("Fernando Caree");
		driver.findElement(By.id("cas4_lkwgt")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> handles =  driver.getWindowHandles();
			for(String windowHandle  : handles)
		       {
		       if(!windowHandle.equals(parentWindow))
		          {
		    	   driver.switchTo().window(windowHandle);
		    	   driver.manage().window().maximize();
						try {Thread.sleep(10000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();}
					driver.findElement(By.xpath("//*[@id=\'lksrch\']")).sendKeys("Fernando Caree");
					driver.findElement(By.name("go")).click();
					}
		         driver.switchTo().window(parentWindow); 
		          }

		}

		public void ValidChannelClosing() {
		
			//Lista de Canales cerrados
			ArrayList<String> Channel = new ArrayList<String>();
			Channel.add("App");
			Channel.add("Chat");
			Channel.add("Email");
			Channel.add("IVR");
			Channel.add("Personalizado");
			Channel.add("Redes Sociales");
			Channel.add("Sat Push");
			Channel.add("SMS");
			Channel.add("Telef�nico");
			Channel.add("USSD");
			Channel.add("Web");
			
			Select dateDropDown=new Select(driver.findElement(By.id("00Nc0000001pWcr")));
			for(int i=0; i<Channel.size(); i++){
				String ChannelClose = Channel.get(i);
				dateDropDown.selectByVisibleText(ChannelClose);
			}
		}
	
	public void FieldsValuesSubArea(){
	//Lista SubArea
		ArrayList<String> SubArea = new ArrayList<String>();
		SubArea.add("Actualizaci�n de Datos del Cliente");
		SubArea.add("Reseteo de Clave");
		SubArea.add("Consulta t�cnica");
		Select dateDropDown=new Select(driver.findElement(By.id("00Nc0000001pWcx")));
		for(int i=0; i<SubArea.size(); i++){
			String ChannelClose = SubArea.get(i);
			dateDropDown.selectByVisibleText(ChannelClose);
		}
	
	}
	
	public void FieldsValuesType(){
		//Lista SubArea
			ArrayList<String> Type = new ArrayList<String>();
			Type.add("Sample Cases");
			Type.add("Trial");
			Type.add("Trial");
			Select dateDropDown=new Select(driver.findElement(By.id("cas5")));
			for(int i=0; i<Type.size(); i++){
				String ChannelClose = Type.get(i);
				dateDropDown.selectByVisibleText(ChannelClose);
			}
		
		}
	
	public void setCaseDueDate(String dueDate) {
		caseduedate.sendKeys(dueDate);
	}
	
	public void setContactName(String contactName) {//*Robo Tech
		casename.sendKeys(contactName);
	}
	
	
	public String getCaseDate(){
		return caseDate.getText();
	}
	
	public String getCaseDueDate(){
		return rawcaseduedate.getText();
	}	
	
	public void save() {
		save.click();
	}
	
}
