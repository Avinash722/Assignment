package com.lamdatest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScenario3 {
	
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
       capabilities.setCapability("name","TestScenario3");
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
  public void testScenrio3() throws Exception {
            driver.get("https://www.lambdatest.com/selenium-playground");

            // Click "Input Form Submit" under "Input Forms"
            WebElement inputFormSubmitLink = driver.findElement(By.xpath("//a[text()='Input Form Submit']"));
            
            inputFormSubmitLink.click();

            // Click "Submit" without filling in any information in the form
            WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
            System.out.println("pass");
            submitButton.click();

            // Assert "Please fill in the fields" error message
           // WebElement errorMessage = driver.findElement(By.xpath("//p[@class='text-danger']/following-sibling::ul"));
           // String errorText = errorMessage.getText();
            //if (!errorText.contains("Please fill in the fields")) {
                //throw new IllegalStateException("The error message does not contain 'Please fill in the fields'");
           // }

            // Fill in Name, Email, and other fields
            driver.findElement(By.name("name")).sendKeys("John Doe");
            driver.findElement(By.xpath("//input[@placeholder='Email' ]")).sendKeys("john.doe@example.com");
            driver.findElement(By.name("password")).sendKeys("password123");
            driver.findElement(By.name("company")).sendKeys("Example Company");
            driver.findElement(By.name("website")).sendKeys("www.example.com");
            driver.findElement(By.name("country")).sendKeys("United States");
            driver.findElement(By.name("city")).sendKeys("New York");
            driver.findElement(By.xpath("//input[@placeholder='Address 1' ]")).sendKeys("123 Example St");
            driver.findElement(By.xpath("//input[@placeholder='Address 2' ]")).sendKeys("Suite 100");
            driver.findElement(By.xpath("//input[@placeholder='State' ]")).sendKeys("NY");
            driver.findElement(By.xpath("//input[@placeholder='Zip code' ]")).sendKeys("10001");

            // From the Country drop-down, select "United States" using the text property
            Select countryDropdown = new Select(driver.findElement(By.name("country")));
            countryDropdown.selectByVisibleText("United States");

            // Click "Submit"
            submitButton.click();

            // Validate the success message
            WebElement successMessage = driver.findElement(By.xpath("//p[text()='Thanks for contacting us, we will get back to you shortly.']"));
            String successText = successMessage.getText();
            if (!successText.contains("Thanks for contacting us, we will get back to you shortly.")) {
                throw new IllegalStateException("The success message is not displayed as expected");
            }

            System.out.println("Test passed: The form was submitted successfully test is :- " + successText);
            status = "passed";}
            @AfterClass
            public void tearDown() throws Exception {
           if (driver != null) {
                ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            // Close the WebDriver
            driver.quit();
                  }
            }}