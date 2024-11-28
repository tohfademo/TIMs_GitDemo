package tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWithoutPOM {

	@Test
	public void test() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		try {
			
			driver.get("https://demo.opencart.com/en-gb?route=common/home");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
			Thread.sleep(5000);
			
			//LANDING PAGE VALIDATION
			//Verify slider section
			Assert.assertEquals(2, driver.findElements(By.xpath("//div[@class='carousel slide']")).size());
			
			//Verify feature section displays 4 products
			Assert.assertEquals(4, driver.findElements(By.xpath("//*[text()='Featured']/..//div[@class='product-thumb']")).size());

			
			//Scroll down to bottom of page
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			
			Thread.sleep(2000);
			
			
			//click on any product button
			String productName = "MacBook";
			driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
			
			Thread.sleep(5000);

			//Validate product name matches with page header
			Assert.assertEquals(productName, driver.findElement(By.tagName("h1")).getText().trim());
			
			//click on Add to Cart button
			//driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();
			
			//navigate back to home page
			driver.findElement(By.xpath("//img[@alt='Your Store']")).click();
			
			if(driver.getTitle().equalsIgnoreCase("Just a moment...")) {
				Thread.sleep(8000);
			}
			else Assert.assertEquals(driver.getTitle(), "Your Store");
			
			
		
		}catch (Exception e) {
			
			//If there is any exception, print it in console
			e.printStackTrace();
		}
		finally {
			
			//whatever happens (pass or failed execution), quit the driver at the very end
			driver.quit();		
		}

		
	}
}

