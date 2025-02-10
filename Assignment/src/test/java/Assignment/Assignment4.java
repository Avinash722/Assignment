package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {
    public static void main(String[] args) throws InterruptedException {
       
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            
            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Shape of You");
            searchBox.submit();
            
            Thread.sleep(10000);
           
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
             driver.findElement(By.xpath("//h3[contains(text(),'Ed Sheeran - Shape of You (Official Music Video)')]")).click();
            
             try {
                WebElement acceptButton = driver.findElement(By.xpath("//button[text()='I agree']"));
                acceptButton.click();
            } catch (Exception e) {
                
                System.out.println("No cookies");
            }

            
            
       
            driver.quit();
        
    }
}


