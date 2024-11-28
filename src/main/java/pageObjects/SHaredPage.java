package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SHaredPage {
	
	private WebDriver driver;

	private By wishList = By.tagName("a");
	private By sliderSections = By.xpath("//div[@class='carousel slide']");
	private By featuredProducts = By.xpath("//*[text()='Featured']/..//div[@class='product-thumb']");
	
	
	//2. constructor (that accepts WebDriver)
	public SHaredPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * click on wishlist
	 */
	public void clickOnEle() {
		driver.findElement(wishList).click();
	}
	
}