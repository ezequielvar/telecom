package demoMobile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class TestMobile {
	
	public static AndroidDriver driver;
	
	@Test
	public void setUp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("deviceName", "Nexus 6P");
		cap.setCapability("platformVersion", "7.1.2");
		cap.setCapability("platformName", "Android");
		//cap.setCapability("appPackage", "com.google.android.GoogleCamera");
		//cap.setCapability("appActivity", "com.android.camera.CameraActivity");
		cap.setCapability("noReset", "True");
		cap.setCapability("fullReset", "False");
		cap.setCapability("appPackage", "com.whatsapp");
		cap.setCapability("appActivity", ".HomeActivity t14350");
		driver = new AndroidDriver (new URL("http://192.168.0.11:4723/wd/hub"), cap);
		
		
		//driver.pressKeyCode(AndroidKeyCode.HOME);
		
		//driver.findElementByName("WhatsApp").click();
		driver.findElementById("com.whatsapp:id/menuitem_search").click();
		driver.findElementById("com.whatsapp:id/search_src_text").sendKeys("Manu Vargas");
		driver.findElementById("com.whatsapp:id/contact_row_container").click();
		driver.findElementById("com.whatsapp:id/entry").sendKeys("Hola, como estas?");
		driver.findElementById("com.whatsapp:id/send").click();
		driver.findElementById("com.whatsapp:id/camera_btn").click();
		driver.findElementById("com.whatsapp:id/shutter").click();
		Thread.sleep(3000);
		driver.findElementById("com.whatsapp:id/caption").sendKeys("foto");
		driver.findElementById("com.whatsapp:id/send").click();
		
		driver.pressKeyCode(AndroidKeyCode.HOME);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Chrome']")).click();
		Thread.sleep(2000);
		driver.findElementById("com.android.chrome:id/url_bar").sendKeys("www.salesforce.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='www.salesforce.com']")).click();;
		Thread.sleep(5000);
		WebElement menu = driver.findElement(By.xpath ("//android.widget.Button[@bounds='[749,238][910,398]']"));
		menu.click();
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.xpath ("//android.widget.Button[@bounds='[0,583][645,725]']"));
		login.click();
		Thread.sleep(2000);
		driver.findElementById("Login").click();
		Thread.sleep(13000);
		WebElement newTask = driver.findElement(By.xpath ("//android.widget.Button[@bounds='[865,2266][1154,2403]']"));
		newTask.click();
		Thread.sleep(2000);
		WebElement Subject = driver.findElement(By.xpath ("//android.widget.EditText[@bounds='[2,437][1439,559]']"));
		Subject.sendKeys("Automation");;
		WebElement Name = driver.findElement(By.xpath ("//android.view.View[@bounds='[2,559][1439,767]']"));
		Name.click();
		Thread.sleep(2000);
		WebElement Contact = driver.findElement(By.xpath ("//android.view.View[@bounds='[38,809][1404,952]']"));
		Contact.click();
		Thread.sleep(1000);
		WebElement RelatedTo = driver.findElement(By.xpath ("//android.view.View[@bounds='[2,767][1439,975]']"));
		RelatedTo.click();
		Thread.sleep(2000);
		WebElement Accounts = driver.findElement(By.xpath ("//android.view.View[@bounds='[2,770][1439,987]']"));
		Accounts.click();
		Thread.sleep(2000);
		WebElement DueDate = driver.findElement(By.xpath ("//android.view.View[@bounds='[2,975][1439,1240]']"));
		DueDate.click();
		Thread.sleep(2000);
		WebElement Date = driver.findElement(By.xpath ("//android.view.View[@bounds='[876,1395][981,1514]']"));
		Date.click();
		Thread.sleep(1000);
		driver.findElementById("android:id/button1").click();
		WebElement Save = driver.findElement(By.xpath ("//android.widget.Button[@bounds='[1201,288][1392,383]']"));
		Save.click();
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//android.view.View[@content-desc='Task Automation']")) != null)
		{
			System.out.println("Tarea creada correctamente");
		}else{
			System.out.println("El test fallo");
		}
		/*driver.findElementById("Cámara").click();
		driver.findElementById("com.google.android.GoogleCamera:id/shutter_button").click();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		//driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		driver.findElementById("com.google.android.GoogleCamera:id/toybox_menu_button").click();
		//driver.findElementById("com.google.android.GoogleCamera:id/thumbnail_button").click();
		driver.findElementById("com.google.android.GoogleCamera:id/camera_switch_button").click();
		Thread.sleep(10000);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElementById("com.google.android.GoogleCamera:id/shutter_button").click();*/
	}

}
