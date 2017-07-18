package Pages;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class setConexion{
		WebDriver driver;

		@BeforeTest
		public void setUp() throws MalformedURLException{
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.WINDOWS);
		driver = new RemoteWebDriver(new URL("http://10.249.37.243:5557/wd/hub"), capability);
		}

		@AfterTest
		public void kill(){
			driver.quit();
		}

		@Test
		public void SimpleTest() {
			driver.get("http://www.google.com");
		}
}