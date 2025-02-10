package com.lamdatest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class TestScenario2 {
	
	public String username = "dinkle.avi722";
    public String accesskey = "VMDJdNodPn6eapCTa10OZTpYBUZWGlSX0LissWaKYMVN5f17Fy";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
  String status = "failed";
  @BeforeClass
    @Parameters({"Browser","Version","Platform"})
    public void setUp(String Browser, String Version, String Platform) throws Exception {
       DesiredCapabilities capabilities = new DesiredCapabilities();
       
       capabilities.setCapability("version", Version);
       capabilities.setCapability("platform",Platform	);
       
       
       capabilities.setCapability("username", "dinkle.avi722");
       capabilities.setCapability("accessKey", "VMDJdNodPn6eapCTa10OZTpYBUZWGlSX0LissWaKYMVN5f17Fy");
       capabilities.setCapability("visual", true);
       capabilities.setCapability("video", true);
       capabilities.setCapability("network", true);
       capabilities.setCapability("build","Selenium Java 101");
       capabilities.setCapability("name","TestScenario2");
       capabilities.setCapability("console", "true");
       capabilities.setCapability("selenium_version", "4.0.0");
       capabilities.setCapability("w3c", true);
       capabilities.setCapability("plugin", "java-java");
       capabilities.setBrowserName(Browser);
        
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
  public void acceptCookie()
    {
    	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	try {
            WebElement acceptButton= driver.findElement(By.xpath("//button[contains(text(), 'Allow all')]"));
            acceptButton.click();
            
        } catch (Exception e) {
            System.out.println("No cookie popup appeared.");
        }
    }
  @Test (priority = 1,timeOut = 20000)
    	public void testScenrio2() throws Exception {
            driver.get("https://www.lambdatest.com/selenium-playground");

            // Click "Drag & Drop Sliders" under "Progress Bars & Sliders"
            WebElement dragAndDropSlidersLink = driver.findElement(By.linkText("Drag & Drop Sliders"));
            dragAndDropSlidersLink.click();

            // Select the slider "Default value 15"
            WebElement slider = driver.findElement(By.xpath("//div[@id='slider3']/div/input"));

            // Create an Actions object to perform the drag and drop
            Actions actions = new Actions(driver);

            // Drag the slider to 95
            actions.dragAndDropBy(slider, 188, 0).perform();  // Adjust the offset as needed

            // Validate whether the range value shows 95
            WebElement rangeValue = driver.findElement(By.id("rangeSuccess"));
            String value = rangeValue.getText();
            if (!value.equals("95")) {
                throw new IllegalStateException("The range value does not show 95, it shows: " + value);
            }

            System.out.println("Test passed: The slider was correctly set to 95 range value is :- " + rangeValue);
            status = "passed";}
  @AfterClass
  public void tearDown() throws Exception {
 if (driver != null) {
      ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
  // Close the WebDriver
  driver.quit();
        }
  }}
