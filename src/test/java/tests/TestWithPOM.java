package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;

public class TestWithPOM {
	
	ProductDetailsPage prodPage;
	WebDriver driver;

	@Test
	public void checkProductDetails() {
		
		driver = new ChromeDriver();
		
		try {
			
			driver.get("https://demo.opencart.com/en-gb?route=common/home");
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
			Thread.sleep(5000);
			
			//Get hold of HomePage Object reference
			HomePage homePage = new HomePage(driver);
			
			//HOME PAGE VALIDATION
			//Verify slider section
			Assert.assertEquals(homePage.getSliderSectionsCount(), 2);
			
			//Verify feature section displays 4 products
			Assert.assertEquals(homePage.getFeaturedProductCount(), 4);
			
			//Scroll down to bottom of page
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			//Navigate to product details page
			String productName = "MacBook";
			//homePage.clickOnProductName(productName);
			
			//Get hold of ProductDetails Object reference
			//ProductDetailsPage prodPage = new ProductDetailsPage(driver);
			prodPage = homePage.clickOnProductName(productName);
			
			Thread.sleep(8000);
			
			//Validate product name matches with page header
			Assert.assertEquals(prodPage.getProductHeaderName(), productName);
			
			
		}catch (Exception e) {
			//If there is any exception, print it in console
			e.printStackTrace();
		}
		//driver.quit();
		
		  finally {
		  
		  //whatever happens (pass or failed execution), quit the driver at the very end 
			  driver.quit(); 
		}
		 
	}
}
