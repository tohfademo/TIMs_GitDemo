package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SHaredPage {
	
	private WebDriver driver;

	private By wishList_DIlina = By.tagName("a");
	private By sliderSections = By.xpath("//div[@class='carousel slide']");
	private By featuredProducts_DIlina = By.xpath("//*[text()='Featured']/..//div[@class='product-thumb']");
	
	
	//2. constructor (that accepts WebDriver)
	public SHaredPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * click on wishlist
	 */
	public void clickOnEle_Dilina() {
		driver.findElement(wishList_DIlina).click();
		System.out.println("Dilina's code");
	}
	

	public void add(int a, int b) {
	System.out.println("Adding two numbers");
		System.out.println( a + " & " + b);
	}
}