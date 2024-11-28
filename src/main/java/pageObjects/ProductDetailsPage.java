package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

	private WebDriver driver;
	
	private By productNameHeader = By.tagName("h1");
	private By openCartImage = By.xpath("//img[@alt='Your Store']");
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public String getProductHeaderName() {
		return driver.findElement(productNameHeader).getText();
	}
	
	public HomePage navigateToHomePage() {
		driver.findElement(openCartImage).click();
		return new HomePage(driver);
	}
}
