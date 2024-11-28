package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class HomePage {

	/*
	 * 1. web elements initialized and declared private
	 * 
	 * 2. constructor (that accepts WebDriver)
	 * 
	 * 3. element actions --> methods are kept public
	 * */
	
	//1. web elements initialized and declared private
	
	private WebDriver driver;
	
	/*
	 * private WebElement wishList = driver.findElement(By.tagName("a")); //loading
	 * the element private WebElement ele1 = driver.findElement(By.tagName("a"));
	 * private WebElement ele2 = driver.findElement(By.tagName("a")); private
	 * WebElement ele3 = driver.findElement(By.tagName("a")); private WebElement
	 * ele4 = driver.findElement(By.tagName("a"));
	 */
	
	private By wishList = By.tagName("a");
	private By sliderSections = By.xpath("//div[@class='carousel slide']");
	private By featuredProducts = By.xpath("//*[text()='Featured']/..//div[@class='product-thumb']");
	
	
	//2. constructor (that accepts WebDriver)
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * click on wishlist
	 */
	public void clickOnEle() {
		driver.findElement(wishList).click();
	}
	
	
	//3. element actions --> methods are kept public
	
	/**
	 * This method returns the number of slider section in the page
	 * @return section count in int
	 */
	public int getSliderSectionsCount() {
		return driver.findElements(sliderSections).size();
		
	}
	
	public int getFeaturedProductCount() {
		return driver.findElements(featuredProducts).size();
	}
	
	public ProductDetailsPage clickOnProductName(String productName) {
		
		Wait<WebDriver> wait = new
				 FluentWait<WebDriver>(driver) .withTimeout(Duration.ofSeconds(155))
				 .pollingEvery(Duration.ofSeconds(5))
				 .ignoring(ElementClickInterceptedException.class);
		
		By productNameElement = By.xpath("//a[text()='"+productName+"']");
		//driver.findElement(productNameElement).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(productNameElement)).click();
		
		return new ProductDetailsPage(driver);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
}
