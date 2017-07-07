package examen;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;


public class test {

        private WebDriver driver;

        @Before
        public void setup() {
                System.setProperty("webdriver.chrome.driver", "C:/Users/Sofia Chardin/Downloads/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                driver = new ChromeDriver(options); //Starts the browser
                driver.get("http://www.google.com"); //Goes to www.google.com
                driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("salesforce argentina"); //Inputs search term
                try { Thread.sleep(3000); } catch(InterruptedException ex) { Thread.currentThread().interrupt();} //Waits 3 seconds

        }

        @Test
        public void testA() {

                List<WebElement> myElements = driver.findElements(By.className("_WGk")); //Gets all Ad elements
                for(WebElement e : myElements) {System.out.println(e.getText());} //Prints all Ad elements

        }

        @Test
        public void testB() {

                Integer i = 0;
                while (i < 5) {
                        List<WebElement> myElements = driver.findElements(By.className("_Rm")); //Gets all Results elements
                        for(WebElement e : myElements) {
                                String m = e.getText();
                                if (m.contains(".ar")) {System.out.println(m);} // Prints all Results elements which contains ".ar"
                        }
                        if (i < 4) {
                        driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[2]")).click(); //Clicks on go to Next page
                        try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} //Waits 3 seconds
                        }
                        i++;
                }
                System.out.println("Finalizo TestB con exito");

        }

        @Test
        public void testC() {

                Integer ii= 1;
                ArrayList<Integer> a = new ArrayList<>();
                ArrayList<Integer> b = new ArrayList<>();

                while (ii < 6) {
                        a.add(0); //Ads value to the array a to avoid null exception
                        b.add(0); //Ads value to the array b to avoid null exception
                        try {
                                WebElement topAdsNumber = driver.findElement(By.id("tads")); //Locates father element of Top Ads
                                List<WebElement> topAdsNumber2 = topAdsNumber.findElements(By.className("ads-ad")); //Lists all Top Ads
                                Integer p = topAdsNumber2.size();
                                a.add(0, topAdsNumber2.size()); //Ads the amount of Top Ads to the Array a
                        } catch (org.openqa.selenium.NoSuchElementException e) { } //Catch Selenium error if there are no Ads at the top
                        List<WebElement> resultsNumber = driver.findElements(By.className("g")); //List all real Results
                        WebElement bottomAdsNumber = driver.findElement(By.id("bottomads")); // Locates father element of bottom ads
                        List<WebElement> bottomAdsNumber2 = bottomAdsNumber.findElements(By.className("ads-ad")); //Lists all bottom ads
                        b.add(0, bottomAdsNumber2.size()); //Ads the amount of bottom ads to the array b
                        List<WebElement> myAds = driver.findElements(By.className("_WGk")); //Gets all Ad elements
                        for (int j = 0; j < myAds.size(); j++) {
                                String l = myAds.get(j).getText();
                                if (l.contains("xappia.com") && j <= (a.get(0))) {
                                        System.out.println("El sitio " + l + " aparece en la posición " + (j + 1) + " en la página " + ii); //Prints all Top Ads elements which contains "xappia.com" and states its page and position
                                }
                                if (l.contains("xappia.com") && j > (a.get(0))) {
                                        System.out.println("El sitio " + l + " aparece en la posición " + (j + 1 + resultsNumber.size()) + " en la página " + ii); // Prints all bottom Ads elements which contains "xappia.com" and states its page and position
                                }
                        }
                        List<WebElement> myResults = driver.findElements(By.className("_Rm")); //Gets all real Results elements
                        for (int i = 0; i < myResults.size(); i++) {
                                String m = myResults.get(i).getText();
                                if (m.contains("xappia.com")) {
                                        System.out.println("El sitio " + m + " aparece en la posición " + (a.get(0) + i + 1) + " en la página " + ii); // Prints all real Results elements which contains "xappia.com" and states its page and position
                                }
                        }
                        if (ii < 5) {
                                driver.findElement(By.xpath("//*[@id=\"pnnext\"]/span[2]")).click(); //Clicks on go to Next page
                                try {Thread.sleep(3000);} catch (InterruptedException ex) {Thread.currentThread().interrupt();} //Waits 3 seconds
                        }
                        ii++;
                }

        }

        @After
        public void tearDown() throws Exception {
                driver.quit(); //Closes the browser
        }
}
