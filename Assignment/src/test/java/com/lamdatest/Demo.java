package com.lamdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Demo {
	
		
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
	    public void testScenrio1() throws Exception {
            driver.get("https://www.lambdatest.com/selenium-playground");
            acceptCookie();            

            // Click "Simple Form Demo" under Input Forms
            WebElement simpleFormDemoLink = driver.findElement(By.linkText("Simple Form Demo"));
            simpleFormDemoLink.click();

            // Validate that the URL contains "simple-form-demo"
            Thread.sleep(2000);  // Wait for the page to load
            String currentUrl = driver.getCurrentUrl();
            if (!currentUrl.contains("simple-form-demo")) {
                throw new IllegalStateException("URL does not contain 'simple-form-demo'");
            }

            // Create a variable for a string value
            String message = "Welcome to LambdaTest";

            // Use this variable to enter values in the "Enter Message" text box
            WebElement messageInputBox = driver.findElement(By.id("user-message"));
            messageInputBox.sendKeys(message);

            // Click "Get Checked Value"
            WebElement showMessageButton = driver.findElement(By.xpath("//button[contains(text(),'Get Checked Value')]"));
            showMessageButton.click();

            // Validate whether the same text message is displayed in the right-hand panel
            WebElement displayedMessageElement = driver.findElement(By.id("message"));
            String displayedMessage = displayedMessageElement.getText();
            if (!message.equals(displayedMessage)) {
            	
                throw new IllegalStateException("The displayed message does not match the input message");
            }
            System.out.println("Test passed: The message was correctly displayed message is :- " +  displayedMessage);status = "passed";}
	   
	    
        
       @AfterClass
    	    public void tearDown() throws Exception {
           if (driver != null) {
                ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            // Close the WebDriver
            driver.quit();
        }
    }

}
