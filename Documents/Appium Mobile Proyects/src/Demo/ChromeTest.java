package Demo;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class ChromeTest {
    private AndroidDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Setup Appium
    	
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability(MobileCapabilityType.APP, "C:\\Android\\BitbarSampleApp.apk");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus6p");
        caps.setCapability("platformName", "Android");
        caps.setCapability("VERSION", "6.0");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait= new WebDriverWait(driver,20);
    }
    @Test
    public void appiumBitBarTest() throws MalformedURLException, InterruptedException,URISyntaxException {
    	
    	driver.pressKeyCode(AndroidKeyCode.HOME);/*
    	driver.findElement(By.name("Contacts")).click();
        driver.findElement(By.id("com.android.contacts:id/floating_action_button")).click();
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Name']")).click();
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Name']")).clear();
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Name']")).sendKeys("Ezequiel Vargas");
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Phone']")).sendKeys("44444444");
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Email']")).sendKeys("ezequiel@gmail.com");
        driver.findElementById("com.android.contacts:id/menu_save").click();*/
        //driver.pressKeyCode(AndroidKeyCode.HOME);
    	driver.findElement(By.name("Clock")).click();
    	driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Alarm']")).click();
    	driver.findElement(By.id("com.android.deskclock:id/onoff")).click();
    	driver.pressKeyCode(AndroidKeyCode.HOME);
    	driver.findElement(By.name("Calculator")).click();
    	driver.findElement(By.name("2")).click();
    	driver.findElement(By.name("+")).click();
    	driver.findElement(By.name("2")).click();
    	driver.findElement(By.name("=")).click();
    	
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}