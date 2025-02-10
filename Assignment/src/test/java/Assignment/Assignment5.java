package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

         {
            // Step 1: Navigate to Flipkart and assert the page title
            driver.get("https://www.flipkart.com");
            String pageTitle = driver.getTitle();
            System.out.println("title is " +pageTitle);
            if (pageTitle.contains("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")) {
                System.out.println("Page title is correct: " + pageTitle);
            } else {
                System.out.println("Page title is incorrect: " + pageTitle);
            }

            // Step 2: Hover over the "Electronics" category using the Actions class
            WebElement electronicsCategory = driver.findElement(By.xpath("//span[text()='Electronics']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(electronicsCategory).perform();

            // Step 3: Click on the "Electronics" category
            driver.findElement(By.xpath("//div/object/a[contains(text(),'All')]")).click();
            // Step 4: Type a product name into the search box and press "Enter"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("smartphone");
            searchBox.sendKeys(Keys.RETURN);  // Press "Enter"

            // Add a sleep or wait here if necessary, to give time for results to load

        } 
            // Close the browser after the task is complete
            driver.quit();
        
    }
}



